package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id @GeneratedValue(GeneratedValue.Type.IDENTITY)
    @MappedProperty(value = "id", type = DataType.BIGDECIMAL)
    private Long id;

    @MappedProperty(value = "deleted", type = DataType.BOOLEAN)
    private Boolean deleted;

    @DateCreated
    @MappedProperty(value = "created_at", type = DataType.TIMESTAMP)
    private Instant createdAt;

    @DateUpdated
    @MappedProperty(value = "updated_at", type = DataType.TIMESTAMP)
    private Instant updatedAt;

    @Version
    @MappedProperty(value = "version", type = DataType.INTEGER)
    private Integer version;
}
