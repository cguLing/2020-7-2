package Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertT {
	private static String sql="insert into ";
	public int insertU(Connection conn,String a,String b) throws Exception{
		String sql0=sql+"users(username,password) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql0);//����һ��Statement����
		ps.setString(1,a);//Ϊsql����е�һ���ʺŸ�ֵ
		ps.setString(2,b);//Ϊsql����еڶ����ʺŸ�ֵ
		return ps.executeUpdate();//ִ��sql���
	}
	public int insertP(Connection conn,String a,String b,String c,String d) throws Exception{
		String sql0="";
		if((!c.equals("0"))&&(!d.equals("0"))) sql0=sql+"person(username,name,age,telenum) values(?,?,?,?)";
		else if((c.equals("0"))&&(!d.equals("0"))) sql0=sql+"person(username,name,telenum) values(?,?,?)";
		else if((!c.equals("0"))&&(d.equals("0"))) sql0=sql+"person(username,name,age) values(?,?,?)";
		else if((c.equals("0"))&&(d.equals("0"))) sql0=sql+"person(username,name) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql0);//����һ��Statement����
		ps.setString(1,a);//Ϊsql����е�һ���ʺŸ�ֵ
		ps.setString(2,b);//Ϊsql����еڶ����ʺŸ�ֵ
		if(!c.equals("0"))ps.setString(3,c);//Ϊsql���������ʺŸ�ֵ
		if((!c.equals("0"))&&(!d.equals("0"))) ps.setString(4,d);
		else if((c.equals("0"))&&(!d.equals("0")))ps.setString(3,d);//Ϊsql���ĵ��ĸ��ʺŸ�ֵ
		return ps.executeUpdate();//ִ��sql���
	}
}
