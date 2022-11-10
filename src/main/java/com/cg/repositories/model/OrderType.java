package com.cg.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {
    PURCHASE("PURCHASE"), CUSTOMER("CUSTOMER");

    private final String value;

    OrderType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OrderType parseOrderType(String value) {
        OrderType[] values = values();
        for (OrderType type : values) {
            if (type.value.equals(value)) return type;
        }
        throw new IllegalArgumentException(value + "invalid");
    }

}
