package withFrameWork.AbstractClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import withFrameWork.PomClasses.cartPage;
import withFrameWork.PomClasses.orderPage;

public class abstractComponent {
	WebDriver driver;
	public abstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[contains(@routerlink, 'cart')]")
	WebElement cartNav;
	
	@FindBy(xpath="//button[contains(@routerlink, 'myorders')]")
	WebElement orderNav;
	
	public void waitUntilElementisLocated(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitUntilElementisLocatedByWebElementLocator(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public cartPage CartHeaderNav() {
		cartNav.click();
		cartPage cp = new cartPage(driver);
		return cp;
	}
	public orderPage orderPageValidation() throws InterruptedException {
		Thread.sleep(1000);
		orderNav.click();
		return new orderPage(driver);
	}
	public void waitUntilElementisInvisible(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}

}
