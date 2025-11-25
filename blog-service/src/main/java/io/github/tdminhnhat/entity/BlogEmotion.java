package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "blog_emotions")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BlogEmotion extends BaseEntity {

    @MappedProperty(value = "emotion_id", type = DataType.LONG)
    Long emotionId;

    @MappedProperty(value = "blog_id", type = DataType.LONG)
    Long blogId;

    @MappedProperty(value = "author_id", type = DataType.LONG)
    Long authorId;
}
