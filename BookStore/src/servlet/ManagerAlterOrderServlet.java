package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Order;

/**
 * Servlet implementation class ManagerAlterOrderServlet
 */
@WebServlet("/Manager_page/ManagerAlterOrderServlet")
public class ManagerAlterOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAlterOrderServlet() {
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int id=Integer.parseInt((String)session.getAttribute("thisid"));
		String alterstate=request.getParameter("alterstate");
		//System.out.println(id+alterstate);
		Order a=new Order();
		if(a.alter_orderstate(id, alterstate))
		{
			out.print("<script language='javascript'>alert('修改成功！');window.location.href='Manager_Order.jsp'</script>");
		}
		else
		{
			out.print("<script language='javascript'>alert('修改失败，请重新修改！');window.location.href='Manager_AlterOrder.jsp'</script>");
		}
	}

}
