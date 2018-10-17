package com.neuedu.dao.impl;


import com.neuedu.dao.IStudentDAO;
import com.neuedu.entity.Student;
import com.neuedu.util.ResultHandle;
import com.neuedu.util.UpdateQuery;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    @Override
    public List<Student> getAll() {
        String sql="select * from student";
        List<Object> objectList=UpdateQuery.query(sql, new ResultHandle() {

            public Object getObjectByResultSet(ResultSet resultSet) throws SQLException {
                Student student=new Student();
                student.setSno(resultSet.getString("sno"));
                student.setSname(resultSet.getString("sname"));
                student.setSage(resultSet.getInt("sage"));
                return student;
            }
        });
        List<Student> studentList=new ArrayList<>();
        for(Object obj:objectList){
            Student student=(Student) obj;
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student getOne(String sno) {
        String sql="select * from student where sno=?";
        List<Object> objectList=UpdateQuery.query(sql, new ResultHandle() {
            @Override
            public Object getObjectByResultSet(ResultSet resultSet) throws SQLException {
                Student student=new Student();
                student.setSno(resultSet.getString("sno"));
                student.setSname(resultSet.getString("sname"));
                student.setSage(resultSet.getInt("sage"));
                return student;
            }
        },sno);
        List<Student> studentList=new ArrayList<>();
        for(Object obj:objectList){
            Student student=(Student) obj;
            studentList.add(student);
        }
        if(studentList==null||studentList.size()==0){
            return null;
        }
        return studentList.get(0);
    }

    @Override
    public int delete(String sno) {
        String sql="delect from student where sno=?";

        return UpdateQuery.Update(sql,sno);
    }

    @Override
    public int insert(Student student) {
        String sql="insert into student(sno,sname,ssex,sage,sdept) values(?,?,?,?,?)";

        return UpdateQuery.Update(sql,student.getSno(),student.getSname(),student.getSsex(),student.getSage(),student.getSdept());
    }

    @Override
    public int update(Student student) {
        String sql="update student set sname=?,ssex=?,sage=?,sdept=? where sno=?";
        return UpdateQuery.Update(sql,student.getSname(),student.getSsex(),student.getSage(),student.getSdept(),student.getSno());
    }
}
