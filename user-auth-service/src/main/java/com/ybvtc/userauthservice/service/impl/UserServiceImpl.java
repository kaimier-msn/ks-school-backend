package com.ybvtc.userauthservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybvtc.userauthservice.domain.Permission;
import com.ybvtc.userauthservice.domain.Role;
import com.ybvtc.userauthservice.domain.User;
import com.ybvtc.userauthservice.mapper.RoleMapper;
import com.ybvtc.userauthservice.service.UserService;
import com.ybvtc.userauthservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* @author kaimier
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-08-21 19:28:05
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
    @Autowired
    private RoleMapper roleMapper;

    public User findByUsername(String username) {
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user != null) {
            Role role = roleMapper.selectById(user.getRoleId());
            if (role != null) {
                role.setPermissions(roleMapper.findPermissionsByRoleId(role.getId()));
            }
            user.setRole(role);
        }
        return user;
    }

    public void registerUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        // 2. 查询 "USER" 角色信息
        Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_name", "USER"));

        if (role == null) {
            throw new RuntimeException("Role USER not found in the database");
        }

        // 3. 设置角色ID
        user.setRoleId(role.getId());

        // 4. 保存用户信息
        this.save(user); // 使用 MyBatis Plus 提供的 save() 方法
        // user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        // this.save(user); // 使用 MyBatis Plus 提供的 save() 方法
        // System.out.println("..........ddddddddddddd");
        // // 赋予 "USER" 角色
        // Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_name", "USER"));
        // user.setRoleId(role.getId());
        // this.updateById(user); // 使用 MyBatis Plus 提供的 updateById() 方法
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Role role = roleMapper.selectById(user.getRoleId());
        if (role != null) {
            role.setPermissions(roleMapper.findPermissionsByRoleId(role.getId()));
        }
        user.setRole(role);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(role));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : role.getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
        }
        return authorities;
    }
}




