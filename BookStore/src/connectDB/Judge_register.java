package connectDB;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import sun.misc.BASE64Encoder;

public class Judge_register {
	 public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	        //确定计算方法
	        MessageDigest md5=MessageDigest.getInstance("MD5");
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
	        return newstr;
	    }
	    public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        if(EncoderByMd5(newpasswd).equals(oldpasswd))
	            return true;
	        else
	            return false;
	    }
	public boolean sameuser(String name)
	{
		try
		{
		  ConnectDB a=new ConnectDB();//连接数据库
		  Statement stmt =a.con.createStatement();
		  String sql =  "SELECT * FROM user_message WHERE name='"+name+"'";
		  ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next())//数据库中有这个用户
			{
			
              return false;
			}
		try 
		{
			stmt.executeQuery(sql);
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
      return true;
	}
	public boolean insert(String name,String password,String email,String question,String answer) throws NoSuchAlgorithmException, UnsupportedEncodingException 
	{
		password=EncoderByMd5(password);
		try
		{
		  ConnectDB a=new ConnectDB();//连接数据库
		  Statement stmt =a.con.createStatement();
		  String sql = "insert into user_message (name,password,email,question,answer) VALUES('"+name+"','"+password+"','"+email+"','"+question+"','"+answer+"')";	
		try 
		{
			if(stmt.executeUpdate(sql)>0);
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

}
