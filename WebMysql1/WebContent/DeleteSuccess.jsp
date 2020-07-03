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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>结果显示</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
	<%User user = (User)session.getAttribute("user");%>
	数据库操作结果：<br>
	成功删除数据表User与person中以“ <%= user.getUserName()%> ”打头的username<br>
	并删除相应数据<br>
	<a href="ShowT.jsp">查看数据库数据</a>
</div>
</body>
</html>