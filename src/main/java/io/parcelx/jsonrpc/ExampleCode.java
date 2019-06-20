package io.parcelx.jsonrpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ExampleCode {

    public static void main() throws ApiException, JsonProcessingException {
        OkHttpJsonRpcInvoker invoker = new OkHttpJsonRpcInvoker("http://localhost", new ObjectMapper(), null);

        ApiResponse resp = invoker.invoke(new ApiRequest("ping"));
        resp.getError();
        String result = resp.getResult(String.class);
        ApiBatchResponse batchResponse = invoker.batch(
                new ApiRequest("ping", "123"),
                new ApiRequest("sayHello", "wenjie")
        );
        ApiBatchResponse batchResponse1 = invoker.batch(Arrays.asList(
                new ApiRequest("ping", "1", "2"),
                new ApiRequest("test", 1, 2)
        ));

        ApiResponse resp1 = batchResponse.getApiResponse(0);
        ApiResponse resp2 = batchResponse.getApiResponse("111");

        resp1.getResult(String.class);
        resp1.getError().getCode();
        batchResponse.getApiResponseList();
        batchResponse.getApiResponseMap();

        List<String> results = invoker.batch(Arrays.asList(
                new ApiRequest("ping", "1", "2"),
                new ApiRequest("test", 1, 2)
        )).getResults(String.class);
    }
}
