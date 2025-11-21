package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.Category;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.CategoryMapper;
import io.github.tdminhnhat.model.dto.CategoryDTO;
import io.github.tdminhnhat.model.vo.CategoryVO;
import io.github.tdminhnhat.repository.CategoryRepository;
import io.github.tdminhnhat.service.ICategoryService;
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
public class CategoryService implements ICategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public Mono<CategoryVO> addImage(Long id, CompletedFileUpload file) {
        return null;
    }

    @Override
    public Mono<CategoryVO> updateImage(Long id, CompletedFileUpload file) {
        return null;
    }

    @Override
    public Mono<CategoryVO> deleteImage(Long id) {
        return null;
    }

    @Override
    public Mono<CategoryVO> add(CategoryDTO request) {
        return categoryRepository.save(categoryMapper.toEntity(request)).map(categoryMapper::toVO);
    }

    @Override
    public Mono<CategoryVO> update(Long id, CategoryDTO request) {
        return categoryRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("category wasn't found"))).flatMap(category -> {
            Category categoryUpdate = categoryMapper.toEntity(request);
            categoryUpdate.setId(category.getId());
            return categoryRepository.update(categoryUpdate).map(categoryMapper::toVO);
        });
    }

    @Override
    public Mono<CategoryVO> delete(Long id) {
        return categoryRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("category wasn't found"))).flatMap(category -> {
                    category.setDeleted(true);
                    return categoryRepository.update(category).map(categoryMapper::toVO);
                }
        );
    }

    @Override
    public Mono<CategoryVO> getById(Long id) {
        return categoryRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("category wasn't found"))).map(categoryMapper::toVO);
    }

    @Override
    public Flux<CategoryVO> getAll() {
        return categoryRepository.findAll().map(categoryMapper::toVO);
    }
}
