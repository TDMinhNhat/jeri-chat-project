package io.github.tdminhnhat.entity;

import io.github.tdminhnhat.enums.GroupMemberRole;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.model.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedEntity(value = "group_members")
@Getter @Setter
@NoArgsConstructor
public class GroupMember extends BaseEntity {

    @Relation(value = Relation.Kind.MANY_TO_ONE)
    @MappedProperty(value = "group_id", type = DataType.LONG)
    private Group group;

    @MappedProperty(value = "user_id", type = DataType.LONG)
    private Long userId;

    @MappedProperty(value = "role", type = DataType.STRING)
    private GroupMemberRole role;

    @MappedProperty(value = "user_approval", type = DataType.LONG)
    private Long userApproval;
}
