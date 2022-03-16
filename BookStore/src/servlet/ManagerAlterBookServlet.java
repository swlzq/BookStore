package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.Book;

/**
 * Servlet implementation class ManagerAlterBookServlet
 */
@WebServlet("/Manager_page/ManagerAlterBookServlet")
public class ManagerAlterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAlterBookServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String altername=request.getParameter("alterthisname");
		String alterprice=request.getParameter("alterthisprice");
		String alterURL=request.getParameter("alterthisURL");
		String alterabstract=request.getParameter("alterthisabstract");
		String alterkinds=request.getParameter("alterthiskinds");
		Book a=new Book();
		a.update_book(altername, alterprice, alterURL, alterabstract, alterkinds);
		PrintWriter out=response.getWriter();
		out.print("<script language='javascript'>alert('ÐÞ¸Ä³É¹¦£¡');window.location.href='Manager_DelBook.jsp'</script>");
	}

}
