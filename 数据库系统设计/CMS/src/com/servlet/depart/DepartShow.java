package com.servlet.depart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DepartShow")
public class DepartShow  extends HttpServlet{ 
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DepartDao dao = new DepartDao();
        List<Depart> list = null;
		try {
			list = dao.getAllDepart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("list:"+list);
        req.setAttribute("list", list);
        req.getRequestDispatcher("cms/department/ScanDepart.jsp").forward(req, resp);
    }    
}