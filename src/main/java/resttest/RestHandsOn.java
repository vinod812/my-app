package resttest;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.admin.RequestSpec;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestHandsOn{
	private static WireMockServer wireMockServer;
	private static RequestSpecification requestSpec;
	private static ResponseSpecification responseSpec;

	@BeforeClass
	public void startWireMock() throws InterruptedException{
		wireMockServer=new WireMockServer(WireMockConfiguration.options().port(8081));
		wireMockServer.start();
		WireMock.configureFor("localhost",8081);

		WireMock.stubFor(post("/api/create")
				.withRequestBody(equalToJson("{ \"name\": \"John Doe\" }"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("{\"company\":{\"employee\":[{\"id\":1,\"name\":\"TechGeekNextUser1\",\"role\":\"Admin\"},{\"id\":2,\"name\":\"TechGeekNextUser2\",\"role\":\"User\"},\r\n" + 
								"{\"id\":3,\"name\":\"TechGeekNextUser3\",\"role\":\"User\"}]}}")));
		//Thread.sleep(10000);
		//Configure Request Specification
		requestSpec=new RequestSpecBuilder()
				.setBaseUri("http://localhost")
				.setPort(8081)
				.addHeader("testHeader", "testHeaderValue")
				.setContentType("application/json")
				.build();
		
		//Configure Response specification
		responseSpec=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.build();
		
		//BlackList
		LogConfig logconfig=new LogConfig()
				.blacklistHeader("testHeader","Content-Type");
		RestAssured.config= RestAssured.config().logConfig(logconfig);
				

		

	}

	@Test
	public void restTesting() {
		Map<String, String> payLoad=new HashMap();
		payLoad.put("name", "John Doe");
		//RestAssured.baseURI="http://localhost";
		//RestAssured.port=8081;
		ExtentReportListener.getTest().log(Status.INFO, "Driver initialized");

		Response responsedata=RestAssured.given()
				.filter(new RestAssuredLoggingFilter())
				.spec(requestSpec)
				.body(payLoad)
				.log().all()
				.when()
				.post("api/create")
				.then()
				.log().all()	
				.statusCode(200)
				.spec(responseSpec)
				.contentType("application/json")
				.body("company.employee.name[0]", equalTo("TechGeekNextUser1"))
				.body(matchesJsonSchemaInClasspath("jsonvalidator.json"))
				.extract()
				.response();

		JsonPath jsonPathObj= responsedata.jsonPath();
		List<String> responsedata1= jsonPathObj.get("company.employee.name");

		for(String cdata:responsedata1) {
			System.out.println(cdata);
		}
		





	}

	@AfterClass
	public static void stopWireMock() {
		wireMockServer.stop();
	}


}