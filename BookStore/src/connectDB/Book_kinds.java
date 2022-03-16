package connectDB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Book_kinds {
	private ArrayList<String> all_bookkinds=new ArrayList<String>();
	private int kinds_number=0;
	public void show_bookkinds()
	{
		try
		{
			
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM book_kinds";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())//数据库中有这个用户
			{
			all_bookkinds.add(rs.getString("kindsname"));
		     kinds_number++;
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
	}
	public void del_kinds(String delthiskinds)
	{
		try
		{
			
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "delete from book_kinds where kindsname='"+delthiskinds+"'";
			
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
	}
	public void add_kinds(String addthiskinds)
	{
		try
		{
			
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "insert into book_kinds (kindsname) values('"+addthiskinds+"')";
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
	}
    public ArrayList<String> get_allbookkinds()
    {
    	return this.all_bookkinds;
    }
    public int get_kindsnumber()
    {
    	return this.kinds_number;
    }
}
