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

public class Put_Or_Update_A_Product {
	SoftAssert softAssert = new SoftAssert();
	GET_Or_Read_A_Product readAprod = new GET_Or_Read_A_Product();

	
	@Test
	public void update_A_Product() {

		
		// https://techfios.com/api-prod/api/product/update.php
		HashMap payload = new HashMap();
		payload.put("id", "1409");
		payload.put("name", "Samsung S21");
		payload.put("description", "Pretty amazing phone");
		payload.put("price", "799");
		payload.put("category name", "Electronics");
		payload.put("category id", "2");
		
		Response response=
		
				given()
	
		           .baseUri("https://techfios.com/api-prod/api/product")
		           .header("Content-Type","application/json; charset=UTF-8")
		           .body(payload)
	           .when()
	               .put("/update.php")
	           .then()
	               .extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody:" + responseBody);
		

		
		//Parsing responseBody to Json:
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
	
		softAssert.assertEquals(message, "Product was updated.", "Not matching the assertions");
		readAprod.read_A_Product();
		softAssert.assertAll();
	}
}
