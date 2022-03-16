package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.Judge_register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name=request.getParameter("username"); //从表单获得
		String password=request.getParameter("password"); //从表单获得
		String email1=request.getParameter("email");
		String email2=request.getParameter("email2");
		String email=email1+email2;
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		PrintWriter out=response.getWriter();
		Judge_register a=new Judge_register();

		if(!a.sameuser(name))
		{
			
			out.print("<script language='javascript'>alert('该用户已存在！');window.location.href='Register.jsp'</script>");
		}
		else
		{
		     try {
				if(a.insert(name, password, email,question,answer))//插入到数据库中
				 {  response.getWriter().write("注册成功！3秒钟回到主页");  
				//设置3秒钟跳转  
				   response.setHeader("refresh", "3;url=../Home_page/Home_iframe.jsp");
				 }
				 else
					 out.print("<script language='javascript'>alert('注册失败，请重新注册！');window.location.href='Register.jsp'</script>");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
