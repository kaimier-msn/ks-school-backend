package com.kaimier.sm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaimier.sm.domain.Student;
import com.kaimier.sm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学生信息
     * @param page 页码，从1开始
     * @param size 每页大小
     * @return 分页查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Student> pageRequest = new Page<>(page, size);
        Page<Student> studentPage = studentService.page(pageRequest);

        return ResponseEntity.ok(studentPage);
    }
}