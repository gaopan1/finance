package TestScript.B2B;


import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import CommonFunction.B2BCommon;
import CommonFunction.Common;
import CommonFunction.HMCCommon;
import Logger.Dailylog;
import Pages.B2BPage;
import Pages.B2CPage;
import Pages.HMCPage;
import TestScript.SuperTestClass;
import junit.framework.Assert;


public class COMM488Test extends SuperTestClass {

	private B2BPage b2bPage;
	public HMCPage hmcPage;

	public String Url;
	public String subscription = "RR00000003";
	private String CartPage_EmptyCartButton = ".//*[@id='emptyCartItemsForm']/a";
	private String cartunitPrice;
	private Boolean cardPayment = false;
	
	public COMM488Test(String Store) {
		this.Store = Store;

		this.testName = "COMM-488";
	}

	public void closePromotion(WebDriver driver, B2CPage page) {
		By Promotion = By.xpath(".//*[@title='Close (Esc)']");

		if (Common.isElementExist(driver, Promotion)) {

			Actions actions = new Actions(driver);

			actions.moveToElement(page.PromotionBanner).click().perform();

		}
	}

	private String GetPriceValue(String Price) {

		Price = Price.replaceAll("\\$", "");
		Price = Price.replaceAll("CAD", "");
		Price = Price.replaceAll("$", "");
		Price = Price.replaceAll(",", "");
		Price = Price.replaceAll("\\*", "");
		Price = Price.replaceAll("\\￥", "");
		Price = Price.replaceAll("HK", "");
		Price = Price.replaceAll("₹", "");
		Price = Price.replaceAll("/yer", "");
		Price = Price.replaceAll("/mon", "");
		Price = Price.replaceAll("/syer", "");
		Price = Price.replaceAll("/que", "");
		Price = Price.trim();
		
		return Price;
	}

	@Test(alwaysRun = true, groups = { "commercegroup", "cartcheckout", "p2", "b2c" })
	public void COMM488(ITestContext ctx) {

		try {
			this.prepareTest();

			b2bPage = new B2BPage(driver);
			hmcPage = new HMCPage(driver);
		
			

			driver.get(testData.B2B.getLoginUrl());

			B2BCommon.Login(b2bPage, testData.B2B.getBuyerId(), testData.B2B.getDefaultPassword());
			b2bPage.HomePage_CartIcon.click();
			Dailylog.logInfoDB(1, "add subscription product to cart", Store, testName);
			Common.sleep(1500);
			if (Common.isElementExist(driver, By.xpath(CartPage_EmptyCartButton))) {
				driver.findElement(By.xpath(CartPage_EmptyCartButton)).click();
			}
			B2BCommon.addProduct(driver, b2bPage, subscription);
			cartunitPrice = b2bPage.cartPage_TotalPrice.getText().toString();
			cartunitPrice = GetPriceValue(cartunitPrice);		
			Dailylog.logInfoDB(2, "cartunitPrice is :"+ cartunitPrice, Store, testName);
			Dailylog.logInfoDB(2, "udpate quantity", Store, testName);
			b2bPage.cartPage_Quantity.clear();
			b2bPage.cartPage_Quantity.sendKeys("3");
			b2bPage.cartPage_QuantityUpdate.click();
			
			
			Dailylog.logInfoDB(3, "checkout", Store, testName);
			b2bPage.cartPage_LenovoCheckout.click();

			B2BCommon.fillB2BShippingInfo(driver, b2bPage, Store, "FirstNameJohn", "LastNameSnow",
					testData.B2B.getCompany(), testData.B2B.getAddressLine1(), testData.B2B.getAddressCity(),
					testData.B2B.getAddressState(), testData.B2B.getPostCode(), testData.B2B.getPhoneNum());
			
			
			Common.javascriptClick(driver, b2bPage.shippingPage_ContinueToPayment);
			if (Common.isElementExist(driver, By.id("checkout_validateFrom_ok"))) {
				b2bPage.shippingPage_validateFromOk.click();
			}

			Thread.sleep(3000);

		
			Dailylog.logInfoDB(3, " select payment", Store, testName);
			Actions actions = new Actions(driver);
			By Card = By.xpath("//input[@id='PaymentTypeSelection_CARD']");
					
			By Purchase_Order = By.xpath(".//*[@id='PaymentTypeSelection_PURCHASEORDER']");
			if (Common.isElementExist(driver, Purchase_Order)){
				actions.moveToElement(b2bPage.paymentPage_PurchaseOrder).click().perform();
				b2bPage.paymentPage_purchaseNum.sendKeys("1234567890");
				b2bPage.paymentPage_purchaseDate.click();
				b2bPage.paymentPage_purchaseDate.sendKeys(Keys.ENTER);
			}else if (Common.isElementExist(driver, Card)) {
				cardPayment = true;
				actions.moveToElement(b2bPage.paymentPage_creditCardRadio).click().perform();		        
				driver.switchTo().frame(b2bPage.creditCardFrame);
				b2bPage.paymentPage_Visa.click();
				b2bPage.paymentPage_CardNumber.sendKeys("4111111111111111");
				b2bPage.paymentPage_ExpiryMonth.sendKeys("06");
				b2bPage.paymentPage_ExpiryYear.sendKeys("20");
				b2bPage.paymentPage_SecurityCode.sendKeys("132");
				driver.switchTo().defaultContent();
				b2bPage.paymentPage_NameonCard.sendKeys("LIXE");
			}

			B2BCommon.fillDefaultB2bBillingAddress (driver,b2bPage, testData);
			Dailylog.logInfoDB(3, "payment continue", Store, testName);
			
			if(Common.isElementExist(driver, By.xpath("//*[@id='resellerID']"))){
				b2bPage.placeOrderPage_ResellerID.clear();
				b2bPage.placeOrderPage_ResellerID.sendKeys("2900718028");
	
			}
			
			Common.javascriptClick(driver, b2bPage.placeOrderPage_Terms);
			b2bPage.placeOrderPage_PlaceOrder.click();
		
			Common.sleep(5000);
			String orderNum=b2bPage.placeOrderPage_OrderNumber.getText();
	        
	        Dailylog.logInfoDB(3, "Order Number is: "+ orderNum, Store, testName);
			
			driver.get(testData.HMC.getHomePageUrl());
			HMCCommon.Login(hmcPage, testData);
			HMCCommon.HMCOrderCheck(hmcPage, orderNum);
			
			
			Common.doubleClick(driver, hmcPage.BaseStore_SearchResult);
			Common.sleep(2000);
			hmcPage.Order_ordersAdministration.click();
			Common.sleep(2000);
			
			Common.scrollToElement(driver, hmcPage.order_Administration_zPayload);
			Common.rightClick(driver, hmcPage.order_Administration_zPayload);
			Common.sleep(2000);
			hmcPage.products_PB_editInNewWindow.click();
			Common.switchToWindow(driver, 1);
			String valuePayload =  hmcPage.order_Administration_zPayloadContent.getAttribute("value");
			
			JSONObject obj = new JSONObject(valuePayload);			 
			JSONObject obj1 = obj.getJSONObject("request");

			Assert.assertEquals("card payment is woring!",obj1.getString("segment"), "Business");
			if(cardPayment){		
				Assert.assertEquals("card payment is woring!",obj1.getString("payment_method"), "CreditCard");
			}else{
				Assert.assertEquals("PO payment is woring!",obj1.getString("payment_method"), "PO");
				
			}
			
			JSONArray jArr = obj1.getJSONArray("items");
			JSONObject obj2 =jArr.getJSONObject(0);
			
			Assert.assertEquals("product No is wrong!",obj2.getString("lenovo_sku"),subscription);
			Assert.assertEquals("quantity is wrong!",obj2.getString("quantity"), "3");
			
			Assert.assertTrue("PO payment is woring!",obj2.getString("unit_price").contains(cartunitPrice) );
				
		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}

	}

	



	
}
