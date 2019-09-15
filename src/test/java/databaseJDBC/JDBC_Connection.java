package databaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {
	
public static String url = "jdbc:postgresql://localhost:5432/dvdrental";
public 	static String user = "postgres";
public static String pwd = "12345";
public static Connection conn; 
public static Statement st ;
	
	public static void main(String[] args) throws SQLException {
		

		conn = DriverManager.getConnection(url, user, pwd);
		st = conn.createStatement();
		
		ResultSet resultSet1 = st.executeQuery("select * from actor");
		while(resultSet1.next()) {
			System.out.println(resultSet1.getInt("actor_id") + " : " + resultSet1.getString("first_name")
			+ " " + resultSet1.getString("last_name"));
		}
		
		ResultSet resultSet2 = st.executeQuery("select * from actor where first_name = 'Nick'");
		while(resultSet2.next()) {
			System.out.println(resultSet2.getInt("actor_id"));
		}
		
		ResultSet resultSet3 = st.executeQuery("select customer_id,first_name,last_name,email,address,"
				+ "address2 from customer inner join address on customer.address_id = address.address_id;");
		while(resultSet3.next()) {
			System.out.println(resultSet3.getString("first_name")+"  :  "+resultSet3.getString("address"));
		}
	}

}
