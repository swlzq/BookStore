package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.Book;

/**
 * Servlet implementation class ManagerDelBookServlet
 */
@WebServlet("/Manager_page/ManagerDelBookServlet")
public class ManagerDelBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDelBookServlet() {
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
		response.setContentType("text/html;charset=UTF-8");  
		request.setCharacterEncoding("utf-8");
	    String[] selectdelete = request.getParameterValues("choosebook");
	    if(selectdelete.length==0)
	    {
	    	response.sendRedirect("Manager_DelBook.jsp");
	    }
	    else
	    {
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	System.out.println(selectdelete[i]);
	    	Book a=new Book();
	    	a.del_book(selectdelete[i]);
	    }
	    response.sendRedirect("Manager_DelBook.jsp");
	    }
	}


}
