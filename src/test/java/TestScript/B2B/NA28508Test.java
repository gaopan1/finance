package TestScript.B2B;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import CommonFunction.B2BCommon;
import CommonFunction.Common;
import CommonFunction.HMCCommon;
import Logger.Dailylog;
import Pages.B2BPage;
import Pages.HMCPage;
import TestScript.SuperTestClass;

public class NA28508Test extends SuperTestClass {
	public B2BPage b2bPage;
	public HMCPage hmcPage;
	private String country1;

	public NA28508Test(String store, String country) {
		this.Store = store;
		this.testName = "NA-28508";
		this.country1 = country;
	}

	@Test(priority = 0, enabled = true, alwaysRun = true, groups = { "shopgroup", "productbuilder", "p2", "b2b" })
	public void NA28508(ITestContext ctx) {

		try {
			this.prepareTest();
			b2bPage = new B2BPage(driver);
			hmcPage = new HMCPage(driver);

			driver.get(testData.B2B.getLoginUrl());
			B2BCommon.Login(b2bPage, testData.B2B.getBuyerId(), testData.B2B.getDefaultPassword());
			b2bPage.HomePage_productsLink.click();
			b2bPage.HomePage_Laptop.click();

			// 1 part number
			By partNumberX = By.xpath("//*[@id='resultList']/div//dt[contains(.,'Part Number:')]/../dd[1]");
			List<WebElement> partNumber = driver.findElements(partNumberX);
			int partNumberSize = partNumber.size();
			Dailylog.logInfoDB(1, "partNumberSize: " + partNumberSize, Store, testName);
			Assert.assertTrue(partNumberSize > 0, "No avalibale product");
			String product;
			if (partNumberSize > 1) {
				product = partNumber.get(1).getText();
				driver.findElement(By.xpath("(.//a[contains(.,'View Details')])[2]")).click();
			} else {
				product = partNumber.get(0).getText();
				driver.findElement(By.xpath("(.//a[contains(.,'View Details')])[1]")).click();
			}
			// check product builder
			String pdpUrl = driver.getCurrentUrl();
			String addAccessoryXpath = "//form[contains(@id,'addToAccessorisForm')]/button";
			String productType;
			if (Common.checkElementDisplays(driver, By.xpath(addAccessoryXpath), 3)) {
				productType = "mtm";
				b2bPage.PDPPage_AddAccessories.click();
			} else {
				productType = "cto";
				product = pdpUrl.substring(pdpUrl.lastIndexOf('/') + 1, pdpUrl.length());
				b2bPage.Agreement_agreementsAddToCart.click();
			}
			Dailylog.logInfoDB(1, "product: " + product, Store, testName);
			boolean isPBExist = Common.checkElementDisplays(driver,
					By.xpath("//span[contains(text(),'Product Builder')]"), 3);
			Dailylog.logInfoDB(1, "isPBExist: " + isPBExist, Store, testName);
			// get base product
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.open('" + testData.HMC.getHomePageUrl() + "')");
			Common.switchToWindow(driver, 1);
			String baseProduct = getBaseProduct("online", product);
			Dailylog.logInfoDB(1, "baseProduct: " + baseProduct, Store, testName);
			// batch assign by MT if product builder not exist
			if (!isPBExist) {
				List<String> countries = new ArrayList<String>();
				countries.add(country1);
				batchAssingByMT(true, baseProduct, countries, "B2B");
				Common.switchToWindow(driver, 0);
				driver.get(testData.B2B.getLoginUrl());
				B2BCommon.Login(b2bPage, testData.B2B.getBuyerId(), testData.B2B.getDefaultPassword());
				driver.get(pdpUrl);
				if (Common.checkElementDisplays(driver, By.xpath(addAccessoryXpath), 3))
					b2bPage.PDPPage_AddAccessories.click();
				else
					b2bPage.Agreement_agreementsAddToCart.click();
				isPBExist = Common.checkElementDisplays(driver, By.xpath("//span[contains(text(),'Product Builder')]"),
						3);
				Assert.assertTrue(isPBExist, "isPBExist after batch assign by MT");
			}

			Common.switchToWindow(driver, 0);
			String lastWarranty = b2bPage.PB_lastWarranty.getText();
			String tabTitle = "Warranty";
			String sectionTitle = "Warranty Upgrade";
			int groupOrder = 1;
			String groupTitle = lastWarranty;
			


			// Step 2~3: create group order
			String templateTitle;
			Common.switchToWindow(driver, 1);
			templateTitle = getTemplateType(product);
			Dailylog.logInfoDB(0, "templateType: " + templateTitle, Store, testName);
			int windowNo = 1;
			String channel = "B2B";
			String isActive = "Yes";
			boolean isGroupOrderCreated;
			int currentOrder = 0;
			isGroupOrderCreated = editTemplate(templateTitle, tabTitle, windowNo, sectionTitle, groupTitle, country1,
					channel, baseProduct, groupOrder, isActive);
			Assert.assertTrue(isGroupOrderCreated, "section order is not successfully created");
			Dailylog.logInfoDB(2, "group order is created", Store, testName);
			openTestProduct(pdpUrl, productType);
			currentOrder = getGroupOrder(groupTitle);
			Assert.assertEquals(currentOrder, groupOrder, "group order not correct");
			Dailylog.logInfoDB(2, "group order is correct: " + currentOrder, Store, testName);

			// Step 4 Change active to inactive in this section
			isActive = "No";
			isGroupOrderCreated = editTemplate(templateTitle, tabTitle, windowNo, sectionTitle, groupTitle, country1,
					channel, baseProduct, groupOrder, isActive);
			Assert.assertTrue(isGroupOrderCreated, "group order is not successfully created");
			openTestProduct(pdpUrl, productType);
			currentOrder = getGroupOrder(groupTitle);
			Assert.assertNotEquals(currentOrder, groupOrder, "group order not correct");
			Dailylog.logInfoDB(4, "group order is correct: " + currentOrder, Store, testName);


		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}
	}

	private void openTestProduct(String pdpUrl, String productType) {
		Common.switchToWindow(driver, 0);
		driver.get(pdpUrl);
		Common.sleep(5000);
		if (productType.equals("mtm"))
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", b2bPage.PDPPage_AddAccessories);
		else
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", b2bPage.Agreement_agreementsAddToCart);
	}

	private String getTemplateType(String product) throws InterruptedException {
		String templateType = "";
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		driver.navigate().refresh();
		searchProduct("online", product);
		Common.rightClick(driver, hmcPage.Products_baseProduct);
		Common.sleep(2000);
		hmcPage.Products_edit.click();
		Common.waitElementVisible(driver, hmcPage.Products_activeTemplate);
		templateType = hmcPage.Products_activeTemplate.getAttribute("value");
		hmcPage.hmcHome_hmcSignOut.click();
		return templateType;
	}

	private String getBaseProduct(String category, String ProductID) throws InterruptedException {
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		searchProduct(category, ProductID);
		Common.waitElementVisible(driver, hmcPage.Products_baseProduct);
		String baseProduct = hmcPage.Products_baseProduct.getAttribute("value");
		baseProduct = baseProduct.substring(0, 15);
		hmcPage.hmcHome_hmcSignOut.click();
		Dailylog.logInfoDB(0, "baseProduct:" + baseProduct, Store, testName);
		return baseProduct;
	}

	private void searchProduct(String category, String productID) {
		hmcPage.Home_CatalogLink.click();
		Common.waitElementClickable(driver, hmcPage.Home_ProductsLink, 5);
		hmcPage.Home_ProductsLink.click();
		hmcPage.Catalog_ArticleNumberTextBox.sendKeys(productID);
		hmcPage.Catalog_CatalogVersion.click();
		if (category.equals("staged")) {
			hmcPage.Catalog_MasterMultiCountryProductCatalogStaged.click();
		} else if (category.equals("online")) {
			hmcPage.Catalog_MasterMultiCountryProductCatalogOnline.click();
		}
		hmcPage.Catalog_SearchButton.click();
		hmcPage.products_resultItem.click();
	}

	private void batchAssingByMT(Boolean catalogFlag, String mt, List<String> countries, String channel)
			throws InterruptedException {
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		hmcPage.Home_Nemo.click();
		hmcPage.Nemo_productBuilder.click();
		hmcPage.ProductBuidler_batchAssignByMT.click();
		// select catlog version
		driver.switchTo().frame(0);
		hmcPage.ProductBuilder_clickSelCatalogVersion.click();
		if (catalogFlag)
			hmcPage.ProductBuilder_selCatalogVersionOnline.click();
		else
			hmcPage.ProductBuilder_selCatalogVersionStaged.click();
		// select machine type
		hmcPage.ProductBuidler_selectMachineType.click();
		hmcPage.ProductBuidler_machineTypeCodeInput.sendKeys(mt);
		hmcPage.ProductBuidler_searchMachineTypeBtn2.click();
		Common.sleep(5000);
		By targetOptionX = By.xpath(".//*[@id='machineTypeTable']//*[text()='" + mt + "']");
		Common.waitElementClickable(driver, driver.findElement(targetOptionX), 30);
		driver.findElement(targetOptionX).click();
		hmcPage.ProductBuidler_selectMachineTypeBtn.click();
		// select country
		for (String coutry : countries) {
			WebElement targetCountry = driver.findElement(By.xpath("//span[text()='" + coutry + "']"));
			Common.javascriptClick(driver, targetCountry);
			try {
				driver.findElement(
						By.xpath("//span[contains(text(),'" + coutry + "') and @class ='filter-option pull-left']"));
			} catch (NoSuchElementException e) {
				Assert.fail("batch assign by MT: country added failure: " + coutry);
			}
		}
		// search channel
		Select channel1 = new Select(hmcPage.ProductBuidler_channelCode);
		channel1.selectByVisibleText(channel);
		// Assign
		Common.sleep(5000);
		hmcPage.ProductBuilder_submit.click();
		for (int i = 0; i < 3; i++) {
			try {
				Common.waitAlertPresent(driver, 120);
				if (Common.isAlertPresent(driver)) {
					String alertText = driver.switchTo().alert().getText();
					driver.switchTo().alert().accept();
					Dailylog.logInfoDB(0, alertText, Store, testName);
					if (alertText.equals("success"))
						break;
				} else {
					Dailylog.logInfoDB(0, "no batch assign by mt alert", Store, testName);
				}
			} catch (TimeoutException e) {
				Assert.fail("assign MT time>120 seconds");
			}
		}
		driver.switchTo().defaultContent();
		hmcPage.hmcHome_hmcSignOut.click();
		Dailylog.logInfoDB(0, "Batch Asign by MT success", Store, testName);
	}

	private int getGroupOrder(String groupTitle) {
		b2bPage.PB_warrantyTab.click();	
		int order = 0;
		Common.sleep(8000);
		if (Common.checkElementDisplays(driver,
				By.xpath("//header[@id='Warranty']/..//div[@class='group-title']"), 15)) {
			int size = b2bPage.PB_warrantyTitle.size();
			for (int i = 0; i < size; i++) {
				String sectionTitle = b2bPage.PB_warrantyTitle.get(i).getText();
				if (sectionTitle.contains(groupTitle)) {
					order = ++i;
					break;
				}
			}
		}
		return order;
	}


	private boolean editTemplate(String template, String tabTitle, int windowNo, String sectionTitle, String groupTitle,
			String country, String channel, String baseProduct, int sectionOrder, String isActive) {
		By targetTemplateX = By.xpath("(//a[contains(.,'" + template + "')])[1]");
		By targetTabX;
		if (tabTitle.toLowerCase().equals("warranty"))
			targetTabX = By.xpath("(//span[contains(@id,'Warranty')])[1]");
		else
			targetTabX = By.xpath("(//span[contains(@id,'Warranty')])[2]");
		By targetSectionX = By.xpath("//span[contains(@id,'" + sectionTitle + "')]");
		By targetGroupX = By.xpath("//input[@value='" + groupTitle + "']/../../../../../../../..//img");
		Common.switchToWindow(driver, windowNo);
		driver.get(testData.HMC.getHomePageUrl());
		HMCCommon.Login(hmcPage, testData);
		driver.navigate().refresh();
		hmcPage.Home_Nemo.click();
		Common.waitElementClickable(driver, hmcPage.Nemo_productBuilder, 5);
		hmcPage.Nemo_productBuilder.click();
		Common.waitElementClickable(driver, hmcPage.Nemo_template, 5);
		hmcPage.Nemo_template.click();
		Common.sleep(1000);
		hmcPage.Catalog_CatalogVersion.click();
		hmcPage.Catalog_MasterMultiCountryProductCatalogOnline.click();
		Common.sleep(1000);
		hmcPage.Contract_searchbutton.click();
		Common.sleep(2000);

		// open target template
		WebElement targetTemplate = driver.findElement(targetTemplateX);
		targetTemplate.click();
		Common.sleep(2000);

		// open target tab
		WebElement targetTab = driver.findElement(targetTabX);
		targetTab.click();
		Common.sleep(2000);
		Common.switchToWindow(driver, ++windowNo);

		// open target section
		WebElement targetSection = driver.findElement(targetSectionX);
		targetSection.click();
		Common.sleep(2000);
		Common.switchToWindow(driver, ++windowNo);

		// open target group
		WebElement targetGroup = driver.findElement(targetGroupX);
		targetGroup.click();
		Common.sleep(2000);
		Common.switchToWindow(driver, ++windowNo);

		// create group order
		By targetGroupOrderX1 = By.xpath("//table[@title='groupOrders']//table//table//tr[contains(.,'" + country
				+ "') and contains(.,'" + channel + "') and contains(.,'" + baseProduct + "')]");
		By targetGroupOrderX2 = By.xpath("//table[@title='groupOrders']//table//table//tr[contains(.,'" + country
				+ "') and contains(.,'" + channel + "') and contains(.,'" + baseProduct + "')]/td[7][contains(.,'"
				+ isActive + "')]/../td[6][contains(.,'" + sectionOrder + "')]");
		if (Common.isElementExist(driver, targetGroupOrderX1)) {
			WebElement targetGroupOrder = driver.findElement(targetGroupOrderX1);
			Common.doubleClick(driver, targetGroupOrder);
		} else {
			Common.rightClick(driver, hmcPage.Template_groupOrders);
			hmcPage.Template_ProductOptionGroupOrder.click();
		}
		Common.switchToWindow(driver, ++windowNo);
		Select countrySel = new Select(hmcPage.Template_country);
		countrySel.selectByVisibleText(country);
		Select channelSel = new Select(hmcPage.Template_channel);
		channelSel.selectByVisibleText(channel);
		hmcPage.Template_machineTypeSearch.click();
		Common.switchToWindow(driver, ++windowNo);
		hmcPage.Template_articleNumber.sendKeys(baseProduct);
		Common.sleep(500);
		Common.waitElementClickable(driver, hmcPage.Template_selCatalogVersionOnline, 5);
		hmcPage.Template_selCatalogVersionOnline.click();
		hmcPage.Template_searchBtn.click();
		hmcPage.Template_searchedHierarchy.click();
		hmcPage.Template_useBtn.click();
		Common.switchToWindow(driver, --windowNo);
		hmcPage.Template_sortOrderNumber.clear();
		hmcPage.Template_sortOrderNumber.sendKeys(String.valueOf(sectionOrder));
		if (isActive.toLowerCase().equals("yes")) {
			if (!hmcPage.Template_actived.isSelected())
				hmcPage.Template_actived.click();
		} else {
			if (hmcPage.Template_actived.isSelected())
				hmcPage.Template_actived.click();
		}

		// save section order
		hmcPage.Template_saveBtn.click();
		Common.sleep(5000);
		driver.close();
		// verify group order saved successfully and close group
		Common.switchToWindow(driver, --windowNo);
		Common.sleep(8000);
		boolean isCreated = Common.isElementExist(driver, targetGroupOrderX2);
		driver.close();
		// close section
		Common.switchToWindow(driver, --windowNo);
		driver.close();
		// close tab
		Common.switchToWindow(driver, --windowNo);
		driver.close();
		// switch back to template
		Common.switchToWindow(driver, --windowNo);
		hmcPage.hmcHome_hmcSignOut.click();
		return isCreated;
	}

}
