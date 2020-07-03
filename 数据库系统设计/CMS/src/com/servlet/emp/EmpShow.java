package com.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpShow")
public class EmpShow extends HttpServlet{
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	 EmpDao emp = new EmpDao();
         List<Emp> list = null;
 		try {
 			list = emp.getAllEmp();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
// 		System.out.println("list:"+list);
         req.setAttribute("list", list);
         req.getRequestDispatcher("cms/employee/ScanEmp.jsp").forward(req, resp);
    	
    }

}
