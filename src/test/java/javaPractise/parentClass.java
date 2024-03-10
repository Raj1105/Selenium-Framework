package javaPractise;

import org.openqa.selenium.WebDriver;

public class parentClass {
	
	WebDriver driver; 
	public parentClass(WebDriver driver) {
		this.driver =driver;
		
	}

	
public void navigateToUrl() {
	driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://rahulshettyacademy.com/client");
	
}


}
