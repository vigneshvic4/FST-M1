package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifytitleSecondCourse {
	
	WebDriver driver;	
	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
	@Test
	public void verifySecondPopularTitle() {
	WebElement popularCoursetitle = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div/div[2]/div/div/div/div[2]/article/div[2]/h3"));
	Assert.assertTrue(popularCoursetitle.isDisplayed());
	System.out.println("Second popular title verified");
	}
	@AfterTest
	public void afterMethod() {
		driver.close();
	}

}
