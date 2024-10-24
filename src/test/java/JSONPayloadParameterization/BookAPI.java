package JSONPayloadParameterization;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

public class BookAPI {
	RequestSpecification rs;
	String ID;
	JsonPath js;
	String response ;
	@Test(dataProvider = "jsonPayload")
	public void addBook(String bookName,String isbn,String aisle,String author)
	{
		rs = given().baseUri("https://rahulshettyacademy.com/").header("Content-Type", "application/json");


		String response =	 given().
				spec(rs)
				.body(Payload.reqJSON(bookName,isbn,aisle,author))
				.log()
				.all()
				.when()
				.post("Library/Addbook.php")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.asPrettyString();
		js = new JsonPath(response);

		ID = js.get("ID");
		String msgAct = js.getString("Msg");
		Assert.assertEquals(msgAct, "successfully added","Book added success message");

		response = given()
				.spec(rs)
				.queryParam("ID", ID)
				.when()
				.get("Library/GetBook.php")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.asPrettyString();

		js = new JsonPath(response);

		String bookNameAct = js.get("[0].book_name");

		Assert.assertEquals(bookNameAct, bookName,"Book Name");
	}




	@DataProvider
	public Object[][] jsonPayload()
	{

		Object[][] jsonBody = new Object[3][4];
		jsonBody[0][0]="Learn Appium Automation with Java";
		jsonBody[0][1]="yuuioawa";
		jsonBody[0][2]="8756723";
		jsonBody[0][3]="John foer";

		jsonBody[1][0]="Learn Selenium with Java";
		jsonBody[1][1]="trwewa";
		jsonBody[1][2]="2252124";
		jsonBody[1][3]="Marshall Fie";

		jsonBody[2][0]="Learn Cypress";
		jsonBody[2][1]="popafaf";
		jsonBody[2][2]="1241241";
		jsonBody[2][3]="Jamie Fie";


		return jsonBody;
	}

}
