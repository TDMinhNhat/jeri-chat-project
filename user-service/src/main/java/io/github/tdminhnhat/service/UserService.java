package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.UserDTO;
import io.github.tdminhnhat.model.vo.UserVO;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.util.List;

public interface UserService extends IService<UserDTO, Long>, IImageService<Long> {

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

    @Override
    UserVO addImage(Long id, CompletedFileUpload upload);

    @Override
    List<UserVO> addListImages(Long id, List<CompletedFileUpload> uploads);
}
