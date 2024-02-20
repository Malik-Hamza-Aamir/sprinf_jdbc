package org.example;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student();
//        student.setId(445);
//        student.setName("Ali Aamir");
//        student.setCity("Manchester");

//        int result = studentDao.insert(student);
//        System.out.println("student added :"+ result);

//        Student student1 = new Student();
//        student1.setId(444);
//        student1.setName("Abdullah Aamir");
//        student1.setCity("Islamabad");

//        Student student2 = new Student();
//        student2.setId(444);
//
//        int res = studentDao.delete(student2.getId());
//        System.out.println("student data changed : "+ res);

//        Student student3 = studentDao.getStudent(3);
//        System.out.println("student info : " + student3);

        List<Student> students = studentDao.getAllStudents();
        for (Student s: students) {
            System.out.println(s);
        }
    }
}