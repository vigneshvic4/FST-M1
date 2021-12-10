package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountNumberOfCourses {

	WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
	}
@Test
	public void countCourse() {
	System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ld-course-list-items row']//div[@class='ld_course_grid col-sm-8 col-md-4 ']"))).size());
}

@AfterTest
public void afterMethod() {
	driver.close();
}
}
