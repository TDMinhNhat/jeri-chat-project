package io.github.tdminhnhat.model.vo;

import io.github.tdminhnhat.enums.GroupMemberRole;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GroupMemberVO extends BaseVO {
    private Long userId;

    private GroupMemberRole role;

    private Long userApproval;
}
