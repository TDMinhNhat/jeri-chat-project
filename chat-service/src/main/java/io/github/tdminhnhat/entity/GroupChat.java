package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "group_chats")
@Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupChat extends BaseEntity {

    @MappedProperty(value = "group_id", type = DataType.BIGDECIMAL)
    Long groupId;

    @MappedProperty(value = "sender_id", type = DataType.BIGDECIMAL)
    Long senderId;

    @MappedProperty(value = "message", type = DataType.STRING)
    String message;

    @MappedProperty(value = "is_recall", type = DataType.BOOLEAN)
    Boolean isRecall;

    public GroupChat(Long groupId, Long senderId, String message) {
        super();
        this.groupId = groupId;
        this.senderId = senderId;
        this.message = message;
        this.isRecall = false;
    }
}
