package connectDB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Message {
private ArrayList<String> context=new ArrayList<String>();
private ArrayList<String> time=new ArrayList<String>();
private ArrayList<String> username=new ArrayList<String>();
private int context_number=0;
public boolean show_context()
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM message_board";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())//数据库中有这个用户
		{
	    context.add(rs.getString("context"));
	    time.add(rs.getString("time"));
	    username.add(rs.getString("username"));
	    context_number++;
		}
		
	try 
	{
	 if( stmt.execute(sql))
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
public boolean add_context(String context,String time,String username)
{
	try
	{
	  ConnectDB a=new ConnectDB();//连接数据库
	  Statement stmt =a.con.createStatement();
	  String sql = "insert into message_board (context,time,username) VALUES('"+context+"','"+time+"','"+username+"')";	
	try 
	{
		if(stmt.executeUpdate(sql)>0)
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
public ArrayList<String> Get_context()
{
	return this.context;
}
public ArrayList<String> Get_time()
{
	return this.time;
}
public ArrayList<String> Get_username()
{
	return this.username;
}
public int Get_context_number()
{
	return this.context_number;
}
}
