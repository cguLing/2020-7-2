package com.servlet.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.depart.Depart;
import com.servlet.log.MysqlCon;

public class EmpDao {

	 public List<Emp> getAllEmp() throws Exception{  //查询所有信息
	        List<Emp> list = new ArrayList<Emp>();  //创建集合
	        Connection conn = MysqlCon.getConnection();
	        String sql  = "select * from empinfo;";  //SQL查询语句
	        System.out.println("sql:"+sql);
	        try {
	            PreparedStatement pst = conn.prepareStatement(sql);
	            ResultSet rst = pst.executeQuery();
	            int empid;
	            String departid,name,sex,cardid,phone,email,faddress,salary;
	            
	            while (rst.next()) {
	            	Emp emp = new Emp();
	            	empid=rst.getInt("empID");
	            	departid=rst.getString("departID");
	            	name=rst.getString("name");
	            	sex=rst.getString("sex");
	            	cardid=rst.getString("cardID");
	            	phone=rst.getString("phone");
	            	email=rst.getString("email");
	            	faddress=rst.getString("Faddress");
	            	salary=rst.getString("salary");
	            	if(empid!=0 && departid!=null & name!=null)
	            	{
	        	    	emp.setId(empid);
	        	    	emp.setDepid(new String(departid.getBytes("ISO-8859-1"),"UTF-8"));
	        	    	emp.setName(name);
	        	    	emp.setSex(sex);
	        	    	emp.setCardid(new String(cardid.getBytes("ISO-8859-1"),"UTF-8"));
	        	    	emp.setPhone(new String(phone.getBytes("ISO-8859-1"),"UTF-8"));
	        	    	emp.setEmail(new String(email.getBytes("ISO-8859-1"),"UTF-8"));
	        	    	emp.setFaddress(faddress);
	        	    	emp.setSalary(salary);
	                    list.add(emp);
	            	}
	            	
	            }
	            System.out.println("查询员工所有集合成功！");
	            rst.close();  //关闭
	            pst.close();  //关闭
	        } catch (SQLException e) {
	            e.printStackTrace();  //抛出异常
	        }
	        return list;  //返回一个集合
	    }
	 
	 /*public boolean Add_EmpFK(int empID,String depID)throws Exception{
	    	//增加员工默认给职位表新建部门与员工的对应关系
		 Statement stmt=null;	
		 Connection conn = MysqlCon.getConnection();
		 stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
	                ResultSet.CONCUR_UPDATABLE);
		 String sql="";
		 String nul="NULL";
		 sql="insert into edinfo (empID,depID,post) values ('"+empID+"','"+depID+"','"+nul+"')";
		 stmt.executeUpdate(sql);
	    	return true;
	    }*/

	 public boolean addEmp(Emp emp) throws Exception{  //添加信息
	        String sql = "INSERT INTO `empinfo`(empID,departID,name,sex,cardID,phone,email,Faddress,salary) VALUES (?,?,?,?,?,?,?,?,?)";  //添加的SQL语句
	        Connection conn = MysqlCon.getConnection();
	        System.out.println("sql:"+sql);
	        int empID=emp.getId();
	        String depID=emp.getDepid();
	        /*boolean flag=Add_EmpFK(empID,depID);
	        if(!flag){
	        	System.out.println("外键配置修改失败！");
	        	return false;
	        }*/
	        try {
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setInt(1, emp.getId());
	            pst.setString(2, emp.getDepid());
	            pst.setString(3, emp.getName());
	            pst.setString(4, emp.getSex());
	            pst.setString(5, emp.getCardid());
	            pst.setString(6, emp.getPhone());
	            pst.setString(7, emp.getEmail());
	            pst.setString(8, emp.getFaddress());
	            pst.setString(9, emp.getSalary());
	            int count = pst.executeUpdate();
	            pst.close();
	            System.out.println("员工信息添加成功！");
	            return count>0?true:false;  //是否添加的判断
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	/* public boolean Update_EmpFK(String depid,int iD)throws Exception{
	    	//传入修改的部门编号参数，把对应职位关系表部门ID修改
		 	Connection conn = MysqlCon.getConnection();
		 	 conn.setAutoCommit(false);//start transaction
		        Savepoint sp=null;
		        ResultSet rs=null;
		        Statement stmt=null;	
		        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
		                ResultSet.CONCUR_UPDATABLE);
		 	
		 	String nul="NULL";
	    	String sql="update edinfo set depID='"+depid+"' where empID='"+iD+"';";
	    	System.out.println("SQL:"+sql);
	    	try{
	    		stmt.executeUpdate(sql);
		    	sp=conn.setSavepoint();//设置事务回滚点
	            conn.commit();	
	            return true;
	    	} catch (SQLException e) {
	        	 try{
	              	conn.rollback(sp);//回滚到设置点
	              	conn.commit();//回滚后提交
	              }catch(SQLException e1){
	              	e1.printStackTrace();
	              }
	             e.printStackTrace();
	    	}
	    	return false;
	    	
	    }*/
	 
	 public boolean updateEmp(Emp emp) throws Exception{  //修改
	        String sql = "UPDATE `empinfo` SET `empID`=?,`departID`=?,name=?,sex=?,cardID=?,phone=?,email=?,Faddress=?,salary=? WHERE `empID` = ?;";  //修改的SQL语句，根据ID修改
	        Connection conn = MysqlCon.getConnection();
	        conn.setAutoCommit(false);//start transaction
	        Savepoint sp=null;
	        
		 	PreparedStatement pst=null;
	        System.out.println("sql:"+sql);
	        int ID=emp.getId();
	        String Depid=emp.getDepid();
	       /* boolean flag=Update_EmpFK(Depid,ID);
	        if(!flag){
	        	System.out.println("外键设置修改失败！");
	        	return false;
	        }*/
	        
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setInt(1, emp.getId());
	            pst.setString(2, emp.getDepid());
	            pst.setString(3, emp.getName()); 
	            pst.setString(4, emp.getSex()); 
	            pst.setString(5, emp.getCardid()); 
	            pst.setString(6, emp.getPhone()); 
	            pst.setString(7, emp.getEmail()); 
	            pst.setString(8, emp.getFaddress()); 
	            pst.setString(9, emp.getSalary()); 
	            pst.setInt(10, emp.getId());
	            int count = pst.executeUpdate();
	            
	            sp=conn.setSavepoint();//设置事务回滚点
	            conn.commit();
	            
	            pst.close();  //关闭
	            conn.close();
	            System.out.println("修改部门信息成功！");
	            return count>0?true:false;  //是否修改的判断
	        } catch (SQLException e) {
	        	 try{
	              	conn.rollback(sp);//回滚到设置点
	              	conn.commit();//回滚后提交
	              }catch(SQLException e1){
	              	e1.printStackTrace();
	              }
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 /*public boolean Delete_EmpFK(String name,int iD)throws Exception{
		 Connection conn = MysqlCon.getConnection();
		 String nul="NULL";	
		 	//是项目负责人->NULL
		 	Statement stmt=null;
	    	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
	                ResultSet.CONCUR_UPDATABLE);
	    	String sql="update projinfo set projEr='"+nul+"' where projEr='"+name+"';";
	    	System.out.println("SQL:"+sql);
	    	stmt.executeUpdate(sql);
	    	System.out.println("projinfo_projEr清除成功！");
	    	//是部门主管->NULL
		 sql="update depinfo set depEr='"+nul+"'  where depEr='"+name+"';";
		 System.out.println("SQL:"+sql);
		 stmt.executeUpdate(sql);
		 System.out.println("depinfo_depEr清除成功！");
	    	//职位表删除对应员工ID的数据
		 sql="delete from edinfo where empID='"+iD+"';";
		 System.out.println("SQL:"+sql);
		 stmt.executeUpdate(sql);
		 System.out.println("edinfo_empID清除成功！");
	    	return true;
	    	
	    }*/
	 
	 public boolean deleteEmp(int id) throws Exception{  //删除
		 	String sql1="select * from empinfo where empID="+id;
	        String sql = "delete from empinfo where empID = ?;";  //删除的SQL语句，根据ID删除
	        Connection conn = MysqlCon.getConnection();
	        Statement stmt=null;
	        ResultSet rs = null;
	    	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,   
	                ResultSet.CONCUR_UPDATABLE);
	    	rs = stmt.executeQuery(sql1);
	    	String empName="";
	    	int ID=0;
	    	while(rs.next()){
	    		empName=rs.getString("name");	
	    		ID=rs.getInt("empID");
	    	}
	    	/*boolean flag=Delete_EmpFK(empName,ID);
	    	if(!flag){
	    		System.out.println("外键设置修改失败！");
	    		return false;
	    	}
	    	*/
	    	
	        try {
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setInt(1, id);
	            int count = pst.executeUpdate();
	            pst.close();
	            return count>0?true:false;  //是否删除的判断
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 
	 
	
}
