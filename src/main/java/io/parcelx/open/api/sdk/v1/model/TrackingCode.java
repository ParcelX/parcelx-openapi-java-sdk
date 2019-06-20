package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat
public enum TrackingCode {

    UNKNOWN(0, "UNKNOWN", "未知"),

    COLLECT(1001, "COLLECT", "已拣货"),

    SHIPPED(1002, "SHIPPED", "已发货"),

    TAKEOFF(2001, "TAKEOFF", "已起运"),

    LANDING(2004, "LANDING", "已着陆"),

    HANDOVER(3001, "HANDOVER", "已提货"),

    CLEARANCE_START(3003, "CR_START", "开始清关"),

    CLEARANCE_END(3005, "CR_END", "清关结束"),

    DELIVERING(4003, "DELIVERING", "配送中"),

    USER_SIGNED(4005, "SINGED", "已签收");

    private final String strCode;
    private int code;
    private String desc;

    TrackingCode(int code, String strCode, String desc) {
        this.code = code;
        this.strCode = strCode;
        this.desc = desc;
    }

    @JsonCreator
    public static TrackingCode fromValue(String strCode) {
        for (TrackingCode code : TrackingCode.values()) {
            if (code.strCode.equals(strCode)) {
                return code;
            }
        }
        return UNKNOWN;
    }


    public static TrackingCode fromIntValue(Integer intCode) {
        for (TrackingCode code : TrackingCode.values()) {
            if (code.code == intCode) {
                return code;
            }
        }
        return UNKNOWN;
    }

    @JsonValue
    public String getStrCode() {
        return strCode;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
