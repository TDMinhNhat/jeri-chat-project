package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public record BlogDTO(
        String content,

        Long ownerId,

        Boolean isPrivate
) {
}
