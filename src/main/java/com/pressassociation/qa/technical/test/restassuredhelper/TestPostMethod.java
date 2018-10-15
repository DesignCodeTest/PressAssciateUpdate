package com.pressassociation.qa.technical.test.restassuredhelper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;	




public class TestPostMethod extends BaseClass 
{
	@Ignore
	@Test
	public void testPost() 
	{
		/*
		 * Given: Accept format is JSON 
		 * With: Content Type as JSON
		 * And Body
		 * When I perform the Post request
		 * Then Status code expected should be 201 - Created
		 * And the response should contain the ID
		 * 
		 * */		
			
		String jsonBody = "{" 
							+ "\"_id\": \"596cbda86ed7c10011a68b37\"," 
							+ "\"artist\": \"Lady Gaga\","
							+ "\"song\": \"Just Dance\"," 
							+ "\"publishDate\": \"2017-09-01T00:00:00.000Z\"," 
							+ "\"__v\": \"1\"," 
							+ "\"date_created\": \"2017-07-17T13:37:44.559Z" + 
							 "}";		
				
		//given().body("{ \"message\" : \"hello world\"}").when().post("/json").then().assertThat().body(equalTo("hello world"));
		 
		
		given()
		.log()
		.all()
		.accept(ContentType.JSON)
		.with()
		.contentType(ContentType.JSON)
		.and()
		.body(jsonBody)
		.when()
		.post("/video")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		//.body("_id", equalToIgnoringCase("596cbda86ed7c10011a68b37"));
		//System.out.println(jsonBody);		
	}
	
	//@Ignore
	@Test
	public void testPostwithObjmapping() 
	{
		// Create and use mapping class
		
		DailySongs ds = new DailySongs();
		ds.set_id("596cbda86ed7c10011a68b38");
		ds.setArtist("Lady Gaga");
		ds.setSong("Just Dance");
		ds.setPublishDate("2017-09-01T00:00:00.000Z");
		ds.setDate_created("2017-07-17T13:37:44.559Z");
		
		String x = given()
		.accept(ContentType.JSON)
		.with()
		.contentType(ContentType.JSON)
		.body(ds)
		.post("/video")
		.thenReturn()
		.asString();
		System.out.println(x);
		
			
	}
}



