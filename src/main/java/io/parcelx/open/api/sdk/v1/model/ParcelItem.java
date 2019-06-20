package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author zhaolu
 * @version 1.0
 * @datetime 6/11/2019 12:17 PM
 * @email zhao.lu@parcelx.io
 */
public class ParcelItem {
    /**
     * 货物编号
     */
    @JsonPropertyDescription("货物编号")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String itemNo;
    /**
     * 海关识别码
     */
    @JsonPropertyDescription("海关识别码")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String hsCode;
//    /** 商家订单编号 */
//    @NotBlank
//    @Size(max = 100)
//    private String onlineOrderNo;
    /**
     * 条形码
     */
    @JsonPropertyDescription("条形码")
    @Size(max = 100)
    private String barCode;
    /**
     * 品牌
     */
    @JsonPropertyDescription("品牌")
    @Size(max = 100)
    private String brand;
//    /** 货物sku */
//    @Size(max = 100)
//    private String productSKU;
    /**
     * 货物名称
     */
    @JsonPropertyDescription("货物名称")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String productName;
    /**
     * 本地化货物名称
     */
    @JsonPropertyDescription("本地化货物名称")
    @Size(max = 100)
    private String nativeProductName;
//    /** 商品类型 */
//    @Size(max = 100)
//    private String productType;
    /**
     * 货物描述
     */
    @JsonPropertyDescription("货物描述")
    @Size(max = 100)
    private String productDescription;
    /**
     * 货物单位
     */
    @JsonPropertyDescription("货物单位")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String productUnit;
    /**
     * 商品url
     */
    @JsonPropertyDescription("商品url")
    @NotBlank
    @Size(max = 2000)
    @NotNull
    private String url;
    /**
     * 原产地
     */
    @JsonPropertyDescription("原产地")
    @NotBlank
    @Size(max = 100)
    @NotNull
    private String origin;
    /**
     * 规格
     */
    @JsonPropertyDescription("规格")
    @NotBlank
    @Size(max = 255)
    @NotNull
    private String specification;
    /**
     * 毛重
     */
    @JsonPropertyDescription("毛重")
    @NotNull
    @Min(0)
    private BigDecimal grossWeight;
    /**
     * 净重
     */
    @JsonPropertyDescription("净重")
    @NotNull
    @Min(0)
    private BigDecimal netWeight;
//    /**
//     * 重量单位 公斤kg default kg optional
//     */
//    @EnumString(enums = {"kg"})
//    private String weightUnit = "kg";
    /**
     * 单价
     */
    @JsonPropertyDescription("单价")
    @NotNull
    @Min(0)
    private BigDecimal unitPrice;
    /**
     * 币种
     */
    @JsonPropertyDescription("币种, ISO标准，例如CNY")
    @NotNull
    private String currency;
//    /** 单位 JGS-20 海关业务代码集 */
//    @Size(max = 30)
//    private String unit;
    /**
     * 数量
     */
    @JsonPropertyDescription("数量")
    @NotNull
    @Min(0)
    private Integer quantity;
//    /** 金额 */
//    @Min(0)
//    private BigDecimal amount;
//    /** 库位，如产品已在集货仓，则传递库位信息 */
//    @Size(max = 50)
//    private String warehouseNo;
//    /** 扩展字段1 */
//    private String ext1;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }


    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNativeProductName() {
        return nativeProductName;
    }

    public void setNativeProductName(String nativeProductName) {
        this.nativeProductName = nativeProductName;
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
