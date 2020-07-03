package com.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/EmpDelete")
public class EmpDelete extends HttpServlet{

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idStr = Integer.parseInt(req.getParameter("empID"));  //删除数据的ID，根据ID删除
        if(idStr != 0){
            EmpDao empdao = new EmpDao();
            try {
				boolean flag=empdao.deleteEmp(idStr);
				if(flag){
					 req.setAttribute("info", "员工信息删除成功！");
					 System.out.println("员工信息删除成功！");
					 req.getRequestDispatcher("cms/employee/DeleteEmp.jsp").forward(req, resp);
				}else{
					 req.setAttribute("error", "员工信息删除失败！");
					 System.out.println("员工信息删除失败！");
					 req.getRequestDispatcher("cms/employee/DeleteEmp.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
    }
}
