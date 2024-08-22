package com.ybvtc.userauthservice.service;

import com.ybvtc.userauthservice.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
* @author kaimier
* @description 针对表【users】的数据库操作Service
* @createDate 2024-08-21 19:28:05
*/
public interface UserService extends IService<User> , UserDetailsService {

    void registerUser(User user);
}
