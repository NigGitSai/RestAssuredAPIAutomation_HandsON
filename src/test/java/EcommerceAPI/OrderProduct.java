package EcommerceAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrderProduct {

	
	@Test
	public void orderProduct() throws JsonProcessingException
	{
		RequestSpecBuilder reqBuild = new RequestSpecBuilder();
	
		RequestSpecification reqSpecLogin =reqBuild.setBaseUri("https://www.rahulshettyacademy.com/").setContentType(ContentType.JSON).build();
	
		LoginPOJO loginPOJO = new  LoginPOJO();
		
		loginPOJO.setUserEmail("abcd@example.com");
		loginPOJO.setUserPassword("Pwd@1234");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String reqJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginPOJO);
		
		LoginResponsePOJO loginresponse =given()
				.relaxedHTTPSValidation()
		.spec(reqSpecLogin)
		.body(reqJson)
		.log()
		.all()
		.when()
		.post("api/ecom/auth/login")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.as(LoginResponsePOJO.class);
		
		String token = loginresponse.getToken();
		
		String userId = loginresponse.getUserId();
		
		
		
		RequestSpecification addProductReqSpec = 
		reqBuild.setBaseUri("https://www.rahulshettyacademy.com/").addHeader("authorization", token).
		setContentType(ContentType.MULTIPART).build();
		
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		 ResponseSpecification responseSpec =   responseSpecBuilder.expectStatusCode(201).build();
		
		String addProdResponse = given()
		.log()
		.all()
		.relaxedHTTPSValidation()
		.spec(addProductReqSpec)
		.formParam("productName", "Kurti")
		.formParam("productAddedBy", userId).formParam("productCategory", "fashion")
		.formParam("productSubCategory", "shirts").formParam("productPrice", "500")
		.formParam("productDescription", "Lenova").formParam("productFor", "women")
		.multiPart("File", new File("./src/test/resources/DressImage.png"))
		.when()
		.post("/api/ecom/product/add-product")
		.then()
		.log()
		.all()
		.spec(responseSpec)
		.extract()
		.response()
		.asString();
		
		JsonPath js  = new JsonPath(addProdResponse);
		
		String productId = js.get("productId");
		
		RequestSpecification createOrderReqSpec = 
				reqBuild.setBaseUri("https://www.rahulshettyacademy.com/").addHeader("authorization", token).setContentType(ContentType.JSON).build();
				
				
		
		
		Orders orders = new Orders();
		
		orders.setCountry("India");
		orders.setProductId(productId);
		
		List<Orders> ordersLst = new ArrayList<Orders>();
		
		ordersLst.add(orders);
		
		CreateOrderPojo createOrder = new CreateOrderPojo();
		
		createOrder.setOrders(ordersLst);
		
		String createOrderReqJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createOrder);
		
		String createOrderResponse = given()
		.log()
		.all()
		.relaxedHTTPSValidation()
		.spec(createOrderReqSpec)
		.body(createOrderReqJson)
		.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();

		System.out.println("Order Created Response :"+createOrderResponse);
		
		//Delete Product
		
		
		String deleteProdResponse = given()
		.log()
		.all()
		.relaxedHTTPSValidation()
		.spec(createOrderReqSpec)
		.pathParam("productID", productId)
		.when()
		.delete("/api/ecom/product/delete-product/{productId}")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asString();
		
		
		js  = new JsonPath(deleteProdResponse);
		
		Assert.assertEquals("Product Deleted Successfully",js.get("message"));

	}
}
