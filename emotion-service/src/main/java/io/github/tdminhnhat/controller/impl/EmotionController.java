package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.github.tdminhnhat.service.IEmotionService;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("${api.path.emotion}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmotionController implements IController<EmotionDTO, Long, EmotionVO> {

    IEmotionService emotionService;

    @Post
    @Override
    public Mono<EmotionVO> add(@Valid @RequestBody EmotionDTO request) {
        return emotionService.add(request);
    }

    @Put("/{id}")
    @Override
    public Mono<EmotionVO> update(@PathVariable("id") Long id, @Valid @RequestBody EmotionDTO request) {
        return emotionService.update(id, request);
    }

    @Delete("/{id}")
    @Override
    public Mono<EmotionVO> delete(@PathVariable("id") Long id) {
        return emotionService.delete(id);
    }

    @Get("/{id}")
    @Override
    public Mono<EmotionVO> getById(@PathVariable("id") Long id) {
        return emotionService.getById(id);
    }

    @Get
    @Override
    public Flux<EmotionVO> getAll() {
        return emotionService.getAll();
    }
}
