package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.GroupChat;
import io.github.tdminhnhat.model.dto.GroupChatDTO;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Mono;

@MongoRepository
public interface GroupChatRepository extends ReactorCrudRepository<GroupChat, Long>, ReactorPageableRepository<GroupChat, Long> {

}
