package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class TS_Home {
	WebDriver driver;
  @Test
  public void TC_VerifyLoginButtonCLickable() throws InterruptedException {
	  WebElement loginButton=driver.findElement(By.linkText("Login"));
	  boolean checkPresent=loginButton.isDisplayed();
	  if(checkPresent)
		  System.out.println("Button is displayed");
	  
	  boolean isclickable=loginButton.isEnabled();
	  if(isclickable)
		  System.out.println("Login button is enabled");
	  Thread.sleep(5000);
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	 driver= StartChrome.setCapabilitiesforAndroid();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }


}
