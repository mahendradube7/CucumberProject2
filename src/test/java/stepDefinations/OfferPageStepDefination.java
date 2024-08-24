package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageobjects.LandingPage;
import pageobjects.OfferPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefination {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefination(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;

	}

	public void switchToOfferPage() {
		// pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
	}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_products_exit(String shortName)
			throws InterruptedException {

		switchToOfferPage();

		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferpage();
		Thread.sleep(2000);
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.offerPageProductName = offerPage.getProductName();
		System.out.println(testContextSetup.offerPageProductName + " is extracted from Offer Page");

	}

	@Then("Validate product name in offer page matches with landing page")
	public void validate_product_name_in_offer_page_matches_with_landing_page() {

		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName);
	}

}
