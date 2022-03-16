package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Book;
import connectDB.Shopping_cart;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/Home_page/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Book a=new Book();
		Shopping_cart b=new Shopping_cart();
		String thisbookname=(String)session.getAttribute("bookname");
		String username=(String)session.getAttribute("login_name");
		if(request.getParameter("cur_number")=="")
		{
			session.setAttribute("bookname1",thisbookname);
			out.print("<script language='javascript'>alert('数量不能为空！');window.location.href='BookAdvice_detail.jsp'</script>");
		}
		else
		{
		if(username==null)
		{
			session.setAttribute("bookname1",thisbookname);
			out.print("<script language='javascript'>alert('请登录！');window.location.href='BookAdvice_detail.jsp'</script>");
		}
		else
		{
		int number=Integer.parseInt(request.getParameter("cur_number"));
		System.out.println(number);
		a.specify_book(thisbookname);
		if(b.insert_goods(thisbookname, a.get_curprice(), number, username))
		{
		session.setAttribute("bookname1",thisbookname);
		out.print("<script language='javascript'>alert('添加成功！');window.location.href='BookAdvice_detail.jsp'</script>");
		}
		else
		{
			session.setAttribute("bookname1",thisbookname);
			out.print("<script language='javascript'>alert('添加失败，请重新添加！');window.location.href='BookAdvice_detail.jsp'</script>");
		}
		}
		}
	}

}
