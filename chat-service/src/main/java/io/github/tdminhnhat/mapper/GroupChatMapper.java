package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.GroupChat;
import io.github.tdminhnhat.model.dto.GroupChatDTO;
import io.github.tdminhnhat.model.vo.GroupChatVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface GroupChatMapper {

    @Mapper.Mapping(to = "deleted", defaultValue = "false")
    @Mapper.Mapping(to = "isRecall", defaultValue = "false")
    GroupChat toEntity(GroupChatDTO request);

    GroupChatVO toVO(GroupChat entity);
}
