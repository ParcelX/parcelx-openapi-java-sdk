package io.parcelx.jsonrpc;

public class ApiException extends Exception {

    private int code;

    public ApiException(int code, String message) {
        this(code, message, null);
    }

    public ApiException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
