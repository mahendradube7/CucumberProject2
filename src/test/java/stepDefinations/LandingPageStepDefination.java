package stepDefinations;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefination {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;

	public LandingPageStepDefination(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

	}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws IOException {

		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.searchItemProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
	}

	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
