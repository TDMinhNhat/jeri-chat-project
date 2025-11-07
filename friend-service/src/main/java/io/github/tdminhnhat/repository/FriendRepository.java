package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.Friend;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface FriendRepository extends ReactorCrudRepository<Friend, Long>, ReactorPageableRepository<Friend, Long> {

    @Query(value = """
        select * from friends f
        where f.sender_id = :userId or f.receiver_id = :userId
        and f.deleted = false
        """)
    Flux<Friend> getAllFriendsByUserId(@Parameter("userId") Long userId);
}
