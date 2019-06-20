package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ParcelLabelResult {

    @JsonPropertyDescription("包裹的国际快递单号")
    private String trackingNo;
    @JsonPropertyDescription("面单对应的包裹单号")
    private String parcelNo;
    @JsonPropertyDescription("电商订单号")
    private String orderNo;
    /**
     * 面单是否已经准备好可以获取
     */
    @JsonPropertyDescription("面单是否已经生成: true已经生成、false尚未生成")
    private boolean isReady;
    /**
     * 面单纸张类型
     * 1: 特殊纸张(10*15厘米）
     * 2: A4纸张(21*29.7厘米)
     * 3: 国内面单(18*10厘米)
     * 4: 标签纸 (10*10厘米)
     * 5: 标签纸(8.05*9厘米)
     */
    @JsonPropertyDescription("面单打印纸张类型: 1 特殊纸张(10*15厘米）、2 A4纸张(21*29.7厘米)、3 国内面单(18*10厘米)" +
            "4 标签纸 (10*10厘米)、5 标签纸(8.05*9厘米)。目前仅支持3 国内面单(18*10厘米)，如有其他需要请与我们联系")
    private String labelType;
    /**
     * 面单格式，PDF或JPG
     */
    @JsonPropertyDescription("生成面单的格式: PDF文件、JPG文件。默认为PDF文件")
    private String labelFormat;
    /**
     * label 文件的 base64 编码
     */
    @JsonPropertyDescription("生成面单文件的Base64的编码")
    private String labelContent;

    public String getTrackingNo() {
        return trackingNo;
    }

    public ParcelLabelResult setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
        return this;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public ParcelLabelResult setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public ParcelLabelResult setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public boolean getIsReady() {
        return isReady;
    }

    public ParcelLabelResult setIsReady(boolean ready) {
        isReady = ready;
        return this;
    }

    public String getLabelType() {
        return labelType;
    }

    public ParcelLabelResult setLabelType(String labelType) {
        this.labelType = labelType;
        return this;
    }

    public String getLabelFormat() {
        return labelFormat;
    }

    public ParcelLabelResult setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
        return this;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public ParcelLabelResult setLabelContent(String labelContent) {
        this.labelContent = labelContent;
        return this;
    }
}
