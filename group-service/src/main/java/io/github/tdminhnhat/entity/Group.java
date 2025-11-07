package io.github.tdminhnhat.entity;

import io.github.tdminhnhat.enums.JoinGroupType;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedEntity(value = "groups")
@Getter @Setter
@NoArgsConstructor
public class Group extends BaseEntity {

    @MappedProperty(value = "title", type = DataType.STRING)
    private String title;

    @MappedProperty(value = "description", type = DataType.STRING)
    private String description;

    @MappedProperty(value = "avatar", type = DataType.STRING)
    private String avatar;

    @MappedProperty(value = "link_group", type = DataType.STRING)
    private String linkGroup;

    @MappedProperty(value = "join_type", type = DataType.STRING)
    private JoinGroupType joinType;
}
