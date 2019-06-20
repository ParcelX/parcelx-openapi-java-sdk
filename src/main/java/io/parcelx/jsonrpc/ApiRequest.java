package io.parcelx.jsonrpc;

import java.util.UUID;

public final class ApiRequest {

    private final String id;
    private final String method;
    private Object[] params;

    public ApiRequest(String method, Object... params) {
        this.method = method;
        this.params = params;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public Object[] getParams() {
        return params;
    }
}
