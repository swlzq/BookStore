package connectDB;

import java.sql.*;

public class ConnectDB {
	public Connection con;
	
    public ConnectDB() {
        //����Connection����
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���
        String url = "jdbc:mysql://localhost:3306/user_list?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "548327619mySQL";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con=DriverManager.getConnection(url,user,password);
           // if(!con.isClosed())
               //System.out.print("���ӳɹ�");
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    } 
 
}