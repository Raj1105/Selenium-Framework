package withoutFrameworkTesting;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class UIcalenderTesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1200)");
		// Thread.sleep(2000);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(ElementClickInterceptedException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).isDisplayed()) {
					return driver.findElement(By.xpath("//input[@placeholder='Date of travel']"));
				}
				else {
					return null;
				}
			}

		});

		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();

//		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();
//		List<WebElement> dateText = driver.findElements(By.cssSelector(".dayContainer span.flatpickr-day"));
//		for (WebElement date : dateText) {
//			
//			String text = date.getText();
//			if (text.contains("28")) {
//				WebDriverWait wait = new WebDriverWait(driver, 20);
//				wait.until(ExpectedConditions.elementToBeClickable(date)).click();
//				
//			}
//		}
	}

}
