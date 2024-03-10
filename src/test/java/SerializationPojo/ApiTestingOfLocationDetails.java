package SerializationPojo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import DeSerializationpojo.ResponseOfLocationDetails;
import io.restassured.RestAssured;

public class ApiTestingOfLocationDetails {

	public static void main(String[] args) {
		//setting serialization value
		
		locationDetails ld = new locationDetails();
		ld.setAccuracy(100);
		ld.setAddress("Bharat, Kalinath chowk Gola");
		ld.setPhone_number("+91 ( 123-456-789) ");
		ld.setName("raj ");
		ld.setWebsite("www.instagram.com");
		ld.setLanguage("Hindi");
		List<String> typess = new ArrayList<String>();
		typess.add("NSE");
		typess.add("BSE");
		ld.setTypes(typess);
		latlangDetails lld = new latlangDetails();
		lld.setLat(-333.9989);
		lld.setLng(-33.8978);
		ld.setLocation(lld);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		ResponseOfLocationDetails rld= given().log().all().queryParam("key", "qaclick123").body(ld)
		.when().post("/maps/api/place/add/json").then().log().all().statusCode(200)
		.extract().as(ResponseOfLocationDetails.class);
		
		System.out.println(rld.getPlace_id());
		
		System.out.println(rld.getScope());
		
	}

}
