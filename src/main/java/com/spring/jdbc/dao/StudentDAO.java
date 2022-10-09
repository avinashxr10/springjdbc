package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

import java.util.List;

public interface StudentDAO {
    public int insert(Student student);

    public int change(Student student);

    public int delete(int studentId);

    public Student getStudent(int studentId);

    public List<Student> getAllStudent();
}
