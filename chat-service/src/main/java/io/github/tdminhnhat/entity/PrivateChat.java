package io.github.tdminhnhat.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@MappedEntity(value = "private_chats")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PrivateChat extends BaseEntity {

    @MappedProperty(value = "friend_id", type = DataType.BIGDECIMAL)
    Long friendId;

    @MappedProperty(value = "sender_id", type = DataType.BIGDECIMAL)
    Long senderId;

    @MappedProperty(value = "message", type = DataType.STRING)
    String message;

    @MappedProperty(value = "is_recall", type = DataType.BOOLEAN)
    Boolean isRecall;
}
