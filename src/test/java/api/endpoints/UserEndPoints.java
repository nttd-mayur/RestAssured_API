package api.endpoints;

//import com.github.scribejava.core.model.Response;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
//import io.restassured.response.Response;

/*
	 * All test cases relates USer model will be part of this class file.
	 * This is not a Test case. This class is used for Endpoitn creation.
	 * These methods will take some payload.
 */
public class UserEndPoints {
	
	// Create User Endpoint
	public static Response createUser(UserPojo Payload) {
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
		.when()
		.post(Routes.post_Usr_url);
		return response;
	}
	
	// Get User Endpoint
		public static Response readUser(String userName) {
			Response response = given()
				.pathParam("username", userName)
			.when()
			.get(Routes.get_Usr_url);
			return response;
		}
	
	// Update user
		public static Response updateUser(String userName, UserPojo Payload) {
			Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userName", userName)
				.body(Payload)
			.when()
			.put(Routes.update_Usr_url);
			return response;
		}	
		
	// Delete user
		public static Response deleteUser(String userName) {
			Response response = given()
				.pathParam("username", userName)
			.when()
			.delete(Routes.delete_Usr_url);
			return response;
		}
		
}// public class UserEndPoints {
