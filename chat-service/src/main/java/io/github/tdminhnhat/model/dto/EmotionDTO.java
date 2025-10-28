package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
@Introspected
public record EmotionDTO(
        @NotBlank(message = "can not be null or empty")
        String emotionName
) {
}
