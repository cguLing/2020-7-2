<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>操作界面</title>
</head>
<body>
	<div style="position: absolute;left: 20px;top: 20px">
	<h3>说明：</h3>
	<textarea rows="9" cols="20" readonly="readonly" style="overflow:auto">
	
····················
·数据库为WebMysql1；
·首先需要进行初始；    
·初始化中实现建表；    
·初始化中插入数据；    
·插入/更新/删除。       
····················
	</textarea>
	</div>
	<div style="position: relative;left: 340px;top: 20px">
	<br>
 	<a href="CreateT.jsp">进入初始化界面</a>
	<dl>
	   <dt><b>初始化：</b>
	   <dd>1. 创建数据表Users</dd>
	   <dd>2. 创建数据表Person</dd>
	   <dd>3. 插入初始数据</dd>
	</dl>
	</div>
    <br>
    <div style="text-align:center;margin-top:20px">
    <form action="InsertServlet" method="post">
        <table style="margin-left:40%" border="1">
        	<tr align="center" >
				<td colspan=2>数据表person插入/更新信息</td>
			</tr>
        	<tr height="25%" align="center">
				<td width="50%">UserName</td>
				<td><input name="username" type="text" size="21"></td>
			</tr>
			<tr align="center" >
				<td>Name</td>
				<td><input name="name" type="text" size="21"></td>
			</tr>
			<tr align="center">
				<td>Age</td>
				<td><input name="age" type="text" size="21"></td>
			</tr>
			<tr align="center">
				<td>TeleNummber</td>
				<td><input name="telenum" type="text" size="21"></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" value="插入/更新"></td>
			</tr>
        </table>
    </form>
        <br><br>
    <form action="DeleteServlet" method="post">
        <table style="margin-left:40%" border="1">
        	<tr align="center" >
				<td colspan=2>数据表users删除信息</td>
			</tr>
        	<tr height="25%" align="center">
				<td width="50%">UserName</td>
				<td><input name="username" type="text" size="21"></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" value="删除"></td>
			</tr>
        </table>
    </form>
    </div>
</body>
</html>