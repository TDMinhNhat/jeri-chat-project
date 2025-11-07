package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Serdeable
@Introspected
public record PrivateChatDTO(
        @NotNull(message = "can not be null or empty")
        Long friendId,

        @NotNull(message = "can not be null or empty")
        Long senderId,

        @NotBlank(message = "can not be null or empty")
        String message
) {
}
