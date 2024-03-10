package javaPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class excelPractise {

	public static void main(String[] args) {
		// String priceOfFruit = null;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#downloadButton")));

		driver.findElement(By.cssSelector("#downloadButton")).click();
		WebElement uploadBtn = driver.findElement(By.cssSelector("#fileinput"));
		uploadBtn.sendKeys("C:\\Users\\shekh\\Downloads\\download.xlsx");

		WebElement msg = driver.findElement(By.className("Toastify__toast-body"));
		wait.until(ExpectedConditions.visibilityOf(msg));
		System.out.println(msg.getText());
		Assert.assertEquals(msg.getText(), "Updated Excel Data Successfully.");
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("div[class*='Toastify__toast-container']")));
		//List<WebElement> fruitName = driver.findElements(By.cssSelector(".sc-hIPBNq #cell-2-undefined"));
	//	List<WebElement> fruitPrice = driver.findElements(By.cssSelector(".sc-hIPBNq #cell-4-undefined"));

//		for(int i=0; i<fruitName.size(); i++) {
//			
//			if(fruitName.get(i).getText().equalsIgnoreCase("kivi")) {
//				for(int j=0; j<fruitPrice.size();j++) {
//					priceOfFruit = fruitPrice.get(i).getText();
//					break;
//				}
//			}
//		}
		String fruitName = "Mango";
		String columnId = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		WebElement price = driver
				.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+columnId+"-undefined']"));
		System.out.println(price.getText());

	}

}
