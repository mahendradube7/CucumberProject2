package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class CheckoutPage {

	WebDriver driver;
	TestContextSetup testContextSetup;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[text()='Place Order']");
	
	public void checkOutItems() {
		
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPromoBtn() {
		driver.findElement(promoBtn).isDisplayed();
		return true;
	}

	public boolean verifypPlaceOrder() {
		driver.findElement(placeOrder).isDisplayed();
		return true;
	}
}
