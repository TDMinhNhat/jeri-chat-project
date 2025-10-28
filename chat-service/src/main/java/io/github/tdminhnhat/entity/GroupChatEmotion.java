package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "group_chat_emotions")
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChatEmotion extends BaseEntity {

    @MappedProperty(value = "group_id", type = DataType.BIGDECIMAL)
    private Long groupId;

    @MappedProperty(value = "emotion_id", type = DataType.BIGDECIMAL)
    private Long emotionId;

    @MappedProperty(value = "user_action", type = DataType.BIGDECIMAL)
    private Long userAction;
}
