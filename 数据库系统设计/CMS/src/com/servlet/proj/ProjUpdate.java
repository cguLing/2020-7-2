package com.servlet.proj;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjUpdate")
public class ProjUpdate extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  
        String idStr = req.getParameter("projid");
        if(idStr != null && !idStr.equals("")){
            String id = idStr;
            ProjDao dao = new ProjDao();
            Proj proj = null;
			try {
				proj = dao.selectProjById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.setAttribute("proj", proj);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException { 
        String projID = req.getParameter("projid");
        String depID = req.getParameter("depid");
        int projEr = Integer.parseInt(req.getParameter("projer"));
        int custID = Integer.parseInt(req.getParameter("custid"));
        String projName=req.getParameter("projname");
        String projText = req.getParameter("projtext");
        String projStart=req.getParameter("projstart");
        String projSta = req.getParameter("projsta");
        String projEnd=req.getParameter("projend");
        Proj proj = new Proj();
        
        proj.setid(projID);  
        proj.setdid(new String(depID.getBytes("ISO-8859-1"),"UTF-8"));
        proj.seter(projEr);
        proj.setcid(custID);
        proj.setname(new String(projName.getBytes("ISO-8859-1"),"UTF-8"));
        proj.settext(new String(projText.getBytes("ISO-8859-1"),"UTF-8"));
        proj.setstart(new String(projStart.getBytes("ISO-8859-1"),"UTF-8"));
        proj.setsta(new String(projSta.getBytes("ISO-8859-1"),"UTF-8"));
        proj.setend(new String(projEnd.getBytes("ISO-8859-1"),"UTF-8"));
        ProjDao dao = new ProjDao();
        try {
			dao.updateProj(proj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/project/ModifyProj.jsp").forward(req, resp);
    }
    
    

}