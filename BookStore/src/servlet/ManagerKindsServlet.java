package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.Book_kinds;

/**
 * Servlet implementation class ManagerKindsServlet
 */
@WebServlet("/Manager_page/ManagerKindsServlet")
public class ManagerKindsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerKindsServlet() {
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
		String del_kinds=request.getParameter("del_kinds");
		String add_kinds=request.getParameter("add_kinds");
		//System.out.println(del_kinds);
		//System.out.println(add_kinds);
		if(del_kinds!=null)
		{
	    String[] selectdelete = request.getParameterValues("choosekinds");
	    if(selectdelete==null)
	    {
	    	response.sendRedirect("Manager_kinds.jsp");
	    }
	    else
	    {
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	//System.out.println(selectdelete[i]);
	    	Book_kinds a=new Book_kinds();
	    	a.del_kinds(selectdelete[i]);
	    }
	    response.sendRedirect("Manager_kinds.jsp");
	    }
		}
		if(add_kinds!=null)
		{
			String addthiskinds=request.getParameter("addthiskinds");
			if(addthiskinds!=null&&addthiskinds!="")
			{
		  
			Book_kinds b=new Book_kinds();
			b.add_kinds(addthiskinds);
			response.sendRedirect("Manager_kinds.jsp");
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>alert('添加分类成功！');window.location.href='Manager_kinds.jsp'</script>");
			}
			else
			{
				PrintWriter out=response.getWriter();
				out.print("<script language='javascript'>alert('请输入分类！');window.location.href='Manager_kinds.jsp'</script>");
			}
				
		}
	}

}
