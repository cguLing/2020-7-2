<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.Dao,Table.User,Table.Person"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>数据表查看</title>
  </head>

  <body>
  <div style="text-align:center;margin-top:120px">
	  <table border="1" style="width: 40%;margin:auto">
	  <caption>数据表Users信息：</caption>
	      <tr>
	          <th>username</th>
	          <th>password</th>
	      </tr>
	        <%
	           Dao dao=new Dao();
	           List<User> list =dao.readUser();
	           for(User u:list)
	           {%>
	          <tr>
	              <td><%=u.getUserName() %></td>
	              <td><%=u.getPassword() %></td>
	          </tr>
	            <%}
	       %>
	  </table>
	  <br>
	  <br>
	  <table border="1" style="width: 40%;margin:auto">
	  <caption>数据表Person信息：</caption>
	      <tr>
	          <th>username</th>
	          <th>name</th>
	          <th>age</th>
	          <th>telenum</th>
	      </tr>
	        <%
	           Dao dao2=new Dao();
	           List<Person> list2 =dao2.readPerson();
	           for(Person per:list2)
	           {%>
	          <tr>
	              <td><%=per.getUserName() %></td>
	              <td><%=per.getName() %></td>
	              <td><%=per.getAge() %></td>
	              <td><%=per.getTelenum() %></td>
	          </tr>
	            <%}
	       %>
	  </table>
	  <br>
	   <a href="Operate.jsp">返回数据库操作界面</a>
   </div>
  </body>
</html>