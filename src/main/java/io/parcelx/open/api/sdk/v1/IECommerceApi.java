package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public interface IECommerceApi extends JsonRpcInvoker {

    ParcelCreationResult createParcel(CreateParcelParam parcel, boolean autoPlaceOrder) throws ApiException, UnsupportedEncodingException;

    void placeOrder(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    ParcelListQueryResult getParcelList(ParcelListQueryParam query) throws ApiException, UnsupportedEncodingException;

    ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    ParcelTrackingResult getTracking(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    void fixException(ParcelNoParam parcelNo, FixParcelInfoParam fixParcelInfoParam) throws ApiException, UnsupportedEncodingException;

    void confirmServiceComplete(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

}
