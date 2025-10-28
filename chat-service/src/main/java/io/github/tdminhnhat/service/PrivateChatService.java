package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.PrivateChatDTO;
import io.github.tdminhnhat.model.vo.PrivateChatVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrivateChatService extends IService<PrivateChatDTO, Long> {

    @Override
    Mono<PrivateChatVO> create(PrivateChatDTO request);

    @Override
    Mono<PrivateChatVO> update(Long id, PrivateChatDTO request);

    @Override
    Mono<PrivateChatVO> delete(Long id);

    @Override
    Mono<PrivateChatVO> getById(Long id);

    @Override
    Flux<PrivateChatVO> getAll();
}
