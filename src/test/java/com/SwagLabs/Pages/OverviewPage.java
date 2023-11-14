package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utilities.Utility;

public class OverviewPage
{
	private WebDriver driver;
	
	public OverviewPage(WebDriver driver)//base class
	{
		this.driver=driver;
		
	}
	
	
	//locator
	By summary=By.xpath("//div[@id='checkout_summary_container']");
	By finishbtn=By.id("finish");
	By msg=By.xpath("//h2");
	
	//method
	
	public void getSummary()
	{
		String text=driver.findElement(summary).getText();
		System.out.println("*******Product summary is: *********");
		System.out.println(text);
		Utility.getScreenshot(driver);
	}
	
	public void doFinish()
	{
		driver.findElement(finishbtn).click();
		String res=driver.findElement(msg).getText();
		System.out.println("Final Status of Order is: "+res);
		Utility.getScreenshot(driver);
	}
	
	
	
	
	

}
