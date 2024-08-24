package stepDefinations;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckOutPageStepDefination {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	CheckoutPage checkoutPage;

	public CheckOutPageStepDefination(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();

	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_items(String name) {

		checkoutPage.checkOutItems();

	}

	@And("verify User has ability to enter the promo code and place the order")
	public void verify_User_has_ability_to_enter_promo() {

		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifypPlaceOrder());
	}

}
