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
		String name=request.getParameter("username"); //�ӱ����
		String password=request.getParameter("password"); //�ӱ����
		String email1=request.getParameter("email");
		String email2=request.getParameter("email2");
		String email=email1+email2;
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		PrintWriter out=response.getWriter();
		Judge_register a=new Judge_register();

		if(!a.sameuser(name))
		{
			
			out.print("<script language='javascript'>alert('���û��Ѵ��ڣ�');window.location.href='Register.jsp'</script>");
		}
		else
		{
		     try {
				if(a.insert(name, password, email,question,answer))//���뵽���ݿ���
				 {  response.getWriter().write("ע��ɹ���3���ӻص���ҳ");  
				//����3������ת  
				   response.setHeader("refresh", "3;url=../Home_page/Home_iframe.jsp");
				 }
				 else
					 out.print("<script language='javascript'>alert('ע��ʧ�ܣ�������ע�ᣡ');window.location.href='Register.jsp'</script>");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
