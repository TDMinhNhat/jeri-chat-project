package io.github.tdminhnhat.model.dto;

import io.github.tdminhnhat.enums.UserGender;
import io.github.tdminhnhat.enums.UserRole;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Serdeable
@SerdeImport
@Introspected
public record UserDTO(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "must not exceed {max} characters")
        String firstName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "must not exceed {max} characters")
        String lastName,

        @NotNull(message = "can not be null or empty")
        UserGender gender,

        @NotNull(message = "can not be null or empty")
        LocalDate birthDate,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 30, message = "must not exceed {max} characters")
        String phoneNumber,

        AddressDTO address,

        @NotNull(message = "can not be null or empty")
        UserRole role,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "must not exceed {max} characters")
        String displayName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 200, message = "must not exceed {max} characters")
        String email,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "must not exceed {max} characters")
        String password
) {
}
