package com.servlet.depart;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepartUpdate")
public class DepartUpdate extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("depID");
        if(idStr != null && !idStr.equals("")){
            String id = idStr;
            DepartDao dao = new DepartDao();
            Depart depart = null;
			try {
				depart = dao.selectDepartById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.setAttribute("depart", depart);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
        String depEr = req.getParameter("deper");
        String depDsc = req.getParameter("depdsc");
        String depID = req.getParameter("depid");
        Depart depart = new Depart();
        depart.setid(depID);
        depart.seter(new String(depEr.getBytes("ISO-8859-1"),"UTF-8"));
        depart.setdsc(new String(depDsc.getBytes("ISO-8859-1"),"UTF-8"));
        DepartDao dao = new DepartDao();
        try {
			dao.updateDepart(depart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/department/ModifyDepart.jsp").forward(req, resp);
    }
    
    

}