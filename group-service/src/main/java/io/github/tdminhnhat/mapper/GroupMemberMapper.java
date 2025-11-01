package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.GroupMember;
import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface GroupMemberMapper {
    GroupMember toEntity(GroupMemberDTO request);

    GroupMemberVO toVO(GroupMember entity);
}
