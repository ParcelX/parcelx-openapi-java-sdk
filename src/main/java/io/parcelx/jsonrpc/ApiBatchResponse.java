package io.parcelx.jsonrpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiBatchResponse {

    private final List<ApiResponse> responses;
    private final Map<String, ApiResponse> responseMap;
    private List<ApiResponse> errors;

    public ApiBatchResponse(List<ApiResponse> responses) {
        this.responses = responses;
        this.responseMap = responses.stream().collect(Collectors.toMap(ApiResponse::getId, s -> s));
    }

    public ApiResponse getApiResponse(int index) {
        return this.responses.get(index);
    }

    public ApiResponse getApiResponse(String requestId) {
        return this.responseMap.get(requestId);
    }


    public List<ApiResponse> getApiResponseList() {
        return responses;
    }

    public Map<String, ApiResponse> getApiResponseMap() {
        return responseMap;
    }

    private List<ApiResponse> ensureErrors() {
        if (errors == null) {
            errors = responses.stream().filter(ApiResponse::hasError).collect(Collectors.toList());
        }
        return errors;
    }

    public <T> List<T> getResults(Class<T> returnType) throws ApiException {
        if (this.hasError()) {
            throw new BatchApiException(this.errors);
        }
        List<T> list = new ArrayList<>();
        for (ApiResponse resp : responses) {
            list.add(resp.getResult(returnType));
        }
        return list;
    }

    public boolean hasError() {
        errors = ensureErrors();
        return errors != null && errors.size() > 0;
    }

    public List<ApiResponse> getErrorResponses() {
        return ensureErrors();
    }

}
