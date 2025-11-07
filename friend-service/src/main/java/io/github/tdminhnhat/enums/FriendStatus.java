package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FriendStatus {
    SEND_REQUEST("Send"), ACCEPTED("Accept"), REJECTED("Reject"), BLOCKED("Block"), CANCELED("Cancel");

    private final String status;
}
