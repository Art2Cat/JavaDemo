package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.User;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/15/18
 */
@Repository
public interface UserMapper {
    
    User getUser(Integer id);

    int insertUser(User user);

    int deleteUser(Integer id);

    int updateUser(User user);

    List<User> findUsers(String userName, RowBounds rowBounds);

}
