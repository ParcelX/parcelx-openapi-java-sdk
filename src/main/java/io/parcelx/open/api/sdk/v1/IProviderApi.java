package io.parcelx.open.api.sdk.v1;


import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

public interface IProviderApi extends JsonRpcInvoker {

    ParcelRouteResult getRoute(String routeCode) throws ApiException;

    ParcelListQueryResult queryParcelList(ParcelListQueryParam query) throws ApiException;

    ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException;

    void reportTrackingNumber(ParcelNoParam parcelNo, String trackingNo) throws ApiException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException;

    void reportLabel(ParcelNoParam parcelNo, ParcelLabelParam label) throws ApiException;

    void reportWeight(ParcelNoParam parcelNo, double weight) throws ApiException;

    void reportLading(ParcelNoParam parcelNo, ParcelLadingParam lading) throws ApiException;

    void reportTrackingEvent(ParcelNoParam parcelNo, TrackingEventParam trackingEvent) throws ApiException;

    void reportServiceComplete(ParcelNoParam parcelNo, ServiceCompleteInfoParam completeInfo) throws ApiException;

    void reportException(ParcelNoParam parcelNo, ParcelExceptionParam exception) throws ApiException;
}
