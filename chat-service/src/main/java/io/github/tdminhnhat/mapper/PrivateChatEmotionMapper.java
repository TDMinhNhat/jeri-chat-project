package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.PrivateChat;
import io.github.tdminhnhat.entity.PrivateChatEmotion;
import io.github.tdminhnhat.model.dto.PrivateChatDTO;
import io.github.tdminhnhat.model.dto.PrivateChatEmotionDTO;
import io.github.tdminhnhat.model.vo.PrivateChatEmotionVO;
import io.github.tdminhnhat.model.vo.PrivateChatVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface PrivateChatEmotionMapper {

    PrivateChatEmotion toEntity(PrivateChatEmotionDTO request);

    PrivateChatEmotionVO toVO(PrivateChatEmotion entity);
}
