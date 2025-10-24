package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public abstract class BaseVO {
    private Long id;

    private Boolean deleted;

    private Instant createdAt;

    private Instant updatedAt;

    private Integer version;
}
