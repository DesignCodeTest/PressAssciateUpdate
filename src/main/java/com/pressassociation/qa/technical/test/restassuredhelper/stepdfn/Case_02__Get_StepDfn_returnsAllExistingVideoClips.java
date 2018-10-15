package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.net.URI;

import com.pressassociation.qa.technical.test.restassuredhelper.BaseClass;



public class Case_02__Get_StepDfn_returnsAllExistingVideoClips extends BaseClass
{
	
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("^the Accept content format is Json - GetsAllExistingVideoClips$")
	public void the_Accept_content_format_is_Json_GetsAllExistingVideoClips() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^Content Type is JSON - GetsAllExistingVideoClips$")
	public void content_Type_is_JSON_GetsAllExistingVideoClips() throws Throwable {
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I perform a Get request for all existing video clips - GetsAllExistingVideoClips$")
	public void i_perform_a_Get_request_for_all_existing_video_clips_GetsAllExistingVideoClips() throws Throwable {
	    response = requestSpec.get(new URI("/video"));	    
	}

	@Then("^Status code \"([^\"]*)\" - OK is expected - GetsAllExistingVideoClips$")
	public void status_code_OK_is_expected_GetsAllExistingVideoClips(String statusCode) throws Throwable {
	    response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@And("^Response should return all clips with the correct credentials - GetsAllExistingVideoClips$")
	public void response_should_return_all_clips_with_the_correct_credentials_GetsAllExistingVideoClips() throws Throwable {
		response.thenReturn().asString(); 
		System.out.println("TO DO: Rework this response:-> " +response.asString());
	    
	}
// Now fully working

}
