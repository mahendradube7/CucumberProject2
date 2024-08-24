package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class LandingPage {

	WebDriver driver;
	TestContextSetup testContextSetup;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String searchItemProductName() throws InterruptedException {
		return driver.findElement(productName).getText();

	}

	public void selectTopDealsPage() {

		driver.findElement(topDeals).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(increment).click();
			i--;
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}