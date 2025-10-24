package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Friend;
import io.github.tdminhnhat.model.dto.FriendDTO;
import io.github.tdminhnhat.model.vo.FriendVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface FriendMapper {
    Friend toEntity(FriendDTO request);

    FriendVO toVO(Friend entity);
}
