package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query = "insert into students(id, name, city) values(?, ?, ?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        String query = "update students set name=? , city=? where id=?";
        int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM students where id=?";
        int r = this.jdbcTemplate.update(query, id);
        return r;
    }

    @Override
    public Student getStudent(int id) {
        // select single student data
        String query = "select * from students where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student res = this.jdbcTemplate.queryForObject(query, rowMapper, id);
        return res;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from students";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> students = this.jdbcTemplate.query(query, rowMapper);
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
