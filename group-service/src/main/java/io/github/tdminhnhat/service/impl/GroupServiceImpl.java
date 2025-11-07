package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.GroupMember;
import io.github.tdminhnhat.enums.GroupMemberRole;
import io.github.tdminhnhat.exception.FileExtensionException;
import io.github.tdminhnhat.exception.MinIOException;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.GroupMapper;
import io.github.tdminhnhat.mapper.GroupMemberMapper;
import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.github.tdminhnhat.repository.GroupMemberRepository;
import io.github.tdminhnhat.repository.GroupRepository;
import io.github.tdminhnhat.service.GroupService;
import io.github.tdminhnhat.util.FileValidation;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.List;

@Singleton
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;
    GroupMemberRepository groupMemberRepository;
    GroupMapper groupMapper;
    GroupMemberMapper groupMemberMapper;
    MinioClient minioClient;
    String bucketName;

    @Inject
    public GroupServiceImpl(GroupRepository groupRepository,
                            GroupMemberRepository groupMemberRepository,
                            GroupMapper groupMapper,
                            GroupMemberMapper groupMemberMapper,
                            MinioClient minioClient,
                            @Value("${minio.bucket-name}") String bucketName) {
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository;
        this.groupMapper = groupMapper;
        this.groupMemberMapper = groupMemberMapper;
        this.minioClient = minioClient;
        this.bucketName = bucketName;
    }

    @PostConstruct
    public void initializeService() throws Exception {
        if(bucketName.isEmpty() || bucketName.isBlank()) {
            throw new MinIOException("MinIO bucket name is not configured properly.");
        } else if(!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    @Override
    public Mono<GroupVO> create(GroupDTO request) {
        return Mono.just(groupMapper.toEntity(request)).flatMap(group -> groupRepository.save(group).flatMap(groupResult -> {
            GroupMember groupMember = new GroupMember();
            groupMember.setGroup(groupResult);
            groupMember.setUserId(request.creatorId());
            groupMember.setUserApproval(null);
            groupMember.setRole(GroupMemberRole.OWNER);
            return groupMemberRepository.save(groupMember);
        }).map(groupMember -> {
            GroupVO groupVO = groupMapper.toVO(groupMember.getGroup());
            groupVO.setGroupMembers(Flux.just(groupMemberMapper.toVO(groupMember)));
            return groupVO;
        }));
    }

    @Override
    public Mono<GroupVO> update(Long id, GroupDTO request) {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found"))).flatMap(group -> {
            group.setTitle(request.title());
            group.setDescription(request.description());
            group.setJoinType(request.joinType());
            return groupRepository.save(group).map(groupMapper::toVO);
        });
    }

    @Override
    public Mono<GroupVO> delete(Long id) {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found"))).flatMap(group -> {
            group.setDeleted(true);
            return groupRepository.save(group).flatMap(groupResult ->
                    groupMemberRepository.findByGroup_Id(groupResult.getId()).map(groupMember -> {
                        groupMember.setDeleted(true);
                        return groupMemberRepository.save(groupMember).map(groupMemberMapper::toVO);
                    }).collectList().map(groupMembersVO -> {
                        GroupVO groupVO = groupMapper.toVO(groupResult);
                        groupVO.setGroupMembers(Flux.fromStream(groupMembersVO.parallelStream().map(Mono::block)));
                        return groupVO;
                    })
            );
        });
    }

    @Override
    public Mono<GroupVO> getById(Long id) {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found"))).map(group -> {
            GroupVO groupVO = groupMapper.toVO(group);
            groupVO.setGroupMembers(groupMemberRepository.findByGroup_Id(group.getId()).map(groupMemberMapper::toVO));
            return groupVO;
        });
    }

    @Override
    public Flux<GroupVO> getAll() {
        return groupRepository.findAll().map(group -> {
            GroupVO groupVO = groupMapper.toVO(group);
            groupVO.setGroupMembers(groupMemberRepository.findByGroup_Id(group.getId()).map(groupMemberMapper::toVO));
            return groupVO;
        });
    }

    @Override
    public Mono<GroupVO> uploadImage(Long id, CompletedFileUpload file) throws Exception {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found"))).flatMap(group -> {
            if (FileValidation.validateImageFileExtension(file)) {
                try (InputStream inputStream = file.getInputStream()) {
                    String objectName = "avatar_" + group.getId();
                    minioClient.putObject(
                            io.minio.PutObjectArgs.builder()
                                    .bucket(bucketName)
                                    .object(objectName)
                                    .stream(inputStream, file.getSize(), -1)
                                    .build()
                    );
                    group.setAvatar(objectName);
                    return groupRepository.save(group).map(groupMapper::toVO);
                } catch (Exception e) {
                    return Mono.error(new MinIOException("Failed to upload image to MinIO: " + e.getMessage()));
                }
            } else {
                return Mono.error(new FileExtensionException("Invalid image file extension. File image should be png or jpeg."));
            }
        });
    }

    @Override
    public Flux<GroupVO> uploadImages(Long id, List<CompletedFileUpload> files) {
        return null;
    }

    @Override
    public Mono<GroupVO> deleteImage(Long id, String imageId) {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found"))).flatMap(group -> {
            try {
                minioClient.removeObject(
                        io.minio.RemoveObjectArgs.builder()
                                .bucket(bucketName)
                                .object("avatar_" + group.getId())
                                .build()
                );
                group.setAvatar(null);
                return groupRepository.save(group).map(groupMapper::toVO);
            } catch (Exception e) {
                return Mono.error(new MinIOException("Failed to delete image from MinIO: " + e.getMessage()));
            }
        });
    }

    @Override
    public Flux<GroupVO> deleteImages(Long id, List<String> imageIds) {
        return null;
    }
}
