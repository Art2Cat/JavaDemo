package com.art2cat.dev.corejava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author huang.yiming
 * @date 1/11/2018
 */
public class HttpConnectionPostTest {
    String httpUrl = "http://localhost:5099/dcl/MarkitClear.sendContactGroupEmail?contactGroupEmailDetail.sendTo=1&contactGroupEmailDetail.subject=test&contactGroupEmailDetail.text=this is test message&contactGroupEmailDetail.sentBy=huang.yiming@system-in-motion.com&contactGroupEmailDetail.sentByName=tianluolin&contactGroupEmailDetail.fileHandles.listSize=1&contactGroupEmailDetail.fileHandles[0].filename=test.txt&contactGroupEmailDetail.fileHandles[0].fileContent=10211799107121111117";
    @Test
    public void testPost() {
        try {
            URL url = new URL(httpUrl);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream(), "UTF-8"); // utf-8编码
//            out.append(params);
            out.flush();
            out.close();
            // 读取响应
            int length = (int) connection.getContentLength();// 获取长度
            InputStream is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                String result = new String(data, "UTF-8"); // utf-8编码
                System.out.println(result);
                
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
