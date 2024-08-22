package com.ybvtc.userauthservice.mapper;

import com.ybvtc.userauthservice.domain.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author kaimier
* @description 针对表【role_permissions】的数据库操作Mapper
* @createDate 2024-08-21 19:29:07
* @Entity com.ybvtc.userauthservice.domain.RolePermission
*/
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}




