package com.pressassociation.qa.technical.test.restassuredhelper;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPutMethod extends BaseClass 
{
	//@Ignore
	@Test
	public void testPatch() 
	{
		/**
		 * Given: content in JSON
		 * With: Content Type as JSON
		 * And: Body
		 * When: I perform PUT request with ID
		 * Then: HTTP status 200 OK should be returned
		 * And: details should get updated 
		 * 
		 **/
		
		DailySongs ds = new DailySongs();
		ds.set_id("598cbda86ed7c10011a68b36");
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
		
		ds.setSong("Just Dance, This line confirms the PATCH method is working");
		
		given()
		.log()
		.all()
		.accept(ContentType.JSON)
		.with()
		.contentType(ContentType.JSON)
		.and()
		.body(ds)
		.when()
		.put("/video/" + ds.get_id())
		.then()
		.assertThat()
		//.statusCode(HttpStatus.SC_OK)
		.body("song", containsString("This line confirms the PATCH method is working"));		
		
	}
	
	@Ignore
	@Test
	public void testDelete()
	{
		
		DailySongs ds = new DailySongs();
		ds.set_id("598cbda86ed7c10011a68b36");
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
		
		expect()
		.statusCode(HttpStatus.SC_NO_CONTENT)
		.when()
		.delete("/video/" + ds.get_id());
		
		
		String y = expect()
		.statusCode(HttpStatus.SC_OK)
		.when()
		.get("/video/" + ds.get_id())
		.thenReturn()
		.asString();
		System.out.println(y);
		
		
	}
	
}
