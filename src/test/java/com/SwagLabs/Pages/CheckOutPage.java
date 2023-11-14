package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utilities.Utility;

public class CheckOutPage
{
	private WebDriver driver;
	
	//initialize driver
	public CheckOutPage(WebDriver driver)//base class
	{
	this.driver=driver;	
	}
	
	//locator
	By fname=By.id("first-name");
	By lname=By.name("lastName");
	By zcode=By.id("postal-code");
	By cancelbtn=By.id("cancel");
	By continuebtn=By.id("continue");
	
	//method
	
	public void doContinue(String firstname,String lastname,String zipcode)
	{
		driver.findElement(fname).sendKeys(firstname);
		driver.findElement(lname).sendKeys(lastname);
		driver.findElement(zcode).sendKeys(zipcode);
		Utility.getScreenshot(driver);
		System.out.println("firstname is: "+firstname);
		System.out.println("lastname is: "+lastname);
		System.out.println("zipcode is: "+zipcode);
		driver.findElement(continuebtn).click();
		System.out.println("Overview page open.....!");
	}
	
	
	public void doCancel()
	{
		driver.findElement(cancelbtn).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
