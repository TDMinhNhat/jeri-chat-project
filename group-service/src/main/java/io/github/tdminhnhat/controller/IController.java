package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IController<S extends Record, P extends Number> {
    Mono<? extends BaseVO> add(S request);

    Mono<? extends BaseVO> update(P id, S request);

    Mono<? extends BaseVO> delete(P id);

    Mono<? extends BaseVO> getById(P id);

    Flux<? extends BaseVO> getAll();
}
