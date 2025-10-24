package io.github.tdminhnhat.service;

import java.util.List;

public interface IService<S extends Record, P extends Number>{
    Object create(S request);

    Object update(P id, S request);

    Object delete(P id);

    Object getById(P id);

    List<?> getAll();
}
