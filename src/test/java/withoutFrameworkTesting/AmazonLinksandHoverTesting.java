package withoutFrameworkTesting;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinksandHoverTesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to amazon page
		driver.get("https://www.amazon.in/");
		// get number of all anchor tag
		System.out.println(driver.findElements(By.tagName("a")).size());
		// get number of anchor tag present in footer section
		WebElement footer = driver.findElement(By.cssSelector("#navFooter"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// extract anchor tag in footer section of particular column
		List<WebElement> footerlink = driver
				.findElements(By.xpath("//div[text()='Get to Know Us']/following-sibling::ul/li/a"));

		for (WebElement link : footerlink) {
			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.sendKeys(clickonLink);
		}

		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
	

		while (it.hasNext()) {
		
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
	
	}

}
