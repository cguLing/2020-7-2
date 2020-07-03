package com.servlet.el;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ELDelete")
public class ELDelete extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("empid"));
        if(id != 0 ){
            ELDao dao = new ELDao();
            try {
				boolean flag=dao.deleteEL(id);
				if(flag){
					 req.setAttribute("info", "此人已被FIRE！");
					 System.out.println("员工解雇成功");
					 req.getRequestDispatcher("cms/emplimits/DeleteEL.jsp").forward(req, resp);
				}else{
					 req.setAttribute("error", "员工解雇失败！");
					 System.out.println("员工解雇失败");
					 req.getRequestDispatcher("cms/emplimits/DeleteEL.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
    }
    
    

}