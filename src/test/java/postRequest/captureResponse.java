package postRequest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
//import static io.restassured.response;
import com.github.scribejava.core.model.Response;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


/*
 * Format
 * 	=> Prerequisite: given()
 *  => Request Type: when()
 *  => Response validation: then()
 *  
 */

public class captureResponse {

	String id, idName, myURL;
	
//	@Test(priority=1)
	public void getSingle()
	{
		io.restassured.response.Response res= given()  // Currently not used for Get API
				.contentType(ContentType.JSON)
				
				.when()
					.get("http://localhost:3000/persons/1");
				Assert.assertEquals(res.getStatusCode(),200);
				Assert.assertEquals(res.header("Content-Type"),"application/json");
				idName = res.jsonPath().get("id").toString();
				System.out.println(" ID => "+idName);
				
	} 

//	@Test(priority=2)
	public void testCookies() {
		myURL = "http://localhost:3000/persons/" + idName;
		given()
		.when()
			.get(myURL);
/*		.then()
		.cookie("AEC","AVYB7croF2by1tigspu-UDMsg2ULtKJp7DuiHiRmzMtNj3dtRG6QDh7Qyg");
			//.log().all();
	*/	
	}
	
//	@Test(priority=3)
	public void testMultiCookies() {
		io.restassured.response.Response res1= given()
		.when()
			.get("http://www.google.co.in");
		// get value of single cookie
		String myCookie = res1.getCookie("AEC");
		System.out.println(".............. cookie is : "+myCookie);
		
		// capture all cookie information.
		Map<String,String> val1=res1.getCookies();
		for(String k:val1.keySet())
		{
			String cookieVal=res1.getCookie(k);
			System.out.println(k+"       "+cookieVal);
		}
		
	}	// public void testMultiCookies()
	
	
	
	
/*	
	@Test(priority=4)
	public void testJsonObj() {
		//io.restassured.response.Response res= 
				given()
			//	.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/persons")
		.then()
			.statusCode(200)
			.body("[0].firtName", equalTo("Mayur"));
		
		// capture all cookie information.
	/*	JSONObject jo = new JSONObject(res); // Converting response to json Object type
		String fName1 = jo.get("firstName").toString();
		System.out.println("First Name: "+fName1);
		//JSONObject jo = new JSONObject("http://localhost:3000/persons"); 
		//for(int i=0;i<jo.getJSONObject(DEFAULT_PATH).length();i++)
		for(int i=0;i<jo.getJSONArray("").length();i++)
		{
			//String fName = jo.getJSO jo.getJSONObject(i).get("firstName").toString();
			String fName = jo.getJSONArray("").getJSONObject(i).toString();
			System.out.println("       "+fName);
		}
		*
		
	}	// public void testJsonObj()
	*/
}
