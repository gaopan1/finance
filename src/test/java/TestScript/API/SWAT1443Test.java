package TestScript.API;

import static org.testng.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import CommonFunction.B2CCommon;
import CommonFunction.Common;
import CommonFunction.EMailCommon;
import CommonFunction.HMCCommon;
import CommonFunction.HttpCommon;
import CommonFunction.JSONCommon;
import CommonFunction.DesignHandler.NavigationBar;
import CommonFunction.DesignHandler.SplitterPage;
import Logger.Dailylog;
import Pages.B2CPage;
import Pages.HMCPage;
import Pages.MailPage;
import TestScript.ServiceSuperTestClass;
import TestScript.SuperTestClass;

public class SWAT1443Test extends ServiceSuperTestClass {

	private String ContextString;
	private String productNumber;

	private String urlPara;
	private String urlPara2;
	private String availableAmount;
	private String tempDMU = "";
	private String tempDMUID = "";
	private String PKValue;
	private String updateCode;
	private String inStockStatus;
	private String releasedAmount;
	@Autowired
	private RestTemplate restTemplate;

	public SWAT1443Test(String store, String productNo, String context,
			String releasedNO, String parameter, String parameter2,
			String updateResult) {
		this.Store = store;

		this.productNumber = productNo;
		this.ContextString = context;
		this.releasedAmount = releasedNO;
		this.urlPara = parameter;
		this.urlPara2 = parameter2;
		this.updateCode = updateResult;

		this.testName = "SWAT1443";
		super.serviceName = "ReleaseStock";
	}

	@Test(alwaysRun = true)
	public void DemoScriptRun(ITestContext ctx) {
		try {

			this.prepareTest();

			HttpCommon hCommon = new HttpCommon();
			JSONCommon JCommon = new JSONCommon();
			super.paraString = "Product Number=" + productNumber
					+ "Release amount is " + this.releasedAmount
					+ "; contextString=" + ContextString;
			String serviceURL = testData.envData.releaseStockServiceDomain()
					+ urlPara;
			String getstockURL = testData.envData.getStockServiceDomain()
					+ urlPara2;

			// verify if the reponse comes back without issues

			String getstockResult = hCommon.HttpRequest(getstockURL);

			String stockJSON = hCommon.getJsonValue(getstockResult,
					productNumber);

			String tempReservedAmount = hCommon.getJsonValue(stockJSON,
					"reserved");

			int tempReserved = Integer.parseInt(tempReservedAmount);

			super.serviceStatus = hCommon.verifyServiceStatus(serviceURL);
			assert super.serviceStatus.equals("200") : "actual status code is "
					+ serviceStatus;
			String httpResult = hCommon.HttpRequest(serviceURL);

			assert httpResult.contains(updateCode);

			getstockResult = hCommon.HttpRequest(getstockURL);

			stockJSON = hCommon.getJsonValue(getstockResult, productNumber);

			tempReservedAmount = hCommon.getJsonValue(stockJSON, "reserved");

			if (this.releasedAmount.equals("500")) {
				assert tempReservedAmount.equals("0");
				String reserveURL = testData.envData
						.reserveStockServiceDomain()
						+ "?codes="
						+ this.productNumber
						+ "__50&contextString=US%7CB2C%7CUSWEB%7CEN";

				String rollback = hCommon.HttpRequest(reserveURL);

			} else if (this.releasedAmount.equals("0")) {
			
				assert tempReservedAmount.equals(tempReserved+"");
			} else {
				assert tempReservedAmount.equals(tempReserved - 2 + "");
			}
		} catch (Throwable e) {
			handleThrowable(e, ctx);
		}
	}

}