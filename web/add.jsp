<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
  <form action="add.student" method="get">
     <table>
         <tr>
             <td>学生sno</td>
             <td>
                 <input type="text" name="sno">
             </td>
         </tr>
         <tr>
             <td>学生姓名</td>
             <td>
                 <input type="text" name="sname">
             </td>
         </tr>
         <tr>
             <td>学生sex</td>
             <td>
                 <input type="radio" name="ssex" value="男">男
                 <input type="radio" name="ssex" value="女">女
             </td>
         </tr>
         <tr>
             <td>学生sage</td>
             <td>
                 <input type="number" name="sage" >
             </td>
         </tr>

         <tr>
             <td>学生sdept</td>
             <td>
                 <select name="sdept">
                     <option value="数学系">数学系</option>
                     <option value="计算机系">计算机系</option>
                     <option value="英语系">英语系</option>
                 </select>
             </td>
         </tr>
         <tr>
             <td>学生birthday</td>
             <td>
                <input type="date" name="birthday">
             </td>
         </tr>
         <tr>
             <td colspan="2">
                 <input type="submit" value="提交">
             </td>

         </tr>
     </table>
  </form>
</body>
</html>
