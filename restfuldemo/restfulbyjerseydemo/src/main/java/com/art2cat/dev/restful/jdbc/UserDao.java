package com.art2cat.dev.restful.jdbc;

import com.art2cat.dev.restful.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    
    public List<User> getAllUsers() {
        
        List<User> userList = null;
        try {
            File file = null;
            ClassLoader classLoader = this.getClass().getClassLoader();
            URL url = classLoader.getResource("Users.data");
            if (url != null) {
                file = new File(url.getPath());
            } else {
                file = new File("src/main/resources/Users.data");
            }
            
            if (!file.exists()) {
                userList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    User user = new User(i, "Mahesh", "Teacher");
                    userList.add(user);
                }
                saveUserList(file, userList);
            } else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<User>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    private void saveUserList(File file, List<User> userList) {
        try {
            FileOutputStream fos;
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}