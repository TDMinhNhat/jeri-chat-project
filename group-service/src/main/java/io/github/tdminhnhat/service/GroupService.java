package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GroupService extends IService<GroupDTO, Long>, IImageService<Long, GroupVO> {

    @Override
    Mono<GroupVO> create(GroupDTO request);

    @Override
    Mono<GroupVO> update(Long id, GroupDTO request);

    @Override
    Mono<GroupVO> delete(Long id);

    @Override
    Mono<GroupVO> getById(Long id);

    @Override
    Flux<GroupVO> getAll();

    @Override
    Mono<GroupVO> uploadImage(Long id, CompletedFileUpload file) throws Exception;

    @Override
    Flux<GroupVO> uploadImages(Long id, List<CompletedFileUpload> files) throws Exception;

    @Override
    Mono<GroupVO> deleteImage(Long id, String imageId) throws Exception;

    @Override
    Flux<GroupVO> deleteImages(Long id, List<String> imageIds) throws Exception;
}
