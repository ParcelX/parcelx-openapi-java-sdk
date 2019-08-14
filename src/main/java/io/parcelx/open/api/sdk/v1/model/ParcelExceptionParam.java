package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Date;

public class ParcelExceptionParam {

    @JsonPropertyDescription("异常编码,不能为空[UNKNOWN:未知错误; PLACE_ORDER_ERROR:下单错误;]")
    private ParcelExceptionCode code;

    @JsonPropertyDescription("异常消息,不能为空")
    private String message;

    @JsonPropertyDescription("异常事件")
    //@NotNull
    private Date time;

    @JsonPropertyDescription("位置信息")
    private String location;

    public String getMessage() {
        return message;
    }

    public ParcelExceptionParam setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public ParcelExceptionParam setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ParcelExceptionParam setLocation(String location) {
        this.location = location;
        return this;
    }

    public ParcelExceptionCode getCode() {
        return code;
    }

    public void setCode(ParcelExceptionCode code) {
        this.code = code;
    }
}
