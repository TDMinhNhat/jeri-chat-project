package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GroupMemberService extends IService<GroupMemberDTO, Long> {
    @Override
    Mono<GroupMemberVO> create(GroupMemberDTO request);

    @Override
    Mono<GroupMemberVO> update(Long id, GroupMemberDTO request);

    @Override
    Mono<GroupMemberVO> delete(Long id);

    @Override
    Mono<GroupMemberVO> getById(Long id);

    @Override
    Flux<GroupMemberVO> getAll();
}
