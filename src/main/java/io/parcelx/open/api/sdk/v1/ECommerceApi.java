package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.open.api.sdk.BaseParcelxApi;
import io.parcelx.open.api.sdk.v1.model.*;

public class ECommerceApi extends BaseParcelxApi implements IECommerceApi {

    public ECommerceApi(String url, String apiKey, String apiSecret) {
        super(url, apiKey, apiSecret);
    }


    @Override
    public ParcelCreationResult createParcel(CreateParcelParam parcel, boolean autoPlaceOrder) throws ApiException {
        return invoke(new ApiRequest("createParcel", parcel, autoPlaceOrder))
                .getResult(ParcelCreationResult.class);
    }

    @Override
    public void placeOrder(ParcelNoParam parcelNo) throws ApiException {
        invoke(new ApiRequest("placeOrder", parcelNo)).throwExceptionIfHasError();
    }

    @Override
    public ParcelListQueryResult getParcelList(ParcelListQueryParam query) throws ApiException {
        return invoke(new ApiRequest("getParcelList", query))
                .getResult(ParcelListQueryResult.class);
    }

    @Override
    public ParcelInfoResult getParcelInfo(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getParcelInfo", parcelNo))
                .getResult(ParcelInfoResult.class);
    }

    @Override
    public ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getLabel", parcelNo))
                .getResult(ParcelLabelResult.class);
    }

    @Override
    public ParcelTrackingResult getTracking(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getTracking", parcelNo))
                .getResult(ParcelTrackingResult.class);
    }

    @Override
    public void fixException(ParcelNoParam parcelNo, FixParcelInfoParam fixParcelInfoParam) throws ApiException {
        invoke(new ApiRequest("fixException", parcelNo, fixParcelInfoParam)).throwExceptionIfHasError();
    }

    @Override
    public void confirmServiceComplete(ParcelNoParam parcelNo) throws ApiException {
        invoke(new ApiRequest("confirmServiceComplete", parcelNo)).throwExceptionIfHasError();
    }
}
