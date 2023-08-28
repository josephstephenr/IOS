package report;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.GherkinKeyword;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.gherkin.model.Feature;

import com.aventstack.extentreports.gherkin.model.Scenario;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.BaseClass;

	 

	public class CucumberReport extends BaseClass {

	public static ExtentHtmlReporter reporter;

	public static ExtentReports extent;

	public static ExtentTest feature;

	public static ExtentTest scenario, step;

	public static String testDetail;

	private static CucumberReport reportRuntimeListener;

	 

	public CucumberReport getReportInstance() {

	if (reportRuntimeListener == null) {

	reportEngine();

	reportRuntimeListener = new CucumberReport();

	return reportRuntimeListener;

	}

	return reportRuntimeListener;

	}

	 

	public ExtentReports reportEngine() {

	extent = new ExtentReports();

	reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//TravelTaxDay.html");

	extent.setSystemInfo("DocumentTile", "TravelTaxDay_Automation");

	extent.setSystemInfo("ReportName", "TravelTaxDay");

	extent.attachReporter(reporter);

	return extent;

	 

	}

	 

	public void reportCreateFeature(String title) {

	feature = extent.createTest(Feature.class, title);

	}

	 

	public void reportCreateScenario(String Scenario) {

	scenario = feature.createNode(Scenario.class, Scenario);

	}

	 

	public void reportScenarioPass(String Details) {

	try {

	String s = captureScreenshot();

	scenario.pass(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());

	} catch (IOException e) {

	e.printStackTrace();

	}

	}

	 

	public void reportScenarioFail(String Details) {

	try {

	String s = captureScreenshot();

	scenario.fail(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());

	} catch (IOException e) {

	e.printStackTrace();

	}

	}

	 

	public void createStep(String keyword, String stepName) throws ClassNotFoundException {

	switch (keyword) {

	case "Given":

	step = scenario.createNode(new GherkinKeyword("Given"), stepName);

	break;

	case "And":

	step = scenario.createNode(new GherkinKeyword("And"), stepName);

	break;

	case "When":

	step = scenario.createNode(new GherkinKeyword("When"), stepName);

	break;

	case "Then":

	step = scenario.createNode(new GherkinKeyword("Then"), stepName);

	break;

	default:

	step = scenario.createNode(new GherkinKeyword("And"), stepName);

	}

	}

	 

	public void reportStepPass(String Details) {

	try {

	String s = captureScreenshot();

	step.pass(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());

	} catch (IOException e) {

	e.printStackTrace();

	}

	}

	 

	public void reportStepFail(String Details) {

	try {

	String s = captureScreenshot();

	step.fail(Details, MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());

	} catch (IOException e) {

	e.printStackTrace();

	}

	}

	 

	public void reportCooldown() {

	extent.flush();

	}

	 

	public void reportStepExpection(Exception e) {

	step.fail(e);

	}

	 

	public void reportFeatureLog(String info) {

	feature.log(Status.INFO, info);

	}

	 

	public void reportFeatureLogPass(String info) {

	feature.log(Status.PASS, info);

	}

	 

	public void reportFeatureLogFail(String info) {

	feature.log(Status.FAIL, info);

	}

	 

	public void reportFeatureLogFatal(String Info) {

	feature.log(Status.WARNING, Info);

	}

	 

	 

	}


