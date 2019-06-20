package io.parcelx.open.api.sdk.v1.model;

import java.math.BigDecimal;

/**
 * @author xinfeng
 * @version 1.0
 * @date 2019/6/5 18:22
 */
public class ParcelItemsParam {
    /** 包裹编号 */
    private String parcelNo;
    /** 货物编号 */
    private String itemNo;
    /** 海关识别码 */
    private String hsCode;
    /** 商家订单编号 */
    private String onlineOrderNo;
    /** 条形码 */
    private String barCode;
    /** 品牌 */
    private String brand;
    /** 货物sku */
    private String productSKU;
    /** 货物名称 */
    private String productName;
    /** 本地化货物名称 */
    private String nativeProductName;
    /** 商品类型 */
    private String productType;
    /** 货物描述 */
    private String productDescription;
    /** 货物单位 */
    private String productUnit;
    /** 商品url */
    private String url;
    /** 原产地 */
    private String origin;
    /** 规格 */
    private String specification;
    /** 毛重 */
    private BigDecimal grossWeight;
    /** 净重 */
    private BigDecimal netWeight;
    /** 重量单位 */
    private String weightUnit;
    /** 单价 */
    private BigDecimal unitPrice;
    /** 币种 */
    private String currency;
    /** 单位 JGS-20 海关业务代码集 */
    private String unit;
    /** 数量 */
    private Integer quantity;
    /** 金额 */
    private BigDecimal amount;
    /** 库位，如产品已在集货仓，则传递库位信息 */
    private String warehouseNo;
    /** 扩展字段1 */
    private String ext1;

    /** 包裹编号 */
    public String getParcelNo() {
        return parcelNo;
    }

    /** 包裹编号 */
    public void setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
    }

    /** 货物编号 */
    public String getItemNo() {
        return itemNo;
    }

    /** 货物编号 */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    /** 海关识别码 */
    public String getHsCode() {
        return hsCode;
    }

    /** 海关识别码 */
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    /** 商家订单编号 */
    public String getOnlineOrderNo() {
        return onlineOrderNo;
    }

    /** 商家订单编号 */
    public void setOnlineOrderNo(String onlineOrderNo) {
        this.onlineOrderNo = onlineOrderNo;
    }

    /** 条形码 */
    public String getBarCode() {
        return barCode;
    }

    /** 条形码 */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /** 品牌 */
    public String getBrand() {
        return brand;
    }

    /** 品牌 */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** 货物sku */
    public String getProductSKU() {
        return productSKU;
    }

    /** 货物sku */
    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    /** 货物名称 */
    public String getProductName() {
        return productName;
    }

    /** 货物名称 */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNativeProductName() {
        return nativeProductName;
    }

    public void setNativeProductName(String nativeProductName) {
        this.nativeProductName = nativeProductName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    /** 货物描述 */
    public String getProductDescription() {
        return productDescription;
    }

    /** 货物描述 */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /** 货物单位 */
    public String getProductUnit() {
        return productUnit;
    }

    /** 货物单位 */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    /** 商品url */
    public String getUrl() {
        return url;
    }

    /** 商品url */
    public void setUrl(String url) {
        this.url = url;
    }

    /** 原产地 */
    public String getOrigin() {
        return origin;
    }

    /** 原产地 */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /** 规格 */
    public String getSpecification() {
        return specification;
    }

    /** 规格 */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /** 毛重 */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /** 毛重 */
    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    /** 净重 */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /** 净重 */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /** 重量单位 */
    public String getWeightUnit() {
        return weightUnit;
    }

    /** 重量单位 */
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    /** 单价 */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /** 单价 */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /** 币种 */
    public String getCurrency() {
        return currency;
    }

    /** 币种 */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /** 单位 JGS-20 海关业务代码集 */
    public String getUnit() {
        return unit;
    }

    /** 单位 JGS-20 海关业务代码集 */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /** 数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 金额 */
    public BigDecimal getAmount() {
        return amount;
    }

    /** 金额 */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /** 库位，如产品已在集货仓，则传递库位信息 */
    public String getWarehouseNo() {
        return warehouseNo;
    }

    /** 库位，如产品已在集货仓，则传递库位信息 */
    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    /** 扩展字段 */
    public String getExt1() {
        return ext1;
    }

    /** 扩展字段 */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }
}