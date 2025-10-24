package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.GroupMember;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface GroupMemberRepository extends ReactorCrudRepository<GroupMember, Long>, ReactorPageableRepository<GroupMember, Long> {
}
