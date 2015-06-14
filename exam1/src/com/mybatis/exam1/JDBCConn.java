package com.mybatis.exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class JDBCConn{
	@Test
	public void testJDBCConn()
	{
		String url = "jdbc:mysql://localhost:3306/mybatis?characterEncoding=UTF8";
		String user = "root";
		String pword = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pword);	
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");			
			while(rs.next())
			{
				System.out.println("username:" + rs.getString(2) + "," + "password:" + rs.getString(3) + ",phone:" + rs.getString(4));
			}						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}			
}
