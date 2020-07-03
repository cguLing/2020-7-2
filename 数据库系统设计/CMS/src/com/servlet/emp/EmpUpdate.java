package com.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpUpdate")
public class EmpUpdate extends HttpServlet{
	 private static final long serialVersionUID = 1L;

	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException { 
	        int empID = Integer.parseInt(req.getParameter("empID"));
	        String departID = req.getParameter("departID");
	        String name = req.getParameter("name");
	        String sex = req.getParameter("sex");
	        String cardID = req.getParameter("cardID");
	        String phone = req.getParameter("phone");
	        String email = req.getParameter("email");
	        String Faddress = req.getParameter("Faddress");
	        String salary = req.getParameter("salary");
	        
	        Emp emp = new Emp();
	        emp.setId(empID);
	        emp.setDepid(departID);
	        emp.setName(name);
	        emp.setSex(sex);
	        emp.setCardid(cardID);
	        emp.setPhone(phone);
	        emp.setEmail(email);
	        emp.setFaddress(Faddress);
	        emp.setSalary(salary);
	        
	        EmpDao empdao = new EmpDao();
	        try {
				empdao.updateEmp(emp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        req.setAttribute("info", "操作成功！");
	        req.getRequestDispatcher("cms/employee/ModifyEmp.jsp").forward(req, resp);
	    }

}
