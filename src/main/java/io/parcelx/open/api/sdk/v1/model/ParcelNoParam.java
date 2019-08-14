package io.parcelx.open.api.sdk.v1.model;

public class ParcelNoParam {

    private String value;

    private ParcelNoType type;

    public String getValue() {
        return value;
    }

    public ParcelNoParam setValue(String value) {
        this.value = value;
        return this;
    }

    public ParcelNoType getType() {
        return type;
    }

    public ParcelNoParam setType(ParcelNoType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "ParcelNoParam{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
