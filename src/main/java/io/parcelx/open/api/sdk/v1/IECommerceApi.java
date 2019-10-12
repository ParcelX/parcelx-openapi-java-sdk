package io.parcelx.open.api.sdk.v1;

import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.JsonRpcInvoker;
import io.parcelx.open.api.sdk.v1.model.*;

import java.io.UnsupportedEncodingException;

public interface IECommerceApi extends JsonRpcInvoker {

    ParcelCreationResult createParcel(CreateParcelParam parcel, boolean autoPlaceOrder) throws ApiException;

    ParcelLabelResult getLabel(ParcelNoParam parcelNo) throws ApiException;

}
