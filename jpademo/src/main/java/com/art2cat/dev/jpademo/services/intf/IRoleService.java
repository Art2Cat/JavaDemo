package com.art2cat.dev.jpademo.services.intf;

import com.art2cat.dev.jpademo.models.Role;
import java.util.List;

/**
 * com.art2cat.dev.jpademo.services.intf
 *
 * @author rorschach
 * @date 4/15/18
 */
public interface IRoleService {
    
    int insertRole(Role role);
    
    int updateRole(Role role);
    
    int deleteRole(Integer id);
    
    Role getRole(Integer id);
    
    List<Role> findRoles(String roleName, int start, int limit);
}
