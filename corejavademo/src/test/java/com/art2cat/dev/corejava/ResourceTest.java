package com.art2cat.dev.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/3/18
 */
public class ResourceTest {

    @Test
    public void FileSourceTest() {
        try {
            Path filePath = Paths.get("src", "test", "resources", "text.txt");
            Resource res1 = new FileSystemResource(filePath.toString());

            Resource res2 = new ClassPathResource("text.txt");

            InputStream ins2 = res2.getInputStream();

            System.out.println("res1: " + res1.getFilename());
            System.out.println("res2: " + res2.getFilename());
            System.out.println("res1 contents: ");
            try (InputStream ins1 = res1.getInputStream()) {
                StringBuilder textBuilder = new StringBuilder();
                try (Reader reader = new BufferedReader(new InputStreamReader
                    (ins1, Charset.forName(StandardCharsets.UTF_8.name())))) {
                    int c = 0;
                    while ((c = reader.read()) != -1) {
                        textBuilder.append((char) c);
                    }
                    System.out.println(textBuilder.toString());
                }
            }
            ins2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void encodedResourceTest() {
        try {
            Resource res = new ClassPathResource("text.txt");

            EncodedResource encodedResource = new EncodedResource(res, "UTF-8");
            String content = FileCopyUtils.copyToString(encodedResource.getReader());
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PatternResolverTest() {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Stream.of(resolver.getResources("classpath*:com/art2cat/dev/corejava/**/*.class"))
                .forEach(resource -> System.out.println(resource.getFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
