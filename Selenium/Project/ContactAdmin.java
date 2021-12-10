package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactAdmin {
	WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
@Test
	public void contactAdmin() {

	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[4]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_0\"]")).sendKeys("Vignesh");
	driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_1\"]")).sendKeys("vigneshvic@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_3\"]")).sendKeys("Test Email");
	driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]")).sendKeys("Hi... How r u");
	driver.findElement(By.xpath("//*[@id=\"wpforms-submit-8\"]")).click();
	WebElement confirmation = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p"));
	System.out.println("Success Message:" + confirmation);
}
@AfterTest
public void afterMethod() {
	driver.close();
}
}