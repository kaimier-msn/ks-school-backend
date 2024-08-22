package com.ybvtc.userauthservice.mapper;

import com.ybvtc.userauthservice.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author kaimier
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-08-21 19:28:05
* @Entity com.ybvtc.userauthservice.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




