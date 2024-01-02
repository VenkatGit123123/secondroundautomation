package com.sra.basepack;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("seleniumjavaautomation");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser launched successfully");
			
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox browser launched successfully");
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser launched successfully");
			
		}
		else if(br.equals("headlessChrome"))
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--headless");
			driver = new ChromeDriver(op);
			logger.info("Headless Chrome browser launched successfully");
		}
		else if(br.equals("headlessFirefox"))
		{
			FirefoxOptions op = new FirefoxOptions();
			op.addArguments("--headless");
			driver = new FirefoxDriver(op);
			logger.info("Headless Firefox browser launched successfully");
		}
		else if(br.equals("headlessEdge"))
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("--headless");
			driver = new EdgeDriver(op);
			logger.info("Headless Edge browser launched successfully");
		}
		else if(br.equals("htmlUnitDriver"))
		{
			driver = new HtmlUnitDriver();
			logger.info("HtmlUnit browser launched successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed successfully");
	}

}
