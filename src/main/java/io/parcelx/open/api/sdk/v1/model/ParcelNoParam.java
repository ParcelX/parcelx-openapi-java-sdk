package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.StringJoiner;

public class ParcelNoParam {

    @JsonPropertyDescription("编号，类型由type决定")
    @NotBlank
    @Size(max = 36)
    @NotNull
    private String value;

    @JsonPropertyDescription("编号类型, PARCEL_NO 包裹编号, ORDER_NO 电商订单编号, TRACKING_NO 物流面单编号")
    @NotNull
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
        return new StringJoiner(", ", ParcelNoParam.class.getSimpleName() + "[", "]")
                .add("value='" + value + "'")
                .add("type=" + type)
                .toString();
    }
}
