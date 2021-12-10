package com.ibm.slenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
	
	    public static void main(String[] args) {

	        // Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();
	    
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/simple-form");
	        
	        //Find the page title and print it
	        String pageTitle = driver.getTitle();
	        System.out.println(pageTitle);
	        
	        //Find the input fields
	        WebElement firstName = driver.findElement(By.id("firstName"));
	        WebElement lastName = driver.findElement(By.id("lastName"));
	        WebElement email =driver.findElement(By.id("email"));
	        WebElement number =driver.findElement(By.id("number"));
	        
	      
	        //Enter text
	        firstName.sendKeys("Saahil");
	        lastName.sendKeys("Sharma");
	        
	        
	        //Enter the email
	        driver.findElement(By.id("email")).sendKeys("test@example.com");
	        
	        //Enter the contact number
	        driver.findElement(By.id("number")).sendKeys("1234567890");
	        
	        //Click Submit
	       // driver.findElement(By.cssSelector(".ui.green.button")).click();
	    
	        System.out.println("firstname: " + driver.findElement(By.id("firstName")).getText());
	        System.out.println("lastname: " + lastName.getText());
	        System.out.println("email: " + email.getText());
	        System.out.println("number: " + number.getText());
	        
	        //Close the browser
	        //driver.close();
	    }
	}
