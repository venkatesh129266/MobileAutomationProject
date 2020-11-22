package com.script.runners;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileHandlers {

	AppiumDriver<MobileElement> appiumDriver;
	AppiumDriver<MobileElement> driver;
	public MobileElement currentButton;
	public String appPackage;
	public static Logger LOGGER = Logger.getAnonymousLogger();
	
	public static void objExists(MobileElement locator) {
		try {
			By byEle = MobileHandlers.mobileElementBy(locator);
			LOGGER.info("objExists check completed successfully, Object exists ");
		} catch (Exception e) {
			e.printStackTrace();
			MobileDriverSettings.closeDriver();
			LOGGER.info("Closed appium driver");
			LOGGER.info("Error occurred while checking whether the object exists " + "Exception :" + e);
			
		}
		}
		
		public static By mobileElementBy(MobileElement mobileElement) {
			String mobileEle = mobileElement.toString();
			String locatorType, locator = null;
			if (mobileEle.contains("{") || mobileEle.contains("}")) {
				mobileEle = (mobileEle.substring(mobileEle.indexOf("{") + 1, mobileEle.indexOf("}")));
				locatorType = mobileEle.substring(mobileEle.indexOf(0) + 1, mobileEle.indexOf(": ")).replace("By.", "");
				locator = mobileEle.substring(mobileEle.indexOf(": ")).replaceFirst(": ", "");
			} else {
				mobileEle = mobileEle.replace("Located by By.", "");
				locatorType = StringUtils.substringBefore(mobileEle, ":");
				locator = StringUtils.substringAfter(mobileEle, ":").trim();

			}
			switch (locatorType) {
			case "xpath":
				return By.xpath(locator);
			case "css selector":
				return By.cssSelector(locator);
			case "id":
				return By.id(locator);
			case "tag name":
				return By.tagName(locator);
			case "name":
				return By.name(locator);
			case "link text":
				return By.linkText(locator);
			case "class name":
				return By.className(locator);
			}
			return null;

		}

	public void scrollScreenVertical(int scrollDepth) throws Exception {
		Dimension dimension = appiumDriver.manage().window().getSize();
		int x = (int) (dimension.getWidth() * 0.5);
		int startY = (int) (dimension.getHeight() * 0.5);
		int endY = (int) (dimension.getHeight() * 0.2);

		for (int i = 0; i < scrollDepth; i++) {
			appiumDriver.swipe(x, startY, x, endY, 400);
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
	}

	public void scrollScreenVerticalUp(int scrollDepth) throws Exception {
		Dimension dimension = appiumDriver.manage().window().getSize();
		int x = (int) (dimension.getWidth() * 0.5);
		int startY = (int) (dimension.getHeight() * 0.2);
		int endY = (int) (dimension.getHeight() * 0.5);

		for (int i = 0; i < scrollDepth; i++) {
			appiumDriver.swipe(x, startY, x, endY, 400);
			Thread.sleep(2000);
		}
		Thread.sleep(5000);
	}

	//this method is to scroll down the current scree for  N number of times with some delay
	public void scrollScreenVerticalDown(int scrollDepth,int delay) throws Exception {

		Dimension dimension = appiumDriver.manage().window().getSize();
		int x = (int) (dimension.getWidth() * 0.5);
		int startY = (int) (dimension.getHeight() * 0.2);
		int endY = (int) (dimension.getHeight() * 0.5);

		for (int i = 0; i < scrollDepth; i++) {
			appiumDriver.swipe(x, startY, x, endY, 400);
			Thread.sleep(delay);
		}
	}

	public static void click(MobileElement locator) {
		try {
			MobileWaitHelper.waitForElement(locator);
			locator.click();

			LOGGER.info("Click action completed successfully for the locator: " + locator);
		} catch (Exception e) {
			//MobileDriverSettings.closeDriver();
			e.printStackTrace();
			LOGGER.info("Error while performing the click action for the locator: " + locator + "Exception :" + e);
			Assert.assertEquals("Error while performing the click action for the locator: " + locator + "Exception :" + e);
		}
	}
		
	public void takeScreenShot() {
		try {

			File scrFile = appiumDriver.getScreenshotAs(OutputType.FILE);
			Thread.sleep(2000);
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
			String destDir = "screenshots";
			new File(destDir).mkdirs();
			String destFile = this.appPackage + "-" + dateFormat.format(new Date()) + ".png";
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			Thread.sleep(2000);
			System.out.println("Screen shot saved to " + destFile + " at " + destDir);

		} catch (Exception exp) {
			System.out.println("Exception in takeScreenShot function");
			System.out.println(exp.getMessage());
		}
		}
		
		public void backScreen(int index, int delay) throws Exception {
			for (int count = 1; count <= index; count++) {
				appiumDriver.navigate().back();
				Thread.sleep(delay);
			}
	}
		
		public void setQueryImageFolder() {
			Dimension size = driver.manage().window().getSize();
			log("Screen size: " + size.toString());
			if ((size.getWidth() <= 520) || (size.getHeight() <= 520)) {
			String screenshotsFolder = "low_resolution_images";
			}
			}

		public void setQueryImage() { 
			Dimension size = driver.manage().window().getSize();
			log("Screen size: " + size.toString());
			if ((size.getWidth() <= 0) || (size.getHeight() <= 1000)) {
			String screenshotsFolder = "low_resolution_images";
			}
			}
		private void log(String string) {
			// TODO Auto-generated method stub
			
		}

		public static void enterText(MobileElement typeText) {
			MobileElement locator = null;
			MobileWaitHelper.waitForElement(locator);
			locator.click();
			LOGGER.info("Click action completed successfully for the locator: " + locator);
			
		}

		public static boolean isElementExists(AppiumDriver<MobileElement> appiumDriver2, By xpath) {
			// TODO Auto-generated method stub
			return false;
		}
}

