package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPojo;
import api.utilities.DataProviders;
//import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;

public class UserModelTest {
	
	Faker faker;
	UserPojo userPayload;
	
	public Logger logger;
	
	//Generate Test data and store in user object
	@BeforeClass
	public void setup()  //setupData()
	{
		faker =new Faker();
		userPayload=new UserPojo();
	//Randomly Generate & pass ID number to payload
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//for logging purpose (log4j)
		logger=LogManager.getLogger(this.getClass());
		
		
	}//public void setupData()
	
	@Test(priority=1)
	public void testCreateUser() {
		logger.info("******** Creating User ***********");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User Created ***********");
	}// public void createUSer() {
	
	
	@Test(priority=1)
	public void testGetUserName() {
		logger.info("******** Reading User Info ***********");
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User Info is displayed ***********");
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		logger.info("******** Deleting User ***********");
			Response response=UserEndPoints.deleteUser(userName);
			Assert.assertEquals(response.getStatusCode(),200);	
		logger.info("******** User Deleted ***********");
	}
}
