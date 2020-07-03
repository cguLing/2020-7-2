package com.servlet.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.el.EL;
import com.servlet.el.ELDao;


@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public registerServlet() {
	        super();
	    }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String password = request.getParameter("password");
			System.out.println("页面取得注册信息"+password);
			ELDao dao = new ELDao();
			int empID =0;
			boolean flag = false;
			String table="user";
			try {
				flag = insert(table, password, '0');
				empID = dao.getNewUser();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				String id=Integer.toString(empID);
				request.setAttribute("empID", id);
				System.out.println("注册信息成功！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else{
				request.setAttribute("erro", "信息注册失败！");
				System.out.println("信息注册失败！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	 
	 
	//封装插入数据语句的特性
	 public boolean insert(String table, String password,char c) {
			boolean flag=false;
			// TODO Auto-generated method stub
			String sql="insert into "+table+" values(null,"+password+","+c+");";
				try{
					Connection conn=MysqlCon.getConnection();
					Statement statement=conn.createStatement();
					statement.executeUpdate(sql);
					flag=true;
					statement.close();//关闭Statement对象 
					conn.close();//关闭Connection对象
							
				}catch(Exception e){
					flag=false;
					e.printStackTrace();
				}
				return flag;	
		}

		public void destroy() {
		}
		 protected void doPost(HttpServletRequest res, HttpServletResponse ron) throws ServletException, IOException {
		        doGet(res, ron);
		    }
		 

}
