package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.CategoryDTO;
import io.github.tdminhnhat.model.vo.CategoryVO;
import io.github.tdminhnhat.service.ICategoryService;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api.path.category}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryController implements IController<CategoryDTO, Long, CategoryVO> {

    ICategoryService categoryService;

    @Post
    @Override
    public Mono<CategoryVO> add(@Valid @Body CategoryDTO request) {
        return categoryService.add(request);
    }

    @Put("/{id}")
    @Override
    public Mono<CategoryVO> update(@PathVariable("id") Long id, @Valid @Body CategoryDTO request) {
        return categoryService.update(id, request);
    }

    @Delete("/{id}")
    @Override
    public Mono<CategoryVO> delete(@PathVariable("id") Long id) {
        return categoryService.delete(id);
    }

    @Get("/{id}")
    @Override
    public Mono<CategoryVO> getById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @Get
    @Override
    public Flux<CategoryVO> getAll() {
        return categoryService.getAll();
    }
}
