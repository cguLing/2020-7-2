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
		Statement Dt0=conn.createStatement();//����һ��Statement����
		re1=Dt0.executeUpdate(sql);//ִ��sql���
		String sql2=sql0+"users"+sql1+a+"%'";
		Statement Dt1=conn.createStatement();//����һ��Statement����
		re2=Dt1.executeUpdate(sql2);//ִ��sql���
		String sql3=sql0+"person"+sql1+a+"%'";
		Statement Dt2=conn.createStatement();//����һ��Statement����
		re3=Dt2.executeUpdate(sql3);//ִ��sql���
		sql="";
		sql="SET foreign_key_checks = 1;";
		Statement Dt3=conn.createStatement();//����һ��Statement����
		re4=Dt3.executeUpdate(sql);//ִ��sql���
		if(re2!=0&&re3!=0) return true;
		else if(re2!=0&&re3==0)return true;
		else return false;
	}
}
