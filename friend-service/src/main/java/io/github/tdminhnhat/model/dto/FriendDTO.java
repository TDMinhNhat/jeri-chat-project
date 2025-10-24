package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Serdeable
@SerdeImport
@Introspected
public record FriendDTO(

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long senderId,

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long userId,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 300, message = "must not exceed {max} characters")
        String messageRequest
) {
}
