package io.parcelx.open.api.sdk.v1;


import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public interface IProviderApi extends JsonRpcInvoker {

    ParcelRouteResult getRoute(String routeCode) throws ApiException, UnsupportedEncodingException;

    ParcelListQueryResult queryParcelList(ParcelListQueryParam query) throws ApiException, UnsupportedEncodingException;

    ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    void reportTrackingNumber(ParcelNoParam parcelNo, String trackingNo) throws ApiException, UnsupportedEncodingException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException, UnsupportedEncodingException;

    void reportLabel(ParcelNoParam parcelNo, ParcelLabelParam label) throws ApiException, UnsupportedEncodingException;

    void reportWeight(ParcelNoParam parcelNo, double weight) throws ApiException, UnsupportedEncodingException;

    void reportLading(ParcelNoParam parcelNo, ParcelLadingParam lading) throws ApiException, UnsupportedEncodingException;

    void reportTrackingEvent(ParcelNoParam parcelNo, TrackingEventParam trackingEvent) throws ApiException, UnsupportedEncodingException;

    void reportServiceComplete(ParcelNoParam parcelNo, ServiceCompleteInfoParam completeInfo) throws ApiException, UnsupportedEncodingException;

    void reportException(ParcelNoParam parcelNo, ParcelExceptionParam exception) throws ApiException, UnsupportedEncodingException;
}
