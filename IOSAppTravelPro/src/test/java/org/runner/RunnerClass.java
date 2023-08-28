package org.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\josephstephenraja.p\\OneDrive - Optisol Business Solutions Private Limited\\Desktop\\rest assured\\Appium\\IOSAppTravelPro\\src\\test\\resources\\feature"},
glue = {"org.TestScripts","org.Controller"}, monochrome = true, dryRun = false,
	
// tags="@InvaildMailID",
 plugin = {"summary", "pretty", "html:target/cucumber-reports/cucumber-pretty",

        "json:target/cucumber-reports/CucumberTestReport.json"}, publish = true)

public class RunnerClass {
	
	

}
