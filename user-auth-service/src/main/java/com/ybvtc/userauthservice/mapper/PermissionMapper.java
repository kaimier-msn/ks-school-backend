package com.ybvtc.userauthservice.mapper;

import com.ybvtc.userauthservice.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kaimier
 * @description 针对表【permissions】的数据库操作Mapper
 * @createDate 2024-08-21 19:28:50
 * @Entity com.ybvtc.userauthservice.domain.Permission
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {


}




