package com.art2cat.dev.jpademo.services.impl;

import com.art2cat.dev.jpademo.mybatis.mapper.Role;
import com.art2cat.dev.jpademo.repositories.RoleRepository;
import com.art2cat.dev.jpademo.services.intf.IRoleService;
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
public class RoleServiceImpl implements IRoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertRole(Role role, Errors errors) {
        return roleRepository.insertRole(role);
    }
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateRole(Role role, Errors errors) {
        return roleRepository.updateRole(role);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteRole(Integer id) {
        return roleRepository.deleteRole(id);
    }
    
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Role getRole(Integer id) {
        return roleRepository.getRole(id);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> findRoles(String roleName, int start, int limit) {
        RowBounds rowBounds = new RowBounds(start, limit);
        return roleRepository.findRoles(roleName, rowBounds);
    }
}
