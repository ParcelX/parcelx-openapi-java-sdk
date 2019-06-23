package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于openApi对接使用，后边可以对其进行扩展
 */
public class RouteWithOpenApiBean {
    /**
     * 链路编码
     */
    @JsonPropertyDescription("链路ID")
    private String routeNo;
    /**
     * 链路自定义编码
     */
    @JsonPropertyDescription("链路自定义编码")
    private String routeCode;
    /**
     * 链路名称
     */
    @JsonPropertyDescription("链路名称，唯一不可重复")
    private String name;
    /**
     * 链路描述
     */
    @JsonPropertyDescription("链路信息描述(备注)")
    private String description;
    /**
     * 承诺期限
     */
    @JsonPropertyDescription("链路承诺期限，承诺期限 = 结束时间 - 开始时间")
    private BigDecimal commitmentDuration;
    /**
     * 平均时间
     */
    @JsonPropertyDescription("链路运输包裹的平均时间")
    private String averageDuration;
    /**
     * 开始时间
     */
    @JsonPropertyDescription("链路的开始使用时间")
    private Date startDate;
    /**
     * 结束时间
     */
    @JsonPropertyDescription("链路停止使用的时间")
    private Date endDate;
    /**
     * 链路状态
     */
    @JsonPropertyDescription("链路状态: 1 启用、2 停用、3 重新恢复使用")
    private String status;
    /**
     * 总评分
     */
    @JsonPropertyDescription("链路评分: 最低分0，最高分100")
    private BigDecimal overallScore;
    /**
     * 集货仓
     */
    @JsonPropertyDescription("链路的集货仓信息")
    private Warehouse warehouse;
    /**
     * 干线承运
     */
    @JsonPropertyDescription("链路的干线承运信息")
    private CrossborderCarrier crossborderCarrier;
    /**
     * 海关清关
     */
    @JsonPropertyDescription("链路的海关清关信息")
    private CustomClearence customClearence;
    /**
     * 本地配送
     */
    @JsonPropertyDescription("链路的本地配送信息")
    private LocalDelivery localDelivery;

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCommitmentDuration() {
        return commitmentDuration;
    }

    public void setCommitmentDuration(BigDecimal commitmentDuration) {
        this.commitmentDuration = commitmentDuration;
    }

    public String getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(String averageDuration) {
        this.averageDuration = averageDuration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(BigDecimal overallScore) {
        this.overallScore = overallScore;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public CrossborderCarrier getCrossborderCarrier() {
        return crossborderCarrier;
    }

    public void setCrossborderCarrier(CrossborderCarrier crossborderCarrier) {
        this.crossborderCarrier = crossborderCarrier;
    }

    public CustomClearence getCustomClearence() {
        return customClearence;
    }

    public void setCustomClearence(CustomClearence customClearence) {
        this.customClearence = customClearence;
    }

    public LocalDelivery getLocalDelivery() {
        return localDelivery;
    }

    public void setLocalDelivery(LocalDelivery localDelivery) {
        this.localDelivery = localDelivery;
    }

    @Override
    public String toString() {
        return "RouteWithOpenApiBean{" +
                "routeNo='" + routeNo + '\'' +
                ", routeCode='" + routeCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", commitmentDuration=" + commitmentDuration +
                ", averageDuration='" + averageDuration + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", overallScore=" + overallScore +
                ", warehouse=" + warehouse +
                ", crossborderCarrier=" + crossborderCarrier +
                ", customClearence=" + customClearence +
                ", localDelivery=" + localDelivery +
                '}';
    }

    /**
     * 集货仓
     */
    public static class Warehouse {
        /**
         * 服务id
         */
        @JsonPropertyDescription("集货仓ID")
        private String serviceNo;
        /**
         * 服务自定义编码
         */
        @JsonPropertyDescription("集货仓服务商自定义编码")
        private String serviceCode;
        /**
         * 服务名称
         */
        @JsonPropertyDescription("集货仓名称")
        private String serviceName;
        /**
         * 服务国际描述名称
         */
        @JsonPropertyDescription("集货仓本地化语言名称")
        private String serviceGlobalName;
        /**
         * 账户编号
         */
        @JsonPropertyDescription("集货仓服务提供商的账户编号")
        private String accountNo;
        /**
         * 账户名称
         */
        @JsonPropertyDescription("集货仓服务提供商的账户名称")
        private String accountName;
        /**
         * 服务地址
         */
        @JsonPropertyDescription("集货仓的服务地址，格式: 国家-一级行政区-二级行政区-详细地址")
        private String serviceAddress;

        public String getServiceNo() {
            return serviceNo;
        }

        public void setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceGlobalName() {
            return serviceGlobalName;
        }

        public void setServiceGlobalName(String serviceGlobalName) {
            this.serviceGlobalName = serviceGlobalName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getServiceAddress() {
            return serviceAddress;
        }

        public void setServiceAddress(String serviceAddress) {
            this.serviceAddress = serviceAddress;
        }
    }

    /**
     * 干线承运
     */
    public static class CrossborderCarrier {
        /**
         * 服务id
         */
        @JsonPropertyDescription("干线承运ID")
        private String serviceNo;
        /**
         * 服务自定义编码
         */
        @JsonPropertyDescription("干线承运服务商自定义编码")
        private String serviceCode;
        /**
         * 服务名称
         */
        @JsonPropertyDescription("干线承运服务名称")
        private String serviceName;
        /**
         * 服务国际化名称
         */
        @JsonPropertyDescription("干线承运本地化语言名称")
        private String serviceGlobalName;
        /**
         * 账户编号
         */
        @JsonPropertyDescription("干线承运服务提供商的账户编号")
        private String accountNo;
        /**
         * 账户名称
         */
        @JsonPropertyDescription("干线承运服务提供商的账户名称")
        private String accountName;
        /**
         * 装货港服务地址
         */
        @JsonPropertyDescription("干线承运服务装货港的服务地址，格式: 国家-一级行政区-二级行政区-详细地址")
        private String dischargeServiceAddress;
        /**
         * 卸货港港服务地址
         */
        @JsonPropertyDescription("干线承运服务卸货港的服务地址，格式: 国家-一级行政区-二级行政区-详细地址")
        private String loadingServiceAddress;
        /**
         * 运输类型
         */
        @JsonPropertyDescription("干线承运服务的运输类型: air 空中运输、sea 航空运输、land 陆地运输")
        private String carrierType;
        /**
         * 运输类型国际化描述
         */
        @JsonPropertyDescription("干线承运服务的运输类型本地化语言描述")
        private String carrierTypeDesc;

        public String getServiceNo() {
            return serviceNo;
        }

        public void setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceGlobalName() {
            return serviceGlobalName;
        }

        public void setServiceGlobalName(String serviceGlobalName) {
            this.serviceGlobalName = serviceGlobalName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getDischargeServiceAddress() {
            return dischargeServiceAddress;
        }

        public void setDischargeServiceAddress(String dischargeServiceAddress) {
            this.dischargeServiceAddress = dischargeServiceAddress;
        }

        public String getLoadingServiceAddress() {
            return loadingServiceAddress;
        }

        public void setLoadingServiceAddress(String loadingServiceAddress) {
            this.loadingServiceAddress = loadingServiceAddress;
        }

        public String getCarrierType() {
            return carrierType;
        }

        public void setCarrierType(String carrierType) {
            this.carrierType = carrierType;
        }

        public String getCarrierTypeDesc() {
            return carrierTypeDesc;
        }

        public void setCarrierTypeDesc(String carrierTypeDesc) {
            this.carrierTypeDesc = carrierTypeDesc;
        }
    }

    /**
     * 海关清关
     */
    public static class CustomClearence {
        /**
         * 服务id
         */
        @JsonPropertyDescription("海关清关ID")
        private String serviceNo;
        /**
         * 服务自定义编码
         */
        @JsonPropertyDescription("海关清关服务商自定义编码")
        private String serviceCode;
        /**
         * 服务名称
         */
        @JsonPropertyDescription("海关清关服务名称")
        private String serviceName;
        /**
         * 服务国际化名称
         */
        @JsonPropertyDescription("海关清关本地化语言名称")
        private String serviceGlobalName;
        /**
         * 账户编号
         */
        @JsonPropertyDescription("海关清关服务提供商的账户编号")
        private String accountNo;
        /**
         * 账户名称
         */
        @JsonPropertyDescription("海关清关服务提供商的账户名称")
        private String accountName;
        /**
         * 服务地址
         */
        @JsonPropertyDescription("海关清关的服务地址，格式: 国家-一级行政区-二级行政区-详细地址")
        private String serviceAddress;
        /**
         * 清关类型
         */
        @JsonPropertyDescription("海关清关的清关类型: BC 直邮清关、 CC 行邮清关、DDU、 DDP")
        private String clearanceType;
        /**
         * 清关类型国际化描述
         */
        @JsonPropertyDescription("海关清关的清关类型本地化描述")
        private String clearanceTypeDesc;

        public String getServiceNo() {
            return serviceNo;
        }

        public void setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceGlobalName() {
            return serviceGlobalName;
        }

        public void setServiceGlobalName(String serviceGlobalName) {
            this.serviceGlobalName = serviceGlobalName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getServiceAddress() {
            return serviceAddress;
        }

        public void setServiceAddress(String serviceAddress) {
            this.serviceAddress = serviceAddress;
        }

        public String getClearanceType() {
            return clearanceType;
        }

        public void setClearanceType(String clearanceType) {
            this.clearanceType = clearanceType;
        }

        public String getClearanceTypeDesc() {
            return clearanceTypeDesc;
        }

        public void setClearanceTypeDesc(String clearanceTypeDesc) {
            this.clearanceTypeDesc = clearanceTypeDesc;
        }
    }

    /**
     * 本地配送
     */
    public static class LocalDelivery {
        /**
         * 服务id
         */
        @JsonPropertyDescription("本地配送ID")
        private String serviceNo;
        /**
         * 服务自定义编码
         */
        @JsonPropertyDescription("本地配送服务商自定义编码")
        private String serviceCode;
        /**
         * 服务名称
         */
        @JsonPropertyDescription("本地配送服务名称")
        private String serviceName;
        /**
         * 服务国际化名称
         */
        @JsonPropertyDescription("本地配送本地化语言名称")
        private String serviceGlobalName;
        /**
         * 账户编号
         */
        @JsonPropertyDescription("本地配送服务提供商的账户编号")
        private String accountNo;
        /**
         * 账户名称
         */
        @JsonPropertyDescription("本地配送服务提供商的账户名称")
        private String accountName;
        /**
         * 服务地址
         */
        @JsonPropertyDescription("本地配送的服务地址，格式: 国家-一级行政区-二级行政区-详细地址")
        private String serviceAddress;

        public String getServiceNo() {
            return serviceNo;
        }

        public void setServiceNo(String serviceNo) {
            this.serviceNo = serviceNo;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceGlobalName() {
            return serviceGlobalName;
        }

        public void setServiceGlobalName(String serviceGlobalName) {
            this.serviceGlobalName = serviceGlobalName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getServiceAddress() {
            return serviceAddress;
        }

        public void setServiceAddress(String serviceAddress) {
            this.serviceAddress = serviceAddress;
        }
    }
}