package com.art2cat.dev.corejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 4/8/18
 */
public class StringEncodeTest {
    
    @Test
    public void test() {
        Path path = Paths.get("src", "test", "resources", "test.txt");
        String charset = "UTF-8";
        try (FileOutputStream outputStream = new FileOutputStream(path.toString())) {
            try (OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
                writer.write("我是要测试的中文文字");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        
        try (FileInputStream inputStream = new FileInputStream(path.toString())) {
            try (InputStreamReader reader = new InputStreamReader(inputStream, charset)) {
                StringBuilder buffer = new StringBuilder();
                char[] buf = new char[64];
                int count = 0;
                while ((count = reader.read(buf)) != -1) {
                    buffer.append(buf, 0, count);
                }
                System.out.println(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
    
    @Test
    public void testCharset() {
        String source = "测试中文字符";
        Charset charset = Charset.forName("utf-8");
        ByteBuffer byteBuffer = charset.encode(source);
        CharBuffer charBuffer = charset.decode(byteBuffer);
        
        System.out.println(charBuffer.toString());
    }
}
