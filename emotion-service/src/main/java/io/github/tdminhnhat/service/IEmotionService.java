package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmotionService extends IService<EmotionDTO, Long>, IImageService<Long> {

    @Override
    default Mono<EmotionVO> addImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    default Mono<EmotionVO> updateImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    default Mono<EmotionVO> deleteImage(Long id) throws Exception {
        return null;
    }

    @Override
    default Mono<EmotionVO> add(EmotionDTO request) {
        return null;
    }

    @Override
    default Mono<EmotionVO> update(Long id, EmotionDTO request) {
        return null;
    }

    @Override
    default Mono<EmotionVO> delete(Long id) {
        return null;
    }

    @Override
    default Mono<EmotionVO> getById(Long id) {
        return null;
    }

    @Override
    default Flux<EmotionVO> getAll() {
        return null;
    }
}
