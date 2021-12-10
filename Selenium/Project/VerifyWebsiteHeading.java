package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyWebsiteHeading {
WebDriver driver;	
	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
@Test
	public void verifyWebHeading() {

	WebElement pageHeading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[1]/div[2]/section/div[2]/div[2]/div[2]/div/div/div/div/div[1]/h1"));
	Assert.assertTrue(pageHeading.isDisplayed());
	System.out.println("Page heading verified");
	}
	@AfterTest
	public void afterMethod() {
		driver.close();
	}
}
