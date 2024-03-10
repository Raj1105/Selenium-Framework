package withFrameWork.PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import withFrameWork.AbstractClass.abstractComponent;

public class productPage extends abstractComponent {

	public productPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	By productOverlay = By.cssSelector(".mb-3");
	By addTocartBtn = By.cssSelector(".card-body button:last-of-type");
	By addedSuccessfullyMsg = By.cssSelector(".ng-trigger-flyInOut");
	By spinner = By.cssSelector(".ng-animating");

	public WebElement getExpectedProduct(String productName) {
		waitUntilElementisLocated(productOverlay);
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addproductToCart(String product) {
		WebElement prod = getExpectedProduct(product);
		prod.findElement(addTocartBtn).click();
		waitUntilElementisLocated(addedSuccessfullyMsg);
		waitUntilElementisInvisible(spinner);
	}
}
