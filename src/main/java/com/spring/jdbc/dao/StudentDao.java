package com.spring.jdbc.dao;


import com.spring.jdbc.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
