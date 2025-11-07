package io.github.tdminhnhat.mapper;

import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface UserMapper {

    User toEntity(UserDTO request);

    UserVO toVO(User user);
}
