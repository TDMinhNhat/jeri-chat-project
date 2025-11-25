package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public record BlogEmotionDTO(
        Long blogId,

        Long emotionId,

        Long authorId
) {
}
