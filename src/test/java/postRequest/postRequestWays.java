package postRequest;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class postRequestWays {
	
	String id;
	
	// 1. Post request using Hashmap 
	/*@Test(priority=1)
	void testPostHashMap() {
		HashMap data = new HashMap();
			data.put("firstname", "Yuji");
			data.put("LastName", "Itadori");
			data.put("age", 29);
			data.put("address", "Kyoto, Japan");
			data.put("PhoneNumber", "080-123-345");
	
		given()  // Currently not used for Get API
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/persons")
			//.jsonPath().getString("id");
			
		.then()
			.statusCode(201)
			.body("firstname",equalTo("Yuji"))
			.body("LastName", equalTo("Itadori"))
			.body("age",equalTo(29))
			.body("address",equalTo("Kyoto, Japan"))
			.body("PhoneNumber",equalTo("080-123-345"))
			.header("content-Type", "application/json") //; charset=utf-8")
			.log().all();
	}
	*/
	// 2. Post request body using org.json library
	@Test(priority=1)
	void testPostJsonLib() {
		
		JSONObject data = new JSONObject();
			data.put("firstname", "Tosaki");
			data.put("LastName", "Itadori");
			data.put("age", 29);
			data.put("address", "Kyoto, Japan");
			data.put("PhoneNumber", "080-123-345");
			
		given()  // Currently not used for Get API
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/persons")
			//.jsonPath().getString("id")
			
		.then()
			.statusCode(201)
			.body("firstname",equalTo("Tosaki"))
			.body("LastName", equalTo("Itadori"))
			.body("age",equalTo(29))
			.body("address",equalTo("Kyoto, Japan"))
			.body("PhoneNumber",equalTo("080-123-345"))
			.header("content-Type", "application/json") //; charset=utf-8")
			//.jsonPath().getString("id")
			.log().all();
	}
	
	@Test(priority=10)
	void deleteRec() {
		given()
		
		.when()
			.delete("http://localhost:3000/persons/4")
		.then()
			.statusCode(200);
	}
}
