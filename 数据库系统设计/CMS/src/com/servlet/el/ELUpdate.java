package com.servlet.el;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ELUpdate")
public class ELUpdate extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
        int idStr = Integer.parseInt(req.getParameter("empID"));
        if(idStr != 0 ){
            int id = idStr;
            ELDao dao = new ELDao();
            EL el = null;
			try {
				el = dao.selectELById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.setAttribute("el", el);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
        int empID = Integer.parseInt(req.getParameter("empid"));
        String isAdmin = req.getParameter("isAdmin");
        String PW=req.getParameter("password");
        EL el = new EL();
        el.setid(empID);
        el.setisAdmin(new String(isAdmin.getBytes("ISO-8859-1"),"UTF-8"));
        el.setpw(new String(PW.getBytes("ISO-8859-1"),"UTF-8"));
        ELDao dao = new ELDao();
        try {
			dao.updateEL(el);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/emplimits/ModifyEL.jsp").forward(req, resp);
    }
}