package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.github.tdminhnhat.repository.GroupMemberRepository;
import io.github.tdminhnhat.repository.GroupRepository;
import io.github.tdminhnhat.service.GroupService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    @Override
    public Mono<GroupVO> create(GroupDTO request) {
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
