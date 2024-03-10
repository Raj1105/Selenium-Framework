package withFrameWork.PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import withFrameWork.AbstractClass.abstractComponent;

public class checkoutPage extends abstractComponent {
	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-group input")
	WebElement inputField;

	@FindBy(css = "section[class*=ta-results] button span")
	List<WebElement> allCountryName;

	@FindBy(css = ".actions a")
	WebElement placeOderBtn;

	@FindBy(css="#toast-container .toast-title")
	WebElement emptyCountryInputErrorMsg;
	
	By inputOverlay = By.cssSelector("section[class*=ta-results]");
	By confirmMsgOverlay = By.cssSelector("td h1");

	public void passValueToInputFiled(String input) {
		inputField.sendKeys(input);
		waitUntilElementisLocated(inputOverlay);
	}

	public void selectCountryFromList(String selectCountry) {
		for (WebElement cou : allCountryName) {
			if (cou.getText().equalsIgnoreCase(selectCountry)) {
				Actions action = new Actions(driver);
				action.moveToElement(cou).click().build().perform();
				break;
			}
		}
	}
	public String countryEmptyFieldValidation() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		waitUntilElementisLocatedByWebElementLocator(placeOderBtn);
		executor.executeScript("arguments[0].click();", placeOderBtn);
		waitUntilElementisLocatedByWebElementLocator(emptyCountryInputErrorMsg);
		return emptyCountryInputErrorMsg.getText();
		
	}

	public orderPlacedPage clickOnPlaceorderBtn() {
		waitUntilElementisLocatedByWebElementLocator(placeOderBtn);
		placeOderBtn.click();
		waitUntilElementisLocated(confirmMsgOverlay);
		orderPlacedPage opp = new orderPlacedPage(driver);
		return opp;
	}
}
