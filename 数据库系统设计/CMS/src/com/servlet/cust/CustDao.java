package com.servlet.cust;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.servlet.depart.Depart;
import com.servlet.log.MysqlCon;

public class CustDao {
    public List<Cust> getAllCust() throws Exception{  
        List<Cust> list = new ArrayList<Cust>(); 
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from custinfo;";  
        System.out.println("sql:"+sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            int id;
            String name,sex,tel,email,sfz;
            
            while (rst.next()) {
            	Cust cust = new Cust();
            	id=rst.getInt("custID");
            	name=rst.getString("custName");
            	sex=rst.getString("custSex");
            	tel=rst.getString("custTel");
            	email=rst.getString("custEmail");
            	sfz=rst.getString("custSfz");
            	System.out.println("id: "+id+"  name: "+name+" sex: "+sex+"  tel: "+tel+" email: "+email+" sfz: "+sfz);
            	if(id!=0 && name!=null & sex!=null & tel!=null & email!=null & sfz!=null)
            	{
            		cust.setid(rst.getInt("custID")); 
                	cust.setname(rst.getString("custName"));
                	cust.setsex(rst.getString("custSex"));
                	cust.settel(rst.getString("custTel")); 
                	cust.setemail(rst.getString("custEmail"));
                	cust.setsfz(rst.getString("custSfz"));
                    list.add(cust);
                    System.out.println("cust:"+cust);
                    System.out.println("element:"+cust.getid()+"|"+cust.getname()+"|"+cust.getsex()+"|"+cust.gettel()+"|"+cust.getemail()+"|"+cust.getsfz());
            	}
            	
            }
            System.out.println("成功展示客户信息！");
            rst.close();  
            pst.close(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list; 
    }
    
    public boolean addCust(Cust cust) throws Exception{  
        String sql = "INSERT INTO `custinfo`(`custID`,`custName`,`custSex`,`custTel`,`custEmail`,`custSfz`) VALUES (null,?,?,?,?,?)";  //锟斤拷拥锟絊QL锟斤拷锟�
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            //pst.setInt(1, cust.getid());
            pst.setString(1, cust.getname());
            pst.setString(2, cust.getsex());
            pst.setString(3, cust.gettel());
            pst.setString(4, cust.getemail());
            pst.setString(5, cust.getsfz());
            
            int count = pst.executeUpdate();
            pst.close();
            System.out.println("成功加入客户！");
            return count>0?true:false; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateCust(Cust cust) throws Exception{  
    	String sql = "UPDATE `custinfo` SET `custName`=?,`custSex`=?,`custTel`=?,`custEmail`=?,`custSfz`=? WHERE `custID` = ?;";  //锟睫改碉拷SQL锟斤拷洌拷锟斤拷锟絀D锟睫革拷
        Connection conn = MysqlCon.getConnection();
        conn.setAutoCommit(false);//start transaction
        Savepoint sp=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
        	pst = conn.prepareStatement(sql); 
            pst.setString(1, cust.getname());
            pst.setString(2, cust.getsex());
            pst.setString(3, cust.gettel());
            pst.setString(4, cust.getemail());
            pst.setString(5, cust.getsfz());
            pst.setInt(6, cust.getid());
            int count = pst.executeUpdate();
            sp=conn.setSavepoint();
            conn.commit();
            
            pst.close(); 
            System.out.println("成功更新客户信息！");
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
    
    
    public boolean deleteCust(int id) throws Exception{ 
        String sql = "delete from custinfo where custID = ?;"; 
        Connection conn = MysqlCon.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int count = pst.executeUpdate();
            pst.close();
            System.out.println("成功删除客户！");
            return count>0?true:false;  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Cust selectCustById(int id) throws Exception{ 
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from custinfo where custID = '"+id+"';";
        Cust cust = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	cust = new Cust();
            	cust.setid(rst.getInt("custID")); 
            	cust.setname(rst.getString("custName"));
            	cust.setsex(rst.getString("custSex"));
            	cust.settel(rst.getString("custTel")); 
            	cust.setemail(rst.getString("custEmail"));
            	cust.setsfz(rst.getString("custSfz"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust; 
    }
}

