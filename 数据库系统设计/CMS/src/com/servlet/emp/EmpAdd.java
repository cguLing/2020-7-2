package com.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpAdd")
public class EmpAdd extends HttpServlet{
	 private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        this.doPost(req, resp);
	    }
	    
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	req.setCharacterEncoding("UTF-8");
	    	int empID=Integer.parseInt(req.getParameter("empID"));
	    	String departID=req.getParameter("departID");
	    	String name=req.getParameter("name");
	    	String sex=req.getParameter("sex");
	    	String cardID=req.getParameter("cardID");
	    	String phone=req.getParameter("phone");
	    	String email=req.getParameter("email");
	    	String Faddress=req.getParameter("Faddress");
	    	String salary=req.getParameter("salary");
	    	
	    	System.out.println("empID:"+empID+"|departID:"+departID+"|name:"+name+"|sex:"+sex+"|cardID:"+cardID+"|phone:"+phone+"|email:"+email+"|Faddress:"+Faddress+"|salary:"+salary);
	    	Emp emp=new Emp();
	    	emp.setId(empID);
	    	emp.setDepid(new String(departID.getBytes("ISO-8859-1"),"UTF-8"));
	    	emp.setName(name);
	    	emp.setSex(sex);
	    	emp.setCardid(new String(cardID.getBytes("ISO-8859-1"),"UTF-8"));
	    	emp.setPhone(new String(phone.getBytes("ISO-8859-1"),"UTF-8"));
	    	emp.setEmail(new String(email.getBytes("ISO-8859-1"),"UTF-8"));
	    	emp.setFaddress(Faddress);
	    	emp.setSalary(salary);
	    	EmpDao empdao=new EmpDao();
	    	  try {
	  			empdao.addEmp(emp);
	  		} catch (Exception e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	          req.setAttribute("info", "操作成功！");
	          req.getRequestDispatcher("cms/employee/AddEmp.jsp").forward(req, resp);
	    
	    }
	
}
