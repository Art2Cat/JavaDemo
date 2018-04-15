package com.art2cat.dev.jpademo.services.intf;

import com.art2cat.dev.jpademo.mybatis.mapper.User;
import java.util.List;
import org.springframework.validation.Errors;

/**
 * com.art2cat.dev.jpademo.services.intf
 *
 * @author rorschach
 * @date 4/15/18
 */
public interface IUserService {
    
    User getUser(Integer id);
    
    int insertUser(User user, Errors errors);
    
    int deleteUser(Integer id);
    
    int updateUser(User user, Errors errors);
    
    List<User> findUsers(String userName, int start, int limit);
}
