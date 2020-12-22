package com.yupeng.service.impl;

import com.yupeng.dao.StudentDao;
import com.yupeng.domain.Student;
import com.yupeng.service.StudentService;
import com.yupeng.util.SqlSessionUtil;

import java.util.List;

/**
 * @author Yupeng
 * @create 2020-12-21 22:46
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
    @Override
    public Student getById(String id) {
        Student student = studentDao.getById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> sList = studentDao.getAll();
        return sList;
    }
}
