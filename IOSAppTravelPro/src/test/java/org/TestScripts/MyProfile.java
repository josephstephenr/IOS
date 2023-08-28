package org.TestScripts;

import org.Controller.EngineController;
import org.junit.Assert;
import org.openqa.selenium.By;

import driver.Driverlaunch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.PageElement;
import utilities.BaseClass;

public class MyProfile extends BaseClass implements PageElement{

	
		
		
	    


	@When("I navigate to the Profile section")
	public void i_navigate_to_the_profile_section() throws Throwable {
		EngineController.reportInstance.createStep("When", "I navigate to the Profile section");
		clickElement(settings);
		clickElement(MyProfileRightArrow);
	   
	}

	@Then("I should see name, email, and profile picture")
	public void i_should_see_name_email_and_profile_picture() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should see name, email, and profile picture");
		try {

			/*
			 * String mailText= getTextFromElement(myEmail); System.out.println(mailText);
			 * Assert.assertEquals(mailText,PropertyFile("validEmail",TestData));
			 * EngineController.reportInstance.reportStepPass("I should see my Email");
			 * String NoText= getTextFromElement(MyNo); System.out.println(NoText);
			 * Assert.assertEquals(NoText,PropertyFile("phoneNO",TestData));
			 */
			Assert.assertTrue(IsDisplayed(phone));
			EngineController.reportInstance.reportStepPass("I should see my phone number");
			Assert.assertTrue(IsDisplayed(email));
			EngineController.reportInstance.reportStepPass("I should see my email");
			
		} catch (Exception e) {
			EngineController.reportInstance.reportStepFail("user is not able see name, email, and profile picture ");
		}
		
	
	}


	@When("I click on the Edit Profile button ,Update first name , last name and click save button")
	public void i_click_on_the_edit_profile_button_update_first_name_last_name_and_click_save_button() throws Throwable {
		EngineController.reportInstance.createStep("When", "I click on the Edit Profile button ,Update first name , last name and click save button");
		   //  clickElement(settings);
			//clickElement(MyProfileRightArrow);
			clickElement(editButton);		
		UpdatedFirstName =	updateStringRandomly();
			sendkeys(firstName,UpdatedFirstName);
		 	lastName = updateLastName();
		sendkeys(LastName,lastName);
		click(DoneButton);
			 fullName =joinStrings(UpdatedFirstName,lastName );
		System.out.println(fullName);
		
		swipeUp();
		//waits();
		clickElement(dateOfBirth);
		
		clickElement(doneBtn);
		clickElement(gender1);
		clickElement(male);
		
		
		
		
		clickElement(updateBtn);
		
		
	}

	@Then("my profile information should be updated with the new first name and last first name")
	public void my_profile_information_should_be_updated_with_the_new_first_name_and_last_first_name() throws Throwable {
		EngineController.reportInstance.createStep("Then", "my profile information should be updated with the new first name and last first name");
	String updatedFullNmae=	getTextFromElement(fullname);
	
	try {
		Assert.assertNotEquals(updatedFullNmae, fullName);
		EngineController.reportInstance.reportStepPass("my profile information should be updated with the new first name and last first name");
	} catch (Exception e) {
		EngineController.reportInstance.reportStepFail("my profile information will not be updated with the new first name and last first name");
		
	}
	
	
	
	}

}
