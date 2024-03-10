package RESTAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class apiTesting {

	
	@Test
	public void Add_PlaceTesting() {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn RAJ Automation with RAJ\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"0180\",\r\n"
				+ "\"author\":\"RAJ K\"\r\n"
				+ "}\r\n"
				+ "")
		.when().post("/Library/Addbook.php").then().assertThat()
		.statusCode(200).extract().asString();
		
		System.out.println(response);
		
		String booksDetails =given().queryParam("AuthorName", "RAJ K")
		.queryParam("ID", "bcd0180")
		.when().get("/Library/GetBook.php")
		.then().assertThat().extract().asString();
		
		System.out.println(booksDetails);
	}
}
