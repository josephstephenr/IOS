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

public class SignUpFeatures extends BaseClass implements PageElement {

	

	@When("I enter an invalid email")
	public void i_enter_an_invalid_email() throws Throwable {
		EngineController.reportInstance.createStep("When", "I enter an invalid email");
		BaseClass.driver = Driverlaunch.setUp();
			clickElement(LoginButton);
			clickElement(SignUpButton);
			clickElement(FirstNameTextBox);
			sendkeys(FirstNameTextBox, PropertyFile("FirstName", TestData));
			clickElement(DoneButton);
			clickElement(LastNameTestBox);
			clickElement(DoneButton);
			IsElementDisplayed(LastNameTestBox);
			clickElement(LastNameTestBox);
			sendkeys(LastNameTestBox, PropertyFile("LastName",TestData));
			clickElement(DoneButton);
			clickElement(NextButton);
		clickElement(NextButton);
		clickElement(EmailIDTextBox);
		sendkeys(EmailIDTextBox,PropertyFile("InvalidEmailID", TestData) );
		clickElement(DoneButton);
		clickElement(NextButton);
		
	 
	}

	@Then("I should see an error message about the invalid email")
	public void i_should_see_an_error_message_about_the_invalid_email() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should see an error message about the invalid email");
		
		try {
			Assert.assertTrue(IsElementDisplayed(InvaildMail));
			EngineController.reportInstance.reportStepPass("I should see an error message about the invalid email");
			
		} catch (Exception e) {
			
			EngineController.reportInstance.reportStepFail("user is not able to an error message about the invalid email");
			
		}
		clear(EmailIDTextBox);
	
	}

	@When("I enter my email , Phone number and set weak pasword")
	public void i_enter_my_email_phone_number_and_set_weak_pasword() throws Throwable {
		EngineController.reportInstance.createStep("When", "I enter my email , Phone number and set weak pasword");
		clickElement(EmailIDTextBox);
		String randomEmail = BaseClass.generateRandomEmail();
		sendkeys(EmailIDTextBox, randomEmail);
		clickElement(DoneButton);
		clickElement(NextButton);
		clickElement(countryDropDown);
		clickElement(CodeNo);
		clickElement(phoneTextBox);
		String randomPhone = BaseClass.generateRandomPhoneNumber();
		sendkeys(phoneTextBox, randomPhone);
		clickElement(DoneButton);
		clickElement(submitButton);
		clickElement(okBtn);
		clickElement(verifyLater);
		clickElement(newPaswwordTextBox);
		sendkeys(newPaswwordTextBox,PropertyFile("weakPassword", TestData) );
		clickElement(eyeOpen1);
		clickElement(DoneButton);
		
	  
	}

	@Then("I should see an error message about the weak password")
	public void i_should_see_an_error_message_about_the_weak_password() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should see an error message about the weak password");
		try {
			
			Assert.assertTrue(IsElementDisplayed(weakPassword));
			EngineController.reportInstance.reportStepPass("I should see an error message about the weak password ");
		} catch (Exception e) {
			EngineController.reportInstance.reportStepFail("user is not able to an error message about the weak password");
			
		}
		
		clear(newPaswwordTextBox);
	

	}

	@When("I enter my email , Phone number, set password and confirm a different password")
	public void i_enter_my_email_phone_number_set_password_and_confirm_a_different_password() throws Throwable {
		
		clickElement(newPaswwordTextBox);
		sendkeys(newPaswwordTextBox, PropertyFile("StrongPassword", TestData));
		clickElement(conPassword);
		sendkeys(conPassword, PropertyFile("DifferentPassword", TestData));
		clickElement(eyeOpen2);
		clickElement(DoneButton);
		clickElement(confirmBtn);
		
	  
	}

	@Then("I should see an error message about the password mismatch")
	public void i_should_see_an_error_message_about_the_password_mismatch() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should see an error message about the password mismatch");
		try {
			Assert.assertTrue(IsElementDisplayed(passMismatch));
			EngineController.reportInstance.reportStepPass("I should see an error message about the password mismatch ");
			
		} catch (Exception e) {
			EngineController.reportInstance.reportStepFail("user is not able to an error message about the password mismatch");
			
		}
		clear(conClear);
	}

	@When("I enter my email , Phone number, set password, confirm password and click on check boxes the next button in consent form")
	public void i_enter_my_email_phone_number_set_password_confirm_password_and_click_on_check_boxes_the_next_button_in_consent_form() throws Throwable {
		EngineController.reportInstance.createStep("When", "I enter my email , Phone number, set password, confirm password and click on check boxes the next button in consent form");
		clickElement(conClear);
		sendkeys(conClear, PropertyFile("SamePass", TestData));
		clickElement(DoneButton);
		clickElement(confirmBtn);
		clickElement(okBtn);
		clickElement(checkBox1);
		clickElement(checkBox2);
		clickElement(nxtBtn);
	
		Waits();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() throws Throwable {
		EngineController.reportInstance.createStep("Then", "I should be redirected to the home page");
		try{
			Assert.assertTrue(IsDisplayed(homeIcon));
			EngineController.reportInstance.reportStepPass("I should be redirected to the home page ");
				} catch (Throwable e) {
					EngineController.reportInstance.reportStepFail("user is not able to redirected to the home page");
				}

		
		
		Waits();
	//	clickElement(getBtn);
		
		
		
			}
	    
	}


