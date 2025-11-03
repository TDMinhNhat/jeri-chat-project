package io.github.tdminhnhat.model.vo;

import io.github.tdminhnhat.enums.UserGender;
import io.github.tdminhnhat.enums.UserRole;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserVO extends BaseVO {
    private String code;

    private String firstName;

    private String lastName;

    private UserGender gender;

    private LocalDate birthDate;

    private String phoneNumber;

    private AddressVO address;

    private String avatar;

    private String avatarUrl;

    private UserRole role;

    private String displayName;

    private String email;
}
