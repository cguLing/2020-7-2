package com.servlet.cust;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustDelete")
public class CustDelete extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idStr = Integer.parseInt(req.getParameter("custid"));  
        if(idStr != 0){
            CustDao dao = new CustDao();
            try {
				boolean flag=dao.deleteCust(idStr);
				if(flag){
					 req.setAttribute("info", "成功解除合作关系！");
					 System.out.println("客户删除成功");
					 req.getRequestDispatcher("cms/customer/DeleteCust.jsp").forward(req, resp);
				}else{
					 req.setAttribute("error", "解除合作关系失败！");
					 System.out.println("客户删除失败");
					 req.getRequestDispatcher("cms/customer/DeleteCust.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
       
    }
    
    

}