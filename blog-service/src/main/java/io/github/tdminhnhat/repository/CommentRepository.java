package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.Comment;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface CommentRepository extends ReactorCrudRepository<Comment, Long>, ReactorPageableRepository<Comment, Long> {
}
