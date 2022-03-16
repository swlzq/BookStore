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
 * Servlet implementation class ManagerRecommendServlet
 */
@WebServlet("/Manager_page/ManagerRecommendServlet")
public class ManagerRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRecommendServlet() {
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
		PrintWriter out=response.getWriter();
		String del_recommend=request.getParameter("del_recommend");
		String add_recommend=request.getParameter("add_recommend");
	
		if(del_recommend!=null)
		{
	    String[] selectdelete = request.getParameterValues("chooseR");
	    
	    if(selectdelete==null)
	    {
	    	response.sendRedirect("Manager_RecommendBook.jsp");
	    }
	    else
	    {
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	//System.out.println(selectdelete[i]);
	    	Book a=new Book();
	    	a.update_recommend(selectdelete[i], "no");
	    }
	    response.sendRedirect("Manager_RecommendBook.jsp");
	    }
		}
		if(add_recommend!=null)
		{
			String addthisrecommend=request.getParameter("addthisrecommend");
			System.out.println(addthisrecommend);
			if(addthisrecommend!=null&&addthisrecommend!="")
			{
		  
			Book b=new Book();
		    if(b.update_recommend(addthisrecommend, "yes"))
		    {
			out.print("<script language='javascript'>alert('添加推荐成功！');window.location.href='Manager_RecommendBook.jsp'</script>");
			}
		    else
		    	out.print("<script language='javascript'>alert('请确认书籍名称，添加失败！');window.location.href='Manager_RecommendBook.jsp'</script>");
			}
			else
			{
				out.print("<script language='javascript'>alert('请输入分类！');window.location.href='Manager_RecommendBook.jsp'</script>");
			}
				
		}
	}

}
