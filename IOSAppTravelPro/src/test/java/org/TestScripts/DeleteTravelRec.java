package org.TestScripts;

import org.Controller.EngineController;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;

public class DeleteTravelRec extends BaseClass implements PageElement{
	
	@When("Delete the created travel record")
	public void delete_the_created_travel_record() throws Throwable {
		EngineController.reportInstance.createStep("When", "Delete the created travel record");
		clickElement(menuOption1);
		clickElement(delete);
		clickElement(yesBtn);
		Waits();
		
		
		
		
	   
	}

	@Then("Deleted travel should be removed from the travel list")
	public void deleted_travel_should_be_removed_from_the_travel_list() throws Throwable {
		EngineController.reportInstance.createStep("Then", "Deleted travel should be removed from the travel list");
		//Assert.assertTrue(IsDisplayed(clkTravelRec));
		try {
			Assert.assertTrue(IsDisplayed(listedCountry));
			EngineController.reportInstance.reportStepPass("Travel record is deleted");
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("Travel record  is not deleted");
		}
		//EngineController.tierDown();
	}
	

}
