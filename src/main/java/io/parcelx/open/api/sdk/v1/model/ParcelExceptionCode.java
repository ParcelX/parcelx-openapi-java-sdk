package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ParcelExceptionCode {

    // 人工处理的指定这个
    UNKNOWN("UNKNOWN", "未知错误"),
    PLACE_ORDER_ERROR("PLACE_ORDER_ERROR", "下单错误");
    //TODO: more errors

    /**
     * 代码
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;

    ParcelExceptionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @JsonCreator
    public static ParcelExceptionCode fromValue(String code) {
        for (ParcelExceptionCode value : ParcelExceptionCode.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return UNKNOWN;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
