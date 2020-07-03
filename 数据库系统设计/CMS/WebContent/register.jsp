<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.servlet.log.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工注册</title>
  </head>
  <style type="text/css">
     body{
		 background:
         url(images/background.png),
		 url(images/register.jpg);
         background-position:top 30px right 50%,center;
         background-repeat:no-repeat,no-repeat;
         background-size:50% 60%,100% 100%;
         background-attachment: fixed,fixed;
       }
 </style>
  <script type="text/javascript">
	  function checkReg(){
			var flag=true;
			//var name=document.getElementById("name").value;
			var pwd=document.getElementById("pwd").value;
			var rePwd=document.getElementById("rePwd").value;
			/*if(""==name){
				alert("用户名不能为空！");
				flag=false;
				return false;
			}else */if(""==pwd){
				alert("密码不能为空！");
				flag=false;
				return false;
			}else if(""==rePwd){
				alert("请再次输入密码以确认！");
				flag=false;
				return false;
			}else if(pwd!=rePwd){
				alert("两次输入的密码不一样，请重新输入！");
				flag=false;
				return false;
			}if(flag==true){
				return true;
			}
		}
</script> 
  
  <body>
  <%String erro = (String)request.getAttribute("erro");
	if(erro!=null && !"".equals(erro)){%>
	<script type="text/javascript">
	alert( "<%=erro%>" );
	</script>
	<%} %>
  	<center>
		<div class="divAll"></div>
		<div id="titles" style="font-family:arial;font-size:20px;font-weight:900;">系统用户注册</div>
		<div id="contents"></div>
	</center>
	<hr width="45%" color="#f2f2f2" />
	<form action="registerServlet" method="post" onsubmit="return checkForm()">
		<center>
			<div class="divAll"></div>
			<div id="contents"></div>
			<h3>基本信息</h3>
			<hr width="45%" color="#2828FF" />
			</br>
			</br>
			
		  <%String empID = (String)request.getAttribute("empID");
			if(empID!=null&&!"".equals(empID)){%>
			您的所属用户账号为：<%=empID%>
			<br/><br>
			<b>请务必记牢自己的账号密码，<b><br>
			<b>遗忘可寻找管理员进行查询。<b>
			<br/><br>
			<a href="welcomeNormal.jsp">进入员工系统</a>
			<%} 
			else{%>
			
			<div id="form-itemGroup">
				<label for="userPasword">密&nbsp&nbsp&nbsp&nbsp码：&nbsp&nbsp&nbsp</label> 
				<input type="password" id="pwd" name="password""> 
			</div>
			</br>
			</br>
			<div id="form-itemGroup">
					<label for="userConfirmPasword">确认密码：</label> 
					<input type="password" id="rePwd" name="repassword">
				
			</div>
			</br>
			<div>
				<input type="submit" value=" 注册  " onclick="return checkReg();"/>
			</div>
			<%} %>
		</center>
		</form>
  </body>
</html>
