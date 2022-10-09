package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDAO")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        //insert query
        String query = "insert into student(id,name,city) values(?,?,?)";

        int res = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return res;
    }

    @Override
    public int change(Student student) {

        //updating data
        String query = "update student set name = ? ,  city = ? where id = ?";
        int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return res;
    }

    @Override
    public int delete(int studentId) {
        //delete operation
        String query = "delete from student where id = ?";
        int res = this.jdbcTemplate.update(query, studentId);
        return res;
    }

    @Override
    public Student getStudent(int studentId) {
        // selecting single Student data
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        // Selecting all students
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
