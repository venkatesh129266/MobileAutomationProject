package com.script.runners;

import java.sql.Driver;
import java.util.logging.Logger;

import org.openqa.selenium.remote.RemoteWebDriver;   
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileDriverSettings {
	
	
	static AppiumDriver<MobileElement> driver;
	public static Logger LOGGER = Logger.getAnonymousLogger();
  
public static void closeDriver() {
		
		getCurrentDriver().quit();
	
		LOGGER.info("Successfully closed current session");

	}


private static RemoteWebDriver getCurrentDriver() {
	// TODO Auto-generated method stub
	return null;
}
}

