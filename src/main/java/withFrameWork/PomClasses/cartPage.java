package withFrameWork.PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import withFrameWork.AbstractClass.abstractComponent;

public class cartPage extends abstractComponent {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = " .totalRow button")
	WebElement checkoutBtn;

	By cartOverlay = By.cssSelector(".cartSection h3");
	By checkoutBtnOverlay = By.cssSelector(".totalRow button");

	public Boolean verifyProduct(String productName) {
		waitUntilElementisLocated(cartOverlay);
		Boolean match = cartProducts.stream().anyMatch(cartpro -> cartpro.getText().equals(productName));
		return match;
	}

	public checkoutPage redirectToCheckOutpage() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		waitUntilElementisLocated(checkoutBtnOverlay);
		executor.executeScript("arguments[0].click();", checkoutBtn);
		checkoutPage ckp = new checkoutPage(driver);
		return ckp;
	}
}
