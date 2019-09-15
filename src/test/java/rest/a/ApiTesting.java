package rest.a;

import static io.restassured.RestAssured.given;

import com.google.gson.JsonObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTesting {

	@Given("I want to go to base URI")
	public void i_want_to_go_to_base_URI() {
		RestAssured.baseURI = "http://localhost:3000/";

	}

	@Given("create an actor")
	public void create_an_actor() {
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("first_name", "Sait");
		requestBody.addProperty("last_name", "Sayar");
		given().when().contentType("application/json").body(requestBody.toString()).and().post("/actor")
		.then().statusCode(201);   
	}

	@Then("get the actor and delete the same actor")
	public void get_the_actor_and_delete_the_same_actor() {
	
		Response response = given().when().get("/actor?first_name=eq.Sait");
		int id = response.body().jsonPath().get("[0].actor_id");

		given().when().contentType("application/json").and().delete("/actor?actor_id=eq." 
		+ id).then().statusCode(204);  
	}

	@Then("retrieve all actors and print them")
	public void retrieve_all_actors_and_print_them() {
		given().when().get("/actor").then().log().body();

	}

}
