package com.servlet.cust;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustUpdate")
public class CustUpdate extends HttpServlet{  //�޸�

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  //��ѯ��ѡ��ID��ֵ����Ӧ������
        int idStr = Integer.parseInt(req.getParameter("custid"));
        if(idStr != 0){
            int id = idStr;
            CustDao dao = new CustDao();
            Cust cust = null;
			try {
				cust = dao.selectCustById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            req.setAttribute("cust", cust);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  //���ݴ�ID�����ݵ�ֵ�����޸�
       
    	int custID = Integer.parseInt(req.getParameter("custid"));
        String custName = req.getParameter("custname");
        String custSex=req.getParameter("custsex");
        String custTel = req.getParameter("custtel");
        String custEmail = req.getParameter("custemail");
        String custSfz=req.getParameter("custsfz");
        
        Cust cust = new Cust();
        cust.setid(custID);  
        cust.setname(new String(custName.getBytes("ISO-8859-1"),"UTF-8"));
        cust.setsex(new String(custSex.getBytes("ISO-8859-1"),"utf-8"));
        cust.settel(new String(custTel.getBytes("ISO-8859-1"),"UTF-8"));  
        cust.setemail(new String(custEmail.getBytes("ISO-8859-1"),"UTF-8"));
        cust.setsfz(new String(custSfz.getBytes("ISO-8859-1"),"utf-8"));
        CustDao dao = new CustDao();
        try {
			dao.updateCust(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        req.setAttribute("info", "操作成功！");
        req.getRequestDispatcher("cms/customer/ModifyCust.jsp").forward(req, resp);
    }
    
    

}
