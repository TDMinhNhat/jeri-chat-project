package io.github.tdminhnhat.model.vo;

import io.github.tdminhnhat.entity.Emotion;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Serdeable
@SerdeImport
@Introspected
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChatEmotionVO extends BaseVO {
    Long groupId;

    EmotionVO emotionVO;

    Long userAction;
}
