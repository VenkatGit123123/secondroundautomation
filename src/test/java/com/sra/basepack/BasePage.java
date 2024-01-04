package com.sra.basepack;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver = null;
	public static Logger logger;
	/**public static final String USERNAME = "oauth-krishnaqa1052-1135b";
    public static final String ACCESS_KEY = "adbdb32d-d713-46a2-80ab-b9d8480b4700";
    public static final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";**/
	
	//@Parameters({"browser","version","platform"})
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws MalformedURLException  //String pf, //String vr
	{
		logger = Logger.getLogger("seleniumjavaautomation");
		PropertyConfigurator.configure("log4j.properties");
		
	/**	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", br);
        caps.setCapability("platform", pf);
        caps.setCapability("version", vr);
        driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
         **/
		
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
	
	//Below method for Capture the sreenshot when script is failed
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
	
	

}
