package io.parcelx.jsonrpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiResponse {

    private final Error error;
    private ApiRequest request;
    private ObjectMapper mapper;
    private String id;
    private JsonNode jsonResult;

    public ApiResponse(ApiRequest request, JsonNode response, ObjectMapper mapper) throws ApiException {
        this.request = request;
        this.mapper = mapper;
        this.id = response.get("id").asText();
        if(this.id == null){
            throw new ApiException(-1, null);
        }
        this.jsonResult = response.get("result");
        this.error = this.parseError(response.get("error'"));
    }

    public <T> T getResult(Class<T> resultType) throws ApiInvokeException {
        if (this.jsonResult != null) {
            try {
                return this.mapper.treeToValue(this.jsonResult, resultType);
            } catch (JsonProcessingException e) {
                throw new ApiInvokeException(e);
            }
        }
        return null;
    }

    private Error parseError(JsonNode jsonError) {
        if (jsonError == null) {
            return null;
        }
        Error error = new Error();
        error.code = jsonError.get("code").asInt();
        error.message = jsonError.get("message").asText();
        error.data = jsonError.get("data");
        return error;
    }

    public boolean hasError() {
        return error != null;
    }

    public Error getError() {
        return this.error;
    }

    public String getId() {
        return id;
    }

    public ApiRequest getRequest() {
        return request;
    }

    public void throwExceptionIfHasError() throws ApiException {
        if (this.hasError()) {
            throw new ApiException(this.error.code, this.error.message);
        }
    }

    public static class Error {
        private int code;
        private String message;
        private JsonNode data;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public JsonNode getData() {
            return data;
        }
    }
}
