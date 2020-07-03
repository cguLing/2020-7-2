<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.servlet.log.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统登陆</title>
     <style type="text/css">
     body{
		 background:
         url(images/background.png),
		 url(images/login.png);
         background-position:top 20px right 50%,center;
         background-repeat:no-repeat,no-repeat;
         background-size:50% 60%,100% 100%;
         background-attachment: fixed,fixed;
       }
 </style>
  </head>
  <body>
  <%String erro = (String)request.getAttribute("erro");
	if(erro!=null && !"".equals(erro)){%>
	<script type="text/javascript">
	alert( "<%=erro%>" );
	</script>
	<%} %>
	<div align="center">
		<br>
		<H1>欢迎光临登录平台</H1>
		<body>
			<form action="login" method="post">	
				<center>
			<div id="form-itemGroup">
				<label for="userName">用户名：</label> <input type="text" id="empID"
					name="empID" class="userName" onBlur="checkUserName()"
					oninput="checkUserName()"> <span class="default"
					id="nameErr"></span>
			</div>
			</br>
			<div id="form-itemGroup">
				<label for="userPasword">密码：&nbsp</label> <input type="password"
					id="userPasword" name="password" class="userName"
					onBlur="checkPassword()" oninput="checkPassword()"> <span
					class="default" id="passwordErr"></span>
			</div>
			</br>
			<div>
				<input type="radio" name="isAdmin" value="1" id="isAdmin">管理员
				<input type="radio" name="isAdmin" checked value="0" id="isAdmin">员工
			</div>
			</br>
			<div>
				<input type="submit" value="登陆" class="divBtn"/>
			</div>
			</br>
			<a href="register.jsp" class="buttonan buttonan1"> 未注册请点击注册 </a>
		</center>
			</form>
		</body>
</html>
