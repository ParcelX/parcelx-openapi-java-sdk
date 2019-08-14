package io.parcelx.jsonrpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiBatchResponse {

    private final List<ApiResponse> responses;
    private final Map<String, ApiResponse> responseMap;
    private List<ApiResponse> errors;
    private List<ApiResponse> correctResponses;

    public ApiBatchResponse(List<ApiResponse> responses) {
        this.responses = responses;
        Map<String, ApiResponse> map = new HashMap<String, ApiResponse>();
        for (ApiResponse respons : responses) {
            map.put(respons.getId(),respons);
        }
        this.responseMap = map;
        //this.responseMap = responses.stream().collect(Collectors.toMap(ApiResponse::getId, s -> s));
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
            for (ApiResponse respons : responses) {
                if(respons.hasError()){
                    errors.add(respons);
                }
            }
            //errors = responses.stream().filter(ApiResponse::hasError).collect(Collectors.toList());
        }
        return errors;
    }

    public <T> List<T> getResults(Class<T> returnType) throws ApiException {
        if (this.hasError()) {
            throw new BatchApiException(this.errors);
        }
        List<T> list = new ArrayList<T>();
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

    private List<ApiResponse> ensureCorrect() {
        if (correctResponses == null) {
            for (ApiResponse respons : responses) {
                if(!respons.hasError()){
                    correctResponses.add(respons);
                }
            }
            //correctResponses = responses.stream().filter(r -> !r.hasError()).collect(Collectors.toList());
        }
        return correctResponses;
    }

    public List<ApiResponse> getCorrectResponses() {
        ensureCorrect();
        return correctResponses;
    }

}
