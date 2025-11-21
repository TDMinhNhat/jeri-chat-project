package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.CategoryDTO;
import io.github.tdminhnhat.model.vo.CategoryVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICategoryService extends IService<CategoryDTO, Long>, IImageService<Long> {

    @Override
    default Mono<CategoryVO> addImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    default Mono<CategoryVO> updateImage(Long id, CompletedFileUpload file) throws Exception {
        return null;
    }

    @Override
    default Mono<CategoryVO> deleteImage(Long id) throws Exception {
        return null;
    }

    @Override
    default Mono<CategoryVO> add(CategoryDTO request) {
        return null;
    }

    @Override
    default Mono<CategoryVO> update(Long id, CategoryDTO request) {
        return null;
    }

    @Override
    default Mono<CategoryVO> delete(Long id) {
        return null;
    }

    @Override
    default Mono<CategoryVO> getById(Long id) {
        return null;
    }

    @Override
    default Flux<CategoryVO> getAll() {
        return null;
    }
}
