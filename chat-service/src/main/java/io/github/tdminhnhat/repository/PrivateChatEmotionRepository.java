package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.PrivateChatEmotion;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;

@MongoRepository
public interface PrivateChatEmotionRepository extends ReactorCrudRepository<PrivateChatEmotion, Long>, ReactorPageableRepository<PrivateChatEmotion, Long> {

    Flux<PrivateChatEmotion> findByPrivateChatId(Long id);
}
