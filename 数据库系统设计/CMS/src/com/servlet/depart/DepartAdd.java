package com.servlet.depart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepartAdd")
public class DepartAdd extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String depID = req.getParameter("depid");
        String depEr = req.getParameter("deper");
        String depDsc=req.getParameter("depdsc");
        
        System.out.println("depID:"+depID);
        System.out.println("depEr:"+depEr);
        System.out.println("depDsc:"+depDsc);
        
        Depart depart = new Depart();
        depart.setid(new String(depID.getBytes("ISO-8859-1"),"UTF-8")); 
        depart.seter(new String(depEr.getBytes("ISO-8859-1"),"UTF-8"));
        depart.setdsc(new String(depDsc.getBytes("ISO-8859-1"),"utf-8"));
        DepartDao dao = new DepartDao();
        try {
			dao.addDepart(depart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/department/AddDepart.jsp").forward(req, resp);
    }    
}