package com.pressassociation.qa.technical.test.restassuredhelper.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:/Users/Owner/Documents/GitHub/Press Association/qa-technical-test/src/main/java/com/pressassociation/qa/technical/test/restassuredhelper/featurefile/PostMethod.feature"},
		glue = {"com.pressassociation.qa.technical.test.restassuredhelper.stepdfn"}, // tells compiler location of StepDfn file during test execution
		monochrome = true, // monochrome variable when TRUE displays the output in readable format 
		dryRun = false)		// dry run when TRUE used to generate the Steps definitions
		

	public class RestFulApiMethodRunner 
	{	
		
	}
