package io.github.tdminhnhat.model.vo;

import io.github.tdminhnhat.enums.JoinGroupType;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;

import java.util.List;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GroupVO extends BaseVO {
    private String title;

    private String description;

    private String avatar;

    private String linkGroup;

    private JoinGroupType joinType;

    private Flux<GroupMemberVO> groupMembers;
}
