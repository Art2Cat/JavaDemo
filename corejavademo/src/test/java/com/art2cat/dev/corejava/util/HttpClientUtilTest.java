package com.art2cat.dev.corejava.util;

import com.art2cat.dev.corejava.network.RsHttpClient;
import java.io.IOException;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava.util
 *
 * @author Rorschach
 * @date 11/01/2018
 */
public class HttpClientUtilTest {
    
    private final static String HTTPS_URL = "https://www.art2cat.com";
    private final static String HTTP_URL = "http://www.art2cat.com";
    
    @Test
    public void testPost() {
        String url = "http://localhost:8080/api/byteArray/";
        Map<String, String> map = new HashMap<>();
        map.put("fileHolder.fileName", "test.txt");
        map.put("fileHolder.fileContent", "10211799107121111117");
        String result = HttpClientUtil.doPost(url, map);
        System.out.println(result);
    }
    
    @Test
    public void test() {
        StringJoiner stringJoiner = new StringJoiner("");
        byte[] bytes = "helloworld".getBytes(StandardCharsets.UTF_8);
        
        Stream.of(Arrays.toString(bytes).replace(", ", "")).forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }
    
    @Test
    public void testGet() {
        try {
            HttpResponse<String> response = RsHttpClient.doGet(HTTPS_URL, Version.HTTP_2);
            Assertions.assertEquals(200, response.statusCode());
        } catch (IOException | InterruptedException e) {
            Assertions.fail(e.getMessage());
        }
    }
    
    @Test
    public void testAsyncGet() {
        try {
            HttpResponse<String> response = RsHttpClient.doAsyncGet(HTTP_URL, Version.HTTP_1_1);
            Assertions.assertEquals(200, response.statusCode());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }
}
