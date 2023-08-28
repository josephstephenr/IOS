package org.TestScripts;

import org.Controller.EngineController;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;

public class Logout extends BaseClass implements PageElement{
	@When("I click on logout and yes button in pop up")
	public void i_click_on_logout_and_yes_button_in_pop_up() throws Throwable {
		EngineController.reportInstance.createStep("When", "I click on logout and yes button in pop up");
		clickElement(settings);
		clickElement(logOut);
		clickElement(okButton);
		
		
	}

	@Then("I should be in entry screen of the app")
	public void i_should_be_in_entry_screen_of_the_app() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should be in entry screen of the app");
		try {
			Assert.assertTrue(IsElementDisplayed(tarvelDayImage));
			EngineController.reportInstance.reportStepPass("I should be in entry screen of the app");
		} catch (Throwable e) {
			EngineController.reportInstance.reportStepFail("user remains in the log out page");
		
		}
	
		EngineController.tierDown();
	}

	
}
