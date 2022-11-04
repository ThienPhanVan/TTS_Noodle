package com.cg.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {
    NEW("NEW"), CHECKOUT("CHECKOUT"), PAID("PAID"), FAILED("FAILED") ;


    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static UserStatus parseOrderStatus(String value) {
        UserStatus[] values = values();
        for (UserStatus userStatus : values) {
            if (userStatus.value.equals(value)) return userStatus;
        }
        throw new IllegalArgumentException(value + "invalid");
    }
}
