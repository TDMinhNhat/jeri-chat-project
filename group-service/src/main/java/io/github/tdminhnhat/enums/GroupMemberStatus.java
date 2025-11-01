package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupMemberStatus {
    JOINING("Joining"),
    KICKED("Kicked"),
    LEFT("Left"),
    BLOCKED("Blocked");

    private final String status;
}
