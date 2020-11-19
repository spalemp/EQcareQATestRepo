package com.eq.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.eq.qa.base.TestBase;
import com.eq.qa.util.TestUtil;

public class ContactUsPage extends TestBase {
	TestUtil util =new TestUtil();
	//Object Repository
	@FindBy(xpath="//*[contains(text(),'Contact EQ Care Support team')]")
	WebElement eqsupportheader;
	@FindBy(css="input[type='text'][placeholder='First Name']")
	WebElement fname;
	@FindBy(css="input[type='text'][placeholder='Last Name']")
	WebElement lname;
	@FindBy(css="input[type='text'][placeholder='Email address']")
	WebElement email;
	@FindBy(css="input[type='text'][placeholder='Please enter your city']")
	WebElement city;
	@FindBy(xpath="//select")
	WebElement selprovince;
	@FindBy(xpath="//div/textarea[@placeholder='Please describe the issue you are having here...']")
	WebElement query;
	@FindBy(xpath="//div/input[@placeholder='Phone Number']")
	WebElement phone;
	@FindBy(xpath="//button[contains(text(),'Contact Support')]")
	WebElement submitbtn;
	@FindBy(xpath="//*[contains(text(),'Your message was sent.')]")
	WebElement successmsg;
	@FindBy(xpath="//*[contains(text(),'The first name field is required')]")
	WebElement failure_msg_fname;
	@FindBy(xpath="//*[contains(text(),'The last name field is required')]")
	WebElement failure_msg_lname;
	@FindBy(xpath="//*[contains(text(),'The work email field is required')]")
	WebElement failure_msg_email;
	@FindBy(xpath="//*[contains(text(),'The city field is required')]")
	WebElement failure_msg_city;
	@FindBy(xpath="//*[contains(text(),'Please select a province')]")
	WebElement failure_msg_province;
	@FindBy(xpath="//*[contains(text(),'Please tell us a bit about your inquiry')]")
	WebElement failure_msg_query;

	
	//Initializing Page objects
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateContactUsPageHeader() {
		return eqsupportheader.getText();		
	}
	
	public boolean validateheaderdisplay() {
		return eqsupportheader.isDisplayed();		
	}
	
	public void submitform(String fnameval,String lnameval,String emailval, String provinceval, String cityval, String queryval, String phval) throws InterruptedException {
		
		fname.sendKeys(fnameval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		lname.sendKeys(lnameval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		email.sendKeys(emailval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		util.select_byval(provinceval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		city.sendKeys(cityval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		query.sendKeys(queryval);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		phone.sendKeys(phval);
		Thread.sleep(1000);
		util.js_submit(submitbtn);
	}
	public String successmsg() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		util.js_movetoelement();
		Thread.sleep(1000);
		return successmsg.getText();		
	}
	public String failuremsgfname() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_fname.getText();
		return failure_message;
		
	}
	public String failuremsglname() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_lname.getText();
		return failure_message;
		
	}
	public String failuremsgemail() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_email.getText();
		return failure_message;
		
	}
	public String failuremsgprovince() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_province.getText();
		return failure_message;
		
	}
	public String failuremsgcity() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_city.getText();
		return failure_message;
		
	}
	public String failuremsgquery() {
		String failure_message;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		failure_message = failure_msg_query.getText();
		return failure_message;
		
	}

	
}

