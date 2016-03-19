package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8",
					"root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn) throws Exception{
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
