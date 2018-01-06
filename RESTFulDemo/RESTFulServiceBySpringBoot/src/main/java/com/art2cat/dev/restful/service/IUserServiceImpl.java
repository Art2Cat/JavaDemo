package com.art2cat.dev.restful.service;

import com.art2cat.dev.restful.jdbc.UserDao;
import com.art2cat.dev.restful.model.User;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;


@Service("userService")
public class IUserServiceImpl implements IUserService {
    
    private static final AtomicLong counter = new AtomicLong();
    
    private static List<User> users;
    
    static {
        users = populateDummyUsers();
        counter.set(users.size() - 1);
    }
    
    private static List<User> populateDummyUsers() {
        UserDao.newInstance().getAllUsers();
        return UserDao.newInstance().getAllUsers();
    }
    
    public List<User> findAllUsers() {
        return users;
    }
    
    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
    
    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }
    
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }
    
    public void deleteUserById(long id) {
        
        users.removeIf(user -> user.getId() == id);
    }
    
    public boolean isUserExist(User user) {
        return findByName(user.getUsername()) != null;
    }
    
    public void deleteAllUsers() {
        users.clear();
    }
    
}
