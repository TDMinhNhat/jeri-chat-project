package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupMemberRole {
    MEMBER("Member"),
    CO_OWNER("Co_Owner"),
    OWNER("Owner");

    private final String type;
}
