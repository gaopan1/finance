package TestScript.B2C;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import CommonFunction.Common;
import CommonFunction.HMCCommon;
import CommonFunction.DesignHandler.NavigationBar;
import CommonFunction.DesignHandler.SplitterPage;
import Logger.Dailylog;
import Pages.B2CPage;
import Pages.HMCPage;
import TestScript.SuperTestClass;

public class BROWSE540Test extends SuperTestClass {
	B2CPage b2cPage;
	HMCPage hmcPage;
	String accessoryPN;
	String homePageUrl;
	String subseriesUrl;
	String subseriesPN;
	
	public BROWSE540Test (String store){
		this.Store = store;
		this.testName = "BROWSE-540";
	}
	
	@Test(priority = 0, enabled = true, alwaysRun = true, groups = {"browsegroup","product",  "p2", "b2c"})
	public void BROWSE540Test(ITestContext ctx) {
		try {
			this.prepareTest();
			hmcPage = new HMCPage(driver);
			b2cPage = new B2CPage(driver);
			accessoryPN = "0C19886";
			homePageUrl = testData.B2C.getHomePageUrl();
			subseriesUrl = "https://pre-c-hybris.lenovo.com/jp/ja/notebooks/thinkpad/x-series/c/thinkpad-x-series";
			subseriesPN = "22TP2TXX16G";

			
			//Maintain value via  Attribute override for JP country, then check in the frontpage
			Dailylog.logInfoDB(1, "Maintain a blank value via  Attribute override, check in the frontpage", Store, testName);
			attributeOverrideOnHmc(accessoryPN,"");
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);	
			String blankAttributeOverride = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			Assert.assertTrue(blankAttributeOverride.equals(""), "The summary attribute override use NULL vaule should be hidden");
			System.out.println("The summary attribute override use NULL value is hidden : " + blankAttributeOverride.equals(""));
			cleanBrowser();
			
			Dailylog.logInfoDB(2, "Maintain ko value via  Attribute override, check in the frontpage", Store, testName);
			attributeOverrideOnHmc(accessoryPN,"test KO summary");
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);	
			String koKRAttributeOverride = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			Assert.assertTrue(koKRAttributeOverride.equals(""), "The summary attribute override use KO vaule should be hidden");
			System.out.println("The summary attribute override use KO value is hidden : " + koKRAttributeOverride.equals(""));
			cleanBrowser();
			
			Dailylog.logInfoDB(3, "Maintain EN value via  Attribute override, check in the frontpage", Store, testName);
			attributeOverrideOnHmc(accessoryPN,"test EN summary");
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);	
			String enAttributeOverride = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			Assert.assertTrue(enAttributeOverride.equals("test EN summary"), "The summary attribute override use EN vaule should be changed");
			System.out.println("The summary attribute override use EN value is changed : " + enAttributeOverride.equals("test EN summary"));
			cleanBrowser();
			
			
			//Maintain value via  Classification attribute override for JP country, then check in the frontpage
			Dailylog.logInfoDB(4, "Maintain blank value via  Classification Attribute override, check in the frontpage", Store, testName);
			classificationOverrideOnHmc(accessoryPN,"");	
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Boolean blankClassificationAttributeOverride = !(Common.isElementExist(driver, By.xpath("//table[@class='techSpecs-table']//td[text()='高さ']"), 3));
			Assert.assertTrue(blankClassificationAttributeOverride, "The height classification attribute override use NULL value should be hidden");
			System.out.println("The height classification attribute override use NULL value is hidden : " + blankClassificationAttributeOverride);
			cleanBrowser();
			
			Dailylog.logInfoDB(5, "Maintain ko value via  Classification Attribute override, check in the frontpage", Store, testName);
			classificationOverrideOnHmc(accessoryPN,"test KO height");	
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Boolean koClassificationAttributeOverride = !(Common.isElementExist(driver, By.xpath("//table[@class='techSpecs-table']//td[text()='高さ']"), 3));
			System.out.println("the height is : " + koClassificationAttributeOverride);
			Assert.assertTrue(koClassificationAttributeOverride, "The height classification attribute override use KO value should be hidden");
			System.out.println("The height classification attribute override use KO value is hidden : " + koClassificationAttributeOverride);
			cleanBrowser();
			
			Dailylog.logInfoDB(6, "Maintain EN value via  Classification Attribute override, check in the frontpage", Store, testName);
			classificationOverrideOnHmc(accessoryPN,"test EN height");	
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Boolean enClassificationAttributeOverride = Common.isElementExist(driver, By.xpath("//table[@class='techSpecs-table']//td[text()='test EN height']"), 3);
			System.out.println("the height is : " + enClassificationAttributeOverride);
			Assert.assertTrue(enClassificationAttributeOverride, "The height classification attribute override use EN value should be changed");
			System.out.println("The height classification attribute override use EN value is changed : " + enClassificationAttributeOverride);
			cleanBrowser();
			
			
			//Maintain value via  PMI Attribute override for JP country, then check in the frontpage
			Dailylog.logInfoDB(7, "Maintain blank value via  PMI Attribute override, check in the frontpage", Store, testName);
			pmiAttributeOverrideOnHmc(accessoryPN,"",true);	
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);
			String blankOverridePmi = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			String blankTextPmi = driver.findElement(By.xpath("//div[@class='overviewSection']/div")).getText().toString();
			String blankMediaPmi = driver.findElement(By.xpath("//div[@class='galleryContent']/img")).getAttribute("src");
			Assert.assertTrue(blankOverridePmi.equals(""), "The override mkt_name pmi attribute override use NULL vaule should be hidden");
			System.out.println("The override mkt_name pmi attribute override use NULL vaule should be hidden : " + blankOverridePmi.equals(""));
			Assert.assertTrue(blankTextPmi.equals(""), "The text mkt_desc_long pmi attribute override use NULL vaule should be hidden");
			System.out.println("The text mkt_desc_long pmi attribute override use NULL vaule should be hidden : " + blankTextPmi.equals(""));
			Assert.assertTrue(blankMediaPmi.equals(""), "The media mkt_imge_list pmi attribute override use NULL vaule should be hidden");
			System.out.println("The media mkt_imge_list pmi attribute override use NULL vaule should be hidden : " + blankMediaPmi.equals(""));
			cleanBrowser();
			
			Dailylog.logInfoDB(8, "Maintain ko value via  PMI Attribute override, check in the frontpage", Store, testName);
			pmiAttributeOverrideOnHmc(accessoryPN,"test KO",true);
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);
			String koOverridePmi = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			String koTextPmi = driver.findElement(By.xpath("//div[@class='overviewSection']/div")).getText().toString();
			String koMediaPmi = driver.findElement(By.xpath("//div[@class='galleryContent']/img")).getAttribute("src");
			Assert.assertTrue(koOverridePmi.equals(""), "The override mkt_name pmi attribute override use KO vaule should be hidden");
			System.out.println("The override mkt_name pmi attribute override use KO vaule should be hidden : " + koOverridePmi.equals(""));
			Assert.assertTrue(koTextPmi.equals(""), "The text mkt_desc_long pmi attribute override use KO vaule should be hidden");
			System.out.println("The text mkt_desc_long pmi attribute override use KO vaule should be hidden : " + koTextPmi.equals(""));
			Assert.assertTrue(koMediaPmi.equals(""), "The media mkt_imge_list pmi attribute override use KO vaule should be hidden");
			System.out.println("The media mkt_imge_list pmi attribute override use KO vaule should be hidden : " + koMediaPmi.equals(""));
			cleanBrowser();
			
			Dailylog.logInfoDB(9, "Maintain EN value via  PMI Attribute override, check in the frontpage", Store, testName);
			String url = pmiAttributeOverrideOnHmc(accessoryPN,"test EN",true);
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			Common.sleep(5000);
			String enOverridePmi = driver.findElement(By.xpath("//div[@class='titleSection']")).getText().toString();
			String enTextPmi = driver.findElement(By.xpath("//div[@class='overviewSection']/div")).getText().toString();
			String src = driver.findElement(By.xpath("//div[@class='galleryContent']/img")).getAttribute("src");
			String[] enMediaPmi = src.split("https://LIeCommerce:M0C0v0n3L!@pre-c-hybris.lenovo.com");
			Assert.assertTrue(enOverridePmi.equals("test EN"), "The override mkt_name pmi attribute override use EN vaule should be changed");
			System.out.println("The override mkt_name pmi attribute override use EN vaule should be changed : " + enOverridePmi.equals("test EN"));
			Assert.assertTrue(enTextPmi.equals("test EN"), "The text mkt_desc_long pmi attribute override use EN vaule should be changed");
			System.out.println("The text mkt_desc_long pmi attribute override use EN vaule should be changed : " + enTextPmi.equals("test EN"));
			Assert.assertTrue(enMediaPmi[1].equals(url), "The media pmi attribute override use EN vaule should be hidden");
			System.out.println("The media mkt_imge_list pmi attribute override use EN vaule should be changed : " + enMediaPmi[1].equals(url));
			cleanBrowser();		
			
			pmiAttributeOverrideOnHmc(accessoryPN,"",false);
			cleanBrowser();
			Common.sleep(3000);
			driver.get(homePageUrl+"/p/"+accessoryPN);
			String productStatus = driver.findElement(By.xpath("//div[@class='productStatus-deals']")).getText().toString();
			Boolean showTechSpeces = Common.isElementExist(driver, By.xpath("//span[@class='js-navText tab_active']"), 3);
			Assert.assertTrue(productStatus.equals("Sold Out"), "The collection pmi attribute override should be changed");
			System.out.println("The collection pmi attribute override should be changed : " + productStatus.equals("Sold Out"));
			Assert.assertTrue(!showTechSpeces, "The boolean pmi attribute override should be changed");
			System.out.println("The boolean pmi attribute override should be changed : " + !showTechSpeces);
			cleanBrowser();		
			
			subseriesPmiAttributeOverrideOnHmc(subseriesPN,"");
			cleanBrowser();
			Common.sleep(3000);
			driver.get(subseriesUrl);
			driver.navigate().refresh();
			String subseries = driver.findElement(By.xpath("//div[contains(@class,'seriesListings-description')]")).getText().toString();
			System.out.println(subseries);
			Assert.assertTrue(subseries.equals(""), "The subseries mkt_desc_short should be hidden on PLP page");
			System.out.println("The subseries mkt_desc_short should be hidden on PLP page : " + subseries.equals(""));
			
		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}
		
	}
	
	
	
	
	//1.attribute override
	public void attributeOverrideOnHmc(String productNo,String summary) throws InterruptedException{	
		//login HMC console
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		Common.sleep(2000);
		HMCCommon.searchOnlineProduct(driver, hmcPage, productNo);
		Common.sleep(3000);
		
		//check if exist mkt_name pmi attribute override
		driver.findElement(By.xpath("//span[@id='Content/EditorTab[OptionCompatibility.tab.pmi.attributeoverride]_span']")).click();
		WebElement override_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"));
		//if exist override group pmi attribute override delete
		if(!(override_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
			List<WebElement> overrideGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr"));
			System.out.println(overrideGroupList.size()-1);
			for(int i=1;i<overrideGroupList.size();i++){
				new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"))).perform();
				hmcPage.hmcOverride_rightRemove.click(); 
				Common.waitAlertPresent(hmcPage.PageDriver, 5);
				hmcPage.PageDriver.switchTo().alert().accept();
				hmcPage.PageDriver.switchTo().defaultContent();
				hmcPage.SaveButton.click();
				Common.sleep(3000);
			}
		}		
		
		//attribute override
		hmcPage.Catalog_AttributeOverrideTabLink.click();	
		//check the groupList if exist attribute data
		WebElement AttributeOverride_groupResult = driver.findElement(By.xpath("//*[contains(text(),'Group Attribute Override:')]/../../td/table//tr[2]"));		
		//if exist group attribute override delete
		if(!(AttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
			List<WebElement> groupList = driver.findElements(By.xpath("//*[contains(text(),'Group Attribute Override:')]/../../td/table//div//tr"));
			System.out.print("The attribute override group level info have : ");
			System.out.println(groupList.size()-1);
			for(int i=1;i<groupList.size();i++){
				new Actions(driver).contextClick(driver.findElement(By.xpath("//*[contains(text(),'Group Attribute Override:')]/../../td/table//tr[2]"))).perform();
				hmcPage.hmcOverride_rightRemove.click(); 
				Common.waitAlertPresent(hmcPage.PageDriver, 5);
				hmcPage.PageDriver.switchTo().alert().accept();
				hmcPage.PageDriver.switchTo().defaultContent();
				Common.sleep(2000);
				hmcPage.SaveButton.click();
				Common.sleep(3000);
			}
		}
		
		//create attribute override
		Common.rightClick(driver, driver.findElement(By.xpath(".//div[contains(text(),'Group Attribute Override')]/../../td/table//tr[1]//div[text()='Attribute']")));
		String currentWindowHandle=driver.getWindowHandle();
		Common.sleep(3000);
		hmcPage.AttributeOverride_rightCreate.click();		
		Common.sleep(2000);
		changeWindow(true,currentWindowHandle);
		Common.sleep(2000);
		driver.findElement(By.xpath("//select[contains(@id,'AttributeOverrideSelectEditor[in Attribute[.descriptorAttribute]')]/option[@value='4']")).click();
		if(summary.equals("test KO summary")){
			driver.findElement(By.xpath("//img[contains(@id,'NemoLocalizableAttribute')]")).click();
			Common.sleep(1000);
			driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).clear();
			driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).sendKeys(summary);
			Common.sleep(1000);
			driver.findElement(By.xpath("//a[contains(@id,'NemoLocalizableAttribute')]")).click();
			Common.sleep(1000);
		}else{
			driver.findElement(By.xpath("//input[contains(@id,'StringEditor[in NemoLocalizableAttribute')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'StringEditor[in NemoLocalizableAttribute')]")).sendKeys(summary);
		}		
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
		Common.sleep(3000);
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
		Common.sleep(3000);
		hmcPage.active.click();
		hmcPage.SaveButton.click();
		changeWindow(false,currentWindowHandle);
		hmcPage.SaveButton.click();	
		Common.sleep(2000);
		HMCCommon.cleanRadis(hmcPage, productNo);
		Common.sleep(5000);
	}
	
	
	//2.classification attribute override
	public void classificationOverrideOnHmc(String productNo,String height) throws InterruptedException {
		//login HMC console
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		Common.sleep(2000);
		HMCCommon.searchOnlineProduct(driver, hmcPage, productNo);
		Common.sleep(3000);
		
		//calssification attribute override		
		Common.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@id,'OptionCompatibility.tab.classattributeoverride')]")).click();
		WebElement classificationAttributeOverride_groupResult = driver.findElement(By.xpath("//*[contains(text(),'Group Class Attribute Override:')]/../../td/table//tr[2]"));
		
		//if exist group classification attribute override delete
		if(!(classificationAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
			List<WebElement> groupList = driver.findElements(By.xpath("//*[contains(text(),'Group Class Attribute Override:')]/../../td/table//div//tr"));
			System.out.print("The classification attribute override group level info have : ");
			System.out.println(groupList.size()-1);
			for(int i=1;i<groupList.size();i++){
				new Actions(driver).contextClick(driver.findElement(By.xpath("//*[contains(text(),'Group Class Attribute Override:')]/../../td/table//tr[2]"))).perform();
				hmcPage.hmcOverride_rightRemove.click(); 
				Common.waitAlertPresent(hmcPage.PageDriver, 5);
				hmcPage.PageDriver.switchTo().alert().accept();
				hmcPage.PageDriver.switchTo().defaultContent();
				Common.sleep(2000);
				hmcPage.SaveButton.click();
				Common.sleep(3000);
			}
		}
		
		//create classification attribute override
		Common.rightClick(driver, driver.findElement(By.xpath(".//div[contains(text(),'Group Class Attribute Override')]/../../td/table//tr[1]//div[text()='Classification Attribute']")));
		String currentWindowHandle=driver.getWindowHandle();
		Common.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@id,'create_ClassificationAttributeOverrideRules_label')]")).click();		
		Common.sleep(2000);
		changeWindow(true,currentWindowHandle);
		Common.sleep(2000);
		driver.findElement(By.xpath("//select[contains(@id,'ClassAttributeOverrideSelectEditor')]/option[@value='41']")).click();
		if(height.equals("test KO height")){
			driver.findElement(By.xpath("//img[contains(@id,'NemoLocalizableAttribute')]")).click();
			Common.sleep(1000);
			driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).clear();
			driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).sendKeys(height);
			Common.sleep(1000);
			driver.findElement(By.xpath("//a[contains(@id,'NemoLocalizableAttribute')]")).click();
			Common.sleep(1000);
		}else{
			driver.findElement(By.xpath("//input[contains(@id,'StringEditor[in NemoLocalizableAttribute')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'StringEditor[in NemoLocalizableAttribute')]")).sendKeys(height);
		}		
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
		Common.sleep(3000);
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
		Common.sleep(3000);
		hmcPage.active.click();
		hmcPage.SaveButton.click();
		changeWindow(false,currentWindowHandle);		
		hmcPage.SaveButton.click();
		Common.sleep(3000);
		HMCCommon.cleanRadis(hmcPage, productNo);
		Common.sleep(5000);
	}
	
	
	//3.pmi attribute override
	public String pmiAttributeOverrideOnHmc(String productNo,String pmi,Boolean pmiFlag) throws InterruptedException {
		String mediaUrl = null;
		//login HMC console
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		Common.sleep(2000);
		HMCCommon.searchOnlineProduct(driver, hmcPage, productNo);
		Common.sleep(3000);
		
		//pmi attribute override
		driver.findElement(By.xpath("//span[@id='Content/EditorTab[OptionCompatibility.tab.pmi.attributeoverride]_span']")).click();
		if(pmiFlag.equals(true)) {
			WebElement override_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"));
			//if exist override group pmi attribute override delete
			if(!(override_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
				List<WebElement> overrideGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr"));
				System.out.println(overrideGroupList.size()-1);
				for(int i=1;i<overrideGroupList.size();i++){
					new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"))).perform();
					hmcPage.hmcOverride_rightRemove.click(); 
					Common.waitAlertPresent(hmcPage.PageDriver, 5);
					hmcPage.PageDriver.switchTo().alert().accept();
					hmcPage.PageDriver.switchTo().defaultContent();
					hmcPage.SaveButton.click();
				}
			}
			//create override pmi attribute override
			Common.rightClick(driver, hmcPage.PMIOverride_GroupAttribute);
			String currentWindowHandle=driver.getWindowHandle();
			Common.sleep(3000);
			hmcPage.PMIOverride_GroupAttribute_Create.click();		
			Common.sleep(2000);
			changeWindow(true,currentWindowHandle);
			Common.sleep(2000);
			hmcPage.PMIOverride_MktName_Attribute.click();
			if(pmi.equals("test KO")){
				driver.findElement(By.xpath("//img[contains(@id,'NemoLocalizableAttribute')]")).click();
				Common.sleep(1000);
				driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).clear();
				driver.findElement(By.xpath("//*[contains(text(),'ko')]/../../td[last()]//input")).sendKeys(pmi);
				Common.sleep(1000);
				driver.findElement(By.xpath("//a[contains(@id,'NemoLocalizableAttribute')]")).click();
				Common.sleep(1000);
			}else{
				driver.findElement(By.xpath(".//*[@id='StringEditor[in NemoLocalizableAttribute[.stringValue]]_input']")).clear();
				driver.findElement(By.xpath(".//*[@id='StringEditor[in NemoLocalizableAttribute[.stringValue]]_input']")).sendKeys(pmi);
			}		
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
			Common.sleep(3000);
			hmcPage.active.click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);				
			hmcPage.SaveButton.click();
			
			//pmi text override
			//if exist text group pmi attribute override delete
			WebElement text_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"));
			if(!(text_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
				List<WebElement> textGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr"));
				System.out.println(textGroupList.size()-1);
				for(int i=1;i<textGroupList.size();i++){
					new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"))).perform();
					hmcPage.hmcOverride_rightRemove.click(); 
					Common.waitAlertPresent(hmcPage.PageDriver, 5);
					hmcPage.PageDriver.switchTo().alert().accept();
					hmcPage.PageDriver.switchTo().defaultContent();
					hmcPage.SaveButton.click();
				}
			}
			//create text group pmi attribute override	
			Common.rightClick(driver, hmcPage.PMIOverride_GroupText);
			currentWindowHandle=driver.getWindowHandle();
			Common.sleep(3000);
			hmcPage.PMIOverride_GroupText_Create.click();		
			Common.sleep(2000);
			changeWindow(true,currentWindowHandle);
			Common.sleep(2000);
			hmcPage.PMIOverride_DesLong_Attribute.click();
			if(pmi.equals("test KO")){
				driver.findElement(By.xpath("//img[contains(@id,'NemoLocalizableAttribute')]")).click();
				Common.sleep(1000);
				driver.findElement(By.xpath("//div[contains(text(),'ko')]/../../td[last()]//iframe")).sendKeys(pmi);
				Common.sleep(1000);
				driver.findElement(By.xpath("//a[contains(@id,'NemoLocalizableAttribute')]")).click();
				Common.sleep(1000);
			}else{
				driver.findElement(By.xpath("//iframe[contains(@id,'setvalue_ifr')]")).sendKeys(pmi);
			}		
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
			Common.sleep(3000);
			driver.findElement(By.xpath("//div[contains(@class,'booleanEditorChip')]/span[contains(text(),'Yes')]")).click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);				
			hmcPage.SaveButton.click();
			
			//delete mkt_desc_name value under 'Properties' tab
			if(pmi.equals("") || pmi.equals("test KO")) {
				driver.findElement(By.xpath("//span[contains(@id,'OptionCompatibility.tab.product.properties')]")).click();
				driver.findElement(By.xpath("//img[contains(@id,'OptionCompatibility.description')]")).click();
				Common.sleep(5000);
				WebElement iframe_en = driver.findElement(By.xpath("//div[contains(text(),'en')]/../../td[last()]//iframe"));
				driver.switchTo().frame(iframe_en);
				driver.findElement(By.xpath("//body[contains(@id,'tinymce')]")).clear();
				driver.switchTo().defaultContent();
				WebElement iframe_en_GB = driver.findElement(By.xpath("//div[contains(text(),'en_GB')]/../../td[last()]//iframe"));
				driver.switchTo().frame(iframe_en_GB);
				driver.findElement(By.xpath("//body[contains(@id,'tinymce')]")).clear();
				driver.switchTo().defaultContent();
				WebElement iframe_ja = driver.findElement(By.xpath("//div[contains(text(),'ja')]/../../td[last()]//iframe"));
				driver.switchTo().frame(iframe_ja);
				driver.findElement(By.xpath("//body[contains(@id,'tinymce')]")).clear();
				driver.switchTo().defaultContent();
				WebElement iframe_ja_JP = driver.findElement(By.xpath("//div[contains(text(),'ja_JP')]/../../td[last()]//iframe"));
				driver.switchTo().frame(iframe_ja_JP);
				driver.findElement(By.xpath("//body[contains(@id,'tinymce')]")).clear();
				driver.switchTo().defaultContent();
				hmcPage.SaveButton.click();
				Common.sleep(3000);
				driver.findElement(By.xpath("//span[@id='Content/EditorTab[OptionCompatibility.tab.pmi.attributeoverride]_span']")).click();
				Common.sleep(2000);
			}
						
			//if exist media group pmi attribute override delete
			WebElement media_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Media Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"));
			//if exist media group pmi attribute override delete
			if(!(media_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
				List<WebElement> mediaGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Media Attribute Override')]/../../td[last()]/table//table/tbody/tr"));
				System.out.println(mediaGroupList.size()-1);
				for(int i=1;i<mediaGroupList.size();i++){
					new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Media Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"))).perform();
					hmcPage.hmcOverride_rightRemove.click(); 
					Common.waitAlertPresent(hmcPage.PageDriver, 5);
					hmcPage.PageDriver.switchTo().alert().accept();
					hmcPage.PageDriver.switchTo().defaultContent();
					hmcPage.SaveButton.click();
				}
			}
			//create media group pmi attribute override	
			Common.rightClick(driver, driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Media Attribute Override')]/../..//td[last()]/table//table/tbody/tr[1]//div[text()='Attribute']")));
			currentWindowHandle=driver.getWindowHandle();
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'create_PmiMediaAttributeOverrideRules_label')]")).click();		
			Common.sleep(2000);
			changeWindow(true,currentWindowHandle);
			Common.sleep(2000);
			driver.findElement(By.xpath("//select[contains(@id,'AttributeOverrideSelectEditor[in Attribute')]/option[@value='0']")).click();
			if(pmi.equals("")) {
				
			}else if(pmi.equals("test KO")){
				driver.findElement(By.xpath("//img[contains(@id,'NemoLocalizableAttribute[.mediaValue]_img')]")).click();
				Common.sleep(1000);
				String currentWindow = driver.getWindowHandle();
				driver.findElement(By.xpath("//div[contains(text(),'ko')]/../../td[last()]//a")).click();
				changeWindow(true,currentWindow);
				driver.findElement(By.xpath("//span[contains(@id,'searchbutton')]")).click();
				Common.sleep(5000);
				driver.findElement(By.xpath("//div[contains(@class,'gislcResultList')]//tr[12]")).click();
				driver.findElement(By.xpath("//span[contains(@id,'[Media]_use')]")).click();
				changeWindow(true,currentWindowHandle);
				driver.findElement(By.xpath("//a[contains(@id,'NemoLocalizableAttribute[.mediaValue]_languagetoggle')]")).click();
				Common.sleep(1000);
			}else{
				String currentWindow = driver.getWindowHandle();
				driver.findElement(By.xpath("//img[contains(@id,'MediaEditor[in NemoLocalizableAttribute[.mediaValue]]_img')]")).click();
				changeWindow(true,currentWindow);
				driver.findElement(By.xpath("//span[contains(@id,'searchbutton')]")).click();
				driver.findElement(By.xpath("//div[contains(@class,'gislcResultList')]//tr[12]")).click();
				driver.findElement(By.xpath("//span[contains(@id,'[Media]_use')]")).click();
				Common.sleep(2000);
				changeWindow(true,currentWindowHandle);
				mediaUrl = driver.findElement(By.xpath("//td[contains(text(),'URL')]/../td[last()]")).getText().toString();
				System.out.println(mediaUrl);
			}		
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
			Common.sleep(3000);
			driver.findElement(By.xpath("//div[contains(@class,'booleanEditorChip')]/span[contains(text(),'Yes')]")).click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);				
			hmcPage.SaveButton.click();
			
			//delete mkt_desc_name value under 'Properties' tab
			if(pmi.equals("") || pmi.equals("test KO")) {
				driver.findElement(By.xpath("//span[contains(@id,'OptionCompatibility.tab.product.multimedia')]")).click();
				if(!(Common.isElementExist(driver, By.xpath("//div[contains(text(),'Image:')]/../../td[last()]//td[contains(text(),'n/a')]"), 3))) {
					Common.rightClick(driver, driver.findElement(By.xpath("//div[contains(text(),'Image:')]/../../td[last()]")));
					driver.findElement(By.xpath("//td[contains(@id,'clear_true_label')]")).click();
				}
				if(!(Common.isElementExist(driver, By.xpath("//div[contains(text(),'Thumbnail:')]/../../td[last()]//td[contains(text(),'n/a')]"), 3))) {
					Common.rightClick(driver, driver.findElement(By.xpath("//div[contains(text(),'Thumbnail:')]/../../td[last()]")));
					driver.findElement(By.xpath("//td[contains(@id,'clear_true_label')]")).click();
				}
				hmcPage.SaveButton.click();
			}
			
			HMCCommon.cleanRadis(hmcPage, productNo);
			Common.sleep(5000);
		}else {
			WebElement collection_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Collection Attribute Override:')]/../../td[last()]/table//table/tbody/tr[2]"));
			//if exist override group pmi attribute override delete
			if(!(collection_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
				List<WebElement> overrideGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Collection Attribute Override:')]/../../td[last()]/table//table/tbody/tr"));
				System.out.println(overrideGroupList.size()-1);
				for(int i=1;i<overrideGroupList.size();i++){
					new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Collection Attribute Override')]/../../td[last()]/table//table/tbody/tr[1]//div[text()='Attribute']"))).perform();
					hmcPage.hmcOverride_rightRemove.click(); 
					Common.waitAlertPresent(hmcPage.PageDriver, 5);
					hmcPage.PageDriver.switchTo().alert().accept();
					hmcPage.PageDriver.switchTo().defaultContent();
					hmcPage.SaveButton.click();
				}
			}
			//create collection override pmi attribute override
			Common.rightClick(driver, driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Collection Attribute Override')]/../../td[last()]/table//table/tbody/tr[1]//div[text()='Attribute']")));
			String currentWindowHandle=driver.getWindowHandle();
			Common.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@id,'create_PmiCollectionAttributeOverrideRules_label')]")).click();		
			Common.sleep(2000);
			changeWindow(true,currentWindowHandle);
			Common.sleep(2000);
			driver.findElement(By.xpath("//select[contains(@id,'AttributeOverrideSelectEditor[in Attribute')]/option[@value='11']")).click();		
			driver.findElement(By.xpath("//select[contains(@id,'[.productStatus]')]/option[@value='1']")).click();;	
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
			Common.sleep(3000);
			hmcPage.active.click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);				
			hmcPage.SaveButton.click();
						
			WebElement boolean_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Boolean Attribute Override:')]/../../td[last()]/table//table/tbody/tr[2]"));
			//if exist override group pmi attribute override delete
			if(!(boolean_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
				List<WebElement> overrideGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Boolean Attribute Override:')]/../../td[last()]/table//table/tbody/tr"));
				System.out.println(overrideGroupList.size()-1);
				for(int i=1;i<overrideGroupList.size();i++){
					new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Boolean Attribute Override:')]/../../td[last()]/table//table/tbody/tr"))).perform();
					hmcPage.hmcOverride_rightRemove.click(); 
					Common.waitAlertPresent(hmcPage.PageDriver, 5);
					hmcPage.PageDriver.switchTo().alert().accept();
					hmcPage.PageDriver.switchTo().defaultContent();
					hmcPage.SaveButton.click();
				}
			}
			//create boolean override pmi attribute override
			Common.rightClick(driver, driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Boolean Attribute Override:')]/../../td[last()]/table//table/tbody/tr[1]//div[text()='Attribute']")));
			currentWindowHandle=driver.getWindowHandle();
			Common.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@id,'create_PmiBooleanAttributeOverrideRules_label')]")).click();		
			Common.sleep(2000);
			changeWindow(true,currentWindowHandle);
			Common.sleep(2000);
			driver.findElement(By.xpath("//select[contains(@id,'AttributeOverrideSelectEditor[in Attribute')]/option[@value='3']")).click();		
			driver.findElement(By.xpath("//input[contains(@id,'BooleanEditor[in Attribute[.booleanValue]]_false')]")).click();;	
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
			Common.sleep(3000);
			driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
			Common.sleep(3000);
			driver.findElement(By.xpath("//div[contains(@class,'booleanEditorChip')]/span[contains(text(),'Yes')]")).click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);				
			hmcPage.SaveButton.click();
			
			HMCCommon.cleanRadis(hmcPage, productNo);
			Common.sleep(5000);
		}
		return mediaUrl;
	}
	
	
	
	public void subseriesPmiAttributeOverrideOnHmc(String productNo,String pmi) throws InterruptedException {
		//login HMC console
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		Common.sleep(2000);
		HMCCommon.searchOnlineProduct(driver, hmcPage, productNo);
		Common.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(@id,'tab.pmi.attributeoverride')]")).click();
		//pmi text override
		//if exist text group pmi attribute override delete
		WebElement text_pmiAttributeOverride_groupResult = driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"));
		if(!(text_pmiAttributeOverride_groupResult.getText().toString().equals("The list is empty."))){
			List<WebElement> textGroupList = driver.findElements(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr"));
			System.out.println(textGroupList.size()-1);
			for(int i=1;i<textGroupList.size();i++){
				new Actions(driver).contextClick(driver.findElement(By.xpath(".//div[contains(text(),'Group PMI Text Attribute Override')]/../../td[last()]/table//table/tbody/tr[2]"))).perform();
				hmcPage.hmcOverride_rightRemove.click(); 
				Common.waitAlertPresent(hmcPage.PageDriver, 5);
				hmcPage.PageDriver.switchTo().alert().accept();
				hmcPage.PageDriver.switchTo().defaultContent();
				hmcPage.SaveButton.click();
			}
		}
		//create text group pmi attribute override	
		Common.rightClick(driver, hmcPage.PMIOverride_GroupText);
		String currentWindowHandle=driver.getWindowHandle();
		Common.sleep(3000);
		hmcPage.PMIOverride_GroupText_Create.click();		
		Common.sleep(2000);
		changeWindow(true,currentWindowHandle);
		Common.sleep(2000);
		driver.findElement(By.xpath(".//*[contains(@id,'descriptorAttribute')]/option[contains(text(),'mkt_desc_short')]")).click();		
		driver.findElement(By.xpath("//iframe[contains(@id,'setvalue_ifr')]")).sendKeys(pmi);			
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys("jppublic_unit");
		Common.sleep(3000);
		driver.findElement(By.xpath(".//*[contains(@id,'ajaxinput_AutocompleteReferenceEditor[in Attribute[.group]')]")).sendKeys(Keys.ENTER);			
		Common.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'booleanEditorChip')]/span[contains(text(),'Yes')]")).click();
		hmcPage.SaveButton.click();
		changeWindow(false,currentWindowHandle);				
		hmcPage.SaveButton.click();
		
		HMCCommon.cleanRadis(hmcPage, productNo);
		Common.sleep(5000);
	}
	
	
	public void changeWindow(boolean flag,String currentHandle){
		Common.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		if(flag){
			for(String hanedle:windowHandles){
				if(!hanedle.equals(currentHandle)){
					driver.switchTo().window(hanedle);
				}
			}
		}else{
			driver.close();
			driver.switchTo().window(currentHandle);			
		}
	}
	
	
	public void cleanBrowser(){
		driver.get("chrome://settings/clearBrowserData");
		Common.sleep(2000);		
		driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();	
		Common.sleep(10000);
	}
}