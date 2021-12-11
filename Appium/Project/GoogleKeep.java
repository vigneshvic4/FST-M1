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

public class GoogleKeep {

  private AndroidDriver<MobileElement> driver=null;
  WebDriverWait wait;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "Pixel_4_Emulator");
    desiredCapabilities.setCapability("platformName", "android");
    //desiredCapabilities.setCapability("automationName", "UiAutomator2");
   // desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appPackage", "com.google.android.keep");
    desiredCapabilities.setCapability("appActivity", ".activities.BrowseActivity");

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    wait = new WebDriverWait(driver, 10);
  }

  @Test (priority=1)
  public void addTask() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.findElementById("new_note_button").click();
	  driver.findElementById("editable_title").click();
	  driver.findElementById("editable_title").sendKeys("New Title");
	  driver.findElementById("edit_note_text").click();
	  driver.findElementById("edit_note_text").sendKeys("New Task");
	  driver.navigate().back();
	  driver.navigate().back();
	  System.out.print(driver.findElementById("index_note_title").getText());
	  System.out.print(driver.findElementById("index_note_text_description").getText());
	   assertEquals(driver.findElementById("index_note_title").getText(), "New Title");
  }
  @Test(priority=2)
  public void addTaskReminder() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.findElementById("new_note_button").click();
	  driver.findElementById("editable_title").click();
	  driver.findElementById("editable_title").sendKeys("Title with Reminder");
	  driver.findElementById("edit_note_text").click();
	  driver.findElementById("edit_note_text").sendKeys("Task with Reminder");
	  // Reminder setting
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_switch_to_list_view")));
	  driver.findElementById("menu_switch_to_list_view").click();//
	  driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]").click();
	  driver.findElementByXPath("//android.widget.TextView[@text='Afternoon']").click(); 
	  driver.findElementById("save").click();

	  //driver.findElementByXPath("//android.widget.LinearLayout[contains(@content-desc=\"Time - Currently selected\")]").click();
	  //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]");
	  //System.out.print(driver.findElementByXPath( "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[contains(@text='Pick')]").getText());
	  
		/*
		 * System.out.print(driver.findElementByXPath(
		 * "//android.widget.TextView[contains(@text='Pick')]").getText()); driver.
		 * findElementByXPath("//android.widget.TextView[@text='Pick a date & time']").
		 * click(); System.out.print(driver.
		 * findElementByXPath("//android.widget.TextView[contains( @content-desc='Time - Currently')]"
		 * ).getText()); driver.
		 * findElementByXPath("//android.widget.TextView[contains( @content-desc='Time - Currently')]"
		 * ).click();
		 * 
		 * driver.findElementByXPath("//android.widget.TextView[@text='Afternoon']").
		 * click(); driver.findElementById("save").click();
		 * assertEquals(driver.findElementById("reminder_chip").getText(),
		 * "Today, 1:00 PM");
		 */
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}

