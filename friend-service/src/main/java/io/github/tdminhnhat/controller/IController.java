package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.HttpResponse;

import java.util.List;

public interface IController<S extends Record, P extends Number, R extends BaseVO> {
    HttpResponse<R> add(S request);

    HttpResponse<R> update(P id, S request);

    HttpResponse<R> delete(P id);

    HttpResponse<R> getById(P id);

    HttpResponse<List<R>> getAll();
}
