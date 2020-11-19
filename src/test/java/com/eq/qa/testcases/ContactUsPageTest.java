package com.eq.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import com.eq.qa.base.TestBase;
import com.eq.qa.pages.ContactUsPage;

public class ContactUsPageTest extends TestBase {
	ContactUsPage  contactUsPage;
	
	
	public ContactUsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialize();
		contactUsPage = new ContactUsPage();
		
	}
	
	@Test(priority=1)
	public void contactUsPagedisplayTest() {
		boolean display=contactUsPage.validateheaderdisplay();
		Assert.assertEquals(display, true);
		
	}
	
	@Test(priority=2)
	public void validsubmitQueryTest() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","EQLastname","email@com","QC","montreal","querygiven","514-231-3456");
		String success_msg = contactUsPage.successmsg();
		Assert.assertEquals(success_msg, "Your message was sent.");
		
	}
	
	
	@Test(priority=3)
	public void emptyFnameTest() throws InterruptedException {
		contactUsPage.submitform("","EQLastname","email@com","QC","montreal","querygiven","514-231-3456");
		String failure_msg = contactUsPage.failuremsgfname();
		Assert.assertEquals(failure_msg, "The first name field is required");
		
	}
	@Test(priority=4)
	public void emptyLnameTest() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","","email@com","QC","montreal","querygiven","");
		String failure_msg = contactUsPage.failuremsglname();
		Assert.assertEquals(failure_msg, "The last name field is required");
		
	}
	@Test(priority=5)
	public void emptyEmail() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","EQLastname","","QC","montreal","querygiven","514-231-3456");
		String failure_msg = contactUsPage.failuremsgemail();
		Assert.assertEquals(failure_msg, "The work email field is required");
		
	}
	@Test(priority=6)
	public void emptyProvince() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","EQLastname","email@com","","montreal","querygiven","514-231-3456");
		String failure_msg = contactUsPage.failuremsgprovince();
		Assert.assertEquals(failure_msg, "Please select a province");
		
	}
	@Test(priority=7)
	public void emptyCity() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","EQLastname","email@com","QC","","querygiven","514-231-3456");
		String failure_msg = contactUsPage.failuremsgcity();
		Assert.assertEquals(failure_msg, "The city field is required");
		
	}
	@Test(priority=8)
	public void emptyQuery() throws InterruptedException {
		contactUsPage.submitform("EQFirstname","EQLastname","email@com","QC","montreal","","514-231-3456");
		String failure_msg = contactUsPage.failuremsgquery();
		Assert.assertEquals(failure_msg, "Please tell us a bit about your inquiry");
		
	}
	
	
	@AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Running: tearDown");
        driver.quit();
    }
}
