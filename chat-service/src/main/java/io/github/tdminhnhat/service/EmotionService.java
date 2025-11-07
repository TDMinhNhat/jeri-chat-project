package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmotionService extends IService<EmotionDTO, Long>, IFileService<Long> {

    @Override
    Mono<EmotionVO> create(EmotionDTO request);

    @Override
    Mono<EmotionVO> update(Long id, EmotionDTO request);

    @Override
    Mono<EmotionVO> delete(Long id);

    @Override
    Mono<EmotionVO> getById(Long id);

    @Override
    Flux<EmotionVO> getAll();

    @Override
    Mono<EmotionVO> uploadImage(Long id, CompletedFileUpload file);

    @Override
    Flux<EmotionVO> uploadImages(Long id, List<CompletedFileUpload> files);

    @Override
    Mono<EmotionVO> deleteImage(Long id, String imageId);

    @Override
    Flux<EmotionVO> deleteImages(Long id, List<String> imageIds);
}
