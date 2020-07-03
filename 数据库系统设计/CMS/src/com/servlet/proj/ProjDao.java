package com.servlet.proj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.servlet.log.MysqlCon;

public class ProjDao {
    public List<Proj> getAllProj() throws Exception{ 
        List<Proj> list = new ArrayList<Proj>();  
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from projinfo;";  
        System.out.println("sql:"+sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            int projer,custid;
            String projid,depid,projname,projtext,projstart,projsta,projend;
            
            while (rst.next()) {
            	Proj proj = new Proj();
            	
            	projid=rst.getString("projID");
            	depid=rst.getString("depID");
            	projer=rst.getInt("projEr");
            	custid=rst.getInt("custID");
            	projname=rst.getString("projName");
            	projtext=rst.getString("projText");
            	projstart=rst.getString("projStart");
            	projsta=rst.getString("projSta");
            	projend=rst.getString("projEnd");
            	System.out.println("projid: "+projid+"  depid: "+depid+"  projer: "+projer+"  custid: "+custid+"  projname: "+projname+"  projtext: "+projtext+"  projstart: "+projstart+"  projsta: "+projsta+"  projend: "+projend );
            	if(projid!=null && depid!=null)
            	{
                    proj.setid(new String(projid.getBytes("ISO-8859-1"),"UTF-8"));  
                    proj.setdid(new String(depid.getBytes("ISO-8859-1"),"UTF-8"));
                    proj.seter(projer);
                    proj.setcid(custid);
                    proj.setname(projname);
                    proj.settext(projtext);
                    proj.setstart(new String(projstart.getBytes("ISO-8859-1"),"UTF-8"));
                    proj.setsta(new String(projsta.getBytes("ISO-8859-1"),"UTF-8"));
                    proj.setend(new String(projend.getBytes("ISO-8859-1"),"UTF-8"));
                    list.add(proj);
                    System.out.println("proj:"+proj);
                    System.out.println("element:"+proj.getid()+"|"+proj.getdid()+"|"+proj.geter()+"|"+proj.getcid()+"|"+proj.getname()+"|"+proj.gettext()+"|"+proj.getstart()+"|"+proj.getsta()+"|"+proj.getend());
            	}
            	
            }
            System.out.println("成功获取项目信息表！");
            rst.close();  
            pst.close(); 
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return list; 
    }
    
    public boolean addProj(Proj proj) throws Exception{  
        String sql = "INSERT INTO `projinfo`(`projID`,`depID`,`projEr`,`custID`,`projName`,`projText`,`projStart`,`projSta`,`projEnd`) VALUES (?,?,?,?,?,?,?,?,?)";  //锟斤拷拥锟絊QL锟斤拷锟�
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, proj.getid());
            pst.setString(2, proj.getdid());
            pst.setInt(3, proj.geter());
            pst.setInt(4, proj.getcid());
            pst.setString(5, proj.getname());
            pst.setString(6, proj.gettext());
            pst.setString(7, proj.getstart());
            pst.setString(8, proj.getsta());
            pst.setString(9, proj.getend());
            int count = pst.executeUpdate();
            pst.close();
            System.out.println("成功增加项目！");
            return count>0?true:false;  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateProj(Proj proj) throws Exception{  
        String sql = "UPDATE `projinfo` SET `depID`=?,`projEr`=? ,`custID`=?,`projName`=?,`projText`=? ,`projStart`=?,`projSta`=? ,`projEnd`=? WHERE `projID` = ?;";  //锟睫改碉拷SQL锟斤拷洌拷锟斤拷锟絀D锟睫革拷
        Connection conn = MysqlCon.getConnection();
        conn.setAutoCommit(false);//start transaction
        Savepoint sp=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, proj.getdid());
            pst.setInt(2, proj.geter());
            pst.setInt(3, proj.getcid());
            pst.setString(4, proj.getname());
            pst.setString(5, proj.gettext());
            pst.setString(6, proj.getstart());
            pst.setString(7, proj.getsta());
            pst.setString(8, proj.getend());
            pst.setString(9, proj.getid());
            int count = pst.executeUpdate();
            sp=conn.setSavepoint();
            conn.commit();
            
            pst.close();  
            System.out.println("成功更新项目信息！");
            return count>0?true:false;  
        } catch (SQLException e) {
            try{
            	conn.rollback(sp);
            	conn.commit();
            }catch(SQLException e1){
            	e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
        	MysqlCon.close(conn, pst, rs);
        }
        return false;
    }
    
    public boolean deleteProj(String id) throws Exception{  
        String sql = "delete from projinfo where projID = ?;"; 
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            int count = pst.executeUpdate();
            pst.close();
           
            return count>0?true:false; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Proj selectProjById(String id) throws Exception{  
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from projinfo where projID = '"+id+"';";
        Proj proj = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	proj = new Proj();
            	proj.setid(rst.getString("projID")); 
        		proj.setdid(rst.getString("depID"));
        		proj.seter(rst.getInt("projEr"));
        		proj.setcid(rst.getInt("custID"));
        		proj.setname(rst.getString("projName")); 
        		proj.settext(rst.getString("projText"));
        		proj.setstart(rst.getString("projStart"));
        		proj.setsta(rst.getString("projSta")); 
        		proj.setend(rst.getString("projEnd"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }
}
