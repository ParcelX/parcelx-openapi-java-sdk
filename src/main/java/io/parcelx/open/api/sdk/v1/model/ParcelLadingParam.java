package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

public class ParcelLadingParam {
    /**
     * 提单号
     */
    @JsonProperty(index = 1)
    @JsonPropertyDescription("提单号")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String ladingBillNo;
    /**
     * 运输类型
     */

    @JsonPropertyDescription("运输类型, AIR 空运, LAND 陆运, SEA 海运")
    @NotNull
    @JsonProperty(index = 2)
    private TransportType transportType;
    /**
     * 运输编号
     */
    @JsonPropertyDescription("运输编号")
    @NotBlank
    @Size(max = 100)
    @NotNull
    @JsonProperty(index = 3)
    private String transportationNo;
    /**
     * 航运号
     */
    @JsonPropertyDescription("航运号")
    @NotBlank
    @Size(max = 100)
    @NotNull
    @JsonProperty(index = 4)
    private String voyageNo;
    /**
     * 起飞时间
     */
    @JsonPropertyDescription("起飞时间")
    @JsonProperty(index = 5)
    private Instant takeOffTime;
    /**
     * 预计到达时间
     */
    @JsonPropertyDescription("预计到达时间")
    @JsonProperty(index = 6)
    private Instant arrivalTime;
    /**
     * 着陆时间
     */
    @JsonProperty(index = 7)
    @JsonPropertyDescription("着陆时间")
    private Instant landingTime;
    /**
     * 装货港
     */
    @JsonProperty(index = 8)
    @JsonPropertyDescription("装货港")
    @Size(max = 100)
    private String portOfLoading;
    /**
     * 卸货港
     */
    @JsonProperty(index = 9)
    @JsonPropertyDescription("卸货港")
    @Size(max = 100)
    private String portOfDischarge;


    public String getPortOfLoading() {
        return portOfLoading;
    }

    public ParcelLadingParam setPortOfLoading(String portOfLoading) {
        this.portOfLoading = portOfLoading;
        return this;
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public ParcelLadingParam setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
        return this;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public ParcelLadingParam setTransportType(TransportType transportType) {
        this.transportType = transportType;
        return this;
    }

    public Instant getLandingTime() {
        return landingTime;
    }

    public ParcelLadingParam setLandingTime(Instant landingTime) {
        this.landingTime = landingTime;
        return this;
    }

    public Instant getTakeOffTime() {
        return takeOffTime;
    }

    public ParcelLadingParam setTakeOffTime(Instant takeOffTime) {
        this.takeOffTime = takeOffTime;
        return this;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public ParcelLadingParam setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getLadingBillNo() {
        return ladingBillNo;
    }

    public ParcelLadingParam setLadingBillNo(String ladingBillNo) {
        this.ladingBillNo = ladingBillNo;
        return this;
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public ParcelLadingParam setVoyageNo(String voyageNo) {
        this.voyageNo = voyageNo;
        return this;
    }

    public String getTransportationNo() {
        return transportationNo;
    }

    public ParcelLadingParam setTransportationNo(String transportationNo) {
        this.transportationNo = transportationNo;
        return this;
    }
}
