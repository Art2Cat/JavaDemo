package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.Role;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * com.art2cat.dev.jpademo.repositories
 *
 * @author rorschach
 * @date 4/15/18
 */
@Repository
public interface RoleMapper {


    @InsertProvider(type = RoleDynamicSqlProvider.class, method = "save")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertRole(Role role);

    @UpdateProvider(type = RoleDynamicSqlProvider.class, method = "update")
    int updateRole(Role role);

    @Delete("delete from role where id = #{id}")
    int deleteRole(@Param("id") Integer id);

    @Select("select id, role_name as roleName, create_date as createDate, note from role where id = #{id}")
    Role getRole(@Param("id") Integer id);

    @SelectProvider(type = RoleDynamicSqlProvider.class, method = "getRoles")
    List<Role> findRoles();

    @SelectProvider(type= RoleDynamicSqlProvider.class, method="getRoleByName")
    Role getRoleByName(@Param("name")String roleName);

}
