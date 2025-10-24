package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.BaseVO;
import io.github.tdminhnhat.model.vo.FriendVO;

import java.util.List;

public interface FriendService extends IService<FriendDTO, Long> {
    @Override
    FriendVO create(FriendDTO request);

    @Override
    FriendVO update(Long id, FriendDTO request);

    @Override
    FriendVO delete(Long id);

    @Override
    FriendVO getById(Long id);

    @Override
    List<FriendVO> getAll();
}
