package connectDB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Shopping_cart {
	private ArrayList<String> goods=new ArrayList<String>();
	private ArrayList<Double> price=new ArrayList<Double>();
	private ArrayList<Integer> number=new ArrayList<Integer>();
	private ArrayList<Double> totalprice=new ArrayList<Double>();
	private ArrayList<String> buyinggoods=new ArrayList<String>();
	private ArrayList<Double> buyingprice=new ArrayList<Double>();
	private ArrayList<Integer> buyingnumber=new ArrayList<Integer>();
	private ArrayList<Double> buyingtotalprice=new ArrayList<Double>();
	
	private int kinds_number=0;
	private int buyingkinds_number=0;
	public void get_goodsmessage(String username)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_shoppingcart where username='"+username+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())//数据库中有这个用户
			{
               goods.add(rs.getString("goods"));
               price.add(rs.getDouble("price"));
               number.add(rs.getInt("number"));
               double pri=calculate_totalprice(rs.getDouble("price"),rs.getInt("number"));
               totalprice.add(pri);
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
	public void get_buyinggoods(String goods)
	{
		
		int index=getgoods().indexOf(goods);
		//System.out.println(index);
		buyinggoods.add(goods);
		buyingprice.add(getprice().get(index));
		buyingnumber.add(getnumber().get(index));
		buyingtotalprice.add(gettotalprice().get(index));
		buyingkinds_number++;
	}
	public boolean insert_goods(String goods,double price,int number,String username)
	{
		try
		{
		  ConnectDB a=new ConnectDB();//连接数据库
		  Statement stmt =a.con.createStatement();
		  String sql = "insert into user_shoppingcart (goods,price,number,username) VALUES('"+goods+"','"+price+"','"+number+"','"+username+"')";	
		try 
		{
			if(stmt.executeUpdate(sql)>0)
			{
				System.out.println("加了");
				System.out.println(stmt.executeUpdate(sql));
			return true;
			}
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
	public boolean del_goods(String username,String goods)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
		
			String sql = "delete  FROM user_shoppingcart WHERE goods='"+goods+"' and username='"+username+"'";
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
	public double calculate_totalprice(double a,double b)
	{
		return a*b;
	}
	public ArrayList<Double> gettotalprice()
	{
		return this.totalprice;
	}
	 public ArrayList<String> getgoods()
	 {
		 return this.goods;
	 }
	 public ArrayList<Double> getprice()
	 {
		 return this.price;
	 }
	 public ArrayList<Integer> getnumber()
	 {
		 return this.number;
	 }
	 public int getkinds_number()
	 {
		 return this.kinds_number;
	 }
	 public ArrayList<Double> getbuyingtotalprice()
		{
			return this.buyingtotalprice;
		}
		 public ArrayList<String> getbuyinggoods()
		 {
			 return this.buyinggoods;
		 }
		 public ArrayList<Double> getbuyingprice()
		 {
			 return this.buyingprice;
		 }
		 public ArrayList<Integer> getbuyingnumber()
		 {
			 return this.buyingnumber;
		 }
		 public int getbuyingkinds_number()
		 {
			 return this.buyingkinds_number;
		 }
}
