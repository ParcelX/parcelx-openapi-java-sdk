package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportType {
    AIR("AIR"),
    LAND("LAND"),
    SEA("SEA");

    @JsonValue
    private final String value;

    TransportType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TransportType fromValue(String value) {
        for (TransportType type : TransportType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
