package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcFirstDemo {
	public static void main(String[] args) throws Exception {
		//要连接的数据库URL
		String url="jdbc:mysql://localhost:3306/jdbcStudy";
		//连接的数据库使用的用户名
		String username="root";
		//连接的数据库使用的密码
		String password="root";
		
		//1.加载驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
		//DriverManager.registerDriver(new Driver());
		//不推荐使用这种方式来加载驱动
		/*注意：在实际开发中并不推荐采用registerDriver方法注册驱动。
		 * 原因有二：
	　　1、查看Driver的源代码可以看到，如果采用此种方式，会导致驱动程序注册两次，
				也就是在内存中会有两个Driver对象。
	　　2、程序依赖mysql的api，脱离mysql的jar包，程序将无法编译，
				将来程序切换底层数据库将会非常麻烦。
		 */
		Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
		
		//2.获取与数据库的连接
		Connection con=DriverManager.getConnection(url, username, password);
		
		//3.获取用于向数据库发送sql语句的statement
		Statement st = con.createStatement();
		
		String sql = "select id,name,password,email,birthday from users";
		//4.向数据库发sql，并获取代表结果集的resultset
		ResultSet rs=st.executeQuery(sql);
		
		//5.取出结果集的数据
		while (rs.next()) {
			System.out.println("id="+rs.getObject("id"));
			System.out.println("name="+rs.getObject("name"));
			System.out.println("password="+rs.getObject("password"));
			System.out.println("email="+rs.getObject("email"));
			System.out.println("birthday="+rs.getObject("birthday"));
		}
		//6.关闭连接，释放资源
		rs.close();
		st.close();
		con.close();
	}
}
