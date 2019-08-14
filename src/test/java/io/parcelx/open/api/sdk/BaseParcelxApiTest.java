package io.parcelx.open.api.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.parcelx.jsonrpc.ApiException;
import io.parcelx.jsonrpc.ApiRequest;
import io.parcelx.jsonrpc.ApiResponse;
import io.parcelx.open.api.sdk.v1.ProviderApi;
import io.parcelx.open.api.sdk.v1.model.ParcelRouteResult;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseParcelxApiTest {

    private final ObjectMapper mapper;

    public BaseParcelxApiTest() throws IOException {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
    }

    private <T> MockResponse buildSuccessJsonRpcMockResponse(T result) {
        MockResponse mockResponse = new MockResponse();
        mockResponse.addHeader("Content-Type", "application/json");
        JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
        jsonRpcResponse.result = result;
        try {
            String respBody = this.mapper.writeValueAsString(jsonRpcResponse);
            mockResponse.setBody(respBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return mockResponse;
    }

    private <T> MockResponse buildSuccessJsonRpcBatchMockResponse(List<ApiRequest> requests, List<T> results) {
        MockResponse mockResponse = new MockResponse();
        mockResponse.addHeader("Content-Type", "application/json");
        List<JsonRpcResponse> responseList = new ArrayList<JsonRpcResponse>();
        for (T result : results) {
            JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
            jsonRpcResponse.result = result;
            responseList.add(jsonRpcResponse);
        }
        for (int i = 0; i < requests.size(); i++) {
            responseList.get(i).id = requests.get(i).getId();
        }
        try {
            String respBody = this.mapper.writeValueAsString(responseList);
            mockResponse.setBody(respBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return mockResponse;
    }

    @Test
    public void invoke() throws ApiException, IOException {

        String apiKey = "apiKey";
        String apiSecret = "apiSecret";
        String routeCode = "routeCode";

        ParcelRouteResult expected = new ParcelRouteResult();
        expected.setRouteCode(routeCode);
        expected.setRouteNo("11111");

        MockWebServer server = new MockWebServer();
        server.enqueue(this.buildSuccessJsonRpcMockResponse(expected));
        server.start();

        HttpUrl apiUrl = server.url("/openapi/v1/provider/jsonrpc");
        ProviderApi providerApi = new ProviderApi(apiUrl.toString(), apiKey, apiSecret);
        ApiResponse resp = providerApi.invoke(new ApiRequest("getRoute", routeCode));
        ParcelRouteResult actualResult = resp.getResult(ParcelRouteResult.class);
        assertEquals(expected.getRouteCode(), actualResult.getRouteCode());
    }

    @Test
    public void batch() throws IOException, ApiException {
        String apiKey = "apiKey";
        String apiSecret = "apiSecret";
        String routeCode = "routeCode";

        List<String> routeCodes = Arrays.asList("route1", "route2", "route3", "route4");
        /*List<ApiRequest> requests = routeCodes.stream()
                .map(s -> new ApiRequest("getRoute", s))
                .collect(Collectors.toList());
        List<ParcelRouteResult> expectResult = routeCodes.stream()
                .map(s -> {
                    ParcelRouteResult r = new ParcelRouteResult();
                    r.setRouteCode(s);
                    return r;
                }).collect(Collectors.toList());*/
        List<ApiRequest> requests = new ArrayList<ApiRequest>();
        for (String code : routeCodes) {
            ApiRequest apiRequest = new ApiRequest("getRoute", code);
            requests.add(apiRequest);
        }
        List<ParcelRouteResult> expectResult = new ArrayList<ParcelRouteResult>();
        for (String code : routeCodes) {
            ParcelRouteResult parcelRouteResult = new ParcelRouteResult();
            parcelRouteResult.setRouteCode(code);
            expectResult.add(parcelRouteResult);
        }
        MockWebServer server = new MockWebServer();
        server.enqueue(this.buildSuccessJsonRpcBatchMockResponse(requests, expectResult));
        server.start();

        HttpUrl apiUrl = server.url("/openapi/v1/provider/jsonrpc");
        ProviderApi providerApi = new ProviderApi(apiUrl.toString(), apiKey, apiSecret);
        List<ParcelRouteResult> actualResults = providerApi.batch(requests).getResults(ParcelRouteResult.class);
        assertEquals(expectResult.size(), actualResults.size());
        for (int i = 0; i < expectResult.size(); i++) {
            assertEquals(expectResult.get(i).getRouteCode(), actualResults.get(i).getRouteCode());
        }
    }

    public static class JsonRpcResponse {
        public String id;
        public Object result;
        public JsonRpcError error;
    }

    public static class JsonRpcError {
        public String message;
        public int code;
    }

}