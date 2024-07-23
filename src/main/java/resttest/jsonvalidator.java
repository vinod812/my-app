package resttest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.sun.tools.sjavac.Log;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;

public class jsonvalidator{
	private static WireMockServer wireMockServer;
	
	@BeforeClass
	public void setup() throws InterruptedException{
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
      Thread.sleep(10000);
		
	}
	

   @AfterClass
   public static void teardown() {
	   wireMockServer.stop();
   }
   
   @Test
   public void jsonvalidator() {
	  Map<String, String> payLoad=new HashMap();
	  payLoad.put("name", "John Doe");
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8081;
	  
	  ExtentReportListener.getTest().log(Status.INFO, "Driver initialized");
	  
	  Response responsedata=RestAssured.given()
	    .filter(new RestAssuredLoggingFilter())
	  	.contentType("application/json")
	  	.body(payLoad)
	  	.log().all()
	  .when()
	  	.post("api/create")
	  	
	  .then()
	  .log().all()	
	  .statusCode(200)
	  //.body("message", equalTo("Received: John Doe"))
	  .extract()
	  .response();
	 
	  JsonPath jsonPathObj= responsedata.jsonPath();
	  List<String> responsedata1= jsonPathObj.get("company.employee.name");
	 
	  for(String cdata:responsedata1) {
		  System.out.println(cdata);
	  }
	  
	  
	  //System.out.println(requestspec.asPrettyString());
	  
	  
	  
   }


}