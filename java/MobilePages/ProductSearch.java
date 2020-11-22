package MobilePages;

import java.util.logging.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.script.runners.MobileHandlers;
import com.script.utils.BaseContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class ProductSearch {
	
	AppiumDriver<MobileElement> appiumDriver;
	ProductSearch productsearch = null;
	
	public static Logger LOGGER = Logger.getAnonymousLogger();
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Home']")
	MobileElement an_headerAmazon;
	
	@FindBy(xpath = "//android.widget.EditText[@text ='Search']")
	MobileElement an_search;
	
	@FindBy(xpath = "//android.view.View[@text = 'Entertext']")
	MobileElement typeText;
	
	@FindBy(xpath = "(//i[@class='icon ion-android-arrow-back'])[1]")
	MobileElement itemClick;	


public ProductSearch(AppiumDriver<MobileElement> appiumDriver) {
	this.appiumDriver = BaseContext.appiumDriver;
	PageFactory.initElements(new AppiumFieldDecorator(BaseContext.appiumDriver), this);
}


public void verifyAuthenticationDispalyed() {
	MobileHandlers.click(an_headerAmazon);
}

public void clickOnSearch() {
	MobileHandlers.click(an_search);
}

public void entertext() {
	MobileHandlers.enterText(typeText);
}

public void itemSelect() {
	MobileHandlers.click(itemClick);
}






}