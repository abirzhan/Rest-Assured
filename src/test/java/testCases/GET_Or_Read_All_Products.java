package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class GET_Or_Read_All_Products {

	@Test
	public void read_All_Products() {

		
		// https://techfios.com/api-prod/api/product/read.php
		Response response=
		given()
		
	        //.log().uri() to see the uri or status code
		    .baseUri("https://techfios.com/api-prod/api/product/read.php")
		    .header("Content-Type","application/json; charset=UTF-8")
		   
		.when()
	        .get("/read.php")
		     
	     .then()
//	        .log().status()
//	        .statusCode(200)
//	        .header("Content-Type","application/json; charset=UTF-8")
//	        .header("Server", "Apache")
		    .extract().response();
        int statusCode = response.getStatusCode();
     	System.out.println("StatusCode: " + statusCode);
    	Assert.assertEquals(statusCode, 200);

	    String responseBody = response.getBody().asString();
     	System.out.println(responseBody);

	}

}
