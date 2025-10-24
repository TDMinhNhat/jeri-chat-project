package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.github.tdminhnhat.service.GroupService;
import io.micronaut.http.annotation.Controller;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api.path.group}")
@RequiredArgsConstructor
public class GroupController implements IController<GroupDTO, Long> {

    private final GroupService groupService;

    @Override
    public Mono<GroupVO> add(GroupDTO request) {
        return null;
    }

    @Override
    public Mono<GroupVO> update(Long id, GroupDTO request) {
        return null;
    }

    @Override
    public Mono<GroupVO> delete(Long id) {
        return null;
    }

    @Override
    public Mono<GroupVO> getById(Long id) {
        return null;
    }

    @Override
    public Flux<GroupVO> getAll() {
        return null;
    }
}
