package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.enums.FriendStatus;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.FriendVO;
import io.github.tdminhnhat.service.FriendService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api.path.friend}/friends")
@RequiredArgsConstructor
public class FriendController implements IController<FriendDTO, Long, FriendVO> {

    private final FriendService friendService;

    @Post
    @Override
    public Mono<FriendVO> add(@Valid @Body FriendDTO request) {
        return friendService.create(request);
    }

    @Put(value = "/{id}")
    @Override
    public Mono<FriendVO> update(@PathVariable("id") Long id, @Valid @Body FriendDTO request) {
        return friendService.update(id, request);
    }

    @Delete(value = "/{id}")
    @Override
    public Mono<FriendVO> delete(@PathVariable("id") Long id) {
        return friendService.delete(id);
    }

    @Get(value = "/{id}")
    @Override
    public Mono<FriendVO> getById(@PathVariable("id") Long id) {
        return friendService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<FriendVO> getAll() {
        return friendService.getAll();
    }

    @Put(value = "/{id}/status")
    public Mono<FriendVO> changeStatus(@PathVariable("id") Long id,
                                       @QueryValue("status") FriendStatus status) {
        return friendService.changeStatus(id, status);
    }
}
