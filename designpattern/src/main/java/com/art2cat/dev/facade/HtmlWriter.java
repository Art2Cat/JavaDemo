package com.art2cat.dev.facade;

import java.io.IOException;
import java.io.Writer;

/**
 * com.art2cat.dev.facade
 *
 * @author art2c
 * @date 6/5/2018
 */
public class HtmlWriter {

    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeTitle(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void writeParagraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    public void writeLink(String href, String caption) throws IOException {
        writeParagraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mail, String userName) throws IOException {
        writeLink("mailto:" + mail, userName);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
