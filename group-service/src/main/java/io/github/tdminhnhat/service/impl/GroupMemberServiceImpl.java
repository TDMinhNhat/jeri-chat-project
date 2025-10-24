package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import io.github.tdminhnhat.repository.GroupMemberRepository;
import io.github.tdminhnhat.repository.GroupRepository;
import io.github.tdminhnhat.service.GroupMemberService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    @Override
    public Mono<GroupMemberVO> create(GroupMemberDTO request) {
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
