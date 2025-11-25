package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(GeneratedValue.Type.IDENTITY)
    @MappedProperty(value = "id", type = DataType.LONG)
    Long id;

    @DateCreated
    @MappedProperty(value = "created_at", type = DataType.TIMESTAMP)
    Instant createdAt;

    @DateUpdated
    @MappedProperty(value = "updated_at", type = DataType.TIMESTAMP)
    Instant updatedAt;

    @MappedProperty(value = "deleted", type = DataType.BOOLEAN)
    Boolean deleted;

    @Version
    @MappedProperty(value = "version", type = DataType.LONG)
    Long version;
}
