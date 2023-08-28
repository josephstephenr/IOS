package org.TestScripts;

import org.Controller.EngineController;
import org.junit.Assert;
import org.openqa.selenium.By;

import driver.Driverlaunch;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;

public class EditTravelRec extends BaseClass implements PageElement {
		@When("Add travel notes to the travel record")
		public void add_travel_notes_to_the_travel_record() throws Throwable {
			EngineController.reportInstance.createStep("When", "Add travel notes to the travel record");
			clickElement(non);
			clickElement(user);
			clickElement(menuOption1);
			clickElement(edit);
			swipeToElement(iosDriver, 624, 1220, 624,716);
			Waits();
			sendkeys(travelNotes, PropertyFile("TravelNotes", TestData));
			clickElement(DoneButton);
			swipeToElement(iosDriver, 640, 1120, 640,448);
			Waits();
			clickElement(updateBtn1);
			//clickElement(yesBtn);
			//Waits();
		}

		@Then("Edited changes needs to be reflected travel record")
		public void edited_changes_needs_to_be_reflected_travel_record() throws Throwable {
			EngineController.reportInstance.createStep("Then", "Edited changes needs to be reflected travel record");
		//	IsDisplayed(editedNotes);
			IsElementDisplayed(editedNotes);
			try {
				Assert.assertEquals(getTextFromElement(travelNotes),getTextFromElement(editedNotes));
				EngineController.reportInstance.reportStepPass("Travel note is updated");
			} catch (Exception e) {
				
				EngineController.reportInstance.reportStepFail("Travel note is not updated");
			}


}}
