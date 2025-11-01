package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Serdeable
@Introspected
public record GroupChatEmotionDTO(

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long groupId,

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long emotionId,

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long userAction
) {
}
