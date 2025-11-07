package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.GroupChatEmotion;
import io.github.tdminhnhat.model.dto.GroupChatEmotionDTO;
import io.github.tdminhnhat.model.vo.GroupChatEmotionVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface GroupChatEmotionMapper {

    GroupChatEmotion toEntity(GroupChatEmotionDTO request);

    GroupChatEmotionVO toVO(GroupChatEmotion entity);
}
