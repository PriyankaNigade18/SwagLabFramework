package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage
{
	private WebDriver driver;
	
	//initialize driver
	public InventoryPage(WebDriver driver)//base class driver
	{
		this.driver=driver;
	}
	
	
	//locators
	private By list=By.xpath("//div[@class='inventory_list']/div[@class='inventory_item']");
	private By listName=By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name ']");
	private By addbtn=By.xpath("//button[text()='Add to cart']");
	
	//methods
	
	public int getProductCount()
	{
		return driver.findElements(list).size();
	}
	
	public void getProductNames()
	{
		List<WebElement> list=driver.findElements(listName);
		
		System.out.println("********Product Names are**********");
		for(WebElement i:list)
		{
			System.out.println(i.getText());
		}
			
	}
	
	public void addProductToCart(String pname)
	{
		List<WebElement> allProducts=driver.findElements(listName);
		
		for(WebElement i:allProducts)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				break;
			}
		}
		
		//click on button
		driver.findElement(addbtn).click();
		System.out.println("Product added into the cart!: "+pname);
		
	}
	
	

}
