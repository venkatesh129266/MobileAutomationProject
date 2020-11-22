package com.script.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwitchToWindowPage {
	
	
	private AndroidDriver<WebElement> androidDriver = null;
	
	@FindBy(id = "win1")
	private AndroidElement NewWindow;	
	
	@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")
	private AndroidElement GoogleTxt ;
	
	@FindBy(id = "alertBox")
	private AndroidElement AlertClk;
	
	@FindBy(id = "promptBox")
	private AndroidElement PromptClk;
	
	@FindBy(id = "tables")
	private AndroidElement table;
	
	public SwitchToWindowPage(AndroidDriver<WebElement> androidDriver) {
		this.androidDriver  = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}
	
	public void CheckSwitchToWindow() throws InterruptedException
	{
		
		/*MobileHandlers.click(NewWindow);
		MobileHandlers.switchToNewWindow();
		MobileHandlers.enterText(GoogleTxt, "flower");
		MobileHandlers.switchToDefaultWindow();
		MobileHandlers.click(AlertClk);
		MobileHandlers.dismissAlert();
		MobileHandlers.click(PromptClk);*/
		

			
		
		
	}
}

