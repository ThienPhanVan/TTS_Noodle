package com.cg.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PENDING("PENDING"), COMPLETED("COMPLETED"), CANCELLED("CANCELLED") ;


    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OrderStatus parseOrderStatus(String value) {
        OrderStatus[] values = values();
        for (OrderStatus userStatus : values) {
            if (userStatus.value.equals(value)) return userStatus;
        }
        throw new IllegalArgumentException(value + "invalid");
    }


}
