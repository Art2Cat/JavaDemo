package com.art2cat.dev.restful;

import com.art2cat.dev.restful.jdbc.UserDao;
import com.art2cat.dev.restful.model.User;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {

    private Logger logger = Logger.getLogger(UserDaoTest.class.getName());

    @Test
    public void testGetAllUsers() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        Assert.assertNotNull(users);
        logger.info(users.get(0).getUsername());
        logger.info(users.get(0).getPassword());
        Assert.assertEquals("Mahesh", users.get(0).getUsername());
    }
}
