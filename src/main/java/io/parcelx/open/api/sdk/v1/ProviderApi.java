package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.open.api.sdk.BaseParcelxApi;
import io.parcelx.open.api.sdk.v1.model.*;

public class ProviderApi extends BaseParcelxApi implements IProviderApi {

    public ProviderApi(String url, String apiKey, String apiSecret) {
        super(url, apiKey, apiSecret);
    }

    @Override
    public void reportTrackingEvent(ParcelNoParam parcelNo, TrackingEventParam trackingEvent) throws ApiException {
        invoke(new ApiRequest("reportTrackingEvent", parcelNo, trackingEvent)).throwExceptionIfHasError();
    }

    @Override
    public ParcelTrackingResult getTracking(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getTracking", parcelNo))
                .getResult(ParcelTrackingResult.class);
    }

    @Override
    public ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getLabel", parcelNo)).getResult(ParcelLabelResult.class);
    }

}
