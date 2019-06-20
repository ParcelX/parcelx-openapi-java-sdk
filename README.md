# parcelx-openapi-java-sdk
openapi java sdk

## 使用范例

```java

    ProviderApi providerApi = new ProviderApi(
            "http://localhost:8080/openapi/v1/provider/jsonrpc",
            "test_api_key",
            "test_api_secret");

    // 直接调用获取结果
    try {
        ParcelRouteResult route = providerApi.getRoute("route_code")
    } catch (ApiException e) {
        // handle exception logic here
    }
    
    // 批量调用获取结果
    try {
        List<ParcelRouteResult> results = providerApi.batch(
            new ApiRequest("getRoute", "route_code1"),
            new ApiRequest("getRoute", "route code2")
        ).getResults(ParcelRouteResult.class);
    } catch (ApiException e) {
        // handle exception logic here
    }


```
