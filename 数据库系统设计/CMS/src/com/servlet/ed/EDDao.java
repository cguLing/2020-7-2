package com.servlet.ed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.servlet.log.MysqlCon;

public class EDDao {
    public List<ED> getAllED() throws Exception{ 
        List<ED> list = new ArrayList<ED>(); 
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from edinfo;"; 
        System.out.println("sql:"+sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            String empID,depID,post;
            
            while (rst.next()) {
            	ED ed = new ED();
            	empID=rst.getString("empID");
            	depID=rst.getString("depID");
            	post=rst.getString("post");
            	System.out.println("empID: "+empID+"  depID: "+depID+"  post: "+post);
            	if(empID!=null && depID!=null & post!=null)
            	{
            		ed.setempID(rst.getInt("empID")); 
                	ed.setdepID(rst.getString("depID"));
                	ed.setpost(rst.getString("post"));
                    list.add(ed);
                    System.out.println("depart:"+ed);
                    System.out.println("element:"+ed.getempID()+"|"+ed.getdepID()+"|"+ed.getpost());
            	}
            	
            }
            System.out.println("成功展示职员部门关系！");
            rst.close();  
            pst.close(); 
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return list; 
    }
    
    public boolean addED(ED ed) throws Exception{  //閿熸枻鎷烽敓鏂ゆ嫹閿熻緝锟�
        String sql = "INSERT INTO `edinfo`(`empID`,`depID`,`post`) VALUES (?,?,?)";  //閿熸枻鎷锋嫢閿熺祳QL閿熸枻鎷烽敓锟�
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ed.getempID());
            pst.setString(2, ed.getdepID());
            pst.setString(3, ed.getpost());
            int count = pst.executeUpdate();
            pst.close();
            System.out.println("閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋伅閿熸枻鎷锋槧鏅掗敓鏂ゆ嫹閿燂拷");
            return count>0?true:false;  //閿熻鍑ゆ嫹閿熸枻鎷锋嫢閿熸枻鎷峰嵏閿燂拷
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateED(ED ed) throws Exception{  //閿熺潾闈╂嫹
        String sql = "UPDATE `edinfo` SET `depID`=?,`post`=? WHERE `empID` = ?;"; 
        Connection conn = MysqlCon.getConnection();
        conn.setAutoCommit(false);//start transaction
        Savepoint sp=null;
        ResultSet rs=null;
	 	PreparedStatement pst=null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ed.getdepID());
            pst.setString(2, ed.getpost()); 
            pst.setInt(3, ed.getempID());
            int count = pst.executeUpdate();
            sp=conn.setSavepoint();//璁剧疆浜嬪姟鍥炴粴鐐�
            conn.commit();
            pst.close();  
            conn.close();
            return count>0?true:false; 
        } catch (SQLException e) {
        	 try{
             	conn.rollback(sp);//鍥炴粴鍒拌缃偣
             	conn.commit();//鍥炴粴鍚庢彁浜�
             }catch(SQLException e1){
             	e1.printStackTrace();
             }
            e.printStackTrace();
        }finally{
        	MysqlCon.close(conn, pst, rs);
        }
        return false;
    }
    
    public boolean deleteED(int idStr) throws Exception{  //鍒犻敓鏂ゆ嫹
        String sql = "delete from edinfo where empID = ?;";  //鍒犻敓鏂ゆ嫹閿熸枻鎷稴QL閿熸枻鎷锋磳顒婃嫹閿熸枻鎷烽敓绲�D鍒犻敓鏂ゆ嫹
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idStr);
            int count = pst.executeUpdate();
            pst.close();
            conn.close();
            return count>0?true:false;  //閿熻鍑ゆ嫹鍒犻敓鏂ゆ嫹閿熸枻鎷烽敓鍙鎷�
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ED selectEDById(int id) throws Exception{  //閿熸枻鎷烽敓鏂ゆ嫹ID閿熸枻鎷烽敓鍙鎷疯
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from edinfo where empID = '"+id+"';";
        ED ed = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	ed = new ED();
            	ed.setempID(rst.getInt("empID"));
            	ed.setdepID(rst.getString("depID"));
            	ed.setpost(rst.getString("post"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ed;  //閿熸枻鎷烽敓鏂ゆ嫹
    }
}
