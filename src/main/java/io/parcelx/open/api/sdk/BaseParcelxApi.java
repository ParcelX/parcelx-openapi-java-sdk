package io.parcelx.open.api.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.parcelx.jsonrpc.*;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

public class BaseParcelxApi implements JsonRpcInvoker {

    private final String apiKey;
    private final String apiSecret;
    private final String url;
    private final JsonRpcInvoker invoker;

    public BaseParcelxApi(String url, String apiKey, String apiSecret) {
        this.url = url;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.invoker = new OkHttpJsonRpcInvoker(url, this.buildMapper(), this.buildHttpClient());
    }

    private static String bodyToString(final Request request) throws IOException {
        final Request copy = request.newBuilder().build();
        final Buffer buffer = new Buffer();
        copy.body().writeTo(buffer);
        return buffer.readUtf8();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public String getUrl() {
        return url;
    }

    private OkHttpClient buildHttpClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String authToken = AuthHelper.makeGPXHMAC256ApiKey(bodyToString(request), apiKey, apiSecret);
                Request newRequest = request.newBuilder().addHeader("Authorization", authToken).build();
                return chain.proceed(newRequest);
            }
        }).build();
        return httpClient;
    }

    private ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Override
    public ApiResponse invoke(ApiRequest request) throws ApiException, UnsupportedEncodingException {
        return this.invoker.invoke(request);
    }

    @Override
    public ApiBatchResponse batch(List<ApiRequest> requests) throws ApiException, UnsupportedEncodingException {
        return this.invoker.batch(requests);
    }

    @Override
    public ApiBatchResponse batch(ApiRequest... requests) throws ApiException, UnsupportedEncodingException {
        return this.invoker.batch(requests);
    }

    private static class AuthHelper {

        private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
        private static Random random = new Random();

        private static String sign(String apiKey, String timestamp, String nonce, String body, String apiSecret) throws UnsupportedEncodingException {
            if (apiKey == null) {
                apiKey = "";
            }
            if (timestamp == null) {
                timestamp = "";
            }
            if (nonce == null) {
                nonce = "";
            }
            if (body == null) {
                body = "";
            }
            if (apiSecret == null) {
                apiSecret = "";
            }
            byte[] data = String.format("%s%s%s%s", apiKey, timestamp, nonce, body).getBytes("UTF-8");
            return toHmacSHA256(data, apiSecret.getBytes("UTF-8"));
        }

        private static String toHmacSHA256(byte[] data, byte[] key) {
            String output = null;
            try {
                SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(signingKey);
                output = bytesToHexString(mac.doFinal(data));
            } catch (NoSuchAlgorithmException e) {
                // 此处忽略异常
            } catch (InvalidKeyException e){
                // 此处忽略异常
            }
            return output;
        }

        private static String bytesToHexString(byte[] bytes) {
            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }

        public static String makeGPXHMAC256ApiKey(String body, String apiKey, String apiSecret) throws UnsupportedEncodingException {
            String timestamp = String.format("%s", System.currentTimeMillis());
            String nonce = String.format("%s", random.nextInt(1000000) + 100000);
            String sign = sign(apiKey, timestamp, nonce, body, apiSecret);
            return String.format("GPX-HMAC256 APIKEY=%s,TIMESTAMP=%s,NONCE=%s,SIGN=%s", apiKey, timestamp, nonce, sign);
        }
    }
}


