package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	private WebDriver driver;
	
	//initialize driver
	public CartPage(WebDriver driver)//base class
	{
		this.driver=driver;
	}

	//locators
	By cartPage=By.xpath("//a[@class='shopping_cart_link']");
	By removebtn=By.xpath("//button[text()='Remove']");
	By continuebtn=By.id("continue-shopping");
	By checkoutbtn=By.id("checkout");
	
	
	//methods
	public void getCartPage()
	{
		driver.findElement(cartPage).click();
		System.out.println("Cart page is Open.....");
	}
	
	
	public void doRemove()
	{
		driver.findElement(removebtn).click();
		System.out.println("Product got removed from the cart!");
	}
	
	public void doContinueShopping()
	{
		driver.findElement(continuebtn).click();
		System.out.println("Inventory page open for continue shopping!");
		
	}
	public void doCheckout()
	{
		driver.findElement(checkoutbtn).click();
		System.out.println("Checkout page open.....!");
	}
	
}
