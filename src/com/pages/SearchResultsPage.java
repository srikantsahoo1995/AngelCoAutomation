package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utility.Datadriven;

public class SearchResultsPage extends TestBase {
	
	@FindBys(@FindBy(xpath="//div[@class='title']/a"))
	List<WebElement>results;

	// Initializing the Page Objects:
		public SearchResultsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public CompanyProfile navigateToCompanyProfile() {
			Iterator<WebElement> itr=results.iterator();
			while(itr.hasNext()) {
				WebElement result=itr.next();
				if(result.getText().equals(Datadriven.companyName())) {
					result.click();
					System.out.println("click on company link");
					break;
				}
				
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return new CompanyProfile();
		}

		
}
