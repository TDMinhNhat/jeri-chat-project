package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.GroupChatDTO;
import io.github.tdminhnhat.model.vo.GroupChatVO;
import io.github.tdminhnhat.service.GroupChatService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api-path.rest.group-chat}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupChatRepository implements IController<GroupChatDTO, Long, GroupChatVO> {

    GroupChatService groupChatService;

    @Post
    @Override
    public Mono<GroupChatVO> add(@Valid @Body GroupChatDTO request) {
        return groupChatService.create(request);
    }

    @Put(value = "/{id}")
    @Override
    public Mono<GroupChatVO> update(@PathVariable("id") Long id, @Valid @Body GroupChatDTO request) {
        return groupChatService.update(id, request);
    }

    @Delete(value = "/{id}")
    @Override
    public Mono<GroupChatVO> delete(@PathVariable("id") Long id) {
        return groupChatService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupChatVO> getById(@PathVariable("id") Long id) {
        return groupChatService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<GroupChatVO> getAll() {
        return groupChatService.getAll();
    }
}
