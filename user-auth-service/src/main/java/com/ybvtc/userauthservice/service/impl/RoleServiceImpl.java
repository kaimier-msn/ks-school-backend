package com.ybvtc.userauthservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybvtc.userauthservice.domain.Role;
import com.ybvtc.userauthservice.service.RoleService;
import com.ybvtc.userauthservice.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author kaimier
* @description 针对表【roles】的数据库操作Service实现
* @createDate 2024-08-21 19:28:33
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




