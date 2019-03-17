package com.art2cat.dev.multithread.chaptersix.serializableSingleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Rorschach on 13/07/2017.
 */
public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        File file = new File("/Users/Rorschach/test.txt");
        if (!file.exists()) {
            file.mkdir();
        }
        Thread.sleep(2000);

        new Thread(() -> {
            try {
                SerializableObject serializableObject = SerializableObject.getInstance();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(serializableObject);

                objectOutputStream.close();
                fileOutputStream.close();
                System.out.println(
                    Thread.currentThread().getName() + " " + serializableObject.hashCode());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);
        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                SerializableObject serializableObject = (SerializableObject) objectInputStream
                    .readObject();
                objectInputStream.close();
                fileInputStream.close();
                System.out.println(
                    Thread.currentThread().getName() + " " + serializableObject.hashCode());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                file.delete();
            }
        }).start();


    }

}
