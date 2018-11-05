package TestScript.Mobile;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import CommonFunction.Common;
import TestScript.H5SuperTestClass;

public class BaiduTest extends H5SuperTestClass {
	
	@Test
	public void Baidu(){
		
		driver.get("http://www.baidu.com");
		
		Common.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='index-kw']")).clear();
		driver.findElement(By.xpath("//input[@id='index-kw']")).sendKeys("google");
		
		Common.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='index-bn']")).click();
		
		Common.sleep(10000);
		
		
	}
	
	

}
