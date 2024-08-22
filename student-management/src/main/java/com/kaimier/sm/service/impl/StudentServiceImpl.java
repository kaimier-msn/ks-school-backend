package com.kaimier.sm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaimier.sm.domain.Student;
import com.kaimier.sm.service.StudentService;
import com.kaimier.sm.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author kaimier
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-07-25 20:21:32
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




