package io.parcelx.open.api.sdk.v1.model;

public class ParcelCreationResult {

    /** 编号 */
    private String parcelNo;
    /** 线上订单号 */
    private String onlineOrderNo;

    public String getOnlineOrderNo() {
        return onlineOrderNo;
    }

    public ParcelCreationResult setOnlineOrderNo(String onlineOrderNo) {
        this.onlineOrderNo = onlineOrderNo;
        return this;
    }

    public String getParcelNo() {
        return parcelNo;
    }

    public ParcelCreationResult setParcelNo(String parcelNo) {
        this.parcelNo = parcelNo;
        return this;
    }
}
