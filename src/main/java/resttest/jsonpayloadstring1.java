package resttest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.sun.tools.sjavac.Log;

import io.restassured.RestAssured;
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;

public class jsonpayloadstring1{
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
                        .withBody("{ \"message\": \"Received: John Doe\" }")));
      Thread.sleep(10000);
		
	}
	

   @AfterClass
   public static void teardown() {
	   wireMockServer.stop();
   }
   
   @Test
   public void payloadString() {
	   String inputPayLoad= "{\"name\":\"John Doe\"}";
	   RestAssured.baseURI="http://localhost";
	   RestAssured.port=8081; 
	   ExtentReportListener.getTest().log(Status.INFO, "Chrome Driver Initialized");
	   given()
	    .filter(new RestAssuredLoggingFilter())
	    .contentType("application/json")
	    .body(inputPayLoad)   
	   .when()
	   	.post("/api/create")
	   .then()
	   	.statusCode(200);
	   
	   ExtentReportListener.getTest().log(Status.PASS, "Request is Successful");
   }


}