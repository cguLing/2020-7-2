package Delete;

import java.sql.Connection;
import java.sql.Statement;

public class delete {
	private static String sql0="delete from ";
	private static String sql1=" where username like '";
	public boolean Delete_T(Connection conn,String a) throws Exception{
		int re1=0,re2=0,re3=0,re4=0;
		String sql="";
		sql="SET foreign_key_checks = 0;";
		Statement Dt0=conn.createStatement();//创建一个Statement对象
		re1=Dt0.executeUpdate(sql);//执行sql语句
		String sql2=sql0+"users"+sql1+a+"%'";
		Statement Dt1=conn.createStatement();//创建一个Statement对象
		re2=Dt1.executeUpdate(sql2);//执行sql语句
		String sql3=sql0+"person"+sql1+a+"%'";
		Statement Dt2=conn.createStatement();//创建一个Statement对象
		re3=Dt2.executeUpdate(sql3);//执行sql语句
		sql="";
		sql="SET foreign_key_checks = 1;";
		Statement Dt3=conn.createStatement();//创建一个Statement对象
		re4=Dt3.executeUpdate(sql);//执行sql语句
		if(re2!=0&&re3!=0) return true;
		else if(re2!=0&&re3==0)return true;
		else return false;
	}
}
