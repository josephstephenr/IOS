package org.TestScripts;

import java.io.IOException;

import org.Controller.EngineController;
import org.junit.Assert;

import driver.Driverlaunch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class CreateRec extends BaseClass implements PageElement{


	@When("I create a new travel record")
	public void i_create_a_new_travel_record() throws Throwable {
		EngineController.reportInstance.createStep("When", "I create a new travel record");
		//clickElement(getBtn);
		clickElement(plusButton);
		clickElement(drpDown);
		clickElement(ToCountry1);
		clickElement(selectBtn);
		swipeToElement(iosDriver, 708, 1076, 708, 2620);
		Waits();
		swipeToElement(iosDriver, 708, 1076, 708, 100);
		Waits();
		clickElement(createBt);	
		
	    
	}

	@Then("the error should appear")
	public void the_error_should_appear() throws Throwable {
		EngineController.reportInstance.createStep("Then", "The error should appear");
		try {
			Assert.assertTrue(IsDisplayed(arrivalDate));
			EngineController.reportInstance.reportStepPass("Roaster appears with message showing that Select arrival date");
		} catch (Exception e1) {
			System.out.println(e1);
			EngineController.reportInstance.reportStepFail("Roaster not appears");
			
		}
		swipeToElement(iosDriver, 576, 1988, 584, 2648);
	}

	@Then("Definition of day and alter Threshold Days must be present by default")
	public void definition_of_day_and_alter_threshold_days_must_be_present_by_default() throws Throwable {
		EngineController.reportInstance.createStep("Then", "Definition of day and alter Threshold Days must be present by default");
		try {
			Assert.assertTrue(contains(DOD));
			Assert.assertTrue(contains(alterThreshold));
			EngineController.reportInstance.reportStepPass("Definition of day and alter Threshold Days is present by default");
		} catch (Exception e) {
			EngineController.reportInstance.reportStepFail("Definition of day and alter Threshold Days are not present by default");
		}
		
		
	    
	}

	@When("I create a new travel record enter same country in from and to country")
	public void i_create_a_new_travel_record_enter_same_country_in_from_and_to_country() throws Throwable {
		EngineController.reportInstance.createStep("When", "I create a new travel record enter same country in from and to country");
		
		clickElement(FromDrp);
		clickElement(ToCountry1);
		clickElement(selectBtn);
		
		
		
	    
	}

	@Then("the error message shown")
	public void the_error_message_shown() throws Throwable {
		EngineController.reportInstance.createStep("Then", "The error message shown");
		try {
			Assert.assertTrue(IsDisplayed(countryShouldNotBeSame));
			EngineController.reportInstance.reportStepPass("Country From and To should not be the same pop up should be shown");
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("The error message not shown");
		}
	    
		

	}
	@When("Full all the required field to create a record")
	public void full_all_the_required_field_to_create_a_record() throws Throwable {
		EngineController.reportInstance.createStep("When", "Full all the required field to create a record");
		clickElement(arrivalDate1);
		swipeToElement(iosDriver, 544, 2096, 544, 1924);
		Waits();
		clickElement(doneBtn);
		clickElement(depDate);
		swipeToElement(iosDriver, 224, 2100, 208,2284);
		Waits();
		clickElement(doneBtn);
		swipeToElement(iosDriver, 708, 1076, 708, 2620);
		Waits();
		swipeToElement(iosDriver, 708, 1076, 708, 100);
		Waits();
		clickElement(createBt);		
	  
	}

	@Then("Created travel record should be listed in travel list")
	public void created_travel_record_should_be_listed_in_travel_list() throws Throwable {
		EngineController.reportInstance.createStep("Then", "Created travel record should be listed in travel list");
		try {
			Assert.assertTrue(IsDisplayed(clkTravelRec));
			EngineController.reportInstance.reportStepPass("Created travel record is listed in travel list");
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("Created travel record is not listed in travel list");
		}

	}
	
	}
