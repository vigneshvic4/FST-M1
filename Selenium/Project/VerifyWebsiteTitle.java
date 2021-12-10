package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyWebsiteTitle {
WebDriver driver;

@BeforeTest
public void beforeMethod() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/lms");
	
}

	@Test
  public void VerifyTitle() throws InterruptedException {
String actualTitle = driver.getTitle();
String expectedTitle = "Alchemy LMS – An LMS Application";
Assert.assertEquals(expectedTitle, actualTitle);
System.out.println("Title verified");
driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();



  }

@AfterTest
public void afterMethod() {
	driver.close();
}
}

