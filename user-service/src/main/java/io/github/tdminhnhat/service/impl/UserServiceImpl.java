package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.Address;
import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.exception.BadRequestException;
import io.github.tdminhnhat.exception.FileExtensionException;
import io.github.tdminhnhat.exception.MinIOException;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.AddressMapper;
import io.github.tdminhnhat.mapper.UserMapper;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.github.tdminhnhat.repository.AddressRepository;
import io.github.tdminhnhat.repository.UserRepository;
import io.github.tdminhnhat.service.UserService;
import io.github.tdminhnhat.util.Validate;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.transaction.annotation.Transactional;
import io.minio.*;
import io.minio.http.Method;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Singleton
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    AddressRepository addressRepository;
    UserMapper userMapper;
    AddressMapper addressMapper;
    MinioClient minioClient;
    String bucketName;

    @Inject
    public UserServiceImpl(UserRepository userRepository,
                           AddressRepository addressRepository,
                           UserMapper userMapper,
                           AddressMapper addressMapper,
                           MinioClient minioClient,
                           @Value("${minio.bucketName}") String bucketName) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.minioClient = minioClient;
        this.bucketName = bucketName;
    }

    @PostConstruct
    public void checkAndCreateBucket() throws Exception {
        if (!minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build())) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName).build());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO add(UserDTO request) {
        User user = userMapper.toEntity(request);
        user.setAddress(addressMapper.toEntity(request.address()));
        user.setCode(generateUserCode());
        return getUserVO(userRepository.save(user).getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO update(Long id, UserDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        Address address = addressRepository.findByUser_Id(user.getId()).orElseThrow(() -> new QueryNotFoundException("Address Not Found"));
        address = addressMapper.toEntity(request.address());
        user.setAddress(address);
        return getUserVO(userRepository.save(user).getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        user.setDeleted(true);
        Address address = addressRepository.findByUser_Id(user.getId()).orElseThrow(() -> new QueryNotFoundException("Address Not Found"));
        address.setDeleted(true);
        return getUserVO(userRepository.save(user).getId());
    }

    @Override
    public UserVO getById(Long id) {
        return getUserVO(id);
    }

    @Override
    public List<UserVO> getAll() {
        return userRepository.findAll().stream().map(user -> getUserVO(user.getId())).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO addImage(Long id, CompletedFileUpload upload) {
        try (InputStream inputStream = upload.getInputStream()) {
            if (Validate.validateImage(upload)) {
                User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
                String objectName = "avatar_" + user.getId();

                minioClient.putObject(PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream, upload.getSize(), -1)
                        .contentType("image/" + upload.getContentType().get().getExtension())
                        .build());

                user.setAvatar(objectName);
                return getUserVO(userRepository.saveAndFlush(user).getId());
            }
            throw new FileExtensionException("Invalid image file");
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public List<UserVO> addListImages(Long id, List<CompletedFileUpload> uploads) {
        return List.of();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO deleteImage(Long id, String imageId) throws Exception {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
            user.setAvatar(null);
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(imageId)
                    .build());

            return getUserVO(userRepository.save(user).getId());
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    private String generateUserCode() {
        return UUID.randomUUID().toString();
    }

    private UserVO getUserVO(Long userId) {
        UserVO userVO = userMapper.toVO(userRepository.findById(userId).orElseThrow(() -> new QueryNotFoundException("User Not Found")));
        userVO.setAddress(addressMapper.toVO(addressRepository.findByUser_Id(userId).orElse(null)));
        userVO.setAvatarUrl(userVO.getAvatar() == null ? null : getUrlAvatar(userVO.getAvatar()));
        return userVO;
    }

    private String getUrlAvatar(String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(bucketName)
                    .object(objectName)
                    .expiry(24, TimeUnit.HOURS).build());
        } catch (Exception e) {
            throw new MinIOException(e.getMessage());
        }
    }
}
