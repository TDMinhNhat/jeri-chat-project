package io.github.tdminhnhat.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
@SerdeImport
@Introspected
public record RestingPasswordDTO(

        @NotBlank(message = "can not be null or empty")
        String email,

        @NotBlank(message = "can not be null or empty")
        String password
) {
}
