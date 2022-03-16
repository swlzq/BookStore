package connectDB;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class Book {
private ArrayList<String> bookname=new ArrayList<String>();
private ArrayList<Double> bookprice=new ArrayList<Double>();
private ArrayList<String> bookURL=new ArrayList<String>();
private ArrayList<String> bookabstract =new ArrayList<String>();
private ArrayList<String> bookkinds =new ArrayList<String>();
private String cur_bookauthor="";
private double cur_bookprice=0;
private String cur_bookabstract="";
private String cur_bookURL="";
private String cur_bookkinds="";

private int booknumber=0;
public void show_book()//获取所有书的信息
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM book";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())//数据库中有这个用户
		{
	     bookname.add(rs.getString("name"));
	     bookprice.add(rs.getDouble("price"));
	     bookURL.add(rs.getString("imageURL"));
	     bookabstract.add(rs.getString("abstract"));
	     bookkinds.add(rs.getString("kinds"));
	     booknumber++;
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
public void specify_book_bykeyword(String thiskeyword)//关键字查询
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM book where name like '%"+thiskeyword+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())//数据库中有这个用户
		{
			 bookname.add(rs.getString("name"));
		     bookprice.add(rs.getDouble("price"));
		     bookURL.add(rs.getString("imageURL"));
		     bookabstract.add(rs.getString("abstract"));
		     bookkinds.add(rs.getString("kinds"));
		     booknumber++;
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
public void specify_book_bykinds(String thisbookkinds)//根据分类获取书的信息
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM book where kinds='"+thisbookkinds+"'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())//数据库中有这个用户
		{
			 bookname.add(rs.getString("name"));
		     bookprice.add(rs.getDouble("price"));
		     bookURL.add(rs.getString("imageURL"));
		     bookabstract.add(rs.getString("abstract"));
		     bookkinds.add(rs.getString("kinds"));
		     booknumber++;
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
public void specify_book_byrecommend()//查找推荐的书的信息
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM book where recommend='yes'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())//数据库中有这个用户
		{
			 bookname.add(rs.getString("name"));
		     bookprice.add(rs.getDouble("price"));
		     bookURL.add(rs.getString("imageURL"));
		     bookabstract.add(rs.getString("abstract"));
		     bookkinds.add(rs.getString("kinds"));
		     booknumber++;
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
public void specify_book(String thisbookname)//根据书名获得书的信息
{
	try
	{
		
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
		stmt.executeQuery("SET NAMES UTF8");
		String sql = "SELECT * FROM book where name='"+thisbookname+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next())//数据库中有这个用户
		{
	    cur_bookprice=rs.getDouble("price");
	    cur_bookabstract=rs.getString("abstract");
	    cur_bookURL=rs.getString("imageURL");
	    cur_bookkinds=rs.getString("kinds");
	    cur_bookauthor=rs.getString("author");
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
public void add_book(String addname,String addauthor,String addprice,String addURL,String addabstract,String addkinds)
{
	try
	{
	  ConnectDB a=new ConnectDB();//连接数据库
	  Statement stmt =a.con.createStatement();
	  String sql = "insert into book (name,price,imageURL,abstract,kinds,author) VALUES('"+addname+"','"+addprice+"','"+addURL+"','"+addabstract+"','"+addkinds+"','"+addauthor+"')";	
	try 
	{
		stmt.executeUpdate(sql);
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

public void update_book(String addname,String addprice,String addURL,String addabstract,String addkinds)
{
	try
	{
	  ConnectDB a=new ConnectDB();//连接数据库
	  Statement stmt =a.con.createStatement();
	  String sql = "update book set name='"+addname+"',price='"+addprice+"',imageURL='"+addURL+"',abstract='"+addabstract+"',kinds='"+addkinds+"' where name='"+addname+"'";	
	try 
	{
		stmt.executeUpdate(sql);
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
public boolean update_recommend(String recommendname,String ifRecommend)
{
	try
	{
	  ConnectDB a=new ConnectDB();//连接数据库
	  Statement stmt =a.con.createStatement();
	  String sql = "update book set recommend='"+ifRecommend+"' where name='"+recommendname+"'";
	try 
	{
		int hh=stmt.executeUpdate(sql);
		if(hh>0)
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
public void del_book(String bookname)
{
	try
	{
		ConnectDB a=new ConnectDB();//连接数据库
		Statement stmt =a.con.createStatement();
	
		String sql = "delete  FROM book WHERE name='"+bookname+"'";
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
public ArrayList<String> get_bookname()
{
	return this.bookname;
}
public ArrayList<Double> get_bookprice()
{
	return this.bookprice;
}
public ArrayList<String> get_bookURL()
{
	return this.bookURL;
}
public ArrayList<String> get_bookabstract()
{
	return this.bookabstract;
}
public ArrayList<String> get_bookkinds()
{
	return this.bookkinds;
}
public int get_booknumber()
{
	return this.booknumber;
}
public double get_curprice()
{
	return this.cur_bookprice;
}
public String get_curabstract()
{
	return this.cur_bookabstract;
}
public String get_curURL()
{
	return this.cur_bookURL;
}
public String get_curkinds()
{
	return this.cur_bookkinds;
}
public String get_curauthor()
{
	return this.cur_bookauthor;
}
}
