package io.parcelx.open.api.sdk.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public class ParcelListQueryResult {
    @JsonPropertyDescription("总共有多少记录")
    private Integer total;
    @JsonPropertyDescription("一页返回多少记录")
    private Integer pageSize;
    @JsonPropertyDescription("当前页面索引，从0开始")
    private Integer pageNum;
    @JsonPropertyDescription("包裹相关单号列表")
    private List<ParcelSimpleResult> list;

    public Integer getTotal() {
        return total;
    }

    public ParcelListQueryResult setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public ParcelListQueryResult setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public ParcelListQueryResult setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public List<ParcelSimpleResult> getList() {
        return list;
    }

    public ParcelListQueryResult setList(List<ParcelSimpleResult> list) {
        this.list = list;
        return this;
    }
}
