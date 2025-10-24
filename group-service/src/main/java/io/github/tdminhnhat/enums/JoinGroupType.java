package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JoinGroupType {
    PUBLIC("Public"),
    NEED_APPROVAL("Need Approval"),
    PRIVATE("Private");
    
    private final String type;
}
