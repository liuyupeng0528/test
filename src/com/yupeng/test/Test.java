package com.yupeng.test;

import com.yupeng.domain.Student;
import com.yupeng.service.StudentService;
import com.yupeng.service.impl.StudentServiceImpl;
import com.yupeng.util.ServiceFactory;

import java.util.List;

/**
 * @author Yupeng
 * @create 2020-12-21 18:48
 */
public class Test {
    public static void main(String[] args) {
        StudentService ss = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        // 测试添加操作
/*        Student student = new Student();
        student.setId("A0006");
        student.setName("cxk");
        student.setAge(21);
        ss.save(student);*/
        // 测试查询单条
//        Student student = ss.getById("A0002");
//        System.out.println(student);
        // 测试查询所有记录
        List<Student> sList = ss.getAll();
        for (Student student : sList) {
            System.out.println(student);
        }
    }
}
