<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--page 标签：属性import ：导入包--%>
<%@page import="com.neuedu.entity.Student,java.util.*" %>
<html>
  <head>
    <title>显示数据</title>
  </head>
  <body>
  <%--
     3：显示数据
      知识点：1）内置对象--request
              2）内置对象--out
  --%>
   <%
       List<Student> list= (List<Student>) request.getAttribute("list");
       out.print("<table>");
     out.print("<tr><td>学号</td><td>姓名</td></tr>");
       for(Student s:list){
           out.print("<tr><td>"+s.getSno()+"</td><td>"+s.getSname()+"</td></tr>");
       }
     out.print("</table>");
   %>

  <a href="add.jsp">添加</a>
  </body>
</html>
