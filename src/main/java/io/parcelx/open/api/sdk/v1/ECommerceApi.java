package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.open.api.sdk.BaseParcelxApi;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public class ECommerceApi extends BaseParcelxApi implements IECommerceApi {

    public ECommerceApi(String url, String apiKey, String apiSecret) {
        super(url, apiKey, apiSecret);
    }

    @Override
    public ParcelCreationResult createParcel(CreateParcelParam parcel, boolean autoPlaceOrder) throws ApiException{
        return invoke(new ApiRequest("createParcel", parcel, autoPlaceOrder))
                .getResult(ParcelCreationResult.class);
    }

    @Override
    public ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException {
        return invoke(new ApiRequest("getLabel", parcelNo))
                .getResult(ParcelLabelResult.class);
    }

}
