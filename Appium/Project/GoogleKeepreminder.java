package project;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class GoogleKeepreminder {
	
	AndroidDriver<MobileElement> driver = null;
	
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Emulator");
        caps.setCapability("platformName", "android");
		/*
		 * caps.setCapability("automationName", "UiAutomator2");
		 * caps.setCapability("ensureWebviewsHavePages", true);
		 */
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);
        // Instantiate Appium Driver
        URL remoteURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteURL, caps);
    }
    @Test
    public void Task() {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	
    	
    	//Adding Tasks
    	
    	// ---- Create Notes
    	
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));	
        driver.findElementById("new_note_button").click();
        // ---- Title
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
        driver.findElementById("editable_title").click();
        driver.findElementById("editable_title").sendKeys("Nikhil Notes with Reminder");
        // ---- Notes content
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
        driver.findElementById("edit_note_text").sendKeys("This is my notes for Appium Project with Reminder");
        // ---Set Reminder
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_switch_to_list_view")));
        driver.findElementById("menu_switch_to_list_view").click();
        driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]").click();
        //--Close page
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        // Assertions
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_title")));
    	String result = driver.findElementById("index_note_title").getText();
    	System.out.println(result);
    	Assert.assertEquals(result, "Notes with Reminder");
    	
    	//-- Open task with reminder
        driver.findElementByXPath("//android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").click();
        // Assertions
    	String rem = driver.findElementById("reminder_chip_text").getText();
    	System.out.println(rem);
    	Assert.assertEquals(rem, "Tomorrow, 8:00 AM");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}