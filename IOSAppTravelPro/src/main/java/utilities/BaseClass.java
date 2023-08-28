package utilities;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption; 
import java.time.Duration; 
import io.appium.java_client.MobileBy;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driverlaunch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;


public class BaseClass extends Driverlaunch{
	public static WebDriver driver;
	public static AppiumDriver Adriver;
	public static WebElement check;
	public static Select s;
	public static String fullName;
	public static String UpdatedFirstName;
	public static String lastName;
	public static AndroidDriver adriver;
	public static File Location;
	public static String properties; 
	public static String myString;
	public static String TestData = System.getProperty("user.dir") + "//TestData.properties";
	public static Random random;
	public static String joinedString;
	public static String popMessage;
	public static String day;
	public static String day1;
	private static Object AppiumSeverWebDriver;
	
	
	public static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void browserlaunch(String url) {
		WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void ScrollDownBy1(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", locator);
	}
	public String PropertyFile(String TestData, String locatorfile) throws Throwable {
		Properties prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		prop.load(File);
		return prop.getProperty(TestData);
	}

	public static void sendData(By Locator, String Data) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
			Element.sendKeys(Data);
		} catch (Exception e) {
			throw new Exception("Unable to send the data" + Locator);
		}
	}
	
	public boolean IsEditable(By locator) {
		WebElement element = driver.findElement(locator);
		element.isEnabled();
		return true;

	}
	public static boolean IsDisplayed(By locator) {
		WebElement element = driver.findElement(locator);
		element.isDisplayed();
		return true;
		

	}
	
	public static boolean contains(By locator) {
		WebElement element= driver.findElement(locator);
		String textBoxText =element.getAttribute("value");
		if (!textBoxText.isEmpty()) {
            System.out.println("Text box contains text: " + textBoxText);
        } else {
            System.out.println("Text box is empty");
        }
		return true;

	}

	public void sendkeys(By locator,String s) throws Exception
	{
		try {
			WebElement element=driver.findElement(locator);
			element.sendKeys(s);
		} catch (Exception e) {
			throw new Exception("unable to send the data"+locator);

		}
	}

	public static void click(By locator) throws Exception {
		try {
			WebElement element = driver.findElement(locator);
			element.click();

		} catch (Exception e) {
			throw new Exception("unable to click the element");

		}
	}

	public static void clear(By locator) throws Exception {
		try {
			WebElement element = driver.findElement(locator);
			element.clear();

		} catch (Exception e) {
			throw new Exception("unable to clear the element" + locator);

		}
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public static void action(By locator) throws Exception {
		try {
			WebElement src = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.moveToElement(src).build().perform();
		} catch (Exception e) {
			throw new Exception("unable to move the element");
		}
	}

	public static String captureScreenshot() throws IOException {

		File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
			String shot = new String(encoded, StandardCharsets.US_ASCII);
			return shot;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;

	}

	public static void selecttxt(By locator, String str) {
		s = new Select((WebElement) locator);
		s.selectByVisibleText(str);
	}

	public static void ScrollDown() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	
	public static void ScrollDownBy(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", locator);
	}

	public static void scrollAndClick(String visibleText) {
		Adriver.findElementByCssSelector(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public void scrollNew() {

		Adriver.executeScript("experitest:client.swipe(\"Down\", 340, -400)");

	}

	public static void Frameid(String s) {
		driver.switchTo().frame(s);
	}

	public void DefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void fluentwait(By locator) {
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		waits.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static boolean IsElementDisplayed(By Locator) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement ElementDisplay = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		return ElementDisplay.isDisplayed();
	}

	public static void waitForElement(By Locator) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	
	}

	/*
	 * public static void elementtobeclick(By Locator) { WebDriverWait wait = new
	 * WebDriverWait(driver, 120);
	 * wait.until(ExpectedConditions.elementToBeClickable(Locator)); }
	 */
	public static void clickElement(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}


	public static void clearkeys(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.clear();
	}
	   public static String generateRandomEmail() {
	        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        int length = 3; // Length of the generated email ID
	        StringBuilder email = new StringBuilder();

	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(allowedChars.length());
	            email.append(allowedChars.charAt(index));
	        }

	        email.append("@yopmail.com"); // Append a domain name of your choice

	        return email.toString();
	    }
	public static void toScrol() {
		Adriver.executeScript("experitest:client.swipe(\"Down\", 256, 567)");

	}

	public static void Waits() throws Throwable {
		Thread.sleep(6000);
	}
	 public static void ScrollDown1() throws Throwable {



	       JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    }

	public static void waits() {
		Adriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}

	public static void ScrollClick(By updatebtn) {
		adriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ updatebtn + "\").instance(0))")
				.click();
	}
	
	public static void scrollclick(String text) {
		String uiSelector = "new UiSelector().textMatches(\"" + text + "\")";
		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
				+ ");";
		adriver.findElementByAndroidUIAutomator(command);
	}

	public static void NewScrollClick(String visibleText) {
		adriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	public static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        // Generate the first digit of the phone number (can't be 0 or 1)
        int firstDigit = random.nextInt(8) + 2;
        phoneNumber.append(firstDigit);

        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10);
            phoneNumber.append(digit);
        }

        return phoneNumber.toString();
    }
	  public static String getTextFromElement(By locator) {
	        WebElement element = driver.findElement(locator);
	        String text = element.getText();
	        return text;
	    }
	  public static String getRandomString(int length) {
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            char randomLetter = LETTERS.charAt(random.nextInt(LETTERS.length()));
	            sb.append(randomLetter);
	        }

	        return sb.toString();
	    }
	  

	      public BaseClass() {
	          myString = "Stephen";
	          lastName ="Tester";
	      }

	      public static String updateStringRandomly() {
	          Random random = new Random();
	          char randomLetter = (char) (random.nextInt(26) + 'A'); // Generate a random capital letter
	          myString += randomLetter;
	          return myString;
	      }
	      
	     
	      public static String updateLastName() {
	    	  Random random = new Random();
	          char randomLetter = (char) (random.nextInt(26) + 'A'); // Generate a random capital letter
	          lastName += randomLetter;
	          return lastName;
			

		}
	      public static String toStoreTextInVaraiable(By locator) {
	String	text = driver.findElement(locator).getText();
	return text;

		}
	      
	     
//	      public void scrollAndClick(String visibleText) {
//	          driver.findElementByCssSelector(
//	                  "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
//	                          + visibleText + "\").instance(0))")
//	          .click();  
//	      }

	  public static void scroll(String visibleText) {

//	          mdriver.findElementByCssSelector(
//	                  "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
//	                          + visibleText + "\").instance(0))");
		
	          Adriver.findElementByCssSelector("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                      + visibleText + "\").instance(0))");
	      }
	  
	  public static void swipeUp() { 
		  org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		//  Dimension size = driver.manage().window().getSize();

	  int startX = size.width / 2; 

	 int startY = (int) (size.height * 0.8); 

	 int endY = (int) (size.height * 0.2); 

	 TouchAction action = new TouchAction((PerformsTouchActions) driver); action.press(PointOption.point(startX, startY)) 
	 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) .

	 moveTo(PointOption.point(startX, endY)) 

	 .release() 

	 .perform(); }
	  public static void scrollT(String visibleText) {
		  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		  AppiumDriver<MobileElement> driverWeb = new AppiumDriver<>(desiredCapabilities);
		  driverWeb.findElementByCssSelector("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                  + visibleText + "\").instance(0))");

	}
	  public static String concatenateStrings(String... strings) {
	        StringBuilder sb = new StringBuilder();
	        for (String str : strings) {
	            sb.append(str);
	        }
	        return sb.toString();
	    }
	 

	    public static String joinStrings(String string1, String string2) {
	        return joinedString = string1 + string2;
	    }
	  public static String joinStringsAndStore(String string1, String string2, String storeVariable) {
	        joinedString = string1 + string2;
	        storeVariable = joinedString;
	        return storeVariable;
	    }
	  public  static void selectDateTime(IOSDriver<IOSElement> Idriver) {
	        // Open the app or navigate to the screen containing the date time picker

	        // Locate the date time picker element
	        IOSElement dateTimePicker = driver.findElement(By.xpath("//XCUIElementTypeDatePicker"));

	        // Get the size and coordinates of the date time picker element
	        org.openqa.selenium.Dimension size = dateTimePicker.getSize();
	        int centerX = (int) (dateTimePicker.getLocation().getX() + (size.getWidth() / 2));
	        int centerY = (int) (dateTimePicker.getLocation().getY() + (size.getHeight() / 2));

	        // Perform swipe gestures to select the desired date and time
	        // Example: Select date "June 14, 2023" and time "9:30 AM"
	     //   swipeToElement(Idriver, ce
	        //		nterX, centerY, centerX, centerY - 300); // Swipe up to select the year
	    //    swipeToElement(Idriver, centerX, centerY, centerX, centerY - 150); // Swipe up to select the month
	    //    swipeToElement(Idriver, centerX, centerY, centerX, centerY - 100); // Swipe up to select the day
	     //   swipeToElement(Idriver, centerX, centerY, centerX, centerY - 50);  // Swipe up to select the hour
	     //   swipeToElement(Idriver, centerX, centerY, centerX, centerY);       // Swipe down to select the minutes

	        // Other actions you want to perform after selecting the date and time

	        // Close the app or perform other cleanup steps
	  
	    }
	  
	  public static void toReset() {
		  iosDriver.closeApp();
		  iosDriver.launchApp();

	}

	    public  static void swipeToElement(IOSDriver<IOSElement> driver, int startX, int startY, int endX, int endY) {
	        driver.performTouchAction(
	                new io.appium.java_client.TouchAction<>(driver)
	                        .press(PointOption.point(startX, startY))
	                        .moveTo(PointOption.point(endX, endY))
	                        .release()
	        );
	    }
		
	    public static void reset() {
			dc.setCapability("fullReset", true);

		}
	    
	    public static void IosScroll(String visibleText) {
	        MobileElement element = driver.findElement(MobileBy.iOSNsPredicateString("visible = 1 AND name CONTAINS '" + visibleText + "'"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	    }

	    
	    public static void start() {
	    

		}
	}
	  


	 
  


