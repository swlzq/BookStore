package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectDB.Message;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/Message_board/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		HttpSession session=request.getSession();
		  java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
          java.util.Date currentTime = new java.util.Date(); 
          String time = simpleDateFormat.format(currentTime).toString();  
          String leavename=(String)session.getAttribute("login_name");
          if(leavename==null)
          {
       	   Random rand=new Random();
       	   int i=rand.nextInt(10000)+89999;
       	   leavename="сн©м"+i;
          }
		String aaa=request.getParameter("leave_message");
		Message a=new Message();
		
		if(a.add_context(aaa,time,leavename))
		{
			response.sendRedirect("Leave_message.jsp");
		}
	}

}
