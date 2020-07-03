package com.servlet.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class loginServlet implements javax.servlet.Servlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws Exception  {
		request.setCharacterEncoding("utf-8");
		String empID = request.getParameter("empID");// 取得员工编号
		String password = request.getParameter("password");// 取得密码
		String isAdmin=request.getParameter("isAdmin");
		System.out.println("页面取得用户名和密码"+empID+"|"+password+"|"+isAdmin);
		 
		boolean canLogin = LoginCheck(empID, password,isAdmin);// 取得用户名和密码
		System.out.println(canLogin);
		if (canLogin) {// 根据登陆情况，跳转页面
			System.out.println("登陆成功");
			if(isAdmin.contentEquals("1"))
			{
				 request.getRequestDispatcher("/welcomeAdmin.jsp").forward(request,response);
			}else{
				 request.getRequestDispatcher("/welcomeNormal.jsp").forward(request,response);
			}
			
			
		} else {
			System.out.println("登陆失败，请确认账户，密码和系统身份！");
			request.setAttribute("erro", "登陆失败，请确认账户，密码和系统身份！");
			 request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

	public boolean LoginCheck(String empID, String password,String isAdmin) throws Exception {
		boolean returnValue = false;
		String sql = "SELECT * FROM user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
 
		try {
			conn = MysqlCon.getConnection();
			if (conn != null) {
				System.out.println("数据库连接正常");
			} else {
				System.out.println("数据库连接异常");
			}
			//把the result set type 不要设成 TYPE_FORWARD_ONLY
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
                    ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			rs.beforeFirst(); //移至第一条记录之前
//			System.out.println("数据库取得用户名和密码"+empID+"|"+password);
			while (rs.next()) {
				String empid = rs.getString("empID");
				String passWord = rs.getString("password");
				String isadmin=rs.getString("isAdmin");
//				System.out.println("数据库取得用户名和密码"+empid+"|"+passWord+"|"+isadmin);
				if (empid.equals(empID) && password.equals(passWord) && isadmin.equals(isAdmin)) {
					//   如果用户名和密码,权限都和数据库的一样，就返回true
					returnValue = true;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
 
	}
	
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		try {
			doPost(rq, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
