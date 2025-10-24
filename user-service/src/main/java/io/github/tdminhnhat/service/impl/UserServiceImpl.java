package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.UserMapper;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.github.tdminhnhat.repository.UserRepository;
import io.github.tdminhnhat.service.UserService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserVO add(UserDTO request) {
        User user = userMapper.toEntity(request);
        user.setCode(generateUserCode());
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO update(Long id, UserDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        user.setDeleted(true);
        return userMapper.toVO(userRepository.save(user));
    }

    @Override
    public UserVO getById(Long id) {
        return userMapper.toVO(userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found")));
    }

    @Override
    public List<UserVO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toVO).toList();
    }

    private String generateUserCode() {
        return "";
    }
}
