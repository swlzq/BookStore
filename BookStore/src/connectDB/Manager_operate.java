package connectDB;
import java.sql.*;
import java.util.ArrayList;

public class Manager_operate {
	private ArrayList<String> name=new ArrayList<String>();
	private ArrayList<String> password=new ArrayList<String>();
	private ArrayList<String> email=new ArrayList<String>();
	private ArrayList<String> sex=new ArrayList<String>();
	private ArrayList<String> address=new ArrayList<String>();
	private ArrayList<String> nickname=new ArrayList<String>();
	private int user_number=0;
	
	public void get_userimformation()
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
			stmt.executeQuery("SET NAMES UTF8");
			String sql = "SELECT * FROM user_message";
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())//数据库中有这个用户
			{
               name.add(rs.getString("name"));
               password.add(rs.getString("password"));
               sex.add(rs.getString("sex"));
               nickname.add(rs.getString("nickname"));
               address.add(rs.getString("address"));
               email.add(rs.getString("email"));
               user_number++;
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
	
	public void del_user(String username)
	{
		try
		{
			ConnectDB a=new ConnectDB();//连接数据库
			Statement stmt =a.con.createStatement();
		
			String sql = "delete  FROM user_message WHERE name='"+username+"'";
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
	
	 public ArrayList<String> getname()
	 {
		 return this.name;
	 }
	 public ArrayList<String> getpassword()
	 {
		 return this.password;
	 }
	 public ArrayList<String> getemail()
	 {
		 return this.email;
	 }
	 public ArrayList<String> getsex()
	 {
		 return this.sex;
	 }
	 public ArrayList<String> getaddress()
	 {
		 return this.address;
	 }
	 public ArrayList<String> getnickname()
	 {
		 return this.nickname;
	 }
	 public int getuser_number()
	 {
		 return this.user_number;
	 }
}
