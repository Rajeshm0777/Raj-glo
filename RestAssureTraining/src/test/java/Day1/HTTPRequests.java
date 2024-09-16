package Day1;
import org.testng.Assert;
import  org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
//	@Test
  void getUser()
	{
	 
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			  .statusCode(200)
			  .body("page",equalTo(2))
			  .log().all();
 }
  
  //@Test 
  void createUser() {
	  
	  HashMap data=new HashMap();
	  data.put("name","Rajesh");
	  data.put("Job","SDET");
	  
	  given()
	  		.contentType("application/json")
	  		.body(data)
	  		
	  .when()		
	  		.post("https://reqres.in/api/users")
	  		
	  .then()
	  		.statusCode(201)
	  		.log().all();
	  
  }
  @Test
  
  void loginUser() {
	  HashMap data=new HashMap();
	  data.put("email","eve.holt@reqres.in");
	  data.put("password","cityslicka");
	  
	  given()
	        .contentType("application/json")
	  		.body(data)
	  		
	  .when()		
	  		.post("https://reqres.in/api/login")
	  .then().
	  assertThat().
	   statusCode(200).
	   body("token", notNullValue())
	  .log().all();
	         
	  
	  
  }
  
  

}
