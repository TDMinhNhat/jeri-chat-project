package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.Group;
import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface GroupMapper {
    Group toEntity(GroupDTO request);

    GroupVO toVO(Group entity);
}
