package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;
import java.util.Date;


public class ParcelInfoResult extends ParcelCreationInfo {

    /**
     * 编号
     */
    @JsonPropertyDescription("包裹编号")
    private String parcelNo;

    /**
     * 所属账户编号
     */
    @JsonPropertyDescription("所属账户编号")
    private String accountNo;

//    /**
//     * 第三方订单号
//     */
//    private String thirdPartyOrderNo;

    /**
     * 国际快递编号
     */
    @JsonPropertyDescription("国际快递编号")
    @JsonProperty("trackingNo")
    private String internationalDeliveryNo;

    /**
     * 提单号
     */
    @JsonPropertyDescription("提单号")
    private String billOfLadingNo;

    /**
     * 包裹服务完成时间(包裹收件时间)
     */
    @JsonPropertyDescription("包裹服务完成时间(包裹收件时间)")
    @JsonProperty("serviceCompleteTime")
    private Date receiveTime;

    /**
     * 包裹运费
     */
    @JsonPropertyDescription("包裹运费")
    private BigDecimal freightCharge;

    /**
     * 包裹运费币种
     */
    @JsonPropertyDescription("包裹运费币种")
    private String freightChargeCurrency;

    /**
     * 包裹状态
     */
    @JsonPropertyDescription("包裹状态")
    private Integer status;

    /**
     * 扣费状态 @PaymentStatus
     */
    @JsonPropertyDescription("扣费状态")
    private String billStatus;


    public String getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getInternationalDeliveryNo() {
        return internationalDeliveryNo;
    }

    public void setInternationalDeliveryNo(String internationalDeliveryNo) {
        this.internationalDeliveryNo = internationalDeliveryNo;
    }

    public String getBillOfLadingNo() {
        return billOfLadingNo;
    }

    public void setBillOfLadingNo(String billOfLadingNo) {
        this.billOfLadingNo = billOfLadingNo;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public BigDecimal getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(BigDecimal freightCharge) {
        this.freightCharge = freightCharge;
    }

    public String getFreightChargeCurrency() {
        return freightChargeCurrency;
    }

    public void setFreightChargeCurrency(String freightChargeCurrency) {
        this.freightChargeCurrency = freightChargeCurrency;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }


}
