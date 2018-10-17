package com.neuedu.servlet;

import com.neuedu.dao.IStudentDAO;
import com.neuedu.dao.impl.StudentDAOImpl;
import com.neuedu.entity.Student;
import com.neuedu.util.GDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//扩展名匹配
@WebServlet("*.student")
public class StudentServlt extends HttpServlet {

     private IStudentDAO studentDAO=new StudentDAOImpl();

    //处理方式两种（doGet、doPost）

    /**
     * HttpServletRequest req,请求对象
     * HttpServletResponse resp：响应对象
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String uri=  req.getRequestURI();
        System.out.println(uri);
      String path=uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
        System.out.println(path);
        if("list".equals(path)){
            list(req,resp);
        }else if("add".equals(path)){
            add(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    //添加功能
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sno=req.getParameter("sno");
       String sname=req.getParameter("sname");
       String ssex=req.getParameter("ssex");
       String sage=req.getParameter("sage");
       String sdept=req.getParameter("sdept");
       String birthday=req.getParameter("birthday");
       // System.out.println(sno+" "+sname);
        //生成对象
        Student student=new Student();
        student.setSno(sno);
        student.setSname(sname);
        student.setSsex(ssex);
        student.setSdept(sdept);
        student.setSage(Integer.parseInt(sage));
        student.setBirthday(GDate.get(birthday));

        int i=studentDAO.insert(student);
        if(i!=-1){
           /* System.out.println("添加成功");*/
            /*重定向*/
            resp.sendRedirect("list.student");
        }else{
            System.out.println("失败");
        }

    }


        public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理数据
        //1：调用数据
        List<Student> studentList=studentDAO.getAll();
        //2:数据传入到jsp页面-- 通过HttpServletRequest对象进行传值
        //2.1 把数据放入到request对象中:调用的是setAttribute方法：第一参数：key|name：自定义的
        // 第二个参数：value：上面的数据

        req.setAttribute("list",studentList);
        //2.2 通过请求转发的方式，将数据传入到jsp页面
        //通过生成RequestDispatcher对象，并且输入路径（显示数据的网页的路径）
        //这个对象的forword的方法进行传入
        RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);

    }
}
