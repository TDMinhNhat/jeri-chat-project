package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.controller.IImageController;
import io.github.tdminhnhat.model.dto.EmotionDTO;
import io.github.tdminhnhat.model.vo.EmotionVO;
import io.github.tdminhnhat.service.EmotionService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller(value = "${api-path.rest.emotion}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmotionController implements IController<EmotionDTO, Long, EmotionVO>, IImageController<Long, EmotionVO> {

    EmotionService emotionService;

    @Post
    @Override
    public Mono<EmotionVO> add(@Valid @Body EmotionDTO request) {
        return emotionService.create(request);
    }

    @Put(value = "/{id}")
    @Override
    public Mono<EmotionVO> update(@PathVariable("id") Long id, @Valid @Body EmotionDTO request) {
        return emotionService.update(id, request);
    }

    @Delete(value = "/{id}")
    @Override
    public Mono<EmotionVO> delete(@PathVariable("id") Long id) {
        return emotionService.delete(id);
    }

    @Get(value = "/{id}")
    @Override
    public Mono<EmotionVO> getById(@PathVariable("id") Long id) {
        return emotionService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<EmotionVO> getAll() {
        return emotionService.getAll();
    }

    @Post(value = "/{id}/icon", consumes = MediaType.MULTIPART_FORM_DATA)
    @Override
    public Mono<EmotionVO> uploadImage(@PathVariable("id") Long id, @Part CompletedFileUpload file) {
        return emotionService.uploadImage(id, file);
    }

    @Override
    public Flux<EmotionVO> uploadImages(Long id, List<CompletedFileUpload> files) {
        return null;
    }

    @Delete(value = "/{id}/icon")
    @Override
    public Mono<EmotionVO> deleteImage(@PathVariable("id") Long id, @QueryValue("imageId") String imageId) {
        return emotionService.deleteImage(id, imageId);
    }

    @Override
    public Flux<EmotionVO> deleteImages(Long id, List<String> imageIds) {
        return null;
    }
}
