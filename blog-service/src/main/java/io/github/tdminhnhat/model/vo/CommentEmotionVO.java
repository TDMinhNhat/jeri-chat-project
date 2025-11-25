package io.github.tdminhnhat.model.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Serdeable
@SerdeImport
@Introspected
@Data @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommentEmotionVO extends BaseVO {

    Long commentId;

    Long emotionId;

    Long authorId;
}
