package com.art2cat.dev.corejava.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * com.art2cat.dev.corejava.util
 *
 * @author Rorschach
 * @date 11/01/2018
 */
public class HttpClientUtilTest {

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
}
