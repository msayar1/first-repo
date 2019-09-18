package databaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DbTestingWFeatureFile {

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
	
	
	@Given("I want to get the number of films which are PG{int}")
	public void i_want_to_get_the_number_of_films_which_are_PG(Integer int1) throws SQLException {
		ResultSet resultSet = st.executeQuery("select count(*) from film where rating = 'PG-13'");
		int numberOfPG13 =0;
		while(resultSet.next()) {
			numberOfPG13 = resultSet.getInt("count");
	System.out.println(numberOfPG13);
		}
		
		Assert.assertEquals(224, numberOfPG13);
	}

	@Given("Retrieve the film called {string}")
	public void retrieve_the_film_called(String string) throws SQLException {
		ResultSet resultSet = st.executeQuery("select * from film");
		boolean babamVeOglum = false;
		while(resultSet.next()) {
			if(resultSet.getString("title").equals("Babam ve Oglum")) {
				babamVeOglum = true;
			}
//			Assert.assertTrue(babamVeOglum);
		}
	}

	@Then("I want to create and delete actor whose name is Roberto")
	public void i_want_to_create_and_delete_actor_whose_name_is_Roberto() throws SQLException {
		st.executeUpdate("INSERT INTO actor (first_name, last_name) VALUES ('Roberto', 'Carlos');");
		
		
		st.executeUpdate("DELETE FROM actor WHERE first_name='Roberto';");
	}

}
