package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.mybatis.mapper.User;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/15/18
 */
@Repository
public interface UserRepository {
    
    User getUser(Integer id);
    
    int insertUser(User user);
    
    int deleteUser(Integer id);
    
    int updateUser(User user);
    
    List<User> findUsers(String userName, RowBounds rowBounds);
    
}
