package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.Friend;
import io.github.tdminhnhat.enums.FriendStatus;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.FriendMapper;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.FriendVO;
import io.github.tdminhnhat.repository.FriendRepository;
import io.github.tdminhnhat.service.FriendService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    @Override
    public Mono<FriendVO> create(FriendDTO request) {
        Friend friend = friendMapper.toEntity(request);
        friend.setStatus(FriendStatus.SEND_REQUEST);
        return friendRepository.save(friend).map(friendMapper::toVO);
    }

    @Override
    public Mono<FriendVO> update(Long id, FriendDTO request) {
        return friendRepository.findById(id).switchIfEmpty(Mono.error(() -> new QueryNotFoundException("Friend Not Found")))
                .flatMap(existingFriend -> {;
                    Friend updatedFriend = friendMapper.toEntity(request);
                    updatedFriend.setId(existingFriend.getId());
                    return friendRepository.save(updatedFriend).map(friendMapper::toVO);
                });
    }

    @Override
    public Mono<FriendVO> delete(Long id) {
        return friendRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Friend Not Found")))
                .flatMap(friend -> {
                    friend.setDeleted(true);
                    return friendRepository.save(friend).map(friendMapper::toVO);
                });
    }

    @Override
    public Mono<FriendVO> getById(Long id) {
        return friendRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Friend Not Found")))
                .map(friendMapper::toVO);
    }

    @Override
    public Flux<FriendVO> getAll() {
        return friendRepository.findAll().map(friendMapper::toVO);
    }

    @Override
    public Flux<FriendVO> getFriendsByUserId(Long userId) {
        return friendRepository.getAllFriendsByUserId(userId).map(friendMapper::toVO);
    }
}
