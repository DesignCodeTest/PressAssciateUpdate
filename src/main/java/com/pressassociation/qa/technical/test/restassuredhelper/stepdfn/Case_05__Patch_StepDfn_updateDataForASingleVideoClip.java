package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;

import static io.restassured.RestAssured.*;

import java.net.URI;

import com.pressassociation.qa.technical.test.restassuredhelper.BaseClass;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Case_05__Patch_StepDfn_updateDataForASingleVideoClip extends BaseClass
{
	
	private RequestSpecification requestSpec;
	private Response response; 
	
	@Given("^content in JSON - PatchToUpdate_A_VideoClip$")
	public void content_in_JSON_PatchToUpdate_A_VideoClip() throws Throwable {
		requestSpec = given().accept(ContentType.JSON).log().all();
	}

	@And("^with the Content Type as JSON - PatchToUpdate_A_VideoClip$")
	public void with_the_Content_Type_as_JSON_PatchToUpdate_A_VideoClip() throws Throwable {
		requestSpec = requestSpec.contentType(ContentType.JSON);
	}

	@When("^I do a GET request with ID, \"([^\"]*)\"  - PatchToUpdate_A_VideoClip$")
	public void i_do_a_GET_request_with_ID_PatchToUpdate_A_VideoClip(String id) throws Throwable {
		response = requestSpec.get(new URI("/video/" + id));
	}

	@Then("^expected Status code \"([^\"]*)\" - OK is returned - PatchToUpdate_A_VideoClip$")
	public void expected_Status_code_OK_is_returned_PatchToUpdate_A_VideoClip(String statusCode) throws Throwable {
		response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@When("^I perform a Patch request without any action against ID,\"([^\"]*)\" - This is a Patch Request\"$")
	public void i_perform_a_Patch_request_without_any_action_against_ID_This_is_a_Patch_Request(String id) throws Throwable {
	   response = requestSpec.patch("/video/" + id);
	}

	@Then("^expected HTTP status code response is \"([^\"]*)\" Not Implemented - PatchToUpdate_A_VideoClip$")
	public void expected_HTTP_status_code_response_is_Not_Implemented_PatchToUpdate_A_VideoClip(String statusCode) throws Throwable {
		response.then().assertThat().statusCode(new Integer(statusCode));
	}

	@And("^details should not get updated - PatchToUpdate_A_VideoClip$")
	public void details_should_not_get_updated_PatchToUpdate_A_VideoClip() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	// Now fully working
}
