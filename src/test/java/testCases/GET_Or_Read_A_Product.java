package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GET_Or_Read_A_Product {
	SoftAssert softAssert = new SoftAssert();
   //soft assert only in testng not junit 
	@Test
	public void read_A_Product () {
          
		
		//https://techfios.com/api-prod/api/product/read_one.php?id=65

		Response response=
		given()
	
		    .baseUri("https://techfios.com/api-prod/api/product")
		    .header("Content-Type","application/json; charset=UTF-8") 
		   .queryParam("id", 1313)
		    
		 .when()
		    .get("/read_one.php")
		 .then()
		     .extract().response();
	   //response.getBody().prettyPrint();
		String responseBody = response.getBody().asString();
		System.out.println("response body "+ responseBody);
	    String responseHeader = response.header("Content-Type");
	    //System.out.println(responseHeader);
		//softAssert.assertEquals(responseHeader, "application/json");
//		softAssert.assertEquals(responseHeader,"application/json", "Header missmatch");
		//Parsing responseBody to Json:
//		JsonPath js = new JsonPath(responseBody);
//		
//		String productId = js.getString("id");
//		String productname = js.getString("name");
//		String productdescription = js.getString("description");
//     
//		softAssert.assertEquals(productId, QueryIdValue);	
//		softAssert.assertEquals(productname, "HP Laptop Elite Pro","ProductName Missmatch");	
//		softAssert.assertEquals(productdescription, "Super fast laptop", "productdescription Missmatch!!!");	

      //  softAssert.assertAll();
//		System.out.println(productId);
//		System.out.println(js);
//		js.prettyPrint();

}
}

