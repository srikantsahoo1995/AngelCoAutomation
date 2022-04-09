package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utility.Datadriven;

public class HomePage extends TestBase {

	@FindBy(id = "search")
	WebElement search;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Verify Title
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	//Search Company Name
	public SearchResultsPage searchCompanyName() {
		search.sendKeys(Datadriven.companyName());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		search.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		return new SearchResultsPage();
	}

}
