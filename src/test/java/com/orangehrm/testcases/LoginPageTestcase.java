package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageobject.LoginPage;
import com.orangehrm.testbase.Testbase;

public class LoginPageTestcase extends Testbase {
	
	LoginPage loginPage;
	
	public LoginPageTestcase()
	{
		super();
	}
  @BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
	}
	@Test
	public void verifylogin()
	{
		loginPage.login();
	}
	
	@Test
	public void VerifyForgetpasswordtext() throws Exception
	{
	  loginPage.ForgetPasswordClick();	
	  Thread.sleep(4000);
	  String Expected = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
	  Assert.assertEquals(driver.getCurrentUrl(), Expected );
	  
	}
	
	@Test
	public void verifylinkdinlink() throws Exception
	{
		loginPage.clicklinkdin();
		Thread.sleep(4000);
		String linkdinn="https://www.linkedin.com/company/orangehrm";
		Assert.assertEquals(driver.getCurrentUrl(), linkdinn);
		
	}
	
	@AfterMethod
	public void teardown()       //browerclose
	{
	driver.quit();	
	}
}
