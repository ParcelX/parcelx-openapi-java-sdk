package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

public class ServiceCompleteInfoParam {

    @JsonPropertyDescription("上报完成附加消息，不可为空")
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String message;

    @JsonPropertyDescription("上报完成时间，不可为空")
    @NotNull
    private Instant time;

    @JsonPropertyDescription("上报完成时的位置")
    @Size(max = 100)
    private String location;

    public String getMessage() {
        return message;
    }

    public ServiceCompleteInfoParam setMessage(String message) {
        this.message = message;
        return this;
    }

    public Instant getTime() {
        return time;
    }

    public ServiceCompleteInfoParam setTime(Instant time) {
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
