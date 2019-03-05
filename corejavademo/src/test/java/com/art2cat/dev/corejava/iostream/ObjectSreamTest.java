package com.art2cat.dev.corejava.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectSreamTest {

    private Path path = Paths.get("src", "test", "resources", "obj.dat");

    private Student student = new Student("10001", "张三", 20);

    @Test
    public void testObjectOutputSream() {

        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(path.toString()))) {
            oos.writeObject(student);
            oos.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }


    @Test
    public void testObjectInputStream() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()))) {
            Student stu = (Student) ois.readObject();
            Assertions.assertEquals(student, stu);
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }
    }
}
