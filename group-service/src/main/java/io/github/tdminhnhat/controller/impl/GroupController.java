package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.controller.IImageController;
import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.github.tdminhnhat.service.GroupService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller(value = "${api.path.group}")
@RequiredArgsConstructor
@Tag(name = "Group Controller")
public class GroupController implements IController<GroupDTO, Long>, IImageController<Long, GroupVO> {

    private final GroupService groupService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> add(@Valid @Body GroupDTO request) {
        return groupService.create(request);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> update(@PathVariable("id") Long id, @Valid @Body GroupDTO request) {
        return groupService.update(id, request);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> delete(@PathVariable("id") Long id) {
        return groupService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> getById(@PathVariable("id") Long id) {
        return groupService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<GroupVO> getAll() {
        return groupService.getAll();
    }

    @Post(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> uploadImage(@PathVariable("id") Long id, @Part CompletedFileUpload file) throws Exception {
        return groupService.uploadImage(id, file);
    }

    @Override
    public Flux<GroupVO> uploadImages(Long id, List<CompletedFileUpload> files) {
        return null;
    }

    @Delete(value = "/{id}/avatar", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupVO> deleteImage(@PathVariable("id") Long id, @QueryValue("imageId") String imageId) throws Exception {
        return groupService.deleteImage(id, imageId);
    }

    @Override
    public Flux<GroupVO> deleteImages(Long id, List<String> imageIds) {
        return null;
    }
}
