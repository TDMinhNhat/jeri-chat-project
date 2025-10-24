package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import io.github.tdminhnhat.service.GroupMemberService;
import io.micronaut.http.annotation.Controller;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "${api.path.group-member}")
@RequiredArgsConstructor
public class GroupMemberController implements IController<GroupMemberDTO, Long> {
    
    private final GroupMemberService groupMemberService;

    @Override
    public Mono<GroupMemberVO> add(GroupMemberDTO request) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> update(Long id, GroupMemberDTO request) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> delete(Long id) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> getById(Long id) {
        return null;
    }

    @Override
    public Flux<GroupMemberVO> getAll() {
        return null;
    }
}
