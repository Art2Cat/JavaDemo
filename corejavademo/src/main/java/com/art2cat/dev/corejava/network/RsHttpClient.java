package com.art2cat.dev.corejava.network;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author rorschach
 */
public class RsHttpClient {
    
    public static HttpResponse<String> doGet(String url, Version version)
        throws IOException, InterruptedException {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                                                        .version(version)
                                                        .build();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .GET()
                                         .build();
        HttpResponse<String> response = httpClient
            .send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }
    
    public static HttpResponse<String> doAsyncGet(String url, Version version)
        throws ExecutionException, InterruptedException, TimeoutException {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                                                        .version(version)
                                                        .build();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .GET()
                                         .build();
        
        return httpClient
            .sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
            .get(10, TimeUnit.SECONDS);
    }
    
    public static HttpResponse<String> doPost(String url, Version version, String json)
        throws IOException, InterruptedException {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                                                        .version(version)
                                                        .build();
        
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .POST(HttpRequest.BodyPublishers.ofString(json))
                                         .build();
        HttpResponse<String> response = httpClient
            .send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        return response;
        
    }
    
    public static HttpResponse<String> doAsyncPost(String url, Version version,
        String json) throws ExecutionException, InterruptedException {
        HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                                                        .version(version)
                                                        .build();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create(url))
                                         .POST(HttpRequest.BodyPublishers.ofString(json))
                                         .build();
        
        return httpClient
            .sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).get();
    }
}
