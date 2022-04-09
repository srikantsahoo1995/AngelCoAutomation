package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CompanyProfile;
import com.pages.HomePage;
import com.pages.SearchResultsPage;

public class CaptureValueTest extends TestBase {
	
	HomePage homepage;
	SearchResultsPage searchResultsPage;
	CompanyProfile companyProfile;
	
	public CaptureValueTest() {
		super();
	}
	
	@BeforeMethod
public void setup() {
		initialization();
		 homepage=new HomePage();
	}
	
	@Test
	public void performTest() {
		
		String Pagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(Pagetitle, "Job search, venture investing & new tech products | AngelList");
		searchResultsPage=homepage.searchCompanyName();
		companyProfile=searchResultsPage.navigateToCompanyProfile();
		companyProfile.extractDataAndWriteOnExcel();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
