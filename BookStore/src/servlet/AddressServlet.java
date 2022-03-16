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
 * Servlet implementation class AddressServlet
 */
@WebServlet("/Personal_center/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String add_address=request.getParameter("add_address");
		String del_address=request.getParameter("del_address");
		if(add_address!=null)
		{
		String address=request.getParameter("address");
		if(address!="")
		{
		HttpSession session=request.getSession();
		String login_name=(String)session.getAttribute("login_name");
		Alter_imformation a=new Alter_imformation();
		a.alter_address(address,login_name);
		out.print("<script language='javascript'>alert('添加成功！');window.location.href='alter_address.jsp'</script>");
	    }
		else
		{
		out.print("<script language='javascript'>alert('请输入地址！');window.location.href='alter_address.jsp'</script>");
		}
		}
		if(del_address!=null)
		{
			 String[] selectdelete = request.getParameterValues("choose_address");
			    if(selectdelete.length==0)
			    {
			    	out.print("<script language='javascript'>alert('请选择地址！');window.location.href='alter_address.jsp'</script>");
			    	response.sendRedirect("alter_address.jsp");
			    }
			    else
			    {
			    for(int i=0;i<selectdelete.length;i++)
			    {
			    	System.out.println(selectdelete[i]);
			    	Alter_imformation a=new Alter_imformation();
			    	a.del_address(selectdelete[i]);
			    }
			    out.print("<script language='javascript'>alert('删除成功！');window.location.href='alter_address.jsp'</script>");
			    response.sendRedirect("alter_address.jsp");
			    }
		}
	}

}
