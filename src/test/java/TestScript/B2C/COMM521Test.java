package TestScript.B2C;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import CommonFunction.B2CCommon;
import CommonFunction.Common;
import CommonFunction.HMCCommon;
import Logger.Dailylog;
import Pages.B2CPage;
import Pages.HMCPage;
import TestScript.SuperTestClass;
import junit.framework.Assert;

public class COMM521Test extends SuperTestClass {

	public B2CPage b2cPage;
	public HMCPage hmcPage;

	public String Url;
	public String subscription = "SQG1S0B013333";

	public COMM521Test(String Store) {
		this.Store = Store;

		this.testName = "COMM-521";
	}

	public void closePromotion(WebDriver driver, B2CPage page) {
		By Promotion = By.xpath(".//*[@title='Close (Esc)']");

		if (Common.isElementExist(driver, Promotion)) {

			Actions actions = new Actions(driver);

			actions.moveToElement(page.PromotionBanner).click().perform();

		}
	}


	public void HandleJSpring(WebDriver driver, B2CPage b2cPage, String loginID, String pwd) {

		if (!driver.getCurrentUrl().contains("account")) {

			driver.get(testData.B2C.getloginPageUrl());
			closePromotion(driver, b2cPage);
			if (Common.isElementExist(driver, By.xpath(".//*[@id='smb-login-button']"))) {
				b2cPage.SMB_LoginButton.click();
			}
			B2CCommon.login(b2cPage, loginID, pwd);
			B2CCommon.handleGateKeeper(b2cPage, testData);
		}
	}

//	@Test(alwaysRun = true, groups = { "commercegroup", "payment", "p2", "b2c" })
	public void COMM521(ITestContext ctx) {

		try {
			this.prepareTest();

			b2cPage = new B2CPage(driver);
			hmcPage = new HMCPage(driver);
			Dailylog.logInfoDB(1, "go to B2C GET PK ", Store, testName);
			driver.get(testData.B2C.getloginPageUrl());
				
			B2CCommon.login(b2cPage, testData.B2C.getLoginID(), testData.B2C.getLoginPassword());
			
			
			Common.sleep(2000);
			b2cPage.Navigation_CartIcon.click();
			if (Common.checkElementExists(driver, b2cPage.Navigation_ViewCartButton, 5))
				b2cPage.Navigation_ViewCartButton.click();
			Common.sleep(2000);
			

			String pkString = b2cPage.Cart_PK.getAttribute("value");
			String pk = pkString.substring(pkString.indexOf("="), pkString.length());
			// 8815033123888
			Dailylog.logInfoDB(1, "get cart pk :  " + pk, Store, testName);
			Dailylog.logInfoDB(1, "go to hmc " + pk, Store, testName);
//			String pk = "8815033123888";
			driver.get(testData.HMC.getHomePageUrl());
			HMCCommon.Login(hmcPage, testData);

			Dailylog.logInfoDB(1, "switch to old Payment Ui :  " + pk, Store, testName);
			switchUiPayment(false, false);
			Dailylog.logInfoDB(1, "check payment type ", Store, testName);
			checkPaymentType();
//			Dailylog.logInfoDB(1, "switch to old cart Ui ", Store, testName);
//			switchUiCart(false, pk);

			Dailylog.logInfoDB(1, "create payment profile", Store, testName);
			createNewProfile();

			driver.get(testData.B2C.getloginPageUrl());
			B2CCommon.login(b2cPage, testData.B2C.getLoginID(), testData.B2C.getLoginPassword());
			Common.sleep(2000);
			b2cPage.Navigation_CartIcon.click();
			if (Common.checkElementExists(driver, b2cPage.Navigation_ViewCartButton, 5))
				b2cPage.Navigation_ViewCartButton.click();
			Common.sleep(2000);
		
			quickOrder();
			Dailylog.logInfoDB(5, "check cart page icon", Store, testName);
			Assert.assertFalse("PayPal Express icons are hidden from cart page faild",
					Common.checkElementExists(driver, b2cPage.Cart_paypal, 5));

			Assert.assertFalse("Amazon  icons are hidden from cart page faild",
					Common.checkElementExists(driver, b2cPage.Cart_Amazon, 5));

			Dailylog.logInfoDB(5, "checkout", Store, testName);
			b2cPage.lenovo_checkout.click();

			Dailylog.logInfoDB(5, "Shipping Address", Store, testName);
			if (Common.checkElementDisplays(driver, b2cPage.ASM_EditAddress, 3)) {
				b2cPage.ASM_EditAddress.click();
			}
			B2CCommon.fillShippingInfo(b2cPage, "test", "test", testData.B2C.getDefaultAddressLine1(),
					testData.B2C.getDefaultAddressCity(), testData.B2C.getDefaultAddressState(),
					testData.B2C.getDefaultAddressPostCode(), testData.B2C.getDefaultAddressPhone(),
					testData.B2C.getLoginID(), testData.B2C.getConsumerTaxNumber());

			Thread.sleep(3000);

			Dailylog.logInfoDB(5, "shipping continue", Store, testName);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", b2cPage.Shipping_ContinueButton);

			if (Common.checkElementExists(driver, b2cPage.Shipping_AddressMatchOKButton, 10))
				b2cPage.Shipping_AddressMatchOKButton.click();

			Thread.sleep(3000);

			Common.waitElementClickable(driver, b2cPage.Payment_ContinueButton, 15);
			Common.sleep(2000);
			Dailylog.logInfoDB(5, " Check the display of PO and Credit Card payment", Store, testName);
			Assert.assertFalse("cart are hidden from payment page faild",
					Common.isElementExist(driver, By.xpath("//*[@id='PaymentTypeSelection_CARD']")));

			Assert.assertTrue("PO on payment page",
					Common.checkElementExists(driver, b2cPage.payment_PurchaseOrder, 5));

			Dailylog.logInfoDB(6, " Select PO", Store, testName);
			Common.javascriptClick(b2cPage.PageDriver, b2cPage.payment_PurchaseOrder);

			b2cPage.payment_purchaseNum.clear();
			b2cPage.payment_purchaseNum.sendKeys("1234567890");

			if (Common.isElementExist(driver, By.id("purchase_orderNumber"))) {

				b2cPage.payment_purchaseDate.sendKeys(Keys.ENTER);

			}

			Dailylog.logInfoDB(7, "payment continue", Store, testName);

			Common.javascriptClick(driver, b2cPage.Payment_ContinueButton);

			if (Common.isElementExist(driver, By.xpath("//*[@id='resellerID']"))) {
				try {
					driver.findElement(By.xpath("//*[@id='resellerID']")).clear();
					driver.findElement(By.xpath("//*[@id='resellerID']")).sendKeys("1234567890");
				} catch (Exception e) {
					System.out.println("reseller id is not available");
				}
			}

			Common.javascriptClick(driver, b2cPage.OrderSummary_AcceptTermsCheckBox);
			B2CCommon.clickPlaceOrder(b2cPage);

			Dailylog.logInfoDB(7, "Drop order", Store, testName);
			String orderNum = B2CCommon.getOrderNumberFromThankyouPage(b2cPage);
			Dailylog.logInfoDB(7, " order number : " + orderNum, Store, testName);

		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}

	}

	private void quickOrder() {

		Dailylog.logInfoDB(3, "quick order", Store, testName);
		B2CCommon.clearTheCart(driver, b2cPage, testData);
		Common.sleep(2000);
		B2CCommon.addPartNumberToCart(b2cPage, subscription);

	}

	private void switchUiPayment(Boolean isNew, Boolean isRollback) {

		HMCCommon.searchB2CUnit(hmcPage, testData);
		hmcPage.B2CUnit_FirstSearchResultItem.click();
		Common.sleep(2000);
		hmcPage.B2CUnit_SiteAttributeTab.click();
		Common.sleep(2000);

		Dailylog.logInfoDB(3, "set Disable Payment Profile Fallback to NO ", Store, testName);
		// Set Disable Payment Profile Fallback" to No
		if (isRollback) {
			hmcPage.B2BUnit_disablePaymentProfileFallbackYes.click();
		} else {
			Dailylog.logInfoDB(5, "set payment UI ", Store, testName);
			if (isNew) {

				hmcPage.CheckoutNew_yes.click();
			} else {
				hmcPage.CheckoutNew_no.click();
			}
			hmcPage.B2BUnit_disablePaymentProfileFallbackNo.click();

		}

		hmcPage.Common_SaveButton.click();

		Common.sleep(5000);

	}

	private void switchUiCart(Boolean isNew, String pk) {

		hmcPage.hmcHome_WCMS.click();
		hmcPage.wcmsPage_pages.click();
		hmcPage.paymentProfile_attributeselect.click();
		
		Common.scrollAndClick(driver, hmcPage.WCMS_PAGE_PK);
		Common.checkElementExists(driver, hmcPage.WCMS_PAGE_PKInput, 120);
		hmcPage.WCMS_PAGE_PKInput.clear();
		hmcPage.WCMS_PAGE_PKInput.sendKeys(pk);

		hmcPage.wcmsPagesPage_searchButton.click();
		Common.sleep(3000);

		Common.doubleClick(driver, hmcPage.PageTemplate_firstResult);

		String PageTemplate_input = hmcPage.PageTemplate_input.getAttribute("value");
		if (PageTemplate_input.contains("Redesign")) {
			// new UI no need change
			Dailylog.logInfoDB(3, "pageTemplate is NEW,no need change ", Store, testName);
		} else {
			Dailylog.logInfoDB(3, "pageTemplate is Old, need change ", Store, testName);
			hmcPage.PageTemplate.click();

			Set<String> winHandels = driver.getWindowHandles();
			List<String> it = new ArrayList<String>(winHandels);
			driver.switchTo().window(it.get(1));

			hmcPage.HMCCatalog_catalogVersion.click();
			//TODO need change
			hmcPage.HMCCatalog_masterMultiCountryProductCatalog.click();
			Common.sleep(2000);
			hmcPage.PageTemplate_name.clear();
			if (isNew) {
				hmcPage.PageTemplate_name.sendKeys("Cart Redesign Page Template");

			} else {
				hmcPage.PageTemplate_name.sendKeys("Cart Page Template");
			}
			hmcPage.WCMS_Website_SearchButton.click();

			Common.doubleClick(driver, hmcPage.PageTemplate_firstResult);
			driver.switchTo().window(it.get(0));
			hmcPage.Common_SaveButton.click();
		}

		Common.sleep(5000);

	}

	private void checkPaymentType() {
		String[] paymentType = { "PURCHASEORDER", "CARD", "PAYPAL", "AMAZON", "BANKDEPOSIT" };

		for (int i = 0; i < paymentType.length; i++) {
			if (Common.checkElementDisplays(driver,
					By.xpath("//div[contains(@id,'" + paymentType[i] + "') and @class='gilcEntry']"), 4)) {
				Dailylog.logInfoDB(1, paymentType[i] + " Payment type is already existing !!", Store, testName);

			} else {
				AddPaymentType(paymentType[i]);
			}
		}

	}

	public void AddPaymentType(String paymentType) {
		Dailylog.logInfoDB(1, "ADD Payment type : " + paymentType, Store, testName);
		Common.rightClick(driver, hmcPage.B2CSiteAttribute_PayTypeHead);
		hmcPage.B2CSiteAttribute_AddPayType.click();
		Common.sleep(3000);
		Common.switchToWindow(driver, 1);
		Common.sendFieldValue(hmcPage.PaymentType_CheckoutCode, paymentType);
		hmcPage.PaymentMessage_Search.click();
		Common.doubleClick(driver, driver.findElement(By.xpath("//div/div[contains(@id,'" + paymentType + "')]")));

		Common.switchToWindow(driver, 0);
		Common.sleep(3000);
		hmcPage.HMC_Save.click();
		Common.sleep(5000);

	}

	@AfterTest(alwaysRun = true, enabled = true)
	public void rollback(ITestContext ctx) throws InterruptedException, MalformedURLException {

		Dailylog.logInfoDB(14, "rollback", Store, testName); // roll back
		SetupBrowser();
		driver.get(testData.HMC.getHomePageUrl());
		hmcPage = new HMCPage(driver);
		HMCCommon.Login(hmcPage, testData);

		Common.sleep(5000);
//		deletePaymentProfile();
		switchUiPayment(false, true);
	}

	private void deletePaymentProfile() {
		hmcPage.Home_Nemo.click();
		hmcPage.Home_payment.click();
		hmcPage.Home_paymentCustomize.click();
		hmcPage.Home_paymentProfile.click();
		
		Common.sleep(3000);
		hmcPage.paymentProfile_PaymentType.click();
		hmcPage.paymentProfile_PaymentTypeCard.click();
		while (true) {
			Common.sleep(1000);
			hmcPage.WCMS_Website_SearchButton.click();

			int count = driver
					.findElements(By.xpath("//table[contains(@id,'innertable')]/tbody/tr[contains(@id,'Card')]"))
					.size();
			System.out.println("card payment profile count: " + count);
			if (count != 0) {
				WebElement deleteBtn = driver.findElement(
						By.xpath("(//table[contains(@id,'innertable')]/tbody/tr[contains(@id,'Card')])[1]"));
				Common.mouseHover(driver, deleteBtn);
				Common.rightClick(driver, deleteBtn);
				hmcPage.b2cUnit_remove.click();
				// accept alert
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Common.sleep(5000);
			}

			if (count == 1 || count == 0)
				break;

		}

	}

	private void createNewProfile() {

		hmcPage.Home_Nemo.click();
		hmcPage.Home_payment.click();
		hmcPage.Home_paymentCustomize.click();
		Common.sleep(3000);

		Common.rightClick(driver, hmcPage.Home_paymentProfile);
		Common.sleep(1500);
		hmcPage.Home_paymentProfileCreate.click();

		// B2C Properties
		String profileName = "Card Profile 521";
		Common.sendFieldValue(hmcPage.paymentProfile_name, profileName);
		Common.sendFieldValue(hmcPage.paymentProfile_code, profileName);
		hmcPage.paymentProfile_paymentType.click();
		Dailylog.logInfoDB(1, "Clicked on cartpayment Type", Store, testName);
		hmcPage.paymentProfile_PaymentTypeCard.click();
		hmcPage.paymentProfile_configLevel.click();
		hmcPage.paymentProfile_configLevelGlobal.click();
		hmcPage.paymentProfile_channel.click();
		hmcPage.paymentProfile_channelB2C.click();
		hmcPage.paymentProfile_activeTrue.click();
		Dailylog.logInfoDB(1, "Clicked on Active : True", Store, testName);
		// B2C&B2B Properties
		hmcPage.paymentProfile_paymentB2BB2C.click();
		Common.sendFieldValue(hmcPage.paymentProfile_paymentB2BB2CDisplayName, profileName);
		// Global Tab
		hmcPage.paymentProfile_global.click();
		Dailylog.logInfoDB(1, "Clicked on Global Tab", Store, testName);
		hmcPage.paymentProfile_globalSubscriptionYes.click();


		hmcPage.B2BCustomer_CreateButton.click();
		Dailylog.logInfoDB(1, "Saved all the changes", Store, testName);
		Common.sleep(2000);
	}

}
