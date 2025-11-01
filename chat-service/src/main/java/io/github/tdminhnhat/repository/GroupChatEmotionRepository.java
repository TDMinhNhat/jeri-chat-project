package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.GroupChatEmotion;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;

@MongoRepository
public interface GroupChatEmotionRepository extends ReactorCrudRepository<GroupChatEmotion, Long>, ReactorPageableRepository<GroupChatEmotion, Long> {

    Flux<GroupChatEmotion> findByGroupId(Long groupId);
}
