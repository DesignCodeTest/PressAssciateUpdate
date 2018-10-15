package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;

import static io.restassured.RestAssured.given;

import java.net.URI;

import com.pressassociation.qa.technical.test.restassuredhelper.BaseClass;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Case_03__Get_StepDfn_returnsSingleVideoClip extends BaseClass
{
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("^the Accept content format is Json - GetSingleVideoClip$")
	public void the_Accept_content_format_is_Json_GetSingleVideoClip() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^with the Content Type as JSON - GetSingleVideoClip$")
	public void with_the_Content_Type_as_JSON_GetSingleVideoClip() throws Throwable {
		
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I perform Get request for video clips with _id as \"([^\"]*)\"  - GetSingleVideoClip$")
	public void i_perform_Get_request_for_video_clips_with__id_as_GetSingleVideoClip(String id) throws Throwable {
		response = requestSpec.get(new URI("/video/" + id));	
	}

	@Then("^expected Status code \"([^\"]*)\" - OK - GetSingleVideoClip$")
	public void expected_Status_code_OK_GetSingleVideoClip(String statusCode) throws Throwable {
		response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@And("^Response should return all clips with the correct credentials - GetSingleVideoClip$")
	public void response_should_return_all_clips_with_the_correct_credentials_GetSingleVideoClip() throws Throwable {
		response.thenReturn().asString(); 
		System.out.println("TO DO: Rework this response:-> " +response.asString());
	}
	
	// Now fully working

}
