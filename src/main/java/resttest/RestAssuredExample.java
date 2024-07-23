package resttest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class RestAssuredExample {
   
	@Test
    public void testcsv() {
        try {
            // Read CSV data
        	
        	// Get the CSV file path from the resources directory
           // URL resource = getClass().getClassLoader().getResource("C:\\data.csv");
            
          /*  if(resource == null) {
            	throw new IOException("File not found exceptoin	");
            }*/
            
           // String filepath=resource.getPath();
            String filepath="C:\\data.csv";
           // System.out.println(resource);
            List<Map<String, String>> csvData = CSVReader.readCSV(filepath);

            // Convert to JSON and send the request
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(csvData)
                    .when()
                    .post("http://example.com/api/endpoint")
                    .then()
                    .statusCode(201);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
