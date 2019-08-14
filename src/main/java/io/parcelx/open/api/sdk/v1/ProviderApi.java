package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.open.api.sdk.BaseParcelxApi;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public class ProviderApi extends BaseParcelxApi implements IProviderApi {

    public ProviderApi(String url, String apiKey, String apiSecret) {
        super(url, apiKey, apiSecret);
    }

    @Override
    public ParcelRouteResult getRoute(String routeCode) throws ApiException {
        return invoke(new ApiRequest("getRoute", routeCode)).getResult(ParcelRouteResult.class);
    }

    @Override
    public ParcelListQueryResult queryParcelList(ParcelListQueryParam query) throws ApiException {
        return invoke(new ApiRequest("queryParcelList", query)).getResult(ParcelListQueryResult.class);
    }

    @Override
    public ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getParcelInfo", parcelNo)).getResult(ParcelInfoResult.class);
    }

    @Override
    public void reportTrackingNumber(ParcelNoParam parcelNo, String trackingNo) throws ApiException {
        invoke(new ApiRequest("reportTrackingNumber", parcelNo, trackingNo)).throwExceptionIfHasError();
    }

    @Override
    public ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getLabel", parcelNo)).getResult(ParcelLabelResult.class);
    }

    @Override
    public void reportLabel(ParcelNoParam parcelNo, ParcelLabelParam label) throws ApiException {
        invoke(new ApiRequest("reportLabel", parcelNo, label)).throwExceptionIfHasError();
    }

    @Override
    public void reportWeight(ParcelNoParam parcelNo, double weight) throws ApiException {
        invoke(new ApiRequest("reportWeight", parcelNo, weight)).throwExceptionIfHasError();
    }

    @Override
    public void reportLading(ParcelNoParam parcelNo, ParcelLadingParam lading) throws ApiException {
        invoke(new ApiRequest("reportLading", parcelNo, lading)).throwExceptionIfHasError();
    }

    @Override
    public void reportTrackingEvent(ParcelNoParam parcelNo, TrackingEventParam trackingEvent) throws ApiException {
        invoke(new ApiRequest("reportTrackingEvent", parcelNo, trackingEvent)).throwExceptionIfHasError();
    }

    @Override
    public void reportServiceComplete(ParcelNoParam parcelNo, ServiceCompleteInfoParam completeInfo) throws ApiException {
        invoke(new ApiRequest("reportServiceComplete", parcelNo, completeInfo)).throwExceptionIfHasError();
    }

    @Override
    public void reportException(ParcelNoParam parcelNo, ParcelExceptionParam exception) throws ApiException {
        invoke(new ApiRequest("reportException", parcelNo, exception)).throwExceptionIfHasError();
    }
}
