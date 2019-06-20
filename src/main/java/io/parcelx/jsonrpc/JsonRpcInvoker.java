package io.parcelx.jsonrpc;

import java.util.List;

public interface JsonRpcInvoker {

    ApiResponse invoke(ApiRequest request) throws ApiException;

    ApiBatchResponse batch(List<ApiRequest> requests) throws ApiException;

    ApiBatchResponse batch(ApiRequest... requests) throws ApiException;
}
