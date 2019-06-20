package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

public class ParcelTrackingResult {

    @JsonPropertyDescription("国际物流单号")
    @NotNull
    private String trackingNo;
    @JsonPropertyDescription("电商订单编号")
    @NotNull
    private String orderNo;
    @JsonPropertyDescription("包裹编号")
    @NotNull
    private String parcelNo;
    /**
     * 事件列表，按照时间顺序排列
     */
    @JsonPropertyDescription("事件列表")
    @NotNull
    private List<TrackingEvent> events;

    public String getTrackingNo() {
        return trackingNo;
    }

    public ParcelTrackingResult setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public ParcelTrackingResult setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public ParcelTrackingResult setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
        return this;
    }

    public List<TrackingEvent> getEvents() {
        return events;
    }

    public ParcelTrackingResult setEvents(List<TrackingEvent> events) {
        this.events = events;
        return this;
    }

    public static class TrackingEvent {
        /**
         * 记录时间
         */
        @JsonPropertyDescription("记录时间")
        @NotNull
        private Instant createTime;
        /**
         * 事件发生时间
         */
        @JsonPropertyDescription("事件发生时间")
        @NotNull
        private Instant time;
        /**
         * 地点、城市
         */
        @JsonPropertyDescription("事件发生地点")
        private String location;
        /**
         * 消息
         */
        @JsonPropertyDescription("事件描述文字")
        @NotNull
        private String message;
        /**
         * 备注
         */
        @JsonPropertyDescription("事件备注信息")
        private String remark;
        /**
         * 状态代码
         */
        @JsonPropertyDescription("事件代码")
        @NotNull
        private TrackingCode code;

        public Instant getCreateTime() {
            return createTime;
        }

        public TrackingEvent setCreateTime(Instant createTime) {
            this.createTime = createTime;
            return this;
        }

        public Instant getTime() {
            return time;
        }

        public TrackingEvent setTime(Instant time) {
            this.time = time;
            return this;
        }

        public String getLocation() {
            return location;
        }

        public TrackingEvent setLocation(String location) {
            this.location = location;
            return this;
        }

        public String getMessage() {
            return message;
        }

        public TrackingEvent setMessage(String message) {
            this.message = message;
            return this;
        }

        public String getRemark() {
            return remark;
        }

        public TrackingEvent setRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public TrackingCode getCode() {
            return code;
        }

        public TrackingEvent setCode(TrackingCode status) {
            this.code = status;
            return this;
        }
    }
}
