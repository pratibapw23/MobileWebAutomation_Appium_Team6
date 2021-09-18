package com.tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TS_Register {
	WebDriver driver;
  @Test
  public void TC_Userid_01() throws InterruptedException, IOException {
	  	driver.findElement(By.linkText("Register")).click();
		String username=randomstring();
		driver.findElement(By.name("username")).sendKeys(username);
		String firstname=randomstring();
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		String lastname=randomstring();
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		String email=randomstring();
		driver.findElement(By.name("email")).sendKeys(email+"@gmail.com");

		driver.findElement(By.name("password1")).sendKeys("Temp@12345");
		driver.findElement(By.name("password2")).sendKeys("Temp@12345");
		driver.findElement(By.name("mobile_number")).sendKeys("8787878787");
		Select genderUi = new Select(driver.findElement(By.name("gender")));
		genderUi.selectByValue("Female");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/form/div/div[11]/input")).click();
		Thread.sleep(5000);
		
		assertEquals(driver.getTitle(), "Login to iDrive");
		System.out.println("User registered successfully");
		
		
		
  }
  public static String randomstring() {
	  int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();

	   return generatedString;
	}
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  driver=StartChrome.setCapabilitiesforAndroid();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
