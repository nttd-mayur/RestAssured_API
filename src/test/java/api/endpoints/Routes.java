package api.endpoints;
/*
 *This class will contain only URLs
  Swagger URI: https: https://petstore.swagger.io/
	
	Base URL: https://petstore.swagger.io/v2
	Endpoints:
		Create user: /user
		Get User (Get): /user/<userName>
		Update User(put):/user/<userName> 
		Delete user (Delete): /user/<userName>
 */

public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Model
	/*
	  	Create User(Post): https://petstore.swagger.io/v2/user
		Get User (Get): https://petstore.swagger.io/v2/user/<userName>
		Update User(put):https://petstore.swagger.io/v2/user/<userName> 
		Delete user (Delete): https://petstore.swagger.io/v2/user/<userName>
	 */
		public static String post_Usr_url=base_url+"/user";
		public static String get_Usr_url=base_url+"/user/{username}";
		public static String update_Usr_url=base_url+"/user/{username}";
		public static String delete_Usr_url=base_url+"/user/{username}";
	
	//Pet Model
	/*	Create Pet(Post): https://petstore.swagger.io/v2/pet
		Get Pet (Get): https://petstore.swagger.io/v2/user/<userName>
		Update Pet(put):https://petstore.swagger.io/v2/user/<userName> 
		Delete Pet (Delete): https://petstore.swagger.io/v2/user/<userName>
		Create Pet image(Post): https://petstore.swagger.io/v2/pet/1/uploadImage
	
		
		public static String post_pet_url=base_url+"/pet";
		public static String 
	/*
	//Store Model
		public static String post_store_url=base_url+"/store";
	*/
		
}// public class Routes {
