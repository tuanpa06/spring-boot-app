package com.tuandev.app.Constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Roles {
    ADMIN(1),
    USER(2),
    STAFF(3);

    int value;

    public static Roles fromValue(int value) {
        for (Roles role : values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role value: " + value);
    }
}
