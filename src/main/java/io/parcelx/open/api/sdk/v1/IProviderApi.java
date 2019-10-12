package io.parcelx.open.api.sdk.v1;


import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public interface IProviderApi extends JsonRpcInvoker {

    void reportTrackingEvent(ParcelNoParam parcelNo, TrackingEventParam trackingEvent) throws ApiException;

    ParcelTrackingResult getTracking(ParcelNoParam parcelNo) throws ApiException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException;

}
