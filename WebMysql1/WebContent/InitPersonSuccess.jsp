<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="Table.User"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>结果显示</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
	<%User user = (User)session.getAttribute("user");%>
	数据库操作结果：<br>
	数据表 Person 成功初始化插入 <%= user.getUserName()%><br><br>
	<a href="InitialPerson.jsp">继续初始化数据表Person</a>
	<a href="InitialUser.jsp">初始化数据表Users</a>
	<a href="Operate.jsp">返回操作界面</a>
</div>
</body>
</html>