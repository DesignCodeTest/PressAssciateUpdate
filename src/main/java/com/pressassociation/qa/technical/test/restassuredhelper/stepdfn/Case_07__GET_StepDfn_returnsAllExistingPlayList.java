package com.pressassociation.qa.technical.test.restassuredhelper.stepdfn;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Case_07__GET_StepDfn_returnsAllExistingPlayList 
{
	
	@Given("^the Accept Content format is JSON$")
	public void the_Accept_Content_format_is_JSON() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@And("^Content Type is JSON$")
	public void content_Type_is_JSON() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I perform a Get request for all existing playlists$")
	public void i_perform_a_Get_request_for_all_existing_playlists() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Status code \"([^\"]*)\" - OK is expected in response$")
    public void status_code_something_ok_is_expected_in_response(String strArg1) throws Throwable {
        throw new PendingException();
    }

	@And("^Response should return all playlists with correct credentials$")
	public void response_should_return_all_playlists_with_correct_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	/* {"__v":"0",
	"desc":"My First Playlist",
	"title":"My List","_id":"596cbda86ed7c10011a68b32",
	"videos":["{\"_id\":\"596cbda86ed7c10011a68b32\",\"artist\":\"Lady Gaga\",\"song\":\"Just Dance\",\"publishDate\":\"2017-09-01T00:00:00.000Z\",\"__v\":\"0\",\"date_created\":\"2017-07-17T13:37:44.559Z\"}"],
	"date_created":"2017-07-17T13:37:44.559Z"}*/
	
	// Not fully working yet due to malformed Json body being passed to the POST method

}
