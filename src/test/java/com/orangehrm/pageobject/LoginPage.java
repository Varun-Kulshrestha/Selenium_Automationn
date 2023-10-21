package com.orangehrm.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testbase.Testbase;

public class LoginPage extends Testbase{
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']//p")
	WebElement ForgetPasswordButton;
	
	@FindBy(xpath="//a[1]")
	WebElement Linkdinlink;
	
	@FindBy(xpath="//div[@class='orangehrm-login-footer-sm']//a")
	List<WebElement> footerlink ;


	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{
	Username.sendKeys("Admin");	
	Password.sendKeys("admin123");
	Login.click();
	}
	
	public void ForgetPasswordClick()
	{
		ForgetPasswordButton.click();	
	}        
	
	public void clicklinkdin() throws InterruptedException
	{
		Linkdinlink.click();
		Thread.sleep(3000);
	}
	
	public void socialmedialink()
	{
		for(WebElement link :footerlink)
		{
			System.out.println(link.getText());
			link.click();
			driver.getCurrentUrl();
			
		}
	}
}
