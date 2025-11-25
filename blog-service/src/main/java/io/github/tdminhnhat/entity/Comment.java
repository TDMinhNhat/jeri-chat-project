package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@MappedEntity(value = "comments")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {

    @MappedProperty(value = "comment", type = DataType.STRING)
    String comment;

    @MappedProperty(value = "author_id", type = DataType.LONG)
    Long authorId;

    @MappedProperty(value = "blog_id", type = DataType.LONG)
    Long blogId;

    @MappedProperty(value = "images", type = DataType.STRING_ARRAY)
    List<String> images;

    @MappedProperty(value = "files", type = DataType.STRING_ARRAY)
    List<String> files;
}
