package resttest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
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
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;

public class jsonpayloadpojo{
	private static WireMockServer wireMockServer;
	
	@BeforeClass
	public void setup() throws InterruptedException{
		wireMockServer=new WireMockServer(WireMockConfiguration.options().port(8081));
		wireMockServer.start();
        WireMock.configureFor("localhost",8081);

        WireMock.stubFor(post("/api/create")
                .withRequestBody(equalToJson("{ \"name\":\"Vinod Verma\", \"age\":43}"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Received:Vinod Verma\" }")));
      //Thread.sleep(10000);
		
	}
	

   @AfterClass
   public static void teardown() {
	   wireMockServer.stop();
   }
   
   @Test
   public void payloadPojo() {
	   pojoclass pj=new pojoclass("Vinod Verma",43);
	   RestAssured.baseURI="http://localhost";
	   RestAssured.port=8081;
	   
	   given()
	    .filter(new RestAssuredLoggingFilter())
	   	.contentType("application/json")
	   	.body(pj)
	   .when()
	   	.post("/api/create")
	   .then()
	   	.statusCode(200)
	   	.body("message", equalTo("Received:Vinod Verma"));
	   
	   
	   
   }


}