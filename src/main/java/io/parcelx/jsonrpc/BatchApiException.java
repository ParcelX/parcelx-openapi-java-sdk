package io.parcelx.jsonrpc;

import java.util.List;

public class BatchApiException extends ApiException {
    private final List<ApiResponse> errors;

    public BatchApiException(List<ApiResponse> errors) {
        super(-2, "JsonRpc批量调用错误");
        this.errors = errors;
    }

    public List<ApiResponse> getErrors() {
        return errors;
    }
}
