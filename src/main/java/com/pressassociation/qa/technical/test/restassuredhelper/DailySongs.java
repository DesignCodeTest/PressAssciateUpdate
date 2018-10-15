package com.pressassociation.qa.technical.test.restassuredhelper;

public class DailySongs 
{
	/*String jsonBody = "{" +
			"\"_id\": \"596cbda86ed7c10011a68b28\"," +
			"\"artist\": \"Lady Gaga\"," +
			"\"song\": \"Just Dance\","  +
			"\"publishDate\": \"2017-09-01\"," + 
			"\"__v\": \"0\"," +
			"\"date_created\": \"2017-07-17T13:37:44.559Z"
			+ "}";*/
	
	private String _id;
	private String artist;
	private String song;
	private String publishDate;
	private String __v;
	private String date_created;
	
	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String get__v() {
		return __v;
	}

	public void set__v(String __v) {
		this.__v = __v;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	
		
	public String get_id() 
	{
		return _id;
	}
	
	public void set_id(String id) {
		this._id = id;
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	
}
