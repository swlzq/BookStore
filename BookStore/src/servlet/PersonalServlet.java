package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Alter_imformation;

/**
 * Servlet implementation class PersonalServlet
 */
@WebServlet("/Personal_center/PersonalServlet")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalServlet() {
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
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8"); 
		PrintWriter out=response.getWriter();
		String nickname=request.getParameter("nickname"); //从表单获得
		String sex=request.getParameter("sex"); //从表单获得
		HttpSession session=request.getSession();
		String login_name=(String)session.getAttribute("login_name");
		Alter_imformation a=new Alter_imformation();
		if(a.alter_imformation(nickname, sex,login_name))
		out.print("<script language='javascript'>alert('修改成功！');window.location.href='alter_imformation.jsp'</script>");
		else
			out.print("<script language='javascript'>alert('修改失败，请重新修改！');window.location.href='alter_imformation.jsp'</script>");
	}
	
}
