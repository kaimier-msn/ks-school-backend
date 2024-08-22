package com.ybvtc.userauthservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybvtc.userauthservice.domain.Permission;
import com.ybvtc.userauthservice.service.PermissionService;
import com.ybvtc.userauthservice.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author kaimier
* @description 针对表【permissions】的数据库操作Service实现
* @createDate 2024-08-21 19:28:50
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




