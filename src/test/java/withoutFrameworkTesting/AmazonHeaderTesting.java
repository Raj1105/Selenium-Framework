package withoutFrameworkTesting;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHeaderTesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		
		//navigate to amazon page
		driver.get("https://www.amazon.in/");
		
		//enter your current location using pin code
		
		driver.findElement(By.xpath("//a[contains(@id, 'nav-global-location')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".a-column.a-span8 input")).sendKeys("829110");
		driver.findElement(By.cssSelector("div[class*='a-column'] span input[class='a-button-input']")).click();
		
		//click on Dropdown and select under 500 category
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".nav-left div[id*='nav-search']")).click();
		
		List<WebElement> categories = driver.findElements(By.cssSelector("select[id='searchDropdownBox'] option"));
		
		for (WebElement option : categories) {
			String nameOfCategory = option.getText();
			if(nameOfCategory.equalsIgnoreCase("Under ₹500")) {
				driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(nameOfCategory);
				
				break;
				
			}
			
		}
		
		//Select any random categories suggested on search bar dropdown list
		Thread.sleep(2000);
		List<WebElement> attribute =driver.findElements(By.cssSelector(".two-pane-results-container div.s-suggestion-container div"));
		for (WebElement getVlaue: attribute) {
			String value = getVlaue.getAttribute("aria-label");
			if(value.equalsIgnoreCase("under 500 kurta set with dupatta")) {
				getVlaue.click();
				break;
			}
			
		}
		
		
		
		

	}

}
