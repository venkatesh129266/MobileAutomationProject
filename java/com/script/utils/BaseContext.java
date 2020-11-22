package com.script.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.script.runners.MobileHandlers;

public class BaseContext<ProductSearch> {
	
	AppiumDriver<MobileElement> driver;
	public static AppiumDriver appiumDriver;
	ProductSearch productsearch = null;
	public static Logger LOGGER = Logger.getAnonymousLogger();
	
	public static String apkPath = "/src/main/resources/MobileApkFiles/Amazon shopping.apk";
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
		capabilities.setCapability(MobileCapabilityType.UDID, "");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		capabilities.setCapability(MobileCapabilityType.APP, "/src/test/resources/apps/Amazon shopping.apk");
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.web.MShopWebGatewayActivity");
		
        URL url = new URL ("http://127.0.01:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, capabilities);
		String sessionId = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}