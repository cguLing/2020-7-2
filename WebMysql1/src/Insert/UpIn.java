package Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpIn {
	private static String sql0="update person set name='";
	private static String sql1=" where username='";
	private static String sql2="insert into ";
	private static String sql3=" where not exists (select * from person where username='";
	private static String sql4="insert into users(username,password) select '";
	private static String sql5=" where not exists (select * from users where username='";
	public static int UpData(Connection conn,String a,String b,String c,String d) throws Exception{
		String sql="";
		if((!c.equals("0"))&&(!d.equals("0"))) sql=sql0+b+"',age="+c+",telenum='"+d+"'";
		else if((c.equals("0"))&&(!d.equals("0"))) sql=sql0+b+"',telenum='"+d+"'";
		else if((!c.equals("0"))&&(d.equals("0"))) sql=sql0+b+"',age="+c;
		else if((c.equals("0"))&&(d.equals("0"))) sql=sql0+b+"'";
		sql+=(sql1+a+"'");
		Statement up=conn.createStatement();//创建一个Statement对象
		return up.executeUpdate(sql);//执行sql语句
	}
	public static int Insert(Connection conn,String a,String b,String c,String d) throws Exception{
		String sql="";
		sql=sql4+a+"','888888'"+sql5+a+"')";
		Statement InUser=conn.createStatement();//创建一个Statement对象
		InUser.executeUpdate(sql);//执行sql语句
		sql="";
		if((!c.equals("0"))&&(!d.equals("0"))) sql=sql2+"person(username,name,age,telenum) select '"+a+"','"+b+"',"+c+",'"+d+"'";
		else if((c.equals("0"))&&(!d.equals("0"))) sql=sql2+"person(username,name,telenum) select '"+a+"','"+b+"','"+d+"'";
		else if((!c.equals("0"))&&(d.equals("0"))) sql=sql2+"person(username,name,age) select '"+a+"','"+b+"',"+c;
		else if((c.equals("0"))&&(d.equals("0"))) sql=sql2+"person(username,name) select '"+a+"','"+b+"'";
		sql+=(sql3+a+"')");
		Statement up=conn.createStatement();//创建一个Statement对象
		return up.executeUpdate(sql);//执行sql语句
	}
	public int UpInData(Connection conn,String a,String b,String c,String d) throws Exception {
		int flag1=0,flag2=0;
		flag1=UpData(conn,a,b,c,d);
		flag2=Insert(conn,a,b,c,d);
		if(flag1!=0&&flag2==0) return 1;
		else if(flag1==0&&flag2!=0) return 2;
		else return 0;
	}
}
