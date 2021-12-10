package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NavigateToAnotherPage {
	WebDriver driver;	
	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");

	}
	@Test
	public void navigateAnotherPage() {
		
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).click();
		String myAccountTitle = driver.getTitle();
		String expectedAccTitle = "My Account – Alchemy LMS";
		Assert.assertEquals(myAccountTitle, expectedAccTitle);
		System.out.println("My Account Title verified");

	}
	@AfterTest
	public void afterMethod() {
		driver.close();
	}
}
