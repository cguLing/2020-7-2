package Util;

import java.sql.Connection;
import java.sql.Statement;

public class TaUtil {
	public void create_D(Connection conn,String a) throws Exception{
		String sql="create database "+a;
		Statement Da=conn.createStatement();//创建一个Statement对象
		Da.executeUpdate(sql);//执行sql语句
	}
	public void create_T(Connection conn,String a) throws Exception{
		String sql="create table "+a;
		Statement Ta=conn.createStatement();//创建一个Statement对象
		Ta.executeUpdate(sql);//执行sql语句
	}
}
