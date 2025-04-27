package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MyntraOrder;


public class BaseClass {
	public String MyntraUrl = "http://www.myntra.com";
	public static WebDriver driver;
	protected MyntraOrder MO;
	
	
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		// added
		
		ChromeOptions options = new ChromeOptions();
		//opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); 
		 options.addArguments("--window-size=1920,1080");
		 options.addArguments("--disable-blink-features=AutomationControlled");
		    
		//chrome binary location specified here
		 driver = new ChromeDriver(options);
		
		 
		    //original
				//driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


	public void captureScreenshot(WebDriver drive, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
		
	}


}
