package com.servlet.ed;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EDDelete")
public class EDDelete extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idStr = Integer.parseInt(req.getParameter("empID"));  
        if(idStr != 0){
            EDDao dao = new EDDao();
            try {
				boolean flag=dao.deleteED(idStr);
				if(flag){
					 req.setAttribute("info", "部门职员关系解除成功！");
					 System.out.println("部门职员关系解除成功");
					 req.getRequestDispatcher("cms/empdepart/DeleteED.jsp").forward(req, resp);
				}else{
					 req.setAttribute("error", "部门职员关系解除失败！");
					 System.out.println("部门职员关系解除失败");
					 req.getRequestDispatcher("cms/empdepart/DeleteED.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
    }
    
    

}