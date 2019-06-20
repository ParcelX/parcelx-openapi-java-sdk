package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class ParcelCreationInfo {

    /**
     * 链路识别码
     */
    @JsonPropertyDescription("链路识别码")
    @Size(max = 36)
    @NotNull
    private String routeCode;

    @JsonPropertyDescription("链路编号")
    @Size(max = 36)
    private String routeNo;

    /**
     * 线上订单号
     */
    @JsonPropertyDescription("线上订单号")
    @Size(max = 100)
    @NotNull
    private String onlineOrderNo;

    /**
     * 发货人站点代码 optional
     */
    @JsonPropertyDescription("发货人站点代码")
    @Size(max = 100)
    private String facility;

    /**
     * 批次号
     */
    @JsonPropertyDescription("批次号")
    @Size(max = 100)
    private String lot;

    /**
     * 包裹类型: [0 普通包裹;]
     */
    @JsonPropertyDescription("包裹类型: [0 普通包裹;]")
    @JsonProperty(defaultValue = "0")
    private Integer type = 0;

    /**
     * 包裹里面的sku种类数量
     */
    @JsonPropertyDescription("包裹里面的sku种类数量")
    @Min(0)
    private Integer skuNumber;

    /**
     * 体积
     */
    @JsonPropertyDescription("体积")
    @Min(0)
    private BigDecimal volume;

    /**
     * 毛重
     */
    @JsonPropertyDescription("毛重")
    @Min(0)
    @NotNull
    private BigDecimal grossWeight;

    /**
     * 净重
     */
    @JsonPropertyDescription("净重")
    @Min(0)
    @NotNull
    private BigDecimal netWeight;

    /**
     * 重量单位 公斤kg default kg optional
     */
    @JsonPropertyDescription("重量单位 公斤kg default kg optional")
    @JsonProperty(defaultValue = "kg")
    private String weightUnit = "kg";

    /**
     * 保险费 optional 默认是0
     */
    @JsonPropertyDescription("保险费 optional 默认是0")
    @Min(0)
    @JsonProperty(defaultValue = "0.0")
    private BigDecimal insuranceFee = BigDecimal.ZERO;

    /**
     * 包裹折扣 默认是0
     */
    @JsonPropertyDescription("包裹折扣 默认是0")
    @Min(0)
    @JsonProperty(defaultValue = "0.0")
    private BigDecimal discount = BigDecimal.ZERO;

    /**
     * 包裹税费 默认是0
     */
    @JsonPropertyDescription("包裹税费 默认是0")
    @Min(0)
    @JsonProperty(defaultValue = "0.0")
    private BigDecimal totalTax = BigDecimal.ZERO;

    /**
     * 运杂费 默认是0
     */
    @JsonPropertyDescription("运杂费 默认是0")
    @Min(0)
    @JsonProperty(defaultValue = "0.0")
    private BigDecimal freight = BigDecimal.ZERO;

    /**
     * 包裹总金额
     */
    @JsonPropertyDescription("包裹总金额")
    @Min(0)
    @NotNull
    private BigDecimal itemAmount;

    /**
     * 包裹贸易国
     */
    @JsonPropertyDescription("包裹贸易国, 使用ISO二字码，例如CN")
    @NotNull
    private String tradeCountry;

    /**
     * 付款人法定姓名
     */
    @JsonPropertyDescription("付款人法定姓名")
    @Size(max = 50)
    @NotNull
    private String payerLegalName;

    /**
     * 付款人证件类型
     */
    @JsonPropertyDescription("付款人证件类型")
    @Size(max = 30)
    @NotNull
    private String payerIdType;

    /**
     * 付款人证件号
     */
    @JsonPropertyDescription("付款人证件号")
    @Size(max = 30)
    @NotNull
    private String payerIdNo;

    /**
     * 付款人手机号
     */
    @JsonPropertyDescription("付款人手机号")
    @Size(max = 30)
    @NotNull
    private String payerPhone;

    /**
     * 付款人证件照
     */
    @JsonPropertyDescription("付款人证件照")
    @Size(max = 255)
    private String payerIdPicture;

    /**
     * 付款人证件照_2
     */
    @JsonPropertyDescription("付款人证件照_2")
    @Size(max = 255)
    private String payerIdPicture2;

    /**
     * 支付公司
     */
    @JsonPropertyDescription("支付公司")
    @Size(max = 100)
    @NotNull
    private String paymentCompanyName;

    /**
     * 支付公司编码
     */
    @JsonPropertyDescription("支付公司编码")
    @Size(max = 50)
    private String paymentCompanyCode;

    /**
     * 支付流水编号
     */
    @JsonPropertyDescription("支付流水编号")
    @Size(max = 100)
    @NotNull
    private String paymentOrderNo;

    /**
     * 支付时间
     */
    @JsonPropertyDescription("支付时间")
    @NotNull
    private Instant paymentTime;

    /**
     * 支付金额
     */
    @JsonPropertyDescription("支付金额")
    @Min(0)
    @NotNull
    private BigDecimal paymentAmount;

    /**
     * 支付货币, CNY ISO
     */
    @JsonPropertyDescription("支付货币, ISO标准，例如CNY, 默认CNY")
    @JsonProperty(defaultValue = "CNY")
    private String paymentCurrency = "CNY";

    /**
     * 发件人证件类型 （怎么填都行）
     */
    @JsonPropertyDescription("发件人证件类型")
    @Size(max = 30)
    private String senderIdType;

    /**
     * 发件人证件号 （怎么填都行）
     */
    @JsonPropertyDescription("发件人证件号")
    @Size(max = 30)
    private String senderIdNo;
    /**
     * 寄件人身份证号正面URL（不大于3M）
     */
    @JsonPropertyDescription("寄件人身份证号正面URL")
    @Size(max = 255)
    private String senderIdcardFront;
    /**
     * 寄件人身份证号反面URL（不大于3M）
     */
    @JsonPropertyDescription("寄件人身份证号反面URL")
    @Size(max = 255)
    private String senderIdcardBack;

    /**
     * 发件人国家编号 ISO 2字码
     */
    @JsonPropertyDescription("发件人国家编号 ISO 2字码")
    private String senderCountryCode;

    /**
     * 发件人一级行政区
     */
    @JsonPropertyDescription("发件人一级行政区")
    @Size(max = 100)
    private String senderPrimaryAdministrative;

    /**
     * 发件人二级行政区
     */
    @JsonPropertyDescription("发件人二级行政区")
    @Size(max = 100)
    private String senderSecondAdministrative;

    /**
     * 发件人地址
     */
    @JsonPropertyDescription("发件人地址")
    @Size(max = 100)
    @NotNull
    private String senderAddress;

    /**
     * 发件人门牌号
     */
    @JsonPropertyDescription("发件人门牌号")
    @Size(max = 100)
    private String senderStreetNum;

    /**
     * 发件人邮编
     */
    @JsonPropertyDescription("发件人邮编")
    @Size(max = 100)
    private String senderPostcode;

    /**
     * 发件人公司
     */
    @JsonPropertyDescription("发件人公司")
    @Size(max = 100)
    @NotNull
    private String senderCompanyName;

    /**
     * 发件人姓名
     */
    @JsonPropertyDescription("发件人姓名")
    @Size(max = 50)
    @NotNull
    private String senderName;

    /**
     * 发件人手机号
     */
    @JsonPropertyDescription("发件人手机号")
    @Size(max = 30)
    @NotNull
    private String senderPhone;

    /**
     * 发件人邮箱
     */
    @JsonPropertyDescription("发件人邮箱")
    @Email
    @Size(max = 100)
    private String senderEmail;

    /**
     * 收件人证件类型
     */
    @JsonPropertyDescription("收件人证件类型")
    @Size(max = 100)
    private String recipientIdType;
    /**
     * 收件人证件号
     */
    @JsonPropertyDescription("收件人证件号")
    @Size(max = 100)
    private String recipientIdNo;

    /**
     * 收件人国家编号 ISO 二字码
     */
    @JsonPropertyDescription("收件人国家编号 ISO 二字码")
    private String recipientCountryCode;

    /**
     * 收件人一级行政区
     */
    @JsonPropertyDescription("收件人一级行政区")
    @Size(max = 100)
    private String recipientPrimaryAdministrative;

    /**
     * 收件人二级行政区
     */
    @JsonPropertyDescription("收件人二级行政区")
    @Size(max = 100)
    private String recipientSecondAdministrative;

    /**
     * 收件人三级行政区
     */
    @JsonPropertyDescription("收件人三级行政区")
    @Size(max = 100)
    private String recipientThirdAdministrative;

    /**
     * 收件人地址
     */
    @JsonPropertyDescription("收件人地址")
    @Size(max = 100)
    @NotNull
    private String recipientAddress;

    /**
     * 收件人门牌号
     */
    @JsonPropertyDescription("收件人门牌号")
    @Size(max = 100)
    private String recipientStreetNum;

    /**
     * 收件人邮编
     */
    @JsonPropertyDescription("收件人邮编")
    @Size(max = 100)
    private String recipientPostcode;

    /**
     * 收件人公司
     */
    @JsonPropertyDescription("收件人公司")
    @Size(max = 100)
    private String recipientCompanyName;

    /**
     * 收件人姓名
     */
    @JsonPropertyDescription("收件人姓名")
    @Size(max = 50)
    @NotNull
    private String recipientName;

    /**
     * 收件人电话
     */
    @JsonPropertyDescription("收件人电话")
    @Size(max = 30)
    @NotNull
    private String recipientPhone;

    /**
     * 收件人邮箱
     */
    @JsonPropertyDescription("收件人邮箱")
    @Email
    @Size(max = 100)
    private String recipientEmail;

    /**
     * 退件人邮编
     */
    @JsonPropertyDescription("退件人邮编")
    @Size(max = 100)
    private String returnPostcode;

    /**
     * 退件人门牌号
     */
    @JsonPropertyDescription("退件人门牌号")
    @Size(max = 100)
    private String returnStreetNum;

    /**
     * 退件人详细地址
     */
    @JsonPropertyDescription("退件人详细地址")
    @Size(max = 100)
    private String returnAddress;

    /**
     * 退件人二级行政区
     */
    @JsonPropertyDescription("退件人二级行政区址")
    @Size(max = 100)
    private String returnSecondAdministrative;

    /**
     * 退件人一级行政区
     */
    @JsonPropertyDescription("退件人一级行政区")
    @Size(max = 100)
    private String returnPrimaryAdministrative;

    /**
     * 退件人国家编号
     */
    @JsonPropertyDescription("退件人国家编号")
    private String returnCountryCode;

    /**
     * 退件人邮箱
     */
    @JsonPropertyDescription("退件人邮箱")
    @Email
    private String returnEmail;

    /**
     * 退件人电话
     */
    @JsonPropertyDescription("退件人电话")
    @Size(max = 30)
    private String returnPhone;

    /**
     * 退件人名称
     */
    @JsonPropertyDescription("退件人名称")
    @Size(max = 30)
    private String returnName;

    /**
     * 退件人企业名称
     */
    @JsonPropertyDescription("退件人企业名称")
    @Size(max = 100)
    private String returnCompanyName;

    /**
     * 退件类型：back_to_owner 退给寄件人，back_to_other 退给其他人，destroy_local 原地销毁
     */
    @JsonPropertyDescription("退件类型：back_to_owner 退给寄件人，back_to_other 退给其他人，destroy_local 原地销毁")
    private String returnType;

    /**
     * 购买人在电商的账号
     */
    @JsonPropertyDescription("购买人在电商的账号")
    @Size(max = 30)
    private String buyerEcAccount;

    /**
     * 购买人全名
     */
    @JsonPropertyDescription("购买人全名")
    @Size(max = 30)
    private String buyerFullName;

    /**
     * 购买人电话
     */
    @JsonPropertyDescription("购买人电话")
    @Size(max = 30)
    private String buyerPhone;

    /** 购买人证件类型 */
    /**
     * TODO: 修改数据库类型
     **/
    @JsonPropertyDescription("购买人证件类型")
    @Size(max = 30)
    private String buyerIdType;

    /**
     * 购买人证件号码
     */
    @JsonPropertyDescription("购买人证件号码")
    @Size(max = 30)
    private String buyerIdNo;

    /**
     * 购买人证件照片
     */
    @JsonPropertyDescription("购买人证件照片")
    @Size(max = 255)
    private String buyerIdPicture;

    /**
     * 购买人证件照片2
     */
    @JsonPropertyDescription("购买人证件照片2")
    @Size(max = 255)
    private String buyerIdPicture2;

    /**
     * 预计入库时间 预估什么时候送到物流商仓库的时间
     */
    @JsonPropertyDescription("预计入库时间 预估什么时候送到物流商仓库的时间")
    private Instant predictPutTime;

    /**
     * 是否需要人签收，0不需要，1需要。默认不需要
     */
    @JsonPropertyDescription("是否需要人签收，0不需要，1需要。默认不需要")
    private Integer needSignature = 0;

    /**
     * 尺寸单位：cm,m,默认cm
     */
    @JsonPropertyDescription("尺寸单位：cm,m,默认cm")
    @JsonProperty(defaultValue = "cm")
    private String dimensionUnit = "cm";

    /**
     * 电商企业的登记名称，对应清单的收发货人。
     */
    @JsonPropertyDescription("电商企业的登记名称，对应清单的收发货人")
    @Size(max = 50)
    private String ebcName;

    /**
     * 电商企业在海关注册登记编号或统一社会信用代码，对应清单的收发货人。
     */
    @JsonPropertyDescription("电商企业在海关注册登记编号或统一社会信用代码，对应清单的收发货人")
    @Size(max = 50)
    private String ebcCode;

    /**
     * 电商平台的登记名称
     */
    @JsonPropertyDescription("电商平台的登记名称")
    @Size(max = 50)
    private String ebpName;

    /**
     * 电商平台在海关注册登记编号或统一社会信用代码
     */
    @JsonPropertyDescription("电商平台在海关注册登记编号或统一社会信用代码")
    @Size(max = 50)
    private String ebpCode;

    /**
     * 是否危险品
     */
    @JsonPropertyDescription("是否危险品")
    @JsonProperty(defaultValue = "false")
    private Boolean isDangerous;

    /**
     * 非必须拓展字段
     */
    @JsonPropertyDescription("非必须拓展字段")
    private Object vendors;

    /**
     * 商品列表
     */
    @JsonPropertyDescription("商品列表")
    @NotNull
    @Size(min = 1)
    private List<ParcelItem> items;

    public List<ParcelItem> getItems() {
        return items;
    }

    public void setItems(List<ParcelItem> items) {
        this.items = items;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public String getOnlineOrderNo() {
        return onlineOrderNo;
    }

    public void setOnlineOrderNo(String onlineOrderNo) {
        this.onlineOrderNo = onlineOrderNo;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(Integer skuNumber) {
        this.skuNumber = skuNumber;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getTradeCountry() {
        return tradeCountry;
    }

    public void setTradeCountry(String tradeCountry) {
        this.tradeCountry = tradeCountry;
    }

    public String getPayerLegalName() {
        return payerLegalName;
    }

    public void setPayerLegalName(String payerLegalName) {
        this.payerLegalName = payerLegalName;
    }

    public String getPayerIdType() {
        return payerIdType;
    }

    public void setPayerIdType(String payerIdType) {
        this.payerIdType = payerIdType;
    }

    public String getPayerIdNo() {
        return payerIdNo;
    }

    public void setPayerIdNo(String payerIdNo) {
        this.payerIdNo = payerIdNo;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerIdPicture() {
        return payerIdPicture;
    }

    public void setPayerIdPicture(String payerIdPicture) {
        this.payerIdPicture = payerIdPicture;
    }

    public String getPayerIdPicture2() {
        return payerIdPicture2;
    }

    public void setPayerIdPicture2(String payerIdPicture2) {
        this.payerIdPicture2 = payerIdPicture2;
    }

    public String getPaymentCompanyName() {
        return paymentCompanyName;
    }

    public void setPaymentCompanyName(String paymentCompanyName) {
        this.paymentCompanyName = paymentCompanyName;
    }

    public String getPaymentCompanyCode() {
        return paymentCompanyCode;
    }

    public void setPaymentCompanyCode(String paymentCompanyCode) {
        this.paymentCompanyCode = paymentCompanyCode;
    }

    public String getPaymentOrderNo() {
        return paymentOrderNo;
    }

    public void setPaymentOrderNo(String paymentOrderNo) {
        this.paymentOrderNo = paymentOrderNo;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public String getSenderIdType() {
        return senderIdType;
    }

    public void setSenderIdType(String senderIdType) {
        this.senderIdType = senderIdType;
    }

    public String getSenderIdNo() {
        return senderIdNo;
    }

    public void setSenderIdNo(String senderIdNo) {
        this.senderIdNo = senderIdNo;
    }

    public String getSenderIdcardFront() {
        return senderIdcardFront;
    }

    public void setSenderIdcardFront(String senderIdcardFront) {
        this.senderIdcardFront = senderIdcardFront;
    }

    public String getSenderIdcardBack() {
        return senderIdcardBack;
    }

    public void setSenderIdcardBack(String senderIdcardBack) {
        this.senderIdcardBack = senderIdcardBack;
    }

    public String getSenderCountryCode() {
        return senderCountryCode;
    }

    public void setSenderCountryCode(String senderCountryCode) {
        this.senderCountryCode = senderCountryCode;
    }

    public String getSenderPrimaryAdministrative() {
        return senderPrimaryAdministrative;
    }

    public void setSenderPrimaryAdministrative(String senderPrimaryAdministrative) {
        this.senderPrimaryAdministrative = senderPrimaryAdministrative;
    }

    public String getSenderSecondAdministrative() {
        return senderSecondAdministrative;
    }

    public void setSenderSecondAdministrative(String senderSecondAdministrative) {
        this.senderSecondAdministrative = senderSecondAdministrative;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderStreetNum() {
        return senderStreetNum;
    }

    public void setSenderStreetNum(String senderStreetNum) {
        this.senderStreetNum = senderStreetNum;
    }

    public String getSenderPostcode() {
        return senderPostcode;
    }

    public void setSenderPostcode(String senderPostcode) {
        this.senderPostcode = senderPostcode;
    }

    public String getSenderCompanyName() {
        return senderCompanyName;
    }

    public void setSenderCompanyName(String senderCompanyName) {
        this.senderCompanyName = senderCompanyName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecipientIdType() {
        return recipientIdType;
    }

    public void setRecipientIdType(String recipientIdType) {
        this.recipientIdType = recipientIdType;
    }

    public String getRecipientIdNo() {
        return recipientIdNo;
    }

    public void setRecipientIdNo(String recipientIdNo) {
        this.recipientIdNo = recipientIdNo;
    }

    public String getRecipientCountryCode() {
        return recipientCountryCode;
    }

    public void setRecipientCountryCode(String recipientCountryCode) {
        this.recipientCountryCode = recipientCountryCode;
    }

    public String getRecipientPrimaryAdministrative() {
        return recipientPrimaryAdministrative;
    }

    public void setRecipientPrimaryAdministrative(String recipientPrimaryAdministrative) {
        this.recipientPrimaryAdministrative = recipientPrimaryAdministrative;
    }

    public String getRecipientSecondAdministrative() {
        return recipientSecondAdministrative;
    }

    public void setRecipientSecondAdministrative(String recipientSecondAdministrative) {
        this.recipientSecondAdministrative = recipientSecondAdministrative;
    }

    public String getRecipientThirdAdministrative() {
        return recipientThirdAdministrative;
    }

    public void setRecipientThirdAdministrative(String recipientThirdAdministrative) {
        this.recipientThirdAdministrative = recipientThirdAdministrative;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientStreetNum() {
        return recipientStreetNum;
    }

    public void setRecipientStreetNum(String recipientStreetNum) {
        this.recipientStreetNum = recipientStreetNum;
    }

    public String getRecipientPostcode() {
        return recipientPostcode;
    }

    public void setRecipientPostcode(String recipientPostcode) {
        this.recipientPostcode = recipientPostcode;
    }

    public String getRecipientCompanyName() {
        return recipientCompanyName;
    }

    public void setRecipientCompanyName(String recipientCompanyName) {
        this.recipientCompanyName = recipientCompanyName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getReturnPostcode() {
        return returnPostcode;
    }

    public void setReturnPostcode(String returnPostcode) {
        this.returnPostcode = returnPostcode;
    }

    public String getReturnStreetNum() {
        return returnStreetNum;
    }

    public void setReturnStreetNum(String returnStreetNum) {
        this.returnStreetNum = returnStreetNum;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getReturnSecondAdministrative() {
        return returnSecondAdministrative;
    }

    public void setReturnSecondAdministrative(String returnSecondAdministrative) {
        this.returnSecondAdministrative = returnSecondAdministrative;
    }

    public String getReturnPrimaryAdministrative() {
        return returnPrimaryAdministrative;
    }

    public void setReturnPrimaryAdministrative(String returnPrimaryAdministrative) {
        this.returnPrimaryAdministrative = returnPrimaryAdministrative;
    }

    public String getReturnCountryCode() {
        return returnCountryCode;
    }

    public void setReturnCountryCode(String returnCountryCode) {
        this.returnCountryCode = returnCountryCode;
    }

    public String getReturnEmail() {
        return returnEmail;
    }

    public void setReturnEmail(String returnEmail) {
        this.returnEmail = returnEmail;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnCompanyName() {
        return returnCompanyName;
    }

    public void setReturnCompanyName(String returnCompanyName) {
        this.returnCompanyName = returnCompanyName;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getBuyerEcAccount() {
        return buyerEcAccount;
    }

    public void setBuyerEcAccount(String buyerEcAccount) {
        this.buyerEcAccount = buyerEcAccount;
    }

    public String getBuyerFullName() {
        return buyerFullName;
    }

    public void setBuyerFullName(String buyerFullName) {
        this.buyerFullName = buyerFullName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerIdType() {
        return buyerIdType;
    }

    public void setBuyerIdType(String buyerIdType) {
        this.buyerIdType = buyerIdType;
    }

    public String getBuyerIdNo() {
        return buyerIdNo;
    }

    public void setBuyerIdNo(String buyerIdNo) {
        this.buyerIdNo = buyerIdNo;
    }

    public String getBuyerIdPicture() {
        return buyerIdPicture;
    }

    public void setBuyerIdPicture(String buyerIdPicture) {
        this.buyerIdPicture = buyerIdPicture;
    }

    public String getBuyerIdPicture2() {
        return buyerIdPicture2;
    }

    public void setBuyerIdPicture2(String buyerIdPicture2) {
        this.buyerIdPicture2 = buyerIdPicture2;
    }

    public Instant getPredictPutTime() {
        return predictPutTime;
    }

    public void setPredictPutTime(Instant predictPutTime) {
        this.predictPutTime = predictPutTime;
    }

    public Integer getNeedSignature() {
        return needSignature;
    }

    public void setNeedSignature(Integer needSignature) {
        this.needSignature = needSignature;
    }

    public String getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(String dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public String getEbcName() {
        return ebcName;
    }

    public void setEbcName(String ebcName) {
        this.ebcName = ebcName;
    }

    public String getEbcCode() {
        return ebcCode;
    }

    public void setEbcCode(String ebcCode) {
        this.ebcCode = ebcCode;
    }

    public String getEbpName() {
        return ebpName;
    }

    public void setEbpName(String ebpName) {
        this.ebpName = ebpName;
    }

    public String getEbpCode() {
        return ebpCode;
    }

    public void setEbpCode(String ebpCode) {
        this.ebpCode = ebpCode;
    }

    public Boolean getIsDangerous() {
        return isDangerous;
    }

    public void setIsDangerous(Boolean isDangerous) {
        isDangerous = isDangerous;
    }

    public Object getVendors() {
        return vendors;
    }

    public void setVendors(Object vendors) {
        this.vendors = vendors;
    }
}
