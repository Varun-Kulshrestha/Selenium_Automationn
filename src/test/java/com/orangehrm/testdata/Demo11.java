package com.orangehrm.testdata;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo11 {

	public static List main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.get("https://www.youtube.com/");
	   // driver.navigate().refresh();
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		List finalList = new ArrayList();
		for (WebElement element : elements){
		if(element.getAttribute("href") != null){
		finalList.add(element);
		}
		}
		return finalList;

	
	}
	
}
