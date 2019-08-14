package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Date;


public class ServiceCompleteInfoParam {

    @JsonPropertyDescription("上报完成附加消息，不可为空")
    private String message;

    @JsonPropertyDescription("上报完成时间，不可为空")
    private Date time;

    @JsonPropertyDescription("上报完成时的位置")
    private String location;

    public String getMessage() {
        return message;
    }

    public ServiceCompleteInfoParam setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public ServiceCompleteInfoParam setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ServiceCompleteInfoParam setLocation(String location) {
        this.location = location;
        return this;
    }
}
