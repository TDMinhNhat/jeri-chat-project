package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;

import java.util.List;

public interface UserService extends IService<UserDTO, Long> {

    @Override
    UserVO add(UserDTO request);

    @Override
    UserVO update(Long id, UserDTO request);

    @Override
    UserVO delete(Long id);

    @Override
    UserVO getById(Long id);

    @Override
    List<UserVO> getAll();
}
