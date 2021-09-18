package com.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TS_Login {
	WebDriver driver;
  @Test
  public void TC_VerifyLogin_Functionality() throws InterruptedException {
	  driver.findElement(By.linkText("Login")).click();
	  driver.findElement(By.name("username")).sendKeys("prati99");
	  driver.findElement(By.name("password")).sendKeys("Password@1234");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
	  System.out.println("Logged In successfully");
	  
	  Thread.sleep(2000);
	  System.out.println("Searching file by extension");
	  driver.findElement(By.name("search")).sendKeys(".jpg");
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/button")).submit();
	  Thread.sleep(3000);
	  System.out.println("Verified..Searching file by extension");
	  
	  System.out.println("Searching all files by empty search..");
	  driver.findElement(By.name("search")).clear();
	  driver.findElement(By.name("search")).sendKeys("");
	  driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/button")).submit();
	  Thread.sleep(4000);
	  System.out.println("Verified..Searching all files by empty search");
	  
  }
  @Test
  public void TC_VerifyFirstname() throws InterruptedException
  {
	  driver.findElement(By.linkText("Login")).click();
	  driver.findElement(By.name("username")).sendKeys("prati99");
	  driver.findElement(By.name("password")).sendKeys("Password@1234");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
	  String fullname[]=driver.findElement(By.className("name")).getText().split(" ");
	  String ActualFirstName=fullname[1];
	  if(ActualFirstName.equals("pratibha"))
		  System.out.println("First name matches: verified successfully");
	  
  }
  @BeforeMethod
  public void beforeClass() throws MalformedURLException {
	 driver= StartChrome.setCapabilitiesforAndroid();
  }

  @AfterMethod
  public void afterClass() {
	  driver.quit();
  }

}
