package io.github.tdminhnhat.entity;

import io.github.tdminhnhat.enums.FriendStatus;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedEntity(value = "friends")
@Getter @Setter
@NoArgsConstructor
public class Friend extends BaseEntity {

    @MappedProperty(value = "sender_id", type = DataType.BIGDECIMAL)
    private Long senderId;

    @MappedProperty(value = "receiver_id", type = DataType.BIGDECIMAL)
    private Long receiverId;

    @MappedProperty(value = "message_request", type = DataType.STRING)
    private String messageRequest;

    @MappedProperty(value = "status", type = DataType.STRING)
    private FriendStatus status;
}
