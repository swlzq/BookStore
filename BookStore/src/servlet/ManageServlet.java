package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Manager_operate;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/Manager_page/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
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
		HttpSession session=request.getSession();
	    String[] selectdelete = request.getParameterValues("user");
	    if(selectdelete.length==0)
	    {
	    	session.setAttribute("ifcheck", "no");
	    	response.sendRedirect("Manager_user.jsp");
	    }
	    else
	    {
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	//System.out.println(selectdelete[i]);
	    	Manager_operate a=new Manager_operate();
	    	a.del_user(selectdelete[i]);
	    }
	    response.sendRedirect("Manager_user.jsp");
	    }
	}

}
