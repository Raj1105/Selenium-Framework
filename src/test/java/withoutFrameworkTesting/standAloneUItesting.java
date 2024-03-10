package withoutFrameworkTesting;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import UtilityClass.BaseTest;
import withFrameWork.AbstractClass.JsonReader;
import withFrameWork.PomClasses.cartPage;
import withFrameWork.PomClasses.checkoutPage;
import withFrameWork.PomClasses.orderPage;
import withFrameWork.PomClasses.orderPlacedPage;
import withFrameWork.PomClasses.productPage;

public class standAloneUItesting extends BaseTest {
	String expectedProduct = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input)
			throws InterruptedException, IOException {

		// landing page
		productPage pp = lp.loginPage(input.get("email"), input.get("password"));
		// productPage
		pp.addproductToCart(input.get("product"));
		// navigate to cartPage
		cartPage cp = pp.CartHeaderNav();
		// cartPage
		Boolean match = cp.verifyProduct(input.get("product"));
		Assert.assertTrue(match);
		checkoutPage ckp = cp.redirectToCheckOutpage();
		// checkoutPage
		ckp.passValueToInputFiled("i");
		ckp.selectCountryFromList("india");
		Thread.sleep(1000);
		// click on placeOrder
		orderPlacedPage opp = ckp.clickOnPlaceorderBtn();
		// orderPacedpage
		String confirnMsg = opp.orderPlacedSucessfullyMsg();
		Assert.assertEquals(confirnMsg, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderPageValidation() throws InterruptedException {
		productPage pp = lp.loginPage("raj1105@gmail.com", "Raj@9211");
		orderPage op = pp.orderPageValidation();
		Boolean match2 = op.verifyOrderProduct(expectedProduct);
		Assert.assertTrue(match2);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = JsonReader.dataReaderfromJson(
				System.getProperty("user.dir") + "\\src\\test\\java\\UtilityClass\\propertyFiles\\Data.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
