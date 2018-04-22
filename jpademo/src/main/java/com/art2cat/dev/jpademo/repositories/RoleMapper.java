package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/15/18
 */
@Repository
public interface RoleMapper {


    @InsertProvider(type = RoleSqlProvider.class, method = "save")
    int insertRole(Role role);

    @UpdateProvider(type = RoleSqlProvider.class, method = "update")
    int updateRole(Role role);

    @Delete("delete from role where id = #{id}")
    int deleteRole(@Param("id") Integer id);

    @Select("select id, role_name as roleName, create_date as createDate, note from role where id = #{id}")
    Role getRole(@Param("id") Integer id);

    @SelectProvider(type = RoleSqlProvider.class, method = "getRoleByName")
    List<Role> findRoles(@Param("name") String roleName, RowBounds rowBounds);
}
