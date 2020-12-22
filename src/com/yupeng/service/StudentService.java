package com.yupeng.service;

import com.yupeng.domain.Student;

import java.util.List;

/**
 * @author Yupeng
 * @create 2020-12-21 22:45
 */
public interface StudentService {
    Student getById(String id);
    void save(Student student);
    List<Student> getAll();
}
