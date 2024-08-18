package com.rakesh.SpringJdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.rakesh.SpringJdbc.dao.*;
import com.rakesh.SpringJdbc.model.Student;

public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/rakesh/SpringJdbc/config.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao dao = context.getBean("studentDao",StudentDao.class);
//        Student s = new Student(206,"Rahul","Bihar");
//        
//        int result= dao.insert(s);
//        System.out.println("No of rows inserted "+result);
        
//        Student s2 = new Student(205,"Srijan Sinha","Kolkata");
//        int rs2 = dao.update(s2);
//        System.out.println("No of rows updated "+rs2);
//        
//        int rs3 = dao.delete(203);
//        System.out.println("No of rows deleted "+rs3);
//        Student s = dao.getStudent(213);
//        System.out.println(s);
        
        List<Student> l = dao.getAllStudents();
        for(Student s1:l)
        	System.out.println(s1);
     }
}
