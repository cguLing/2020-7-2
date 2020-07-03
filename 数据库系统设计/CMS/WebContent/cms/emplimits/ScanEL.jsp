<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>
<%@page import="com.servlet.el.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示员工权限</title>
      <style type="text/css">
            table {
                border: 1px solid pink;
                margin: 0 auto;
            }
            
            td{
                width: 150px;
                border: 1px solid pink;
                text-align: center;
            }
      #header {
	    	background-color:black;
	    	color:white;
	    	text-align:center;
	    	padding:5px;
		}
		#section {
		    background-color:rgba(255,255,255,0.6);
		    width:600px;
		    height:70%;
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
    <%
   		String isAd=(String)application.getAttribute("isAdmin");
     %>
    <%	if(isAd.equals("1")){%>
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
	#nav {
	    line-height:20px;
	    height:140%;
	    width:180px;
	    float:left;
	    padding:5px;	      
	}

  </style>
  <%}
  else {%>
  <style>
    body{
		 background:
		 url(images/work.jpg);
         background-position:center;
         background-repeat:no-repeat;
         background-size:100% 100%;
         background-attachment: fixed;
       }
  	#back{
	    color:black;
	    clear:both;
	    text-align:right;
	   	padding:5px;	
  	}
	#nav {
	    line-height:20px;
	    background-color:#eeeeee;
	    height:140%;
	    width:135px;
	    float:left;
	    padding:5px;	      
	}
  </style>
  <%} %>
  </head>
  <body>
    <div id="back">
	  <a href="login.jsp">退出登陆</a>
  </div>
   	<%	if(isAd.equals("1")){%>
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
    <%}else{ %>
    	<div id="header">
	<h1>欢迎来到员工界面</h1>
	</div>
    <%
   application.setAttribute("isAdmin", "0");
    %>
    <div id="nav">
   		</br>
   		<li><a href="welcomeNormal.jsp">员工守则</a></li>
   		<br><br>
   		<li><a href="DepartShow" name="isAdmin" value="0">部门基本信息</a></li>
   		<br><br>
   		<li><a href="EmpShow" name="isAdmin" value="0">员工基本信息</a></li>
   		<br><br>
   		<li><a href="EDShow" name="isAdmin" value="0">员工职位信息</a></li>
   		<br><br>
   		<li><a href="CustShow" name="isAdmin" value="0">客户基本信息</a></li>
   		<br><br>
   		<li><a href="ProjShow" name="isAdmin" value="0">项目基本信息</a></li>
   		<br><br>
    </div>
     <%} %>
    <div id="section">
    <h1>
    	员工权限信息总表
    </h1>
    
      <%
        List<EL> lists=(ArrayList)request.getAttribute("list");
		int length;
		if(lists!=null && !lists.isEmpty())length=lists.size();
		else length=0;
        %>  
		<br>
		员工权限数据表中共有
		<FONT SIZE=4 COLOR=black>
			<!--取得最后一条记录的行数-->
			<%=length%>
		</FONT>
		笔记录
		<br>
		<br>
		<TABLE  width="600" border=1  cellpadding="0" cellspacing="0">
			<TR bgcolor=CCCCCC ALIGN=CENTER>
				
				<TD>
					<B>员工编号</B>
				</TD>
				<TD>
					<B>登陆系统</B>
				</TD>
				<TD>
					<B>密码</B>
				</TD>
			</TR>
    
    		<%
    			for(int i=0;i<length;i++){
    			EL d=lists.get(i);
    		 %>
    			<TR ALIGN=CENTER>
				<!--利用getRow方法取得记录的位置-->		
				<TD>
					<B><%=d.getid()%></B>
				</TD>
				<TD>
					<B><%=d.getisAdmin()%></B>
				</TD>
				<TD>
					<B><%=d.getpw()%></B>
				</TD>
			</TR>
			<%} %>
			</TABLE>
		</div>
    <div id="footer">
	数据库期末实验系统
	</div>
  </body>
</html>
