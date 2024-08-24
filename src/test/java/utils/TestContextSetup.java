package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup () throws IOException {
		testBase = new TestBase();
		pageObjectManager =  new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
