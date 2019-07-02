package io.parcelx.jsonrpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return new OkHttpClient.Builder().build();
    }

    @Override
    public ApiResponse invoke(ApiRequest request) throws ApiException {
        String payload = getRequestPayload(request);
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                payload.getBytes(StandardCharsets.UTF_8));
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
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                payload.getBytes(StandardCharsets.UTF_8));
        Call call = this.client.newCall(new Request.Builder().url(url).post(requestBody).build());
        Map<String, ApiRequest> requestMap = requests.stream().collect(Collectors.toMap(ApiRequest::getId, s -> s));
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
        List<ApiResponse> apiResponseList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ObjectNode node = (ObjectNode) responses.get(i);
            ApiRequest request = requestMap.get(node.get("id"));
            apiResponseList.add(new ApiResponse(request, node, mapper));
        }
        return apiResponseList;
    }

    @Override
    public ApiBatchResponse batch(ApiRequest... requests) throws ApiException {
        return this.batch(Arrays.stream(requests).collect(Collectors.toList()));
    }
}
