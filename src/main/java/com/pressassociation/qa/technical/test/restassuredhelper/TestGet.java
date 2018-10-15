package com.pressassociation.qa.technical.test.restassuredhelper;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.junit.*;

import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 



public class TestGet extends BaseClass
{
	@Ignore
	@Test
	public void testGet() throws URISyntaxException
	{
		/*
		 * Given: the Accept format to be used is JSON 
		 * When: I perform the GET request
		 * 
		 * 
		 * */
		
		//URI uri = new URI("http://turing.niallbunting.com:3003/api/video/");	
		Response response = given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/"));
		System.out.println(response.asString());
		
		
	}
	

	@Test
	public void testStatusCode () throws URISyntaxException
	{
		/*
		 * Given: the Accept format is JSON 
		 * When: I perform the GET request for a video clip
		 * Then: Expected status code from response should be 200 OK
		 * 
		 * */
		
		/*int code = given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("http://turing.niallbunting.com:3003/api/video/"))
		.thenReturn()
		.statusCode();
		Assert.assertEquals(HttpStatus.SC_OK, code);
		System.out.println(code);*/
		
		
		given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
		// thenReturns  : captures the status code and other info
		// then : deals with validation of response
		
	}
	
	@Ignore
	@Test
	public void testGetWithId () throws URISyntaxException
	{
		/*
		 * Given: the Accept format to be used is in JSON 
		 * When: I perform the GET request with ID '596cc3b16ed7c10011a68b26'
		 * Then: expected status code should be 200 OK
		 * 
		 * */
		
		
		/*given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596cc3b16ed7c10011a68b26"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);*/
		
		
		String body = given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596cc3b16ed7c10011a68b26"))
		.thenReturn()
		.body()
		.asString();
		System.out.println(body);
		
	}
	
	@Ignore
	@Test
	public void testGetWithNoExistentId () throws URISyntaxException
	{
		/*
		 * Given: the Accept format to be used is in JSON 
		 * When: I perform the GET request
		 * Then: expected status code should be 404 Not Found
		 * 
		 * */
		given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);			
		
	}
	
	@Ignore
	@Test
	public void testResponseContent () throws URISyntaxException
	{
		/*
		 * Given: the Accept format to be used is in JSON 
		 * When: I perform the GET request with ID '596cc3b16ed7c10011a68b26'
		 * Then: the response should contain artist as "Ed Sheeran"
		 * 
		 * */		
		
		/*given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596cc3b16ed7c10011a68b26"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);*/
		
		
		given()
		.log()
		.all()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596cc3b16ed7c10011a68b26"))
		.then()
		.body("artist", equalToIgnoringCase("Ed Sheeran"));
		
	}
	
	@Ignore
	@Test
	public void testContent_using_JsonPath () throws URISyntaxException
	{
		/*
		 * Given: Accept format is JSON 
		 * When: I perform the GET request with ID '596cc3b16ed7c10011a68b26'
		 * Then: expected status code should have artist as "Ed Sheeran"
		 * 
		 * */
		
		String s = given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("/video/596cc3b16ed7c10011a68b26"))
		.thenReturn()
		.body()
		.asString();
		System.out.println(s);
		
		//JsonPath json = new JsonPath(s);
		//Assert.assertEquals("596cc3b16ed7c10011a68b26", json.getInt("_id"));
		//Assert.assertTrue(json.getInt(path).getList("Feature.Feature").contains("20 GB"));
		
		//System.out.println(s);
		
	}
	

}
