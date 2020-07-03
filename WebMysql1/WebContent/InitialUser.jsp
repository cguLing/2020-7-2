<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>初始化界面</title>
</head>
<body>
<div style="text-align:center;margin-top:120px">
	<form action="InitUserServlet" method="post">
        <table style="margin-left:40%" border="1">
        	<tr align="center" >
				<td colspan=2>数据表User初始化信息</td>
			</tr>
        	<tr height="25%" align="center">
				<td width="50%">UserName</td>
				<td><input name="username" type="text" size="21"></td>
			</tr>
			<tr align="center" >
				<td>Password</td>
				<td><input name="password" type="text" size="21"></td>
			</tr>
			<tr align="center">
				<td colspan=2><input type="submit" value="插入"></td>
			</tr>
        </table>
    </form>
</div>
</body>
</html>