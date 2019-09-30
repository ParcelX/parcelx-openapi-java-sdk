package io.parcelx.jsonrpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OkHttpJsonRpcInvoker implements JsonRpcInvoker {

    private static final String REQUEST_TEMPLATE = "{\"jsonrpc\":\"2.0\",\"id\":\"%s\",\"method\":\"%s\",\"params\":%s}";

    private final OkHttpClient client;
    private final String url;
    private final ObjectMapper mapper;

    public OkHttpJsonRpcInvoker(String url) {
        this(url, null, null);
    }

    public OkHttpJsonRpcInvoker(String url, ObjectMapper mapper) {
        this(url, mapper, null);
    }

    public OkHttpJsonRpcInvoker(String url, ObjectMapper mapper, OkHttpClient client) {
        this.url = url;
        this.mapper = mapper;
        this.client = client == null ? getDefaultClient() : client;

        this.mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    private static OkHttpClient getDefaultClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public ApiResponse invoke(ApiRequest request) throws ApiException {
        String payload = getRequestPayload(request);
        RequestBody requestBody = null;
        try {
            requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    payload.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // 修改charset异常，不做处理
            e.printStackTrace();
        }
        Call call = this.client.newCall(new Request.Builder().url(url).post(requestBody).build());
        try {
            Response resp = call.execute();
            JsonNode jsonResp = null;
            if (resp.body() != null) {
                jsonResp = mapper.readTree(resp.body().byteStream());
            }
            return new ApiResponse(request, jsonResp, mapper);
        } catch (IOException e) {
            throw new ApiInvokeException(e);
        }
    }

    private String getRequestPayload(ApiRequest request) throws ApiInvokeException {
        try {
            return String.format(REQUEST_TEMPLATE, request.getId(), request.getMethod(), mapper.writeValueAsString(request.getParams()));
        } catch (JsonProcessingException e) {
            throw new ApiInvokeException(e);
        }
    }

    @Override
    public ApiBatchResponse batch(List<ApiRequest> requests) throws ApiException {
        StringBuilder sb = new StringBuilder(requests.size() * 50);
        sb.append("[");
        int count = 0;
        for (ApiRequest req : requests) {
            count++;
            sb.append(getRequestPayload(req));
            if (count < requests.size()) {
                sb.append(",");
            }
        }
        sb.append("]");
        String payload = sb.toString();
        RequestBody requestBody = null;
        try {
            requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    payload.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // 修改charset异常，不做处理
            e.printStackTrace();
        }
        Call call = this.client.newCall(new Request.Builder().url(url).post(requestBody).build());
        for (ApiRequest request : requests) {

        }
        Map<String, ApiRequest> requestMap = new HashMap<String, ApiRequest>();
        for (ApiRequest request : requests) {
            requestMap.put(request.getId(),request);
        }
        try {
            Response resp = call.execute();
            JsonNode jsonResp = mapper.readTree(resp.body().byteStream());
            List<ApiResponse> responseList = parseBatchResponse(jsonResp, requestMap);
            ApiBatchResponse batchResponse = new ApiBatchResponse(responseList);
            return batchResponse;
        } catch (IOException e) {
            throw new ApiInvokeException(e);
        }
    }

    private List<ApiResponse> parseBatchResponse(JsonNode jsonResp, Map<String, ApiRequest> requestMap) throws ApiException {
        //TODO: more parsing error logic
        ArrayNode responses = (ArrayNode) jsonResp;
        int size = responses.size();
        List<ApiResponse> apiResponseList = new ArrayList<ApiResponse>(size);
        for (int i = 0; i < size; i++) {
            ObjectNode node = (ObjectNode) responses.get(i);
            ApiRequest request = requestMap.get(node.get("id"));
            apiResponseList.add(new ApiResponse(request, node, mapper));
        }
        return apiResponseList;
    }

    @Override
    public ApiBatchResponse batch(ApiRequest... requests) throws ApiException {
        List<ApiRequest> apiRequestList = new ArrayList<ApiRequest>();
        for (ApiRequest request : requests) {
            apiRequestList.add(request);
        }
        return this.batch(apiRequestList);
    }
}
