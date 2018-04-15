package com.art2cat.dev.jpademo.services.intf;

import com.art2cat.dev.jpademo.mybatis.mapper.Role;
import java.util.List;
import org.springframework.validation.Errors;

/**
 * com.art2cat.dev.jpademo.services.intf
 *
 * @author rorschach
 * @date 4/15/18
 */
public interface IRoleService {
    
    int insertRole(Role role, Errors errors);
    
    int updateRole(Role role, Errors errors);
    
    int deleteRole(Integer id);
    
    Role getRole(Integer id);
    
    List<Role> findRoles(String roleName, int start, int limit);
}
