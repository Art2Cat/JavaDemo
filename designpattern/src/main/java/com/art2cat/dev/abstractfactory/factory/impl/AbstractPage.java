package com.art2cat.dev.abstractfactory.factory.impl;

import com.art2cat.dev.abstractfactory.factory.intf.IItem;
import com.art2cat.dev.abstractfactory.factory.intf.IPage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * com.art2cat.dev.abstractfactory.factory.impl
 *
 * @author art2c
 * @date 5/25/2018
 */
public abstract class AbstractPage implements IPage {
    
    protected String title;
    protected String author;
    protected List<IItem> contents = new ArrayList<>();
    
    public AbstractPage(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    @Override
    public void add(IItem item) {
        contents.add(item);
    }
    
    @Override
    public void output() throws IOException {
        Path path = Paths.get("src", "main", "resources", title + ".html");
        
        Files.deleteIfExists(path);
        try (Writer writer = new FileWriter(path.toString())) {
            writer.write(this.makeHTML());
            System.out.println("write complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
