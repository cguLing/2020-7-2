package com.servlet.ed;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EDUpdate")
public class EDUpdate extends HttpServlet{  

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
        int idStr = Integer.parseInt(req.getParameter("empID"));
        if(idStr != 0){
            int id = idStr;
            EDDao dao = new EDDao();
            ED ed = null;
			try {
				ed = dao.selectEDById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.setAttribute("ed", ed);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  
        int empID = Integer.parseInt(req.getParameter("empID"));
        String depID = req.getParameter("depID");
        String post = req.getParameter("post");
        ED ed = new ED();
        ed.setempID(empID);
        ed.setdepID(new String(depID.getBytes("ISO-8859-1"),"UTF-8"));
        ed.setpost(new String(post.getBytes("ISO-8859-1"),"UTF-8"));
        EDDao dao = new EDDao();
        try {
			dao.updateED(ed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/empdepart/ModifyED.jsp").forward(req, resp);
    }
}