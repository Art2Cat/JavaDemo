package com.art2cat.dev.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * com.art2cat.dev.facade
 *
 * @author art2c
 * @date 6/5/2018
 */
public class PageMaker {
    
    private PageMaker() {
    }
    
    public static void makeWelcomePage(String mail, String fileName) {
        try {
            Properties mailProp = Database.getProperties("maildata");
            String userName = mailProp.getProperty(mail);
            HtmlWriter writer = new HtmlWriter(
                new FileWriter(Paths.get("src", "main", "resources", fileName).toString()));
            writer.writeTitle("Welcome to " + userName + "'s page!");
            writer.writeParagraph(userName + " welcome to " + userName + " 's page.");
            writer.writeParagraph("waiting for your email!");
            writer.mailto(mail, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mail + " (" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
