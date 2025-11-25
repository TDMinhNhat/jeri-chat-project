package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@MappedEntity(value = "blogs")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Blog extends BaseEntity {

    @MappedProperty(value = "content", type = DataType.STRING)
    String content;

    @MappedProperty(value = "owner_id", type = DataType.LONG)
    Long ownerId;

    @MappedProperty(value = "is_private", type = DataType.BOOLEAN)
    Boolean isPrivate;

    @MappedProperty(value = "images", type = DataType.STRING_ARRAY)
    List<String> images;

    @MappedProperty(value = "files", type = DataType.STRING_ARRAY)
    List<String> files;
}
