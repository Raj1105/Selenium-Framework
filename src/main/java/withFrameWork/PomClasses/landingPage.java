package withFrameWork.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import withFrameWork.AbstractClass.abstractComponent;

public class landingPage extends abstractComponent {

	WebDriver driver;

	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#userEmail")
	WebElement userEmail;

	@FindBy(css = "#userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;

	//div[class*='ng-trigger-flyInOut']
	@FindBy(css = "div[class*='ng-trigger-flyInOut']")
	WebElement errorLoginMsg;
	
	public void goToURL() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String LoginErrorMsg() {
		waitUntilElementisLocatedByWebElementLocator(errorLoginMsg);
		String msg = errorLoginMsg.getText();
		return msg;
	}

	public productPage loginPage(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		productPage pp = new productPage(driver);
		return pp;
	}

}
