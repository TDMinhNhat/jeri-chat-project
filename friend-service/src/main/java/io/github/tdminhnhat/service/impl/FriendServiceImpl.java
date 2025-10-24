package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.mapper.FriendMapper;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.FriendVO;
import io.github.tdminhnhat.repository.FriendRepository;
import io.github.tdminhnhat.service.FriendService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    @Override
    public FriendVO create(FriendDTO request) {
        return null;
    }

    @Override
    public FriendVO update(Long id, FriendDTO request) {
        return null;
    }

    @Override
    public FriendVO delete(Long id) {
        return null;
    }

    @Override
    public FriendVO getById(Long id) {
        return null;
    }

    @Override
    public List<FriendVO> getAll() {
        return List.of();
    }
}
