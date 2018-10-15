package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.pressassociation.qa.technical.test.restassuredhelper.BaseClass;
import com.pressassociation.qa.technical.test.util.RestUtil;

public class Case_01__Post_StepDfn_toCreateAnumberOfVideoClips extends BaseClass
{
	private RequestSpecification requestSpec;
	private Response response;
	
		
	@Given("^Accept the content in Json Format - PostToCreateAFewVideoClips$")
	public void accept_the_content_in_Json_Format_PostToCreateAFewVideoClips() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^Content Type as JSON - PostToCreateAFewVideoClips - PostToCreateAFewVideoClips$")
	public void content_Type_as_JSON_PostToCreateAFewVideoClips_PostToCreateAFewVideoClips() throws Throwable {
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I Post request with _id as \"([^\"]*)\",artist as \"([^\"]*)\",song as \"([^\"]*)\",publishDate as \"([^\"]*)\",__v as \"([^\"]*)\", date_created as \"([^\"]*)\" - PostToCreateAFewVideoClips$")
	    public void i_post_request_with_id_as_Clipid_artist_as_ArtistName_song_as_songName_publishdate_as_Pdate_asv_as_versionNo_datecreated_as_DCreated
	    (String _Id, 
	    String Artist, 
	    String Song, 
	    String PublishDate, 
	    String __v, 
	    String Date_created
	    ) throws Throwable {
		
		String getreqbody = RestUtil.getJsonBody(_Id, Artist, Song, PublishDate, __v, Date_created);
		response = requestSpec.body(getreqbody).post("/video");
	}

	
	@Then("^Status code \"([^\"]*)\" OK should be returned - PostToCreateAFewVideoClips$")
    public void status_code_201_created_should_be_returned(String statusCode) throws Throwable	{
        response.then().assertThat().statusCode(new Integer(statusCode)); // or try this (Intger.parseInt(statusCode));
    }
	

	@And("^Response should return the correct ID - PostToCreateAFewVideoClips$")
	public void response_should_return_the_correct_ID_PostToCreateAFewVideoClips() throws Throwable {
	    response.thenReturn().asString(); 
	    System.out.println(response);
	}
	
	// Now fully working

}
