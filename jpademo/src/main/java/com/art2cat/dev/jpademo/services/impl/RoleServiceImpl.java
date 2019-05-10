package com.art2cat.dev.jpademo.services.impl;

import com.art2cat.dev.jpademo.models.Role;
import com.art2cat.dev.jpademo.repositories.RoleMapper;
import com.art2cat.dev.jpademo.services.intf.IRoleService;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.art2cat.dev.jpademo.services.impl
 *
 * @author rorschach
 * @date 4/15/18
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertRole(Role role) {
        return roleRepository.insertRole(role);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateRole(Role role) {
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
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> findRoles(String roleName, int start, int limit) {
//        RowBounds rowBounds = new RowBounds(start, limit);
        return roleRepository.findRoles();
    }
}
