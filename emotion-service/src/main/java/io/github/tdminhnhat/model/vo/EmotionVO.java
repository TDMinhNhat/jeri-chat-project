package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Serdeable
@SerdeImport
@Introspected
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class EmotionVO extends BaseVO {

    String code;

    String name;

    String icon;

    String iconUrl;

    String description;
}
