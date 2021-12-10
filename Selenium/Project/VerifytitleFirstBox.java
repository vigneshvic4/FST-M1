package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import junit.framework.Assert;

public class VerifytitleFirstBox {
	WebDriver driver;	
	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
	public void verifyFirstTitle() {
	WebElement firstboxTitle = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/h3"));
	Assert.assertTrue(firstboxTitle.isDisplayed());
	System.out.println("First box title verified");
	}
	@AfterTest
	public void afterMethod() {
		driver.close();
	}
}
