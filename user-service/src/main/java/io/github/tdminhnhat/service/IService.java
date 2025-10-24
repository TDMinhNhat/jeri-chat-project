package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.vo.BaseVO;

import java.util.List;

public interface IService<S extends Record, P extends Number> {

    Object add(S request);

    Object update(P id, S request);

    Object delete(P id);

    Object getById(P id);

    List<? extends BaseVO> getAll();
}
