package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.dto.GroupDTO;
import io.github.tdminhnhat.model.vo.GroupVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GroupService extends IService<GroupDTO, Long> {

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
}
