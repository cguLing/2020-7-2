package Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.DBUtil;
import Insert.InsertT;
import Table.User;

@WebServlet("/InitUserServlet")
public class InitUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession sessionzxl = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = DBUtil.getCon();
        InsertT t = new InsertT();
        User u= new User();
        int flag=0;
        try {
	        flag=t.insertU(connection,username,password);
	        }catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("\nUser表初始插入失败");
            request.getRequestDispatcher("InitUserFail.jsp").forward(request, response);
			e.printStackTrace();
		}
        if(flag!=0){
        	u.setUserName(username);
            sessionzxl.setAttribute("user", u);
        	System.out.println("\nUser表初始插入成功");
            request.getRequestDispatcher("InitUserSuccess.jsp").forward(request, response);
        }
        else{
        	System.out.println("\nUser表初始插入失败");
            request.getRequestDispatcher("InitUserFail.jsp").forward(request, response);
        }
    }
}
