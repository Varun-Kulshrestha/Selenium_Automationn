package com.orangehrm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.orangehrm.utilities.Testutils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	public static Properties pr;
	public static WebDriver driver;
	
	public Testbase() {
		try {
		pr= new Properties();
		FileInputStream ip = new FileInputStream("E:\\Eclipse java\\SeleniumAutomation\\src\\test\\java\\com\\orangehrm\\config\\config.properties");
        pr.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
	}
	
	public static void initialization() {
		String Browser= pr.getProperty("Browser");
		if(Browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Testutils.implicitWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutils.pageLoad,TimeUnit.SECONDS);
		driver.get(pr.getProperty("URL"));
		
	}
	
	
}
