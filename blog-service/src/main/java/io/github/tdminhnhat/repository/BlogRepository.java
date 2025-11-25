package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.Blog;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@MongoRepository
public interface BlogRepository extends ReactorCrudRepository<Blog, Long>, ReactorPageableRepository<Blog, Long> {
}
