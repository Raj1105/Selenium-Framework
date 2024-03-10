package withoutFrameworkTesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinkTesting {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		
for (int i=1; i<links.size(); i++) {
	String hrefVlaue = links.get(i).getAttribute("href");
	if (hrefVlaue.contains("#")) {
		continue;
	}
	else {
		//System.out.println(hrefVlaue);
		HttpURLConnection conn = (HttpURLConnection)new URL(hrefVlaue).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int rescode = conn.getResponseCode();
		//System.out.println(rescode);
		if(rescode> 400) {
			System.out.println("Broken Link is  " + hrefVlaue + "Rescode is  " + rescode);
		}
	}
}
	}

}
