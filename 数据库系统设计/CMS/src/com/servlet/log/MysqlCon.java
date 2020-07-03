package com.servlet.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class MysqlCon {
	static Connection conn;

	//数据库的连接
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";// 驱动
		String base="cms";
		String url = "jdbc:mysql://localhost:3306/"+base+"?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT"; 
		String username = "root"; 
		String password = "xxxxxx"; 
		conn = null;    
		if (conn == null) {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	//关闭数据库链接
		 public static void close(Connection con,PreparedStatement ps,ResultSet rs){
		        if(rs!=null){
		            try {
		                rs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        if(ps!=null){
		            try {
		                ps.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        if(con!=null){
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		
		  
		  
 
}
