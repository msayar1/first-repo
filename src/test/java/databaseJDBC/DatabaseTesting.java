package databaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import org.junit.*;

public class DatabaseTesting {
	static String url = "jdbc:postgresql://localhost:5432/dvdrental";
	static String user = "postgres";
	static String pwd = "12345";
	static Connection conn; 
	static Statement st ;

	@Before
	public void setUp() throws SQLException {

		conn = DriverManager.getConnection(url, user, pwd);
		st = conn.createStatement();
		
	}
	
@Test
	public void testFilm() throws SQLException {
		ResultSet resultSet = st.executeQuery("select count(*) from film where rating = 'PG-13'");
		int numberOfPG13 =0;
		while(resultSet.next()) {
			numberOfPG13 = resultSet.getInt("count");
	System.out.println(numberOfPG13);
		}
		
		Assert.assertEquals(224, numberOfPG13);
	
	}

@Test
public void testBabamVeOglum() throws SQLException {
	ResultSet resultSet = st.executeQuery("select * from film");
	boolean babamVeOglum = false;
	while(resultSet.next()) {
		if(resultSet.getString("title").equals("Babam ve Oglum")) {
			babamVeOglum = true;
		}
//		Assert.assertTrue(babamVeOglum);
	}
}

@Test
public void insert () throws SQLException {
	st.executeUpdate("INSERT INTO actor (first_name, last_name) VALUES ('Roberto', 'Carlos');");
	
	
	st.executeUpdate("DELETE FROM actor WHERE first_name='Roberto';");
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
