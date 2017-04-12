package com.jdbc.test;
/**
 * 演示executeUpdate方法
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcDemo2 {
	public static void main(String[] args) throws Exception {
		//要连接的数据库URL
		String url="jdbc:mysql://localhost:3306/jdbcTest";
		//连接的数据库使用的用户名
		String username="root";
		//连接的数据库使用的密码
		String password="root";
		
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
		
		//2.获取与数据库的连接
		Connection con=DriverManager.getConnection(url, username, password);
		
		//3.获取用于向数据库发送sql语句的statement
		Statement st = con.createStatement();
		
		//4.执行update语句
		int row=st.executeUpdate("update user set password='321");
		System.out.println(row);
		//6.关闭连接，释放资源
		
		st.close();
		con.close();
	}
}
