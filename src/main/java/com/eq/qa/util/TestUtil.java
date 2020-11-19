package com.eq.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.eq.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long Page_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void js_movetoelement() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)", "");
	}
	public void js_submit(WebElement submit_btn) throws InterruptedException {
		Thread.sleep(1000);
		try {
			submit_btn.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", submit_btn);
		  }
	}
	
	public void select_byval(String val) {
		//Select select=new Select(driver.findElement(By.xpath("//select/option[contains(text(), 'Select your province')]")));
		if(val!="") {
		Select select=new Select(driver.findElement(By.xpath("//select")));
		select.selectByValue(val);
		}
	}
			

}
