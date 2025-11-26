package io.github.tdminhnhat.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Serdeable
@SerdeImport
@Introspected
public record UserLoginDTO(

        @NotBlank(message = "can not be null or empty")
        String account,

        @NotBlank(message = "can not be null or empty")
        String password
) {

}
