package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CheckOutPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyCheckOut() 
  {
	  ch.doContinue("Priyanka", "Nigade", "411047");
	  
  }
}
