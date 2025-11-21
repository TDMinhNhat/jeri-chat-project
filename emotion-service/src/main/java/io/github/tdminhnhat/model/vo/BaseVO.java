package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Serdeable
@SerdeImport
@Introspected
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseVO {

    Long id;

    Instant createdAt;

    Instant updatedAt;

    Boolean deleted;

    Long version;
}
