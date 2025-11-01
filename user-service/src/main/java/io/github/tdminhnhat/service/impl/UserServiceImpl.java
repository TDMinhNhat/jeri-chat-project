package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.exception.BadRequestException;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.UserMapper;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.github.tdminhnhat.repository.UserRepository;
import io.github.tdminhnhat.service.UserService;
import io.github.tdminhnhat.util.Validate;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.io.InputStream;
import java.util.List;

@Singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MinioClient minioClient;
    private final String bucketName;

    @Inject
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, MinioClient minioClient,
                           @Value("${minio.bucket-name}") String bucketName) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.minioClient = minioClient;
        this.bucketName = bucketName;
    }

    @Override
    public UserVO add(UserDTO request) {
        User user = userMapper.toEntity(request);
        user.setCode(generateUserCode());
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO update(Long id, UserDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        user.setDeleted(true);
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO getById(Long id) {
        return userMapper.toVO(userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found")));
    }

    @Override
    public List<UserVO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toVO).toList();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVO addImage(Long id, CompletedFileUpload upload) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        try(InputStream inputStream = upload.getInputStream()) {
            if(Validate.validateImage(upload.getInputStream())) {
                minioClient.putObject(PutObjectArgs.builder()
                        .bucket(bucketName)
                        .stream(inputStream, inputStream.available(), -1)
                        .object(user.getCode() + "_avatar")
                        .build());
                user.setAvatar("");
                return userMapper.toVO(userRepository.save(user));
            }
            throw new BadRequestException("Invalid image file");
        }
    }

    @Deprecated
    @Override
    public List<UserVO> addListImages(Long id, List<CompletedFileUpload> uploads) {
        return List.of();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVO deleteImage(Long id, String imageId) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(imageId)
                .build());
        user.setAvatar(null);
        return userMapper.toVO(userRepository.save(user));
    }

    private String generateUserCode() {
        return "";
    }
}
