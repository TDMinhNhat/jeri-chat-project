package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.exception.BadRequestException;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.EmotionMapper;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.github.tdminhnhat.repository.EmotionRepository;
import io.github.tdminhnhat.service.EmotionService;
import io.github.tdminhnhat.util.FileValidation;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.List;

@Singleton
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmotionServiceImpl implements EmotionService {

    EmotionRepository emotionRepository;
    EmotionMapper emotionMapper;
    MinioClient minioClient;

    @Value("${minio.bucketName}")
    String bucketName;

    @Override
    public Mono<EmotionVO> create(EmotionDTO request) {
        return emotionRepository.save(emotionMapper.toEntity(request)).map(emotionMapper::toVO);
    }

    @Override
    public Mono<EmotionVO> update(Long id, EmotionDTO request) {
        return null;
    }

    @Override
    public Mono<EmotionVO> delete(Long id) {
        return emotionRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found")))
                .flatMap(emotion -> {
                    emotion.setDeleted(true);
                    return emotionRepository.save(emotion).map(emotionMapper::toVO);
                });
    }

    @Override
    public Mono<EmotionVO> getById(Long id) {
        return emotionRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found"))).map(emotionMapper::toVO);
    }

    @Override
    public Flux<EmotionVO> getAll() {
        return emotionRepository.findAll().map(emotionMapper::toVO);
    }

    @Override
    public Mono<EmotionVO> uploadImage(Long id, CompletedFileUpload file) {
        return emotionRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found")))
                .flatMap(emotion -> {
                    if (FileValidation.validateImageFile(file)) {
                        try (InputStream inputStream = file.getInputStream()) {
                            String objectName = emotion.getId() + "_" + file.getFilename();
                            minioClient.putObject(PutObjectArgs.builder()
                                    .bucket(bucketName)
                                    .object(objectName)
                                    .stream(inputStream, file.getSize(), -1)
                                    .build());
                            return emotionRepository.save(emotion).map(emotionMapper::toVO);
                        } catch (Exception e) {
                            return Mono.error(new BadRequestException("Failed to upload image: " + e.getMessage()));
                        }
                    } else {
                        return Mono.error(new BadRequestException("Invalid image file. Only PNG and JPEG are allowed."));
                    }
                });
    }

    @Override
    public Flux<EmotionVO> uploadImages(Long id, List<CompletedFileUpload> files) {
        return null;
    }

    @Override
    public Mono<EmotionVO> deleteImage(Long id, String imageId) {
        return emotionRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found")))
                .flatMap(emotion -> {
                    try {
                        minioClient.removeObject(RemoveObjectArgs.builder()
                                .bucket(bucketName)
                                .object(imageId)
                                .build());
                        return emotionRepository.save(emotion).map(emotionMapper::toVO);
                    } catch (Exception e) {
                        return Mono.error(new BadRequestException("Failed to delete image: " + e.getMessage()));
                    }
                });
    }

    @Override
    public Flux<EmotionVO> deleteImages(Long id, List<String> imageIds) {
        return null;
    }
}
