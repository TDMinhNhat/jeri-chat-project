package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.PrivateChat;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface PrivateChatRepository extends ReactorCrudRepository<PrivateChat, Long>, ReactorPageableRepository<PrivateChat, Long> {
}
