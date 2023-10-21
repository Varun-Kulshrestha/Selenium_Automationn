package com.orangehrm.testdata;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demooo {

	@Test
	public void launch() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.get("https://www.tutorialspoint.com/selenium/selenium_find_all_links.htm");
		List <WebElement> Footer=driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[@target='_blank']"));
		System.out.println("Number of elements in Footer is "+ Footer.size());
		
		for (WebElement socialmediafooter :Footer)
		{
			
			 socialmediafooter.click();
			} 
		
		// String parentWindow =driver.getWindowHandle();
	//	 driver.switchTo().window(parentWindow);
		 Set<String> windows=driver.getWindowHandles();
		 
		 System.out.println(windows);
		 for (String s : windows)
		 {    
			//String title = driver.switchTo().window(s).getTitle();
			//System.out.println(title);
			//if(title.equals("OrangeHRM | LinkedIn")) 
			driver.switchTo().window(s);
			if (driver.getCurrentUrl().equals("https://twitter.com/orangehrm?lang=en"))
			{
				driver.close();
			//break;
			}
			
		 }
         
		
		driver.quit(); 
		/*List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links:"+links.size()); //48
		
		int brokenlinks=0;
		
		for(WebElement linkEle:links)
		{
			String hrefAttValue=linkEle.getAttribute("href");
			
			// pre-requisite for checking broken link
			if(hrefAttValue==null || hrefAttValue.isEmpty())
			{
				System.out.println("href attribute value is empty.");
				continue;
			}
			
			//Checking link is broken or not
			URL linkurl=new URL(hrefAttValue); // convert String --> URL format
						
			HttpURLConnection conn=(HttpURLConnection) linkurl.openConnection(); ////send request to server - open , connect
			
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefAttValue+"     "+"====> Broken Link");
				brokenlinks++;
			}
			else
			{
				System.out.println(hrefAttValue+"     "+"====> Not Broken Link");
			}
			
			
		}
		
		System.out.println("total number of broken links:"+brokenlinks);
		
		
*/
	}

	
}
