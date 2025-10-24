package io.github.tdminhnhat.model.dto;

import io.github.tdminhnhat.enums.JoinGroupType;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Serdeable
@SerdeImport
@Introspected
public record GroupDTO(
        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "exceeds maximum length of {max} characters")
        String title,

        @Size(max = 300, message = "exceeds maximum length of {max} characters")
        String description,

        @NotNull(message = "can not be null or empty")
        JoinGroupType joinType
) {
}
