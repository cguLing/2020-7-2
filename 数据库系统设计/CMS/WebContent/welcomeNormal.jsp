<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url="";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <base href="<%=basePath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>普通员工界面</title>
  </head>
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
	#header {
	    background-color:black;
	    color:white;
	    text-align:center;
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
	#section {
	    width:500px;
	    height:100%;
	    float:left;
	    padding:10px;
	    margin-left:30px	 	 
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
    <div id="section">
    <h2>员工守则</h2>
    <br>
    <h3>十要</h3>
	<p>
	一、要爱岗敬业，把岗位作为实现自我人生价值的基石。<br>
	二、要团结和睦、相互支持，正确处理同事关系。<br>
	三、要科学创新，不断学习探索，积极开发新的科学技术。<br>
	四、要踏实进取，保持务实进取的精神，不断提高自身素质。<br>
	五、要遵章守纪，遵守国家法律法规，遵守公司规章制度。<br>
	六、要文明诚信，举止大方，诚信为本，实事求是。<br>
	七、要勇于负责，承担重任，对工作结果负责。<br>
	八、要乐于奉献，任劳任怨，以贡献自身力量为快乐和自豪。<br>
	九、要顾全大局，发现问题及时与上级领导协商解决。<br>
	十、要树立安全第一意识，遵守安全管理规章制度<br>
	</p>
	<br>
    <h3>十不准</h3>
	<p>
	一、不准迟到、早退、无故旷工，不得擅自离岗办理私事。<br>
	二、不准我行我素,目无规章制度，居功自傲、滥用职权。<br>
	三、不准光说不练、只图表面、相互推诿、事事搪塞。<br>
	四、不准拉帮结派、挑拨离间、无中生有、造谣生事。<br>
	五、不准以公谋私、收受礼赂、吃拿回扣、暗箱操作。<br>
	六、不准携带易燃、易爆等危险品进入公司明令禁止区域。<br>
	七、不准违规操作、故意破坏、刻意浪费公司资源。<br>
	八、不准作出任何有损公司利益、形象和信誉的行为。<br>
	九、不准泄漏公司机密。<br>
	十、不准违法乱纪、危害社会治安。<br>
	</p>
    </div>
    <div id="footer">
	数据库期末实验系统
	</div>
  </body>
</html>
