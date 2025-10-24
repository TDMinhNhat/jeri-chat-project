package io.github.tdminhnhat.model.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Size;

@Serdeable
@SerdeImport
@Introspected
public record AddressDTO(

        @Size(max = 50, message = "must not exceed {max} characters")
        String address,

        @Size(max = 50, message = "must not exceed {max} characters")
        String ward,

        @Size(max = 50, message = "must not exceed {max} characters")
        String city,

        @Size(max = 50, message = "must not exceed {max} characters")
        String country,

        @Size(max = 50, message = "must not exceed {max} characters")
        String zipCode
) {
}
