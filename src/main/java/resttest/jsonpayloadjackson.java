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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.google.gson.JsonObject;
import com.sun.tools.sjavac.Log;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;

public class jsonpayloadjackson{
	private static WireMockServer wireMockServer;
	
	@BeforeClass
	public void setup() throws InterruptedException{
		wireMockServer=new WireMockServer(WireMockConfiguration.options().port(8081));
		wireMockServer.start();
        WireMock.configureFor("localhost",8081);

        WireMock.stubFor(post("/api/create")
                .withRequestBody(equalToJson("{ \"name\":\"John Doe\" }"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"name\":\"John Doe\" }")));
      Thread.sleep(10000);
		
	}
	

   @AfterClass
   public static void teardown() {
	   wireMockServer.stop();
   }
   
   @Test
   public void payloadjackson() throws JsonProcessingException {
	   
	   ObjectMapper objectMapper=new ObjectMapper();
	   Map<String,Object> datatotest=new HashMap();
	   
	   datatotest.put("name", "John Doe");
	   //datatotest.put("Age", 43);
	   String jsonString =objectMapper.writeValueAsString(datatotest);
	   
	   RestAssured.baseURI="http://localhost";
	   RestAssured.port=8081;
	   
	   given()
	    .filter(new RestAssuredLoggingFilter())
	   	.contentType("application/json")
	   	.body(jsonString)	   
	   .when()
	   	.post("/api/create")
	   .then()
	   	.statusCode(200)
	   	.body("name", equalTo("John Doe"));
	  
   }

}