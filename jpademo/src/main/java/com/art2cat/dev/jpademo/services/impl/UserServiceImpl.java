package com.art2cat.dev.jpademo.services.impl;

import com.art2cat.dev.jpademo.mybatis.mapper.User;
import com.art2cat.dev.jpademo.repositories.UserRepository;
import com.art2cat.dev.jpademo.services.intf.IUserService;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

/**
 * com.art2cat.dev.jpademo.services.impl
 *
 * @author rorschach
 * @date 4/15/18
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertUser(User user, Errors errors) {
        return userRepository.insertUser(user);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateUser(User user, Errors errors) {
        return userRepository.updateUser(user);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> findUsers(String userName, int start, int limit) {
        RowBounds rowBounds = new RowBounds(start, limit);
        return userRepository.findUsers(userName, rowBounds);
    }
}
