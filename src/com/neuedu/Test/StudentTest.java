package com.neuedu.Test;


import com.neuedu.dao.IStudentDAO;
import com.neuedu.dao.impl.StudentDAOImpl;
import com.neuedu.entity.Student;

import java.util.Date;
import java.util.List;

public class StudentTest {
    private static IStudentDAO studentDAO=new StudentDAOImpl();

    public static void main(String[] args) {
        @SuppressWarnings(value={"unused"})
        Date date=new Date();
        getAll();
    }

    public static void getAll(){
        List<Student> students=studentDAO.getAll();
        for(Student student:students){
            System.out.println(student);
        }
    }
}
