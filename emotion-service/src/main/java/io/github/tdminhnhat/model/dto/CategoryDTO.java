package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Serdeable
@SerdeImport
@Introspected
public record CategoryDTO(
        @NotBlank(message = "can not be null or empty")
        @Size(max = 20, message = "must not exceed {max} characters")
        String code,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 200, message = "must not exceed {max} characters")
        String name,

        @Size(max = 500, message = "must not exceed {max} characters")
        String description
) {
}
