package javaPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class childClass1 extends parentClass {

	public childClass1(WebDriver driver) {
		super(driver);

	}

	public void login() {
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("raj1105@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Raj@9211");
		driver.findElement(By.id("login")).click();
	}

}
