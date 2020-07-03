package com.servlet.depart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import com.servlet.log.MysqlCon;

public class DepartDao {
    public List<Depart> getAllDepart() throws Exception{
        List<Depart> list = new ArrayList<Depart>(); 
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from depinfo;"; 
        System.out.println("sql:"+sql);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            String id,er,dsc;
            
            while (rst.next()) {
            	Depart depart = new Depart();
            	id=rst.getString("depID");
            	er=rst.getString("depEr");
            	dsc=rst.getString("depDsc");
            	System.out.println("id: "+id+"  er: "+er+"  dsc: "+dsc);
            	if(id!=null && er!=null & dsc!=null)
            	{
            		depart.setid(rst.getString("depID")); 
                	depart.seter(rst.getString("depEr"));
                	depart.setdsc(rst.getString("depDsc"));
                    list.add(depart);
                    System.out.println("depart:"+depart);
                    System.out.println("element:"+depart.getid()+"|"+depart.geter()+"|"+depart.getdsc());
            	}
            	
            }
            System.out.println("获取部门信息成功！");
            rst.close(); 
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list; 
    }
    
   
     
    public boolean addDepart(Depart depart) throws Exception{  //�����Ϣ
        String sql = "INSERT INTO `depinfo`(`depID`,`depEr`,`depDsc`) VALUES (?,?,?)";  //��ӵ�SQL���
        Connection conn = MysqlCon.getConnection();
       
        PreparedStatement pst=null;
        ResultSet rs=null;
       
        System.out.println("sql:"+sql);
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, depart.getid());
            pst.setString(2, depart.geter());
            pst.setString(3, depart.getdsc());
            int count = pst.executeUpdate();
           
            pst.close();
            System.out.println("������Ϣ��ӳɹ���");
            return count>0?true:false;  //�Ƿ���ӵ��ж�
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	MysqlCon.close(conn, pst, rs);
        }
        return false;
    }
    
    public boolean updateDepart(Depart depart) throws Exception{  //�޸�
        String sql = "UPDATE `depinfo` SET `depEr`=?,`depDsc`=? WHERE `depID` = ?;";  //�޸ĵ�SQL��䣬����ID�޸�
        Connection conn = MysqlCon.getConnection();
        conn.setAutoCommit(false);//start transaction
        Savepoint sp=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, depart.geter());
            pst.setString(2, depart.getdsc());
            pst.setString(3, depart.getid()); 
            int count = pst.executeUpdate();
            sp=conn.setSavepoint();//��������ع���
            conn.commit();//�ύ����
            
            pst.close();  //�ر�
            System.out.println("�޸Ĳ�����Ϣ�ɹ���");
            return count>0?true:false;  //�Ƿ��޸ĵ��ж�
        } catch (SQLException e) {
            try{
            	conn.rollback(sp);//�ع������õ�
            	conn.commit();//�ع����ύ
            }catch(SQLException e1){
            	e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
        	MysqlCon.close(conn, pst, rs);
        }
        return false;
    }
    
    /*public boolean Delete_DepartFK(String id)throws Exception{
    	 Connection conn = MysqlCon.getConnection();
    	
    	try{
    		
    	 //Ա������IDΪNULL
    	String nul="NULL";
    	String sql="update empinfo set departID='"+nul+"' where departID='"+id+"';";
    	Statement stmt=null;
    	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
                ResultSet.CONCUR_UPDATABLE);
    	stmt.executeUpdate(sql);
    	System.out.println("empinfo_departID����ɹ���");
    	//ְλ����IDΪNULL
    	sql="update edinfo set d='"+nul+"' where did='"+id+"';";
    	stmt.executeUpdate(sql);
    	System.out.println("edinfo_did����ɹ���");
    	//��Ŀ����IDΪNULL
    	sql="update projinfo set depID='"+nul+"' where depID='"+id+"';";
    	stmt.executeUpdate(sql);
    	System.out.println("projinfo_depID����ɹ���");
    
    	stmt.close();
    	conn.close();
    	
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return true;
    }
    */
    public boolean deleteDepart(String id) throws Exception{  //ɾ��
    	//��ɾ��֮ǰ�������ϵ��Ա����ְλ��ϵ����Ŀ��Ϣ��Ĳ��ű������ΪNULL
    	Connection conn = MysqlCon.getConnection();

    	
    	/*boolean flag=Delete_DepartFK(id);
    	if(!flag){
    		System.out.println("���Լ����ʼ��ʧ��");
    		return false;
    	}*/
        String sql = "delete from depinfo where depID = ?;";  //ɾ����SQL��䣬����IDɾ��
        PreparedStatement pst=null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            int count = pst.executeUpdate();
            pst.close();
            conn.close();
            return count>0?true:false;  //�Ƿ�ɾ�����ж�
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Depart selectDepartById(String id) throws Exception{  //����ID���в�ѯ
        Connection conn = MysqlCon.getConnection();
        String sql  = "select * from depinfo where depID = '"+id+"';";
        Depart depart = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	depart = new Depart();
            	depart.setid(rst.getString("depID"));
            	depart.seter(rst.getString("depEr"));
            	depart.setdsc(rst.getString("depDsc"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depart;  //����
    }
}
