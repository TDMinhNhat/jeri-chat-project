package io.github.tdminhnhat.service;

import io.github.tdminhnhat.entity.Friend;
import io.github.tdminhnhat.enums.FriendStatus;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.BaseVO;
import io.github.tdminhnhat.model.vo.FriendVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FriendService extends IService<FriendDTO, Long> {
    @Override
    Mono<FriendVO> create(FriendDTO request);

    @Override
    Mono<FriendVO> update(Long id, FriendDTO request);

    @Override
    Mono<FriendVO> delete(Long id);

    @Override
    Mono<FriendVO> getById(Long id);

    @Override
    Flux<FriendVO> getAll();

    Flux<FriendVO> getFriendsByUserId(Long userId);

    Mono<FriendVO> changeStatus(Long id, FriendStatus status);
}
