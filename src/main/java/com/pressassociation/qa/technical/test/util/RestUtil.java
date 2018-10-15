package com.pressassociation.qa.technical.test.util;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pressassociation.qa.technical.test.restassuredhelper.DailySongs;

import io.restassured.http.ContentType;

public class RestUtil {
	
	private static final String _ID = "_id";
	private static final String ARTIST = "artist";
	private static final String SONG = "song";
	private static final String PUBLISHDATE = "publishDate";
	private static final String __V = "__v";
	private static final String DATE_CREAATED = "date_created";
	private static final String DESC = "desc";
	private static final String TITLE = "title";
	private static final String VIDEO = "video";
	private static final String VIDEOS = "videos";
	
	
	
	public static String getJsonBody (String _Id, String Artist, String Song,String PublishDate,String __v,String Date_created)
	{
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty(_ID, _Id);
		jsonObject.addProperty(ARTIST, Artist);
		jsonObject.addProperty(SONG, Song);
		jsonObject.addProperty(PUBLISHDATE, PublishDate);
		jsonObject.addProperty(__V, __v);
		jsonObject.addProperty(DATE_CREAATED, Date_created);
		
		
		return jsonObject.toString();		
	}
	
	
	public static String getJsonBodyforPlayList (String _Id, String Desc, String Title,String __v,String Date_created, List<String> video)
	{
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty(__V, __v);
		jsonObject.addProperty(DESC, Desc);
		jsonObject.addProperty(TITLE, Title);
		jsonObject.addProperty(_ID, _Id);
		
		//JsonObject videolist = new JsonObject();
		JsonArray array = getJsonArray(video);
		
		//videolist.add(VIDEO, array);
		//jsonObject.add(VIDEOS,videolist);
		jsonObject.add(VIDEOS,array);
		
		
		jsonObject.addProperty(DATE_CREAATED, Date_created);
		
		
		return jsonObject.toString();		
	}


	private static JsonArray getJsonArray(List<String> video) {
		JsonArray array = new JsonArray();
		
		for (String jsonElement: video) {
			array.add(jsonElement);
		}
		return array;
	}
	
	
	
	private static String JsonObjMap() 
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
		.get()
		.thenReturn()
		.asString();
		System.out.println(x);
		return x;
			
	}
	
	//@Ignore
	@Test
	public void test()
	{
		
		//String [] data1 = {};
		String data = getJsonBody("596cbda86ed7c10011a68b32", "Lady Gaga","Just Dance", "2017-09-01T00:00:00.000Z", "0", "2017-07-17T13:37:44.559Z");
		//String data1 = RestUtil.JsonObjMap();
		//System.out.println(RestUtil.getJsonBody("596cbda86ed7c10011a68b32", "Lady Gaga","Just Dance", "2017-09-01T00:00:00.000Z", "0", "2017-07-17T13:37:44.559Z"));
		System.out.println(RestUtil.getJsonBodyforPlayList("596cbda86ed7c10011a68b32", "My First Playlist","My List", "0", "2017-07-17T13:37:44.559Z", Arrays.asList(data)));
	}
	

}
