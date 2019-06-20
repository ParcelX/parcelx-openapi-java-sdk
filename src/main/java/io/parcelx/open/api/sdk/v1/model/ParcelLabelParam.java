package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParcelLabelParam {

    /**
     * 面单纸张类型
     * 1: 特殊纸张(10*15厘米）
     * 2: A4纸张(21*29.7厘米)
     * 3: 国内面单(18*10厘米)
     * 4: 标签纸 (10*10厘米)
     * 5: 标签纸(8.05*9厘米)
     */
    @JsonPropertyDescription("面单打印纸张类型: 1 特殊纸张(10*15厘米）、2 A4纸张(21*29.7厘米)、3 国内面单(18*10厘米)" +
            "4 标签纸 (10*10厘米)、5 标签纸(8.05*9厘米)。目前仅支持4 (10*10厘米)，如有其他需要请与我们联系")
    private String labelType = "4";
    /**
     * 面单格式，PDF或JPG
     */
    @JsonPropertyDescription("生成面单的格式: PDF文件、JPG文件。默认PDF文件")
    private String labelFormat = "PDF";
    /**
     * label 文件的 base64 编码
     */
    @JsonPropertyDescription("生成面单文件的Base64的编码")
    @NotBlank
    private String labelContent;
    /**
     * UBI追踪单号，也就是国际物流单号
     */
    @JsonPropertyDescription("包裹的国际快递单号")
    @Size(max = 100)
    private String trackingNo;

    public String getTrackingNo() {
        return trackingNo;
    }

    public ParcelLabelParam setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
        return this;
    }

    public String getLabelType() {
        return labelType;
    }

    public ParcelLabelParam setLabelType(String labelType) {
        this.labelType = labelType;
        return this;
    }

    public String getLabelFormat() {
        return labelFormat;
    }

    public ParcelLabelParam setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
        return this;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public ParcelLabelParam setLabelContent(String labelContent) {
        this.labelContent = labelContent;
        return this;
    }
}
