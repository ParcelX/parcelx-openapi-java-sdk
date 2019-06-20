package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class ParcelListQueryParam {

    @JsonPropertyDescription("包裹查询条件, CREATED 查询已创建状态的包裹, " +
            "COMMITTED 查询已经提交状态的包裹, PROCESSING 查询正在处理中的包裹, " +
            "MISSING_LABEL 查询还没有面单数据的包裹, MISSING_TRACKING_NUMBER 查询还没有物流单号的包裹, " +
            "EXCEPTION 查询异常的包裹, SERVICE_COMPLETE 查询服务完成的包裹, " +
            "CONFIRM_COMPLETE 查询已经被电商确认服务完成的包裹, FAILED 查询所有失败的包裹")
    @NotNull
    private ParcelQueryCriteria criteria;
    /**
     * 开始时间，为null表示没有开始时间限制
     */
    @JsonPropertyDescription("开始时间，为null表示没有开始时间限制")
    private Instant startTime;
    /**
     * 结束时间，为null表示没有结束时间限制
     */
    @JsonPropertyDescription("结束时间，为null表示没有结束时间限制")
    private Instant endTime;
    /**
     * 一页返回多少记录
     */
    @JsonPropertyDescription("一页返回多少记录")
    @Min(0)
    @Max(500)
    @JsonProperty(defaultValue = "20")
    private int pageSize = 20;
    /**
     * 当前页面索引，从0开始
     */
    @JsonPropertyDescription("当前页面索引，从0开始")
    @Min(0)
    @JsonProperty(defaultValue = "0")
    private int pageNum = 0;

    public ParcelQueryCriteria getCriteria() {
        return criteria;
    }

    public ParcelListQueryParam setCriteria(ParcelQueryCriteria criteria) {
        this.criteria = criteria;
        return this;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public ParcelListQueryParam setStartTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public ParcelListQueryParam setEndTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ParcelListQueryParam setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNum() {
        return pageNum;
    }

    public ParcelListQueryParam setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }
}
