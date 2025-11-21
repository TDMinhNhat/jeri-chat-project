package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "categories")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    @MappedProperty(value = "code", type = DataType.STRING)
    @NonNull
    String code;

    @MappedProperty(value = "name", type = DataType.STRING)
    @NonNull
    String name;

    @MappedProperty(value = "icon", type = DataType.STRING)
    String icon;

    @MappedProperty(value = "description", type = DataType.STRING)
    String description;

    public Category(@NonNull String code, @NonNull String name, String icon, String description) {
        this.code = code;
        this.name = name;
        this.icon = icon;
        this.description = description;
    }
}
