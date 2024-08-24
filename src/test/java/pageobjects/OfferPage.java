package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class OfferPage {
	WebDriver driver;
	

	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String getProductName() throws InterruptedException {
		return driver.findElement(productName).getText();
				
	}
}
