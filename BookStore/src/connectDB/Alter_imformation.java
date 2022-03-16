package connectDB;
import java.sql.*;
import java.util.ArrayList;
public class Alter_imformation {
	
	private String nickname="";
	private String sex="";
	private ArrayList<String> address=new ArrayList<String>();

	public boolean alter_imformation(String nickname,String sex,String login_name)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "update  user_message set nickname='"+nickname+"', sex='"+sex+"' where name='"+login_name+"'" ;
		try 
		{
		  stmt.execute(sql);
		}catch(Exception e) 
		{
		  e.printStackTrace();
		  return false;
		}
		  stmt.close();
		  a.con.close();
		}catch (Exception e) 
		{
		  e.printStackTrace();
		  return false;
		}
		return true;
	}
	
	public void alter_address(String address,String login_name)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String addresss=address+"#";
			String tempsql="select address from user_message where name='"+login_name+"'";//先检查有没有地址
			ResultSet rs = stmt.executeQuery(tempsql); 
			String sql="";
			String tempnext="";
			if(rs.next())
				tempnext=rs.getString("address");
			if(tempnext!=null)
			{
				//System.out.println("@"+login_name);
				sql = "update  user_message set address=CONCAT(address,'"+addresss+"') where name='"+login_name+"'" ;
				
			}
			else
			{
				//System.out.println("@@@"+login_name);
				sql="update user_message set address='"+addresss+"' where name='"+login_name+"'" ;
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
	public void getuser(String username)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_message where name='"+username+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			String alladdress=null;
			String []splitaddress;
			while(rs.next())
			{
				if(rs.getString("nickname")!=null)
				    this.nickname=rs.getString("nickname");
				if(rs.getString("sex")!=null)
				    this.sex=rs.getString("sex");
				if(rs.getString("address")!=null)
				     alladdress=rs.getString("address");
			}
			if(alladdress!=null)//分割,获取全部地址
			{
				splitaddress=alladdress.split("#");
				for(int i=0;i<splitaddress.length;i++)
				{
				this.address.add(splitaddress[i]);
				//System.out.print(address.get(i)); 
				}
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
	public void del_address(String address)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			String temp=address+"#";
			String sql = "update user_message set address =replace(address,'"+temp+"','')";
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
	public String getnickname()
	{
		return this.nickname;
	}
	public String getsex()
	{
		return this.sex;
	}
	public ArrayList<String> getaddress()
	{
		return this.address;
	}
}
