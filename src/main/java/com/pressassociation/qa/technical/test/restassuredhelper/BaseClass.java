package com.pressassociation.qa.technical.test.restassuredhelper;

import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

// http://turing.niallbunting.com:3003/api/video/

public class BaseClass 

{
	@BeforeClass
	public static void setUp()
	{
		baseURI = "http://turing.niallbunting.com";
		port = 3003;
		basePath = "/api";
		
	}
	
	public BaseClass ()
	{
		baseURI = "http://turing.niallbunting.com";
		port = 3003;
		basePath = "/api";
	}

}
