package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Judge_login;

/**
 * Servlet implementation class ManagerLoginServlet
 */
@WebServlet("/Manager_page/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
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
		HttpSession session=request.getSession();
		response.setContentType("text/html;charset=utf-8");//设置响应的MIME类型。  
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		Judge_login a=new Judge_login();
		if(a.Mjudge(name, password))
		{
			
			session.setAttribute("ifmsuccess", "yes");
			response.sendRedirect("Manager_frameset.jsp");
		}
		else
		{
			session.setAttribute("ifmsuccess", "no");
			response.sendRedirect("Manager_login.jsp");
		}
	}

}
