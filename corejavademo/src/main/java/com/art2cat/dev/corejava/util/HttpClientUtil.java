package com.art2cat.dev.corejava.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.net.ssl.SSLContext;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

/**
 * com.art2cat.dev.corejava.util
 *
 * @author Rorschach
 * @date 11/01/2018
 */
public class HttpClientUtil {
    
    /**
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        
        String result = null;
        HttpGet httpget = new HttpGet(url);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpget)) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     *
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map<String, String> params) {
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = params.entrySet().stream()
            .map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
        if (!formParams.isEmpty()) {
            UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
            httpPost.setEntity(paramEntity);
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static String doHttpsPost(String url, Map<String, String> params)
        throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        SSLContext sslContext = new SSLContextBuilder()
            .loadTrustMaterial(null, (arg0, arg1) -> true).build();
        
        // Allow TLSv1 protocol only, use NoopHostnameVerifier to trust self-singed cert
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
            new String[]{"TLSv1"}, null, new NoopHostnameVerifier());
        
        List<NameValuePair> formParams = params.entrySet().stream()
            .map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
        
        if (!formParams.isEmpty()) {
            UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
            httpPost.setEntity(paramEntity);
        }
        //do not set connection manager
        try (CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            CloseableHttpResponse response = httpClient.execute(httpPost)) {
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, Consts.UTF_8);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     *
     * @param url
     * @return
     */
    public static String doPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        
        String result = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
