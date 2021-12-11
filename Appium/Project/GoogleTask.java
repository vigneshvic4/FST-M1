package project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTask {

  private AndroidDriver<MobileElement> driver;
  WebDriverWait wait;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "Pixel_4_Emulator");
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("automationName", "UiAutomator2");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appPackage", "com.google.android.apps.tasks");
    desiredCapabilities.setCapability("appActivity", ".ui.TaskListsActivity");

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void addTask() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("welcome_get_started")));
	  driver.findElementById("welcome_get_started").click();
	  
	  String[] taskToAdd= {"Complete Activity with Google Tasks","Complete Activity with Google Keep",
			  "Complete the second Activity Google Keep"
	  };
		
		  for(String i:taskToAdd) {
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")))
		  ; driver.findElementById("tasks_fab").click();
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(
		  "add_task_title"))); //System.out.print(i);
		  driver.findElementById("add_task_title").sendKeys(i);
		  driver.findElementById("add_task_done").click(); }
		 
     wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("tasks_item_completed_check"),3));
     List<MobileElement> taskAdded=driver.findElementsById("task_item_layout");
     System.out.print(taskAdded.size());
     System.out.print(taskAdded.get(2).getAttribute("content-desc"));
     assertEquals(taskAdded.size(), 3);
     assertEquals(taskAdded.get(0).getAttribute("content-desc"), "Complete the second Activity Google Keep");
          
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}

