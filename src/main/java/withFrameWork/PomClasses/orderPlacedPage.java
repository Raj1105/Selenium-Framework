package withFrameWork.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPlacedPage {
	
	WebDriver driver;
	public orderPlacedPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="td h1")
	WebElement confirmMsg;
	public String orderPlacedSucessfullyMsg() {
		String confirnMsg = confirmMsg.getText();
		return confirnMsg;
	}
	
	
}
