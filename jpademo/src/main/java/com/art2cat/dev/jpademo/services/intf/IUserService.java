package com.art2cat.dev.jpademo.services.intf;

import com.art2cat.dev.jpademo.models.User;
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
    
    int insertUser(User user);
    
    int deleteUser(Integer id);
    
    int updateUser(User user);
    
    List<User> findUsers(String userName, int start, int limit);
}
