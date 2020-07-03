package com.servlet.ed;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EDAdd")
public class EDAdd extends HttpServlet{ 
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int empID = Integer.parseInt(req.getParameter("empID"));
        String depID = req.getParameter("depID");
        String post=req.getParameter("post");
        
        System.out.println("empID:"+empID);
        System.out.println("depID:"+depID);
        System.out.println("post:"+post);

        ED ed = new ED();
        ed.setempID(empID); 
        ed.setdepID(new String(depID.getBytes("ISO-8859-1"),"UTF-8"));
        ed.setpost(new String(post.getBytes("ISO-8859-1"),"utf-8"));
        EDDao dao = new EDDao();
        try {
			dao.addED(ed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/empdepart/AddED.jsp").forward(req, resp);
    }    
}