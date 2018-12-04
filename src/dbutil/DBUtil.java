package dbutil;
import java.sql.*;

public class DBUtil {
	
	
//	create conn method
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_managment_system", "product" , "product");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
//	close conn method
	
	public static void closeConnection(Connection conn) {
		try {
			
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
