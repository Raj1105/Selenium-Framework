package withoutFrameworkTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import UtilityClass.BaseTest;
import withFrameWork.PomClasses.cartPage;
import withFrameWork.PomClasses.checkoutPage;
import withFrameWork.PomClasses.productPage;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void loginValidation() {
		lp.loginPage("raj1105@gmail.com", "Raj@9211");
		Assert.assertEquals(lp.LoginErrorMsg(), "Incorrect email or password");
	}

	@Test
	public void selectCountryInputValidation() throws InterruptedException {
		productPage pp = lp.loginPage("raj1105@gmail.com", "Raj@9211");
		pp.addproductToCart("ADIDAS ORIGINAL");
		cartPage cp = pp.CartHeaderNav();
		//adding comment
		checkoutPage ckp = cp.redirectToCheckOutpage();
		String opp = ckp.countryEmptyFieldValidation();
		Assert.assertEquals(opp, "Please Enter Full Shipping Information");
	}
}
