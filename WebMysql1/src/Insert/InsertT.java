package Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertT {
	private static String sql="insert into ";
	public int insertU(Connection conn,String a,String b) throws Exception{
		String sql0=sql+"users(username,password) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql0);//创建一个Statement对象
		ps.setString(1,a);//为sql语句中第一个问号赋值
		ps.setString(2,b);//为sql语句中第二个问号赋值
		return ps.executeUpdate();//执行sql语句
	}
	public int insertP(Connection conn,String a,String b,String c,String d) throws Exception{
		String sql0="";
		if((!c.equals("0"))&&(!d.equals("0"))) sql0=sql+"person(username,name,age,telenum) values(?,?,?,?)";
		else if((c.equals("0"))&&(!d.equals("0"))) sql0=sql+"person(username,name,telenum) values(?,?,?)";
		else if((!c.equals("0"))&&(d.equals("0"))) sql0=sql+"person(username,name,age) values(?,?,?)";
		else if((c.equals("0"))&&(d.equals("0"))) sql0=sql+"person(username,name) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql0);//创建一个Statement对象
		ps.setString(1,a);//为sql语句中第一个问号赋值
		ps.setString(2,b);//为sql语句中第二个问号赋值
		if(!c.equals("0"))ps.setString(3,c);//为sql语句第三个问号赋值
		if((!c.equals("0"))&&(!d.equals("0"))) ps.setString(4,d);
		else if((c.equals("0"))&&(!d.equals("0")))ps.setString(3,d);//为sql语句的第四个问号赋值
		return ps.executeUpdate();//执行sql语句
	}
}
