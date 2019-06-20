package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

public class TrackingEventParam {

    @JsonPropertyDescription("轨迹代码: \n UNKNOWN 未知, COLLECT 已拣货, SHIPPED 已发货, TAKEOFF 已起运, LANDING 已着陆, HANDOVER 已提货, " +
            "CR_START 开始清关, CR_END 清关结束, DELIVERING 配送中, SINGED 已签收. \n (如果找不到对应代码，请使用UNKNOWN) ")
    @NotNull
    private TrackingCode code;

    @JsonPropertyDescription("轨迹文本信息")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String message;

    @JsonPropertyDescription("轨迹事件发生时间，请使用UTC时间")
    @NotNull
    private Instant time;

    @JsonPropertyDescription("轨迹发生所在地点，如城市: 上海")
    @Size(max = 300)
    private String location;

    @JsonPropertyDescription("轨迹事件备注信息")
    @Size(max = 100)
    private String remark;

    public TrackingCode getCode() {
        return code;
    }

    public TrackingEventParam setCode(TrackingCode code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public TrackingEventParam setMessage(String message) {
        this.message = message;
        return this;
    }

    public Instant getTime() {
        return time;
    }

    public TrackingEventParam setTime(Instant time) {
        this.time = time;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public TrackingEventParam setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public TrackingEventParam setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
