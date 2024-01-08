package com.sra.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.sra.basepack.BasePage;

public class BasicTestBrowserLaunch extends BasePage{
	

	@Test(priority=1)
	public void testBasicTestBrowserLaunch()
	{
		logger.info("testBasicTestBrowserLaunch test started");
		//open application in browser
		driver.get("http://only-testing-blog.blogspot.com");
		logger.info("Application launched");
		
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The URL: "+currentUrl);
		logger.info("Current page url is printed");
		
		String pageTitle = driver.getTitle();
		System.out.println("The Page Title: "+pageTitle);
		logger.info("Page Title is printed");
		logger.info("testBasicTestBrowserLaunch test finished");
		
		
	}
	
	@Test(priority=2)
	public void testDisplayed()
	{
		logger.info("testDisplayed test method started");
		//open application in browser
		driver.get("http://only-testing-blog.blogspot.com");
		logger.info("Application launched");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The URL: "+currentUrl);
		logger.info("Current page url is printed");
		
		String pageTitle = driver.getTitle();
		System.out.println("The Page Title: "+pageTitle);
		logger.info("Page Title is printed");
		
		
		if(driver.findElement(By.xpath("//input[@name='gparent1']")).isDisplayed())
		{
			System.out.println("Grand Parent1 text box Is displayed");
			logger.info("Grand Parent1 text box Is displayed");
		}
		else
		{
			System.out.println("Grand Parent1 box Is Not displayed.");
			logger.info("Grand Parent1 box Is Not displayed.");
		}
		logger.info("testDisplayed test finished");
		
	}	
	
	    @Test(priority=3)
		public void testIsEnabled() throws IOException
		{
	    	
	    	logger.info("testIsEnabled test method started");
			//open application in browser
			driver.get("http://only-testing-blog.blogspot.com");
			logger.info("Application launched");
			
			//get current url and verified
			if(driver.getCurrentUrl().equals("http://only-testing-blog.blogspot.com/"))
			{
				Assert.assertTrue(true);
				logger.info("URL verified");
			}
			else
			{
				captureScreen(driver,"testIsEnabled");
				Assert.assertTrue(false);
				logger.info("URL mismatched");
				
			}
			
			/**String currentUrl = driver.getCurrentUrl();
			System.out.println("The URL: "+currentUrl);
			logger.info("Current page url is printed"); **/
			
			//get title and verify 
			if(driver.getTitle().equals("Only Testing"))
			{
				Assert.assertTrue(true);
				logger.info("Title verified");
			}
			else
			{
				captureScreen(driver,"testIsEnabled");
				Assert.assertTrue(false);
				logger.info("Title mismatched");
			} 
	     
		
			
		/**	String pageTitle = driver.getTitle();
			System.out.println("The Page Title: "+pageTitle);
			logger.info("Page Title is printed"); **/
			
		//element enabled or not	
		if(driver.findElement(By.xpath("//input[@name='gparent1']")).isEnabled())
		{
			Assert.assertTrue(true);
			System.out.println("Grand Parent1 text box Is enabled.");
			logger.info("Grand Parent1 text box Is enabled.");
			driver.findElement(By.xpath("//input[@name='gparent1']")).sendKeys("WebDriver Test");
			System.out.println("Text is entered in Grand Parent1 text box");
			logger.info("Text is entered in Grand Parent1 text box");
		}
		else
		{
			captureScreen(driver,"testIsEnabled");
			Assert.assertTrue(false);
			System.out.println("Grand Parent1 box Is Not enabled.");
			logger.info("Grand Parent1 box Is Not enabled.");
			
		}
		
		logger.info("testIsEnabled test finished");
	}
		
		
}
