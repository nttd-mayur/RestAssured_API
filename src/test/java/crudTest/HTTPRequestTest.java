package crudTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class HTTPRequestTest {

	String id;
	
	@Test(priority=1)
	public void createSingle()
	{
		System.out.println("In FIRST METHOD: Create User");
		
		HashMap data = new HashMap();
			data.put("firstname", "Yuji");
			data.put("LastName", "Itadori");
			data.put("age", 29);
			data.put("address", "Kyoto, Japan");
			data.put("PhoneNumber", "080-123-345");
		
		id=given()  // Currently not used for Get API
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/persons")
			.jsonPath().getString("id");
	/*	.then()
			.statusCode(201)
			.log().all();
		*/	
	}
	
	@Test(priority=2)
	public void getSingle()
	{
		System.out.println("In FIRST METHOD");
		
		given()  // Currently not used for Get API
		
		.when()
			.get("http://localhost:3000/persons/"+id)
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	@Test(priority=3)
	public void deleteSingle()
	{
		System.out.println("In Delete METHOD");
		
		when()
			.delete("http://localhost:3000/persons/"+id)
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	
	@Test(priority=6)
	public void getAll()
	{
		System.out.println("In Get All API");
		
		given()  // Currently not used for Get API
		
		.when()
			.get("http://localhost:3000/persons")
		.then()
			.statusCode(200)
			.log().all();
			
	}
}
