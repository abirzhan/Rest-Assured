package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class POST_Or_Create_A_Product {
	SoftAssert softAssert = new SoftAssert();

	
	@Test
	public void create_A_Product() {

		
		// https://techfios.com/api-prod/api/product/create.php
		HashMap payload = new HashMap();//keyvalue pair
		payload.put("name", "HP Laptop Elite Pro");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199");
	    payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		
		
		Response response=
		
			given()
	
		          .baseUri("https://techfios.com/api-prod/api/product")
		          .header("Content-Type","application/json; charset=UTF-8")
		          .body(payload)
		    .when()
		          .post("/create.php")
		    .then()
		          .extract().response();
   
     	String responseBody = response.getBody().asString();
    	System.out.println("ResponseBody:" + responseBody);
//		

		
		//Parsing responseBody to Json:
      JsonPath js = new JsonPath(responseBody);
	  String message = js.getString("message");
	  Assert.assertEquals(message, "Product was created.");
}
}
