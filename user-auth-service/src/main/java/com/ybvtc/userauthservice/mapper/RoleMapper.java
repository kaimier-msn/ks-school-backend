package com.ybvtc.userauthservice.mapper;

import com.ybvtc.userauthservice.domain.Permission;
import com.ybvtc.userauthservice.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author kaimier
* @description 针对表【roles】的数据库操作Mapper
* @createDate 2024-08-21 19:28:33
* @Entity com.ybvtc.userauthservice.domain.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT p.* FROM permissions p INNER JOIN role_permissions rp ON p.id = rp.permission_id WHERE rp.role_id = #{roleId}")
    List<Permission> findPermissionsByRoleId(Integer roleId);
}




