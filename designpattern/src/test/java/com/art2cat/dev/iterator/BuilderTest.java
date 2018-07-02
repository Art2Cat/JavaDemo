package com.art2cat.dev.iterator;

import com.art2cat.dev.builder.Director;
import com.art2cat.dev.builder.HTMLBuilder;
import com.art2cat.dev.builder.TextBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/24/2018
 */
public class BuilderTest {
    
    @Test
    public void testTextBuilder() {
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);
    }
    
    @Test
    public void testHTMLBuilder() throws IOException {
        
        Path path = Paths.get("src", "main", "resources", "Greeting.html");
        Files.deleteIfExists(path);
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Director director = new Director(htmlBuilder);
        director.construct();
        String result = htmlBuilder.getResult();
        System.out.println(result);
    }
    
}
