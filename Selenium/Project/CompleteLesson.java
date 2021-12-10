package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompleteLesson {
WebDriver driver;

@BeforeTest
public void beforeMethod() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/lms");
	
}
@Test
public void completeLess() {
	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a")).click();
	driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[1]/article/a/img")).click();
	driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[1]/div[1]/a/div[2]")).click();
	driver.findElement(By.xpath("")).click();
}
@AfterTest
public void afterMethod() {
	driver.close();
}
}