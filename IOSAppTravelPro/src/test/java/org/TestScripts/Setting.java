package org.TestScripts;

import org.Controller.EngineController;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;

public class Setting extends BaseClass implements PageElement{
	@When("I navigate to the settings page")
	public void i_navigate_to_the_settings_page() throws Throwable {
		EngineController.reportInstance.createStep("When", "I navigate to the settings page");
		clickElement(backIcon1);
	    
	}

	@Then("Default values must be present for  my location check and alter threshold")
	public void default_values_must_be_present_for_my_location_check_and_alter_threshold() throws Throwable {
		EngineController.reportInstance.createStep("Then", "Default values must be present for  my location check and alter threshold");
		try {
			Assert.assertEquals(getTextFromElement(LocCheck),PropertyFile("MyLocation", TestData));
			Assert.assertEquals(getTextFromElement(alterThreshold1),PropertyFile("AlterThreshold", TestData));
			EngineController.reportInstance.reportStepPass("Default values is present for  my location check and alter threshold");
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("Default values is not present for  my location check and alter threshold");
		}
	    

	}

	@When("Make changes in maximum stay date")
	public void make_changes_in_maximum_stay_date() throws Throwable {
		EngineController.reportInstance.createStep("When", "Make changes in maximum stay date");
		swipeToElement(iosDriver, 432, 1876, 544,1048);
		clickElement(maxStayDay);
		clickElement(DoneButton);
		clickElement(plusButton);
		
		
		
		
	   
	}

	@Then("Changes made in maximum stay date must be reflected in travel record")
	public void changes_made_in_maximum_stay_date_must_be_reflected_in_travel_record() throws Throwable {
		EngineController.reportInstance.createStep("Then", "Changes made in maximum stay date must be reflected in travel record");
		swipeToElement(iosDriver, 732, 420, 692,1816);
		try {
			Assert.assertTrue(IsDisplayed(travelMaxStayDay));
			EngineController.reportInstance.reportStepPass("Changes made in maximum stay date are reflected in travel record");
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("Changes made in maximum stay date are not reflected in travel record");
		}
	    
		
	   
	}

}
