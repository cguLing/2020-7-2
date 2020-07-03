<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.servlet.ed.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>系统管理</title>
  </head>
  <style>
    body{
		 background:
         url(images/background.png),
         url(images/background.png),
		 url(images/admin.jpg);
         background-position:top 60px left 0%，top 40px left 0%,center;
         background-repeat:no-repeat,no-repeat,no-repeat;
         background-size:22% 110%,22% 110%,100% 100%;
         background-attachment: relative,relative,fixed;
       }
    td{text-align:center;}
  	#back{
  		background-color:white;
	    color:black;
	    clear:both;
	    text-align:right;
	   	padding:5px;	
  	}
	#header {
	    background-color:black;
	    color:white;
	    text-align:center;
	    padding:5px;
	}
	#nav {
	    line-height:20px;
	    height:140%;
	    width:180px;
	    float:left;
	    padding:5px;	      
	}
	#section {
	    background-color:rgba(255,255,255,0.6);
	    width:500px;
	    height:50%;
	    float:left;
	    padding:10px;
	    margin-left:120px;	
	    text-align:center; 	 
	}
	#footer {
	    background-color:black;
	    color:white;
	    clear:both;
	    text-align:center;
	   	padding:5px;
	   	position:bottom;	 	 
	}
  </style>
  <body>
  <div id="back">
	  <a href="login.jsp">退出登陆</a>
  </div>
    <div id="header">
    	<h1>欢迎来到管理员界面</h1>
		<hr width="100%" color="LightGrey" />
    </div>
    <%
   application.setAttribute("isAdmin", "1");
    %>
    <div id="nav">
    <br>
    <li>部门信息管理</li>
    <ol>
        <li><a href="cms/department/AddDepart.jsp">增加部门信息</a></li>
        <li><a href="cms/department/DeleteDepart.jsp">删除部门信息</a></li>
        <li><a href="cms/department/ModifyDepart.jsp">修改部门信息</a></li>
        <li><a href="DepartShow" name="isAdmin" value="1">查看部门数据</a></li>
    </ol>
    <br>
    <li>员工信息管理</li>
    <ol>
  		<li><a href="cms/employee/AddEmp.jsp">增加员工信息</a></li>
   		<li><a href="cms/employee/DeleteEmp.jsp">删除员工信息</a></li>
  		<li><a href="cms/employee/ModifyEmp.jsp">修改员工信息</a></li>
   		<li><a href="EmpShow" name="isAdmin" value="1">查看员工数据</a></li>
   	</ol>
   	<br>
    <li>部门员工职位管理</li>
    <ol>
   		<li><a href="cms/empdepart/AddED.jsp">增加职位关联</a></li>
   		<li><a href="cms/empdepart/DeleteED.jsp">删除职位关联</a></li>
   		<li><a href="cms/empdepart/ModifyED.jsp">修改职位关联</a></li>
   		<li><a href="EDShow" name="isAdmin" value="1">查看职位关联数据</a></li>
   		<li><a href="cms/emplimits/AddEL.jsp">增加员工权限</a></li>
   		<li><a href="cms/emplimits/DeleteEL.jsp">删除员工权限</a></li>
   		<li><a href="cms/emplimits/ModifyEL.jsp">修改员工权限</a></li>
   		<li><a href="ELShow" name="isAdmin" value="1">查看员工权限数据</a></li>
   	</ol>
   	<br>
    <li>客户信息管理</li>
    <ol>
   		<li><a href="cms/customer/AddCust.jsp">增加客户信息</a></li>
   		<li><a href="cms/customer/DeleteCust.jsp">删除客户信息</a></li>
   		<li><a href="cms/customer/ModifyCust.jsp">修改客户信息</a></li>
   		<li><a href="CustShow" name="isAdmin" value="1">查看客户数据</a></li>
   	</ol>
   	<br>
    <li>项目信息管理</li>
   	<ol>
   		<li><a href="cms/project/AddProj.jsp">增加项目信息</a></li>
   		<li><a href="cms/project/DeleteProj.jsp">删除项目信息</a></li>
   		<li><a href="cms/project/ModifyProj.jsp">修改项目信息</a></li>
   		<li><a href="ProjShow" name="isAdmin" value="1">查看项目数据</a></li>
   	</ol>
    </div>
    <br><br><br>
    <div id="section">
        <%String info = (String)request.getAttribute("info");
	if(info!=null&&!"".equals(info)){%>
	<br>
	<h1>系统提示：</h1>
	&nbsp;&nbsp;&nbsp;&nbsp;<h2><%=info%></h2>
	<br><br>
	<h3><a href="EDShow">查看部门员工关系</a></h3>
	<%} 
	else{%>
    	<%String erro = (String)request.getAttribute("erro");
		if(erro!=null && !"".equals(erro)){%>
		<script type="text/javascript">
		alert( "<%=erro%>" );
		</script>
		<%}%>
	    <h1>
	    	部门与员工关系表删除操作界面
	    </h1>
	    <br>
	    <form  action="EDDelete" method="post">
	    <input type="text" placeholder="请输入删除的员工编号" name="empID" width="200"/>
	    <br>
	    </br>
	    <input type="submit" value="确认删除"/>
	    </form>
    <%}%>
    </div>
    <div id="footer">
	数据库期末实验系统
	</div>
  </body>
</html>