package TestScript;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Logger.Dailylog;

public class H5SuperTestClass {

	public WebDriver driver;
	
	
	
	
	@BeforeTest(alwaysRun = true)
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
		
		
	        try {
	            System.out.println("开始启动driver~~~");
	           
	            driver = new ChromeDriver(options);
	 
	            System.out.println("启动driver成功~~~");
	            
	            driver.manage().window().maximize();
	            
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            
	        } catch (Exception e) {
	            System.out.println("启动driver失败~~~");
	            System.out.println(e.getMessage());
	        }        	
		
	}
	
	@AfterTest
	public void tearDown(){
		
		if(driver != null){
			driver.close();
		}
		
		Dailylog.logInfo("driver closed !!");
	}
	
	
	
	
	
	
	
}
