package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Shopping_cart;

/**
 * Servlet implementation class ShoppingcartServlet
 */
@WebServlet("/Shopping_cart/ShoppingcartServlet")
public class ShoppingcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingcartServlet() {
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
		PrintWriter out=response.getWriter();
	    String[] selectdelete = request.getParameterValues("shopping");
	    String del_goods=request.getParameter("del_goods");
	    String buy_goods=request.getParameter("buy_goods");
	   // System.out.println("del"+del_goods+"buy"+buy_goods);
	    if(del_goods!=null)
	    {
	    if(selectdelete==null)
	    { 
	    	out.print("<script language='javascript'>alert('请选择商品！');window.location.href='Shopping_cart.jsp'</script>");
	    }
	    else
	    {
	    	boolean del=false;
	    for(int i=0;i<selectdelete.length;i++)
	    {
	    	//System.out.println(selectdelete[i]);
	    	String username=(String)session.getAttribute("login_name");
	    	Shopping_cart a=new Shopping_cart();
	    	if(a.del_goods(username,selectdelete[i]))
	    	{
	    		del=true;
	    	}
	    	else
	    	{
	    		del=false;
	    		break;
	    	}
	    
	    	
	    }
		if(del==true)
	    out.print("<script language='javascript'>alert('删除成功！');window.location.href='Shopping_cart.jsp'</script>");
	    }
	    }
	    if(buy_goods!=null)
	    {
	    	Shopping_cart a=new Shopping_cart();
	    	 if(selectdelete==null)
	 	    { 
	    		 out.print("<script language='javascript'>alert('请选择商品！');window.location.href='Shopping_cart.jsp'</script>");
	 	    }
	 	    else
	 	    {
	 	    for(int i=0;i<selectdelete.length;i++)
	 	    {
	 	    	//System.out.println(selectdelete[i]);
	 	    	String username=(String)session.getAttribute("login_name");
	 	    	a.get_goodsmessage(username);
	 	    	a.get_buyinggoods(selectdelete[i]);
	 	    } 
	 	    String []tempgoods=new String[selectdelete.length];
	 	    for(int j=0;j<selectdelete.length;j++)
	 	    {
	 	    	tempgoods[j]=a.getbuyinggoods().get(j)+"--"+a.getbuyingprice().get(j)+"--"+a.getbuyingnumber().get(j)
	 	    			+"--"+a.getbuyingtotalprice().get(j);
	 	    }
	 	    session.setAttribute("buy_number", selectdelete.length);
	 	    for(int k=0;k<selectdelete.length;k++)
	 	    {
	 	    	session.setAttribute("tempgood"+k, tempgoods[k]);
	 	    }
	 	    response.sendRedirect("Shopping_pay.jsp");
	 	    }
	    }
	}
}
