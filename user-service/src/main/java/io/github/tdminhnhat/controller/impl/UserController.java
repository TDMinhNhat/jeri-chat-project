package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.github.tdminhnhat.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller(value = "${api.path.user}/users")
@RequiredArgsConstructor
public class UserController implements IController<UserDTO, Long, UserVO> {

    private final UserService userService;

    @Post
    @Override
    public HttpResponse<UserVO> add(@Valid @Body UserDTO request) {
        return HttpResponse.ok(userService.add(request));
    }

    @Put(value = "/{id}")
    @Override
    public HttpResponse<UserVO> update(@PathVariable("id") Long id, @Valid @Body UserDTO request) {
        return HttpResponse.ok(userService.update(id, request));
    }

    @Delete(value = "/{id}")
    @Override
    public HttpResponse<UserVO> delete(@PathVariable("id") Long id) {
        return HttpResponse.ok(userService.delete(id));
    }

    @Get(value = "/{id}")
    @Override
    public HttpResponse<UserVO> getById(@PathVariable("id") Long id) {
        return HttpResponse.ok(userService.getById(id));
    }

    @Get
    @Override
    public HttpResponse<List<UserVO>> getAll() {
        return HttpResponse.ok(userService.getAll());
    }
}
