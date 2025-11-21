package io.github.tdminhnhat.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService<S extends Record, P extends Number> {
    
    Mono<?> add(S request);
    
    Mono<?> update(P id, S request);
    
    Mono<?> delete(P id);
    
    Mono<?> getById(P id);
    
    Flux<?> getAll();
}
