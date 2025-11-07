package io.github.tdminhnhat.repository;

import io.github.tdminhnhat.entity.GroupMember;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@R2dbcRepository(dialect = Dialect.POSTGRES)
public interface GroupMemberRepository extends ReactorCrudRepository<GroupMember, Long>, ReactorPageableRepository<GroupMember, Long> {

    Flux<GroupMember> findByGroup_Id(Long groupId);

    Mono<GroupMember> findByGroup_IdAndUserId(Long groupId, Long memberId);

    Flux<GroupMember> findByGroup_IdAndUserIdIn(Long groupId, Long[] memberIds);
}
