package com.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utility.Datadriven;

public class CompanyProfile extends TestBase {
	
	@FindBy(xpath="//a[@title='Jobs']")
	WebElement job;
	
	@FindBys(@FindBy(xpath="//div[@class='component_e6bd3 expanded_80d76']" +"//h6[@class='__halo_textContrast_dark_A __halo_fontSizeMap_size--xs __halo_fontWeight_medium styles_uppercase__382zl styles_component__1kg4S']"))
	List<WebElement>jobtypes;
	
	@FindBys(@FindBy(xpath="//div[@class='component_e6bd3 expanded_80d76']" +"//h4[@class='__halo_textContrast_dark_AAAA __halo_fontSizeMap_size--lg __halo_fontWeight_medium styles_component__1kg4S styles_flow__3_K06 jobTitle_1e76b']"))
	List<WebElement>jobtitles;
	
	@FindBys(@FindBy(xpath="//div[@class='component_e6bd3 expanded_80d76']" +"//span[@class='location_a70ea']"))
	List<WebElement>joblocations;
	
	// Initializing the Page Objects:
			 public CompanyProfile() {
				PageFactory.initElements(driver, this);
			}
			 //Capture the value and write it on Excel
			 public void extractDataAndWriteOnExcel()  {
				 job.click();
				 System.out.println("Capture the Jobtypes and write in the excel");
				 Datadriven.writeExcel(jobtypes, "Job Type");
				 
				 System.out.println("Capture the Jobtitels and write in the excel");
				 Datadriven.writeExcel(jobtitles, "Job Title");
				 
				 System.out.println("Capture the Joblocations and write in the excel");
				 Datadriven.writeExcel(joblocations, "Job Location");
				 
				 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }

}
