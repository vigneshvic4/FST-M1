package project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleChrome {

  private AndroidDriver<MobileElement> driver=null;
  WebDriverWait wait;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "Pixel_4_Emulator");
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("automationName", "UiAutomator2");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appPackage", "com.android.chrome");
    desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    wait = new WebDriverWait(driver, 20);
    
  }

  @Test (priority=1)
  public void addTask() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("terms_accept")));
	  driver.findElementById("terms_accept").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("negative_button")));
	  driver.findElementById("negative_button").click();
	  driver.get("https://www.training-support.net/selenium");
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\")"));
	  //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("search_box_text")));
		/*
		 * driver.findElementById("search_box_text").click();
		 * driver.findElementById("url_bar").click();
		 * driver.findElementById("url_bar").sendKeys(
		 * "https://www.training-support.net/selenium");
		 * driver.findElementById("url_bar").click();
		 * driver.findElementById("edit_note_text").sendKeys("New Task");
		 * driver.navigate().back(); driver.navigate().back();
		 * System.out.print(driver.findElementById("index_note_title").getText());
		 * System.out.print(driver.findElementById("index_note_text_description").
		 * getText());
		 * assertEquals(driver.findElementById("index_note_title").getText(),
		 * "New Title");
		 */
	  
	  System.out.print("Inside chrome");
  }
  
  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}

