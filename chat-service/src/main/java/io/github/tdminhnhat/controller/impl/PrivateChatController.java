package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.PrivateChatDTO;
import io.github.tdminhnhat.model.vo.PrivateChatVO;
import io.github.tdminhnhat.service.PrivateChatService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api-path.rest.private-chat}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PrivateChatController implements IController<PrivateChatDTO, Long, PrivateChatVO> {

    PrivateChatService privateChatService;

    @Post
    @Override
    public Mono<PrivateChatVO> add(@Valid @Body PrivateChatDTO request) {
        return privateChatService.create(request);
    }

    @Put(value = "/{id}")
    @Override
    public Mono<PrivateChatVO> update(@PathVariable("id") Long id, @Valid @Body PrivateChatDTO request) {
        return privateChatService.update(id, request);
    }

    @Delete(value = "/{id}")
    @Override
    public Mono<PrivateChatVO> delete(@PathVariable("id") Long id) {
        return privateChatService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<PrivateChatVO> getById(@PathVariable("id") Long id) {
        return privateChatService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<PrivateChatVO> getAll() {
        return privateChatService.getAll();
    }
}
