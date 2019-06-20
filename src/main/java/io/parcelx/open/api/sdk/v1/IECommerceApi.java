package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

public interface IECommerceApi extends JsonRpcInvoker {

    ParcelCreationResult createParcel(CreateParcelParam parcel, boolean autoPlaceOrder) throws ApiException;

    void placeOrder(ParcelNoParam parcelNo) throws ApiException;

    ParcelListQueryResult getParcelList(ParcelListQueryParam query) throws ApiException;

    ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException;

    ParcelTrackingResult getTracking(ParcelNoParam parcelNo) throws ApiException;

    void fixException(ParcelNoParam parcelNo, FixParcelInfoParam fixParcelInfoParam) throws ApiException;

    void confirmServiceComplete(ParcelNoParam parcelNo) throws ApiException;

}
