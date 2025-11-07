package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Serdeable
@SerdeImport
@Introspected
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AddressVO extends BaseVO {

    private String address;

    private String ward;

    private String city;

    private String country;

    private String zipCode;
}
