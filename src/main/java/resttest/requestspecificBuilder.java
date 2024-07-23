package resttest;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ExtentReportListener;
import utility.RestAssuredLoggingFilter;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
public class requestspecificBuilder{

    private static WireMockServer wireMockServer;
    private static RequestSpecification requestSpec;
    @BeforeClass
    public static void setup() throws InterruptedException {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8081));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8081);

        WireMock.stubFor(post("/api/create")
                .withRequestBody(equalToJson("{ \"name\": \"John Doe\" }"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Received: John Doe\" }")));
        
        //Thread.sleep(10000);
        
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost");
        builder.setPort(8081);
        builder.setContentType("application/json");
        requestSpec=builder.build();
        RestAssured.requestSpecification=builder.build();
    }

    @AfterClass
    public static void teardown() {
     wireMockServer.stop();
    }

    @Test
    public void testCreate() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;

        String jsonBody = "{\"name\":\"John Doe\"}";
        ExtentReportListener.getTest().log(Status.INFO, "ChromeDriver initialized");

        Response response = RestAssured.given()
        		.filter(new RestAssuredLoggingFilter())
        		.spec(requestSpec)
        		.body(jsonBody)
        		.when()
        		.post("/api/create")
        		.then()
            .statusCode(200)
            .body("message", equalTo("Received: John Doe"))
            .extract()
            .response() ;
        
        System.out.println(response.asString());
        
        ExtentReportListener.getTest().log(Status.PASS, "GET request successful and response validated");

        
    }
    


}
