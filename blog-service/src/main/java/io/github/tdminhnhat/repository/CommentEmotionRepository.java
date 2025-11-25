package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.CommentEmotion;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface CommentEmotionRepository extends ReactorCrudRepository<CommentEmotion, Long>, ReactorPageableRepository<CommentEmotion, Long> {
}
