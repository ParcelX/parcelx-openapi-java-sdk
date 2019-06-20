package io.parcelx.jsonrpc;

public class ApiInvokeException extends ApiException {

    public ApiInvokeException(Throwable cause) {
        super(-1, "本地调用过程中发生错误", cause);
    }
}
