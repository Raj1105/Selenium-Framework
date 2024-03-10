package javaPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getDataUsingSuper {

	public static void main(String[] args) {
		String expectedProduct = "ADIDAS ORIGINAL";
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		childClass1 cc1 = new childClass1(driver);
		cc1.navigateToUrl();
		cc1.login();
		
		

		
		childClass2 cc2 = new childClass2(driver) ;
		
			cc2.addProduct(expectedProduct);
	
	}

}
