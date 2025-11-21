package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IController<S extends Record, P extends Number, R extends BaseVO> {
    Mono<R> add(S request);

    Mono<R> update(P id, S request);

    Mono<R> delete(P id);

    Mono<R> getById(P id);

    Flux<R> getAll();
}
