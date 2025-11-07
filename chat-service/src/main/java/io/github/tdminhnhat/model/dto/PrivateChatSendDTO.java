package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
@SerdeImport
@Introspected
public record PrivateChatSendDTO(

        @NotBlank(message = "can not be null or empty")
        Long receiverId,

        @NotBlank(message = "can not be null or empty")
        String message
) {
}
