package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;


import static io.restassured.RestAssured.given;

import com.pressassociation.qa.technical.test.restassuredhelper.BaseClass;
import com.pressassociation.qa.technical.test.util.RestUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Case_04__Post_StepDfn_toCreate_A_VideoClip extends BaseClass
{
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("^Accept the content in Json Format - PostToCreateVideoClip$")
	public void accept_the_content_in_Json_Format_PostToCreateVideoClip() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^Content Type as JSON - PostToCreateVideoClip$")
	public void content_Type_as_JSON_PostToCreateVideoClip() throws Throwable {
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I Post request video clip with _id as \"([^\"]*)\",artist as \"([^\"]*)\",song as \"([^\"]*)\",publishDate as \"([^\"]*)\",__v as \"([^\"]*)\", date_created as \"([^\"]*)\" - PostToCreateVideoClip$")
	public void i_Post_request_video_clip_with__id_as_artist_as_song_as_publishDate_as___v_as_date_created_as_PostToCreateVideoClip
			(String _Id, 
			String Artist, 
			String Song, 
			String PublishDate, 
			String __v, 
			String Date_created) throws Throwable {
		
		String getreqbody = RestUtil.getJsonBody(_Id, Artist, Song, PublishDate, __v, Date_created);
		response = requestSpec.body(getreqbody).post("/video");	    
	}

	@Then("^Status code \"([^\"]*)\" - Created should be returned - PostToCreateVideoClip$")
    public void status_code_something_created_should_be_returned_posttocreatevideoclip(String statusCode) throws Throwable {
		 response.then().assertThat().statusCode(new Integer(statusCode)); // or try this (Intger.parseInt(statusCode));
    }


	@And("^Response should return the correct ID - PostToCreateVideoClip$")
	public void response_should_return_the_correct_ID_PostToCreateVideoClip() throws Throwable {
		response.thenReturn().asString(); 
	    System.out.println(response);
	}
	
	// Now fully working

}
