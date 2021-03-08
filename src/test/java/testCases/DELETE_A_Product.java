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

import javax.mail.Message;

public class DELETE_A_Product {
	SoftAssert softAssert = new SoftAssert();

	
	@Test
	public void delete_A_Product() {

		
		// https://techfios.com/api-prod/api/product/delete.php
		HashMap payload = new HashMap();
		payload.put("id", "1313");
		
		
		Response response=
		
				given()
	
		            .baseUri("https://techfios.com/api-prod/api/product")
		            .header("Content-Type","application/json; charset=UTF-8")
		            .body(payload)
	           .when()
	                .delete("/delete.php")
	           .then()
	               .extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody:" + responseBody);
		
	
		
		//Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
		//Assert.assertEquals("message", "Product was created.");
		softAssert.assertEquals(message, "Product was deleted.", "Not matching the assertions");
		
		softAssert.assertAll();

}
}
