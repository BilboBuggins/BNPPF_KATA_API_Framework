package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {
	
	public static RequestSpecification requestSpecification;
	
	public RequestSpecification requestSpecBuilder() throws IOException {
		
		
		if(requestSpecification==null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
			requestSpecification=new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return requestSpecification;
				}
		return requestSpecification;
		
	}
	
	public ResponseSpecification responseSpecBuilder(int responseCode) {
		return new ResponseSpecBuilder().expectStatusCode(responseCode).build();
	}
	
	public static String getGlobalValues(String key) throws IOException {
		Properties properties= new Properties();
		FileInputStream fileInputStream= new FileInputStream("src/test/java/resources/global.properties");
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

}
