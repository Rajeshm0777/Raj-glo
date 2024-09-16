package Day1POC;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*
given()
content type,set cookies, add auth, add parm, set headrs info etc,

when()
Get,post,put,patch,delete

then()
validate status codes,exctract responce,extract header cookies& responce body
*/

public class HTTPRequest {
//	@Test
//	Run/ Debug

	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
		
		
		
	}
	
}

