package com.servlet.el;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ELAdd")
public class ELAdd extends HttpServlet{ 
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String isAdmin = req.getParameter("isAdmin");
        String PW=req.getParameter("password");
        
        System.out.println("isAdmin:"+isAdmin);
        System.out.println("PW:"+PW);
        
        EL el = new EL();
        el.setisAdmin(new String(isAdmin.getBytes("ISO-8859-1"),"UTF-8"));
        el.setpw(new String(PW.getBytes("ISO-8859-1"),"utf-8"));
        ELDao dao = new ELDao();
        try {
			dao.addEL(el);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/emplimits/AddEL.jsp").forward(req, resp);
    }    
}