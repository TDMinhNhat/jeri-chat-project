package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.BlogEmotion;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface BlogEmotionRepository extends ReactorCrudRepository<BlogEmotion, Long>, ReactorPageableRepository<BlogEmotion, Long> {
}
