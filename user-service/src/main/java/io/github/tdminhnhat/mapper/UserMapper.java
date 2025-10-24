package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.micronaut.context.annotation.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserDTO request);

    UserVO toVO(User user);
}
