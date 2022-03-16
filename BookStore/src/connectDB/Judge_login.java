package connectDB;
import java.sql.*;

public class Judge_login {
    private String current_user;
    private String cur_question;
   
	public boolean judge(String name,String password)
	{
		try
		{
			Judge_register reg=new Judge_register();
			password=reg.EncoderByMd5(password);
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_message WHERE name='"+name+"'and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next())//数据库中有这个用户
			{
             return true;
			}	
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public boolean Mjudge(String name,String password)
	{
		try
		{
			Judge_register reg=new Judge_register();
			password=reg.EncoderByMd5(password);
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM manage WHERE name='"+name+"'and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next())//数据库中有这个用户
			{
             return true;
			}
			
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public boolean FindPassword(String name,String email)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_message WHERE name='"+name+"'and email='"+email+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next())
			{
             return true;
			}
			
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public boolean Question_Answer(String question,String answer)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_message WHERE question='"+question+"'and answer='"+answer+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next())
			{
             return true;
			}
			
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public boolean Get_question(String findname)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT question FROM user_message WHERE name='"+findname+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())
			{
             cur_question=rs.getString("question");
			}
			
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public boolean Update_password(String updatename,String updatepassword)
	{
		try
		{
		  ConnectDB a=new ConnectDB();//连接数据库
		  Statement stmt =a.con.createStatement();
		  String sql = "update user_message set password='"+updatepassword+"' where name='"+updatename+"'";	
		try 
		{
			stmt.executeUpdate(sql);
			return true;
		}catch(Exception e) 
		{
		  e.printStackTrace();
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		}
		return false;
	}
	public void get_name(String name)
	{
		this.current_user=name;
	}
	
	public String Get_user()
	{
		return this.current_user;
	}
	public String Get_cur_question()
	{
		return this.cur_question;
	}
}
