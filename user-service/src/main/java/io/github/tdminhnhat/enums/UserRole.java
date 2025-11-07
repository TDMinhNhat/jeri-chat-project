package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    USER("User"),
    MANAGER("Manager"),
    ADMIN("Admin");

    private final String roleName;
}
