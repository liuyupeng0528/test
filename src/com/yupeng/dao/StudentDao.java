package com.yupeng.dao;

import com.yupeng.domain.Student;

import java.util.List;

/**
 * @author Yupeng
 * @create 2020-12-21 22:28
 */
public interface StudentDao {
    Student getById(String id);
    void save(Student student);
    List<Student> getAll();
}
