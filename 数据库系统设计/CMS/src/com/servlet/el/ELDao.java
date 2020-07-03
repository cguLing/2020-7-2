package com.servlet.el;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.depart.Depart;
import com.servlet.log.MysqlCon;

public class ELDao {
    public List<EL> getAllEL() throws Exception{ 
        List<EL> list = new ArrayList<EL>();  
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from user;";  
        System.out.println("sql:"+sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            String isAdmin,pw;
            int empid;
            
            while (rst.next()) {
            	EL el = new EL();
            	empid=rst.getInt("empID");
            	isAdmin=rst.getString("isAdmin");
            	pw=rst.getString("password");
            	System.out.println("empid: "+empid+"  isAdmin: "+isAdmin+"  pw: "+pw);
            	if(empid!=0 && isAdmin!=null && pw!=null){
            		el.setid(rst.getInt("empID")); 
                	el.setisAdmin(rst.getString("isAdmin"));
                	el.setpw(rst.getString("password"));
                    list.add(el);
                    System.out.println("el:"+el);
                    System.out.println("element:"+el.getid()+"|"+el.getisAdmin()+"|"+el.getpw());
            	}
            	
            }
            System.out.println("成功获取用户表！");
            rst.close();  
            pst.close();  
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list; 
    }
    
    public boolean addEL(EL el) throws Exception{  //锟斤拷锟斤拷锟较�
        String sql = "INSERT INTO `user`(`empID`,`password`,`isAdmin`) VALUES (null,?,?)";  //锟斤拷拥锟絊QL锟斤拷锟�
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, el.getpw());
            pst.setString(2, el.getisAdmin());
            int count = pst.executeUpdate();
            pst.close();
            System.out.println("锟斤拷锟斤拷锟斤拷息锟斤拷映晒锟斤拷锟�");
            return count>0?true:false;  //锟角凤拷锟斤拷拥锟斤拷卸锟�
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateEL(EL el) throws Exception{  //锟睫革拷
        String sql = "UPDATE `user` SET `isAdmin`=?,`password`=? WHERE `empID` = ?;";  //锟睫改碉拷SQL锟斤拷洌拷锟斤拷锟絀D锟睫革拷
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, el.getisAdmin());
            pst.setString(2, el.getpw());
            pst.setInt(3, el.getid()); 
            int count = pst.executeUpdate();
            pst.close();  //锟截憋拷
            System.out.println("锟睫改诧拷锟斤拷锟斤拷息锟缴癸拷锟斤拷");
            return count>0?true:false;  //锟角凤拷锟睫改碉拷锟叫讹拷
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteEL(int empid) throws Exception{  //删锟斤拷
        String sql = "delete from user where empID = ?;";  //删锟斤拷锟斤拷SQL锟斤拷洌拷锟斤拷锟絀D删锟斤拷
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, empid);
            int count = pst.executeUpdate();
            pst.close();
           
            return count>0?true:false;  //锟角凤拷删锟斤拷锟斤拷锟叫讹拷
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public EL selectELById(int id) throws Exception{  //锟斤拷锟斤拷ID锟斤拷锟叫诧拷询
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from user where empID = '"+id+"';";
        EL el = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	el = new EL();
            	el.setid(rst.getInt("empID"));
            	el.setisAdmin(rst.getString("isAdmin"));
            	el.setpw(rst.getString("password"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return el;  //锟斤拷锟斤拷
    }

    public int getNewUser() throws Exception{
    	Connection conn = MysqlCon.getConnection();
        String sql  = "SELECT * FROM user ORDER BY empID DESC LIMIT 1;";
        Depart depart = null;
        int newID=0;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	newID=rst.getInt("empID");
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return newID;
    }
}
