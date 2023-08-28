package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driverlaunch {
	  public static IOSDriver<IOSElement> iosDriver;

	public  static DesiredCapabilities dc = new DesiredCapabilities();
	   
	   public static IOSDriver<IOSElement> setUp() throws Throwable {
	      
	       dc.setCapability("testName", "IOS Test");
	       dc.setCapability(MobileCapabilityType.UDID,"00008020-000661A22E43002E");
	       dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"com.obs.travelpro");
	       iosDriver  = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	       iosDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       return iosDriver;
	   }
	   
	   public static WebDriver toLaunchSafari() throws Throwable {
		   dc.setCapability("testName", "IOS Test");
	       dc.setCapability(MobileCapabilityType.UDID,"00008020-000661A22E43002E");
	       dc.setBrowserName(MobileBrowserType.SAFARI);
	       iosDriver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

		return iosDriver;

	}
	   public void runAppInBackground(Duration duration) {
		   iosDriver.runAppInBackground(duration);
		    }
}
