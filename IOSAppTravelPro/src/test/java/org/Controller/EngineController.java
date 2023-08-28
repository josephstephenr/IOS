package org.Controller;
import java.io.IOException;

import java.net.MalformedURLException;

import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import report.CucumberReport;

public class EngineController {
	public String feature, scenario;

	public static CucumberReport reportInstance;

	 

	 

	public static String mFeature = "";

	 

	@Before

	public void beforeEngine(Scenario initConfig) throws MalformedURLException {

	 

	reportInstance = new CucumberReport().getReportInstance();

	if (!mFeature.equals(initConfig.getName().toString().split("-")[0])) {

	reportInstance.reportCreateFeature(initConfig.getName().toString().split("-")[0]);

	mFeature = initConfig.getName().toString().split("-")[0];

	}

	reportInstance.reportCreateScenario(initConfig.getName().toString().split("-")[1]);

	}

	 

	@After

	public static void tierDown() throws IOException {

	reportInstance.reportCooldown();

	}

	
}
