package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.Address;
import io.github.tdminhnhat.entity.User;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.AddressMapper;
import io.github.tdminhnhat.mapper.UserMapper;
import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.github.tdminhnhat.repository.AddressRepository;
import io.github.tdminhnhat.repository.UserRepository;
import io.github.tdminhnhat.service.UserService;
import io.micronaut.http.multipart.CompletedFileUpload;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    @Override
    public UserVO add(UserDTO request) {
        User user = userMapper.toEntity(request);
        Address address = addressRepository.save(addressMapper.toEntity(request.address()));
        user.setAddress(address);

        user.setCode(generateUserCode(request.firstName(), request.lastName()));
        UserVO userVO = userMapper.toVO(userRepository.save(user));
        userVO.setAddress(addressMapper.toVO(address));
        return userVO;
    }

    @Override
    public UserVO update(Long id, UserDTO request) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        Address address = addressRepository.findByUser_Id(user.getId()).orElseThrow(() -> new QueryNotFoundException("Address Not Found"));
        address = addressMapper.toEntity(request.address());
        user.setAddress(address);
        
        UserVO userVO = userMapper.toVO(userRepository.save(user));
        userVO.setAddress(addressMapper.toVO(address));
        return userVO;
    }

    @Override
    public UserVO delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        user.setDeleted(true);
        Address address = addressRepository.findByUser_Id(user.getId()).orElseThrow(() -> new QueryNotFoundException("Address Not Found"));
        address.setDeleted(true);

        UserVO userVO = userMapper.toVO(userRepository.save(user));
        userVO.setAddress(addressMapper.toVO(addressRepository.save(address)));
        return userVO;
    }

    @Override
    public UserVO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User Not Found"));
        UserVO userVO = userMapper.toVO(user);
        Address address = addressRepository.findByUser_Id(user.getId()).orElseThrow(() -> new QueryNotFoundException("Address Not Found"));
        userVO.setAddress(addressMapper.toVO(address));
        return userVO;
    }

    @Override
    public List<UserVO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toVO).toList();
    }

    @Override
    public UserVO addImage(Long id, CompletedFileUpload upload) {
        try(InputStream inputStream = upload.getInputStream()) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserVO> addListImages(Long id, List<CompletedFileUpload> uploads) {
        return List.of();
    }

    private String generateUserCode(String firstName, String lastName) {
        return UUID.fromString(firstName + " " + lastName).toString();
    }
}
