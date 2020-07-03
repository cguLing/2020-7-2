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
import Util.TaUtil;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
        Connection connection = DBUtil.getCon();
        TaUtil t = new TaUtil();
        try {
	        t.create_T(connection,"users(username varchar(10) not null primary key,"
			 		+ "password varchar(8) not null)");
	        t.create_T(connection, "person(username varchar(10) not null,name varchar(20) not null primary key,"
			 		+ "age varchar(4),telenum char(11),foreign key(username) references users(username))");
        }catch (Exception e) {
			// TODO Auto-generated catch block
        	System.out.println("\n数据表创建失败");
            request.getRequestDispatcher("CreateFail.jsp").forward(request, response);
			e.printStackTrace();
		}
        System.out.println("\n数据表创建成功");
        request.getRequestDispatcher("CreateSuccess.jsp").forward(request, response);
    }
}
