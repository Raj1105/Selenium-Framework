package javaPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class childClass2 extends parentClass {
public WebElement prod;
public WebDriverWait wait;
	public childClass2(WebDriver driver) {
		super(driver);

	}

	public void addProduct(String expectedProduct) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		// get all product and then select the needed product and then click to add to
		// cart
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(expectedProduct))
				.findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//wait for overlay to disappear and product to be added message visible and then click on cart navigation
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-trigger-flyInOut")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

				driver.findElement(By.xpath("//button[contains(@routerlink, 'cart')]")).click();
	}

}
