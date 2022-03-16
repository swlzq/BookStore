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
 * Servlet implementation class AlterPasswordServlet
 */
@WebServlet("/Login/AlterPasswordServlet")
public class AlterPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterPasswordServlet() {
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
		HttpSession session =request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String altername=(String)session.getAttribute("altername");
		String updatepassword=request.getParameter("newpassword");
		Judge_login a=new Judge_login();
		if(a.Update_password(altername, updatepassword))
		{
			 response.getWriter().write("修改成功！3秒后回到主页");  
		        //设置3秒钟跳转  
		    response.setHeader("refresh", "3;url=../Home_page/Home_iframe.jsp");
		}
	}

}
