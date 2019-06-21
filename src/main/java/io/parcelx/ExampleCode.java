package io.parcelx;

import io.parcelx.jsonrpc.ApiBatchResponse;
import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.jsonrpc.ApiResponse;
import io.parcelx.open.api.sdk.v1.ProviderApi;
import io.parcelx.open.api.sdk.v1.model.ParcelRouteResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleCode {

    public static void main() {

        ProviderApi api = new ProviderApi(
                "http://localhost:8080/openapi/v1/provider/jsonrpc",
                "test_api_key",
                "test_api_secret");

        // 1. 单独调用某个API，捕获异常处理错误
        try {
            ParcelRouteResult result1 = api.getRoute("route_code");
        } catch (ApiException e) {
            // 业务错误处理逻辑
        }

        // 2. 调用某个API，获取完整的jsonrpc response
        try {
            ApiResponse resp2 = api.invoke(new ApiRequest("getRoute", "route_code"));
            if (!resp2.hasError()) {
                // 处理正常流程
                ParcelRouteResult result2 = resp2.getResult(ParcelRouteResult.class);
            } else {
                ApiResponse.Error error2 = resp2.getError();
                // 处理错误流程
            }
        } catch (ApiException e) {
            // 错误网络，JSON解析等错误
        }


        // 3. 批量调用API
        ArrayList<ApiRequest> batchRequests = new ArrayList<>();
        batchRequests.add(new ApiRequest("getRoute", "route_code_1"));
        batchRequests.add(new ApiRequest("getRoute", "route_code_2"));
        batchRequests.add(new ApiRequest("getRoute", "route_code_3"));
        try {
            ApiBatchResponse batchResult = api.batch(batchRequests);

            // 3.1 直接获取结果，如果有错误，会抛出异常
            List<ParcelRouteResult> results = batchResult.getResults(ParcelRouteResult.class);

            // 3.2 判断是否有错误，非异常处理
            if(batchResult.hasError()){
                // 处理出错的请求
                List<ApiResponse> errorResponses = batchResult.getErrorResponses();
                List<ApiResponse.Error> errors = errorResponses.stream()
                        .map(r -> r.getError()).collect(Collectors.toList());
                // 处理
                List<ApiResponse> correctResponses = batchResult.getCorrectResponses();
            }
        } catch (ApiException e) {
            // 处理错误
        }
    }
}
