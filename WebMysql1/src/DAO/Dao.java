package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Insert.UpIn;
import Table.Person;
import Table.User;
import Util.DBUtil;
import Delete.delete;

public class Dao {
	//数据库连接对象
    public  int  login(String username,String name, String age, String telenum) throws Exception {
       Connection connection =null;
       PreparedStatement pstmt=null;
       int resultSet=0;

      //赋值
      try {
         connection=DBUtil.getCon();
         UpIn in=new UpIn();
		 resultSet = in.UpInData(connection,username,name,age,telenum);
         if(resultSet==1){
            System.out.println("更新成功！");
         }
         else if(resultSet==2) {
             System.out.println("插入成功！");
         }
         else{
            System.out.println("插入失败！");
         }
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
         // DBUtil.close(pstmt, connection);
      }
      return resultSet;

    }

    public boolean TryDelete(String username) throws Exception {
    	boolean flag=false;
        Connection connection = null;
        try {
             connection = DBUtil.getCon();
             delete de=new delete();
             flag = de.Delete_T(connection,username);
             if(flag==true) {
            	 System.out.println("删除成功！");
             }
             else {
            	 System.out.println("删除失败！");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //DBUtil.close(psmt, connection);
        }
        return flag;
    }
    public List readUser(){
	     List<User> list =new ArrayList<User>();
	     Connection con=null;
	     PreparedStatement psmt=null;
	     ResultSet rs=null;
	     
	     try {
	         con=DBUtil.getCon();
	         String sql="select * from users";
	         psmt=con.prepareStatement(sql);
	         rs=psmt.executeQuery();
	         
	         while(rs.next()){
	        	 String username=rs.getString("username");
	        	 String password=rs.getString("password");
	             User user=new User();
	             user.UserShow(username,password);
	             list.add(user);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return list;
	 }
    public List readPerson(){
	     List<Person> list =new ArrayList<Person>();
	     Connection con=null;
	     PreparedStatement psmt=null;
	     ResultSet rs=null;
	     
	     try {
	         con=DBUtil.getCon();
	         String sql="select * from person";
	         psmt=con.prepareStatement(sql);
	         rs=psmt.executeQuery();
	         
	         while(rs.next()){
	        	 String username=rs.getString("username");
	        	 String name=rs.getString("name");
	        	 String age=rs.getString("age");
	        	 String telenum=rs.getString("telenum");
	             Person per=new Person();
	             per.PersonShow(username,name,age,telenum);
	             list.add(per);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return list;
	 }
}
