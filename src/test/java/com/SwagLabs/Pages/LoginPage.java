package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utilities.Utility;

public class LoginPage
{
	private WebDriver driver;
	
	//initialize driver
	
	public LoginPage(WebDriver driver)//baseclass
	{
		this.driver=driver;
		
	}
	
	//Locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By button=By.id("login-button");
	
	
	
	//Methods
	
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	public void doLogin(String un,String psw)
	{
	driver.findElement(username).sendKeys(un);
	driver.findElement(password).sendKeys(psw);
	Utility.getScreenshot(driver);
	driver.findElement(button).click();
	}
	

}
