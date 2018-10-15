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

public class Case_06__Delete_StepDfn_remove_A_VideoClip extends BaseClass
{
	
	private RequestSpecification requestSpec;
	private Response response; 
	
	@Given("^Accept content is JSON - removeVideoClip$")
	public void accept_content_is_JSON_removeVideoClip() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^with the Content Type as JSON - removeVideoClip$")
	public void with_the_Content_Type_as_JSON_removeVideoClip() throws Throwable {
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I do a GET request with ID, \"([^\"]*)\"  - removeVideoClip$")
	public void i_do_a_GET_request_with_ID_removeVideoClip(String id) throws Throwable {
		response = requestSpec.get(new URI("/video/" + id));
	}

	@Then("^expected Status code \"([^\"]*)\" - OK is returned - removeVideoClip$")
	public void expected_Status_code_OK_is_returned_removeVideoClip(String statusCode) throws Throwable {
		response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@When("^I perform a DELETE request with ID \"([^\"]*)\" - removeVideoClip$")
	public void i_perform_a_DELETE_request_with_ID_removeVideoClip(String id) throws Throwable {
		response = requestSpec.delete("/video/" + id);
	}

	@Then("^expected response HTTP status code  is \"([^\"]*)\" - removeVideoClip$")
	public void expected_response_HTTP_status_code_is_removeVideoClip(String statusCode) throws Throwable {
	    
		response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@When("^I now repeat GET request with same ID, \"([^\"]*)\"  again - removeVideoClip$")
	public void i_now_repeat_GET_request_with_same_ID_again_removeVideoClip(String id) throws Throwable {
		response = requestSpec.get(new URI("/video/" + id));
	}

	@Then("^expected response HTTP status code  should be \"([^\"]*)\" OK - with data NOT found - removeVideoClip$")
	public void expected_response_HTTP_status_code_should_be_NOT_found_removeVideoClip(String statusCode) throws Throwable {
		response.then().assertThat().statusCode(new Integer(statusCode));
	}
	
	// Now fully working

}
