package com.SwagLabs.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifySummary()
  {
	  op.getSummary();
	  
  }
  
  @Test(priority=2)
  public void verifyOrderPurches()
  {
	  op.doFinish();
  }
}
