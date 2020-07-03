package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao;
import Table.User;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String telenum = request.getParameter("telenum");
        Dao D=new Dao();
        User u= new User();
        int flag = 0;
		try {
			flag = D.login(username, name,age,telenum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(flag==1){
        	u.setUserName(username);
            sessionzxl.setAttribute("user", u);
            request.getRequestDispatcher("UpdataSuccess.jsp").forward(request, response);
        }
        else if(flag==2){
        	u.setUserName(username);
            sessionzxl.setAttribute("user", u);
        	request.getRequestDispatcher("InsertSuccess.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("UpInFail.jsp").forward(request, response);
        }
    }
}
