package io.github.tdminhnhat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserGender {

    MALE("Male"),

    FEMALE("Female"),

    OTHER("Other"),

    NO_ANSWER("No_Answer");

    private final String type;
}
