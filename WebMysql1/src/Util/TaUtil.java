package Util;

import java.sql.Connection;
import java.sql.Statement;

public class TaUtil {
	public void create_D(Connection conn,String a) throws Exception{
		String sql="create database "+a;
		Statement Da=conn.createStatement();//����һ��Statement����
		Da.executeUpdate(sql);//ִ��sql���
	}
	public void create_T(Connection conn,String a) throws Exception{
		String sql="create table "+a;
		Statement Ta=conn.createStatement();//����һ��Statement����
		Ta.executeUpdate(sql);//ִ��sql���
	}
}
