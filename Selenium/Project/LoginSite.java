package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginSite {
	
WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
@Test
	public void verifyWebHeading() throws InterruptedException {
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
	
	Thread.sleep(20000);
	driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("root");
	driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("pa$$w0rd");
	driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
	System.out.println("Logged in successfully");
	
}
@AfterTest
public void afterMethod() {
	driver.close();
}
}