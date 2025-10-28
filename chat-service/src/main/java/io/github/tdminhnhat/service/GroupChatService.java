package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.GroupChatDTO;
import io.github.tdminhnhat.model.vo.GroupChatVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GroupChatService extends IService<GroupChatDTO, Long> {

    @Override
    Mono<GroupChatVO> create(GroupChatDTO request);

    @Override
    Mono<GroupChatVO> update(Long id, GroupChatDTO request);

    @Override
    Mono<GroupChatVO> delete(Long id);

    @Override
    Mono<GroupChatVO> getById(Long id);

    @Override
    Flux<GroupChatVO> getAll();
}
