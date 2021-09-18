package com.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class StartChrome {
	static WebDriver driver;
  
  public static WebDriver setCapabilitiesforAndroid() throws MalformedURLException {
	  DesiredCapabilities cap=new DesiredCapabilities();
	  
	  cap.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
	  cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  cap.setCapability(MobileCapabilityType.VERSION, "11");
	  URL url=new URL("http://0.0.0.0:4723/wd/hub");
	  
	  driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);	  
	  driver.get("http://test-monk.in/");
	  
	return driver;
	  
 
  }
  
}
