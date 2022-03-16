package connectDB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Order {
	private ArrayList<Integer> orderid=new ArrayList<Integer>();
	private ArrayList<String>orderusername=new ArrayList<String>();
	private ArrayList<String>orderaddress=new ArrayList<String>();
	private ArrayList<String>ordertime=new ArrayList<String>();
	private ArrayList<String>ordergoods=new ArrayList<String>();
	private ArrayList<Double>orderprice=new ArrayList<Double>();
	private ArrayList<Integer>ordernumber=new ArrayList<Integer>();
	private ArrayList<String>orderstate=new ArrayList<String>();
	private int order_number=0;
	public void add_Order(String username,String address,String time,String goods,double price,int number,String state)
	{
		try
		{
		  ConnectDB a=new ConnectDB();//连接数据库
		  Statement stmt =a.con.createStatement();
		  String sql = "insert into user_order (username,address,time,goods,price,number,state) VALUES('"+username+"','"+address+"','"+time+"','"+goods+"','"+price+"','"+number+"','"+state+"')";	
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
	public void show_order()//获取所有订单的信息
	{
		try
		{
			
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_order";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())//数据库中有这个用户
			{
				orderid.add(rs.getInt("id"));
		     orderusername.add(rs.getString("username"));
		     orderaddress.add(rs.getString("address"));
		     ordertime.add(rs.getString("time"));
		     ordergoods.add(rs.getString("goods"));
		     orderprice.add(rs.getDouble("price"));
		     ordernumber.add(rs.getInt("number"));
		     orderstate.add(rs.getString("state"));
		     order_number++;
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
	public void specify_order(String username)//获取所有指定用户订单的信息
	{
		try
		{
			
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_order where username='"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())//数据库中有这个用户
			{
				orderid.add(rs.getInt("id"));
		     orderaddress.add(rs.getString("address"));
		     ordertime.add(rs.getString("time"));
		     ordergoods.add(rs.getString("goods"));
		     orderprice.add(rs.getDouble("price"));
		     ordernumber.add(rs.getInt("number"));
		     orderstate.add(rs.getString("state"));
		     order_number++;
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
	public void del_order(int orderid)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
		
			String sql = "delete  FROM user_order WHERE id='"+orderid+"'";
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
	public boolean alter_orderstate(int orderid,String alterstate)//修改订单状态
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
		
			String sql = "update  user_order set state ='"+alterstate+"'WHERE id='"+orderid+"'";
		try 
		{
		  stmt.execute(sql);
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
	public ArrayList<Integer> get_orderid()
	{
		return this.orderid;
	}
	public ArrayList<String> get_orderusername()
	{
		return this.orderusername;
	}
	public ArrayList<String> get_orderaddress()
	{
		return this.orderaddress;
	}
	public ArrayList<String> get_ordertime()
	{
		return this.ordertime;
	}
	public ArrayList<String> get_ordergoods()
	{
		return this.ordergoods;
	}
	public ArrayList<Double> get_orderprice()
	{
		return this.orderprice;
	}
	public ArrayList<Integer> get_ordernumber()
	{
		return this.ordernumber;
	}
	public ArrayList<String> get_orderstate()
	{
		return this.orderstate;
	}
	public int get_order_number()
	{
		return this.order_number;
	}
}
