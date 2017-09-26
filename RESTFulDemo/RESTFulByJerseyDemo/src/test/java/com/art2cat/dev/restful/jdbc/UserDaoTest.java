package com.art2cat.dev.restful.jdbc;

import com.art2cat.dev.restful.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class UserDaoTest {
    private Logger logger = Logger.getLogger(UserDaoTest.class.getName());

    @Test
    public void testGetAllUsers() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        Assert.assertNotNull(users);
        logger.info(users.get(0).getName());
        logger.info(users.get(0).getProfession());
        Assert.assertEquals("Mahesh", users.get(0).getName());
    }
}
