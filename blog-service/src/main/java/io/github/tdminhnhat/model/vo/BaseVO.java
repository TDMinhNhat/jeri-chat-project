package io.github.tdminhnhat.model.vo;

import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Serdeable
@SerdeImport
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor @AllArgsConstructor
public abstract class BaseVO {
    Long id;

    Instant createdAt;

    Instant updatedAt;

    Boolean deleted;

    Long version;
}
