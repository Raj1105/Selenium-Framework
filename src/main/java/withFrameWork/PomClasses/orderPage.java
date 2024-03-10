package withFrameWork.PomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import withFrameWork.AbstractClass.abstractComponent;

public class orderPage extends abstractComponent {

	public orderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tbody td:nth-child(3)")
	List<WebElement> orderProducts;
	
	public Boolean verifyOrderProduct(String productName) throws InterruptedException {
		Thread.sleep(1000);
		Boolean match = orderProducts.stream().anyMatch(cartpro -> cartpro.getText().equals(productName));
		return match;
	}
}
