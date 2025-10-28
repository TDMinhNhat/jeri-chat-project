package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.PrivateChat;
import io.github.tdminhnhat.model.dto.PrivateChatDTO;
import io.github.tdminhnhat.model.vo.PrivateChatVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface PrivateChatMapper {

    @Mapper.Mapping(to = "isRecall", defaultValue = "false")
    PrivateChat toEntity(PrivateChatDTO request);

    PrivateChatVO toVO(PrivateChat entity);
}
