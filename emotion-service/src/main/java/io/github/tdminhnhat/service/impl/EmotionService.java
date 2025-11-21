package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.mapper.EmotionMapper;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.github.tdminhnhat.repository.EmotionRepository;
import io.github.tdminhnhat.service.IEmotionService;
import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmotionService implements IEmotionService {

    EmotionRepository emotionRepository;
    EmotionMapper emotionMapper;

    @Override
    public Mono<EmotionVO> addImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    public Mono<EmotionVO> updateImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    public Mono<EmotionVO> deleteImage(Long id) throws Exception {
        return null;
    }

    @Override
    public Mono<EmotionVO> add(EmotionDTO request) {
        return null;
    }

    @Override
    public Mono<EmotionVO> update(Long id, EmotionDTO request) {
        return null;
    }

    @Override
    public Mono<EmotionVO> delete(Long id) {
        return null;
    }

    @Override
    public Mono<EmotionVO> getById(Long id) {
        return null;
    }

    @Override
    public Flux<EmotionVO> getAll() {
        return null;
    }
}
