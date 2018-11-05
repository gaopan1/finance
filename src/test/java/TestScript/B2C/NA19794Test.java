package TestScript.B2C;

import java.text.DecimalFormat;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import CommonFunction.B2CCommon;
import CommonFunction.Common;
import CommonFunction.EMailCommon;
import CommonFunction.HMCCommon;
import Logger.Dailylog;
import Pages.B2CPage;
import Pages.HMCPage;
import TestScript.SuperTestClass;

public class NA19794Test extends SuperTestClass {
	public B2CPage b2cPage;
	public HMCPage hmcPage;
	String unit;

	public NA19794Test(String store, String unit) {
		this.Store = store;
		this.unit = unit;
		this.testName = "NA-19794";
	}

	@Test(priority = 0,alwaysRun = true, groups = {"browsegroup","uxui",  "p2", "b2c"})
	public void NA19794(ITestContext ctx) {
		try {
			this.prepareTest();
			b2cPage = new B2CPage(driver);
			hmcPage = new HMCPage(driver);
			String color="FFB6C1";
			String colorRGB ="rgb(255, 182, 193)";
			String label ="Store near me";
			String CTALink = "L470 CTA url test";
			String URL = "https://www.baidu.com/";
			String partNum = "20J5A08WIG";
			String MTNum = "22TP2TBL470";
			String pageID="page_00007SVC";
			
			String currentHandle;
			
			// step 1 login hmc
			driver.get(testData.HMC.getHomePageUrl());
			HMCCommon.Login(hmcPage, testData);
			Dailylog.logInfoDB(1, "Login hmc", Store, testName);

			// step 2 Go to B2C unit, search B2C UNIT
			hmcPage.Home_B2CCommercelink.click();
			hmcPage.Home_B2CUnitLink.click();
			hmcPage.B2CUnit_IDTextBox.sendKeys(unit);
			hmcPage.B2CUnit_SearchButton.click();
			Common.sleep(2000);
			hmcPage.B2CUnit_FirstSearchResultItem.click();
			Dailylog.logInfoDB(2, "search B2C UNIT", Store, testName);
			
			// step 3 Stay in 'site attributes'
			Common.sleep(2000);
			hmcPage.B2CUnit_SiteAttributeTab.click();
			Common.scrollToElement(driver, hmcPage.Indirect_site);
			hmcPage.Indirect_site.click();
			hmcPage.PaymentLeasing_saveAndCreate.click();
			Dailylog.logInfoDB(3, "save Indirect_site price", Store, testName);
			
			//step 4 Under "site attrubutes":
			Common.sleep(3000);
			Common.scrollToElement(driver, hmcPage.CTA_backgroundcolor);
			hmcPage.CTA_backgroundcolor.clear();
			hmcPage.CTA_backgroundcolor.sendKeys(color);
			hmcPage.CTA_label.clear();
			hmcPage.CTA_label.sendKeys(label);
			hmcPage.PaymentLeasing_saveAndCreate.click();
			Dailylog.logInfoDB(4, "save Indirect_site price", Store, testName);
			
			//step 5 Go HMC->category->Product->PMI tab
			Common.sleep(3000);
			hmcPage.Home_CatalogLink.click();
			hmcPage.Home_ProductsLink.click();
			hmcPage.Catalog_ArticleNumberTextBox.sendKeys(partNum);
			Common.sleep(1000);
			hmcPage.Catalog_CatalogVersion.click();
			hmcPage.Catalog_MasterMultiCountryProductCatalogOnline.click();
			Common.sleep(1000);
			hmcPage.Catalog_SearchButton.click();
			Common.sleep(2000);
			Common.doubleClick(driver, hmcPage.Catalog_MultiCountryCatOnlineLinkInSearchResult);
			Common.sleep(5000);
			Dailylog.logInfoDB(11, "Click on search result(Searched with part number)", Store, testName);
			hmcPage.Catalog_PMITab.click();
			
			//check if cta link exist
			hmcPage.Catalog_ctaLinksearch.click();
			currentHandle = driver.getWindowHandle();
			changeWindow(true,currentHandle);
			hmcPage.Catalog_ctaLink_id.clear();
			hmcPage.Catalog_ctaLink_id.sendKeys(CTALink);		
			
			//select the catalog_version
			driver.findElement(By.xpath(".//*[@id='AllInstancesSelectEditor[in GenericCondition[NemoLinkComponent.catalogVersion]]_select']/option[contains(text(),'	ap-inContentCatalog - Online')]")).click();
			hmcPage.B2BUnit_SearchButton.click();
			if(Common.checkElementExists(driver, hmcPage.Catalog_ctaLink_result, 10)){
				hmcPage.Catalog_ctaLink_result.click();
				hmcPage.checkoutPaymentType_useButton.click();
				driver.switchTo().window(currentHandle);
			}else{
				changeWindow(false,currentHandle);
				createCTALink(CTALink,URL);
			}
			
			//create pmi attribute override on product level
			hmcPage.SaveButton.click();
			hmcPage.Catalog_PMIAttributeOverride.click();
			createPMIOverride(CTALink,unit);
			hmcPage.SaveButton.click();
			hmcPage.Home_closeSession.click();
			
			//check pdp page cta link 
			driver.get(testData.B2C.getHomePageUrl().replace("au/en/auweb", "in/en")+"/p/"+partNum);
			Common.sleep(5000);
			Assert.assertTrue(Common.checkElementExists(driver, b2cPage.Product_CTALink, 10),"Check Store near me is existed");
			System.out.println("Check the Custome Tab:"+"Store near me exist");
			Common.scrollToElement(driver, b2cPage.Product_CTALink);
			System.out.println(b2cPage.Product_CTALink.getAttribute("style"));
			Assert.assertTrue(b2cPage.Product_CTALink.getText().equals(label), "check the cta name");		
			Assert.assertTrue(b2cPage.Product_CTALink.getAttribute("style").contains(colorRGB), "check the cta color");
			
			//add check model exist		
			Assert.assertTrue(Common.checkElementExists(driver, b2cPage.Product_ViewCurrentModelTab, 3), "check the model tab is not exist");
			System.out.println("Check the Model tab exist:"+Common.checkElementExists(driver, b2cPage.Product_ViewCurrentModelTab, 1));				
			b2cPage.Product_CTALink.click();
			Common.sleep(3000);
			System.out.println(driver.getCurrentUrl().equals(URL));
			Assert.assertTrue(driver.getCurrentUrl().equals(URL),"check cta link is correct");
			
			
			//maintence ctabutton link on sub series page
			driver.get(testData.HMC.getHomePageUrl());
			HMCCommon.Login(hmcPage, testData);
			Dailylog.logInfoDB(1, "Login hmc", Store, testName);
			
			//Go HMC->category->Product->PMI tab->Hide model
			Common.sleep(3000);
			hmcPage.Home_CatalogLink.click();
			hmcPage.Home_ProductsLink.click();
			hmcPage.Catalog_ArticleNumberTextBox.sendKeys(MTNum);
			Common.sleep(1000);
			hmcPage.Catalog_CatalogVersion.click();
			hmcPage.Catalog_MasterMultiCountryProductCatalogOnline.click();
			Common.sleep(1000);
			hmcPage.Catalog_SearchButton.click();
			Common.sleep(2000);
			Common.doubleClick(driver, hmcPage.Catalog_MultiCountryCatOnlineLinkInSearchResult);
			Common.sleep(2000);
			hmcPage.Catalog_PMITab.click();
			Common.sleep(2000);
			if(hmcPage.Suberies_hide_model.isSelected()) {
				hmcPage.SaveButton.click();
			}else {
				hmcPage.Suberies_hide_model.click();
				hmcPage.SaveButton.click();
			}			
			Common.sleep(3000);
			
			//step 5 Go HMC->category->Product->PMI attribute override tab		
			Dailylog.logInfoDB(11, "Click on search result(Searched with part number)", Store, testName);
			hmcPage.Catalog_PMIAttributeOverride.click();
			createPMIOverride(CTALink,unit);
			hmcPage.SaveButton.click();
			
			//change the page cta link override
			hmcPage.hmcHome_WCMS.click();
			hmcPage.wcmsPage_pages.click();
			hmcPage.Wcms_page_id.clear();
			hmcPage.Wcms_page_id.sendKeys(pageID);
			hmcPage.Wcms_in_category.click();
			hmcPage.wcmsPagesPage_searchButton.click();
			Common.sleep(3000);
			Assert.assertTrue(Common.checkElementDisplays(driver, hmcPage.Wcms_longScrollPage, 5));
			Dailylog.logInfoDB(2, "ID field 'faq' catalogversion field 'aucontentcatalog-online", Store, testName);
			// Step~3  Edit the longScrollCTATempFix: Invisible
			Common.rightClick(driver, hmcPage.Wcms_longScrollPage);
			Common.sleep(1000);
			hmcPage.products_PB_edit.click();
			Dailylog.logInfoDB(3, "Edit the Frequently Asked Questions page located in result list.", Store, testName);
			hmcPage.Product_admin.click();
			changelongScrollCTATempFix();
			hmcPage.SaveButton.click();
			hmcPage.Home_closeSession.click();
			
			//check subseries page ctabutton link 
			driver.get(testData.B2C.getHomePageUrl().replace("au/en/auweb", "in/en")+"/p/"+MTNum);
			Assert.assertTrue(Common.checkElementExists(driver, b2cPage.Product_CTAButtonlink, 10),"Check Store near me is existed");
			Assert.assertTrue(b2cPage.Product_CTAButtonlink.getAttribute("style").contains(colorRGB), "check the cta color");		
			Assert.assertTrue(b2cPage.Product_CTAButtonlink.getText().equals(label), "check the cta color");
			Common.sleep(2000);			
			Assert.assertTrue(!(Common.checkElementExists(driver, b2cPage.Product_ViewCurrentModelTab, 3)), "check the model tab is not exist");
			System.out.println("Check the Model tab is not exist:"+!(Common.checkElementExists(driver, b2cPage.Product_ViewCurrentModelTab, 1)));
			Common.sleep(2000);
			b2cPage.Product_CTAButtonlink.click();
			Common.sleep(3000);
			Assert.assertTrue(driver.getCurrentUrl().equals(URL),"check cta link is correct");
			
			//set subseries hide model unchecked
			driver.get(testData.HMC.getHomePageUrl());
			HMCCommon.Login(hmcPage, testData);
			Dailylog.logInfoDB(1, "Login hmc", Store, testName);
			
			//Go HMC->category->Product->PMI tab->Hide model
			Common.sleep(3000);
			hmcPage.Home_CatalogLink.click();
			hmcPage.Home_ProductsLink.click();
			hmcPage.Catalog_ArticleNumberTextBox.sendKeys(MTNum);
			Common.sleep(1000);
			hmcPage.Catalog_CatalogVersion.click();
			hmcPage.Catalog_MasterMultiCountryProductCatalogOnline.click();
			Common.sleep(1000);
			hmcPage.Catalog_SearchButton.click();
			Common.sleep(2000);
			Common.doubleClick(driver, hmcPage.Catalog_MultiCountryCatOnlineLinkInSearchResult);
			Common.sleep(2000);
			hmcPage.Catalog_PMITab.click();
			Common.sleep(2000);
			if(hmcPage.Suberies_hide_model.isSelected()) {
				hmcPage.Suberies_hide_model.click();
				hmcPage.SaveButton.click();
				Common.sleep(5000);
			}
			
			
		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}
	}
	
	public void createCTALink(String ID,String URL){
		Common.rightClick(driver, hmcPage.Products_PMI_CTALinkInput);
		
		String currentWindowHandle = driver.getWindowHandle();
		hmcPage.Products_PMI_CTALinkCreate.click();
		changeWindow(true,currentWindowHandle);
		hmcPage.CTALink_ID.clear();
		hmcPage.CTALink_ID.sendKeys(ID);
		hmcPage.CTALink_Name.clear();
		hmcPage.CTALink_Name.sendKeys(ID);
		hmcPage.CTALink_Catalog.click();
		hmcPage.CTALink_External.click();
		hmcPage.CTALink_URL.clear();
		hmcPage.CTALink_URL.sendKeys(URL);
		hmcPage.SaveButton.click();
		changeWindow(false,currentWindowHandle);		
	}
	
    public void changelongScrollCTATempFix(){
		if(hmcPage.Pages_longScrollCTATempFix_Visible.getText().contains("Yes")){
			String currentWindowHandle = driver.getWindowHandle();
			hmcPage.Pages_longScrollCTATempFix_edit.click();
			changeWindow(true,currentWindowHandle);
			hmcPage.Pages_longScrollCTATempFix_changeVisible.click();
			hmcPage.SaveButton.click();
			changeWindow(false,currentWindowHandle);	
		}
	}
	
	public void createPMIOverride(String CTALinkLabel,String unit){
		
		if(Common.checkElementExists(driver, hmcPage.PMIOverride_GroupCollection_Result, 3)){
			Common.rightClick(driver, hmcPage.PMIOverride_GroupCollection);
			hmcPage.PMIOverride_GroupCollection_SelectAll.click();
			Common.sleep(3000);
			Common.waitElementClickable(driver,  hmcPage.PMIOverride_GroupCollection, 10);
			Common.rightClick(driver, hmcPage.PMIOverride_GroupCollection);
			hmcPage.PMIOverride_GroupCollection_Remove.click();
			Alert alert= driver.switchTo().alert();
			alert.accept();
			Common.sleep(2000);
			hmcPage.SaveButton.click();
		}
		
		Common.rightClick(driver, hmcPage.PMIOverride_GroupCollection);
		String currentHandle=driver.getWindowHandle();
		hmcPage.PMIOverride_GroupCollection_Create.click();
		changeWindow(true,currentHandle);
		hmcPage.PMIOverride_CTAButtonLink_Attribute.click();
		hmcPage.PMIOverride_CTAButtonLink_Input.clear();
		hmcPage.PMIOverride_CTAButtonLink_Input.sendKeys(CTALinkLabel);
		String  PMIOverride_CTAButtonLink_Result = ".//*[contains(@id,'AutocompleteReferenceEditor[in Attribute[.ctaButtonLink]')][contains(text(),'"+CTALinkLabel+"')]";
		Common.waitElementClickable(driver, driver.findElement(By.xpath(PMIOverride_CTAButtonLink_Result)), 10);
		driver.findElement(By.xpath(PMIOverride_CTAButtonLink_Result)).click();		
		hmcPage.PMIOverride_CTAButtonLink_GroupInput.clear();
		hmcPage.PMIOverride_CTAButtonLink_GroupInput.sendKeys(unit);
		String  PMIOverride_CTAButtonLink_GroupResult = ".//*[contains(@id,'AutocompleteReferenceEditor[in Attribute[.group]')][contains(@id,'"+unit+"')]";
		Common.waitElementClickable(driver, driver.findElement(By.xpath(PMIOverride_CTAButtonLink_GroupResult)), 10);
		driver.findElement(By.xpath(PMIOverride_CTAButtonLink_GroupResult)).click();		
		hmcPage.PMIOverride_CTAButtonLink_Active.click();
		hmcPage.SaveButton.click();	
		changeWindow(false,currentHandle);
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
	

}
