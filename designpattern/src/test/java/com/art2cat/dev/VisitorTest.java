package com.art2cat.dev;

import com.art2cat.dev.composite.FileTreatmentException;
import com.art2cat.dev.visitor.Directory;
import com.art2cat.dev.visitor.File;
import com.art2cat.dev.visitor.ListVisitor;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/30/2018
 */
public class VisitorTest {

    @Test
    public void test() {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        try {
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.accept(new ListVisitor());
            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanako);
            usrDir.add(tomura);
            File file = new File("rm.sh", 50);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            yuki.add(file);
            hanako.add(new File("memo.text", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootDir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
