package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

/**
 * @author rorschach
 */
public class HttpClientUtil {

    public static HttpResponse<String> doGet(String url, HttpClient.Version version) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(version)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public static HttpResponse<String> doAsyncGet(String url, HttpClient.Version version) throws ExecutionException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(version)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8"))).get();
    }

    public static HttpResponse<String> doPost(String url, HttpClient.Version version, String json) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(version)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));
        return response;

    }

    public static HttpResponse<String> doAsyncPost(String url, HttpClient.Version version, String json) throws ExecutionException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(version)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8"))).get();
    }
}
