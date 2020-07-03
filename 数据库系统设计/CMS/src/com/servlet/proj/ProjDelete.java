package com.servlet.proj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjDelete")
public class ProjDelete extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("projid");  
        if(idStr != null && !idStr.equals("")){
            ProjDao dao = new ProjDao();
            try {
				boolean flag=dao.deleteProj(idStr);
				if(flag){
					 req.setAttribute("info", "项目信息删除成功！");
					 System.out.println("项目信息删除成功");
					 req.getRequestDispatcher("cms/project/DeleteProj.jsp").forward(req, resp);
				}else{
					 req.setAttribute("error", "项目信息删除失败！");
					 System.out.println("项目信息删除失败");
					 req.getRequestDispatcher("cms/project/DeleteProj.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
    }
}