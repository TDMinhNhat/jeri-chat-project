package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Serdeable
@SerdeImport
@Introspected
@Data @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseVO {
    Long id;

    Boolean deleted;

    Instant createdAt;

    Instant updatedAt;
}
