package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "private_chat_emotions")
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class PrivateChatEmotion extends BaseEntity {

    @MappedProperty(value = "private_chat_id", type = DataType.BIGDECIMAL)
    Long privateChatId;

    @MappedProperty(value = "emotion_id", type = DataType.BIGDECIMAL)
    Long emotionId;

    @MappedProperty(value = "user_action", type = DataType.BIGDECIMAL)
    Long userAction;

    public PrivateChatEmotion(Long privateChatId, Long emotionId, Long userAction) {
        super();
        this.privateChatId = privateChatId;
        this.emotionId = emotionId;
        this.userAction = userAction;
    }
}
