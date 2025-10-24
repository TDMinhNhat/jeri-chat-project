package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.FriendVO;
import io.github.tdminhnhat.service.FriendService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller(value = "${api.path.friend}/friends")
@RequiredArgsConstructor
public class FriendController implements IController<FriendDTO, Long, FriendVO> {

    private final FriendService friendService;

    @Post
    @Override
    public HttpResponse<FriendVO> add(@Valid @Body FriendDTO request) {
        return HttpResponse.ok(friendService.create(request));
    }

    @Put(value = "/{id}")
    @Override
    public HttpResponse<FriendVO> update(@PathVariable("id") Long id, @Valid @Body FriendDTO request) {
        return HttpResponse.ok(friendService.update(id, request));
    }

    @Delete(value = "/{id}")
    @Override
    public HttpResponse<FriendVO> delete(@PathVariable("id") Long id) {
        return HttpResponse.ok(friendService.delete(id));
    }

    @Get(value = "/{id}")
    @Override
    public HttpResponse<FriendVO> getById(@PathVariable("id") Long id) {
        return HttpResponse.ok(friendService.getById(id));
    }

    @Get
    @Override
    public HttpResponse<List<FriendVO>> getAll() {
        return HttpResponse.ok(friendService.getAll());
    }
}
