package com.script.android;


import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class AndroidUtil {
	public static Logger LOGGER = Logger.getLogger(AndroidUtil.class);
	private AndroidDriver<WebElement> androidDriver = null;
	private WebDriver webdriver;
	private WebDriver driver;

	public AndroidUtil(String remoteUrl) {
		
		try {
			androidDriver = new AndroidDriver<WebElement>(new URL(remoteUrl), this.getDesiredCapabilities());
			setAndroidDriver(androidDriver);
			this.driver = androidDriver;
		} catch (Exception e) {
			LOGGER.error("AndroidDriver initilization issues : " + e.getMessage());
			throw new WebDriverException("AndroidDriver initilization issues : " + e.getMessage());
			
			
		}
		this.setWebdriver(this.driver);
	}

	private Capabilities getDesiredCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public AndroidUtil() {
		throw new WebDriverException("AndroidDriver initilization issues");
	}

	public void setAndroidDriver(AndroidDriver<WebElement> driver) {
		this.androidDriver = driver;
	}

	public AndroidDriver<WebElement> getAndroidDriver() {
		return androidDriver;
	}

	public Options manage() {
		return this.driver.manage();
	}

	public WebDriver getWebdriver() {
		return webdriver;
	}

	public void setWebdriver(WebDriver webdriver) {
		this.webdriver = webdriver;
	}
}
