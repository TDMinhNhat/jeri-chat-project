package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "comment_emotions")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentEmotion extends BaseEntity {

    @MappedProperty(value = "comment_id", type = DataType.LONG)
    Long commentId;

    @MappedProperty(value = "emotion_id", type = DataType.LONG)
    Long emotionId;

    @MappedProperty(value = "author_id", type = DataType.LONG)
    Long authorId;
}
