package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.script.runners.MobileHandlers;
import com.script.utils.CommonFunctions;

import MobilePages.ProductSearch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	AppiumDriver<MobileElement> driver;
    AppiumDriver appiumDriver = null;
	ProductSearch productsearch = null;
	String s = "sony tv 65 inch";
	
	public static Logger LOGGER = Logger.getAnonymousLogger();
	public static String apkPath = "/src/main/resources/MobileApkFiles/Amazon shopping.apk";
	
	@BeforeTest
	public void setup() throws MalformedURLException {
	
	}
	
	// Product selection and added to cart
	@Test
	public void productSearch() {
		productsearch = new ProductSearch(appiumDriver);
		CommonFunctions.waitForContentToLoad(appiumDriver);
		ProductSearch.verifyAuthenticationDispalyed();
		 LOGGER.info("Successfully verified Amazon header");
		 ProductSearch.clickOnSearch();
		 LOGGER.info("Successfully clicked on search button");
		 ProductSearch.entertext("sony tv 65 inch");
		 LOGGER.info("Successfully listed sony tv");
		 MobileHandlers.scrollScreenVerticalUp(0, 5);
		 ProductSearch.itemSelect();
		 LOGGER.info("Successfully clicked on sony tv and added to cart");
		 CommonFunctions.waitForContentToLoad(appiumDriver);
		 
	}
	
	// Product scroll and image resolution
	
	@Test
	public void productScrollAndImageResolution() {
		productsearch = new ProductSearch(appiumDriver);
		CommonFunctions.waitForContentToLoad(appiumDriver);
		ProductSearch.verifyAuthenticationDispalyed();
		LOGGER.info("Successfully verified Amazon header");
		MobileHandlers.scrollScreenVerticalUp(0, 5);
		LOGGER.info("Successfully done scrolling to half page");
		MobileHandlers.setQueryImageFolder();
		LOGGER.info("Successfully scrolled to resolution and set it"); 
	}
	
    @AfterTest
	public void teardown () {
		driver.close();
		driver.quit();
}
    }
	
	