package javatest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class Wiremock {
	
	public static void main(String[] args) {
		WireMockServer wiremockserver = new WireMockServer();
		wiremockserver.start();
		WireMock.configureFor("localhost", 8081);
        // Stub a request
        stubFor(get(url EqualTo("/api/resource"))
            //.willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"message\": \"Hello, world!\" }")));

        // Make your API call here to test against the mock server

        // Stop the WireMock server
        //wireMockServer.stop();

		
	}

}
