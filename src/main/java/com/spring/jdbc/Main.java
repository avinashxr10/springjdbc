package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program Started ......");

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);


        // Spring JDBC => JdbcTemplate
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");

        Student student = new Student();

        //Insert Query
//        student.setId(222);
//        student.setName("Avinash");
//        student.setCity("Dhanbad");
//
//        int res = studentDAO.insert(student);
//        System.out.println("No of records inserted " + res);

//         //Update Query
//        student.setId(444);
//        student.setName("Sunil");
//        student.setCity("Dhanbad");
//        int upd = studentDAO.change(student);
//        System.out.println("No of records effected " + upd);

        //  Delete Query
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter valid id to delete the data from Database: ");
//        int id = scanner.nextInt();
//        int delete = studentDAO.delete(id);
//        System.out.println("No of records effected " + delete);

        // for single user
//        Student student = studentDAO.getStudent(333);
//        System.out.println(student);


        //for all user
        List<Student> allStudent = studentDAO.getAllStudent();
        System.out.println();
        for (Student s : allStudent) {
            System.out.println(s);
        }
    }
}
