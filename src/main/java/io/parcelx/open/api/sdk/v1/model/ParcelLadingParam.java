package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.Date;

public class ParcelLadingParam {
    /**
     * 提单号
     */
    @JsonPropertyDescription("提单号")
    private String ladingBillNo;
    /**
     * 运输类型
     */

    @JsonPropertyDescription("运输类型, AIR 空运, LAND 陆运, SEA 海运")
    private TransportType transportType;
    /**
     * 运输编号
     */
    @JsonPropertyDescription("运输编号")
    private String transportationNo;
    /**
     * 航运号
     */
    @JsonPropertyDescription("航运号")
    private String voyageNo;
    /**
     * 起飞时间
     */
    @JsonPropertyDescription("起飞时间")
    private Date takeOffTime;
    /**
     * 预计到达时间
     */
    @JsonPropertyDescription("预计到达时间")
    private Date arrivalTime;
    /**
     * 着陆时间
     */
    @JsonPropertyDescription("着陆时间")
    private Date landingTime;
    /**
     * 装货港
     */
    @JsonPropertyDescription("装货港")
    private String portOfLoading;
    /**
     * 卸货港
     */
    @JsonPropertyDescription("卸货港")
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

    public Date getLandingTime() {
        return landingTime;
    }

    public ParcelLadingParam setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
        return this;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public ParcelLadingParam setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
        return this;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public ParcelLadingParam setArrivalTime(Date arrivalTime) {
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
