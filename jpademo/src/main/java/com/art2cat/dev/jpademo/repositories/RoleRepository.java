package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.mybatis.mapper.Role;
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
public interface RoleRepository {
    
    int insertRole(Role role);
    
    int updateRole(Role role);
    
    int deleteRole(Integer id);
    
    Role getRole(Integer id);
    
    List<Role> findRoles(String roleName, RowBounds rowBounds);
}
