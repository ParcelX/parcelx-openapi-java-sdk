package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * 包裹相关单号
 */
public class ParcelSimpleResult {
    @JsonPropertyDescription("包裹单号")
    private String parcelNumber;
    @JsonPropertyDescription("物流单号")
    private String trackingNumber;
    @JsonPropertyDescription("电商单号")
    private String orderNumber;

    public String getParcelNumber() {
        return parcelNumber;
    }

    public ParcelSimpleResult setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
        return this;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public ParcelSimpleResult setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public ParcelSimpleResult setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }
}
