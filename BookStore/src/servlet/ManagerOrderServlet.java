package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.Order;

/**
 * Servlet implementation class ManagerOrderServlet
 */
@WebServlet("/Manager_page/ManagerOrderServlet")
public class ManagerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerOrderServlet() {
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
	    String[] selectdelete = request.getParameterValues("chooseOrder");
	    if(selectdelete==null)
	    {
	    	response.sendRedirect("Manager_Order.jsp");
	    }
	    else
	    {
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	System.out.println(selectdelete[i]);
	    	Order a=new Order();
	    	int sel=Integer.parseInt(selectdelete[i]);
	    	a.del_order(sel);
	    }
	    response.sendRedirect("Manager_Order.jsp");
	    }
	}

}
