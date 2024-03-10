package RESTAPI;

import static io.restassured.RestAssured.given;

import DeSerializationpojo.getCourses;
import io.restassured.path.json.JsonPath;
public class oAuth_clientGrant {

	public static void main(String[] args) {
	
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath js = new JsonPath(response);
		String token = js.getString("access_token");
		
		//System.out.println(token);
		
		getCourses gc  = given().queryParam("access_token", token)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").then().assertThat().statusCode(401)
		.extract().as(getCourses.class);

		//System.out.println(gc);
		int webcources = gc.getCourses().getWebAutomation().size();
		
		for (int i = 0; i< webcources; i++) {
			String text = gc.getCourses().getWebAutomation().get(i).getCourseTitle();
			String price = gc.getCourses().getWebAutomation().get(i).getPrice();
			System.out.println(text + "  " + price);
		}
		
		System.out.println(gc.getExpertise());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.url);
		System.out.println(gc.getServices());
	}

}
