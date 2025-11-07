package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.Emotion;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface EmotionRepository extends ReactorCrudRepository<Emotion, Long>, ReactorPageableRepository<Emotion, Long> {
}
