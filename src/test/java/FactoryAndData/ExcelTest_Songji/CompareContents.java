package FactoryAndData.ExcelTest_Songji;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Songji.CompareContentsTest;



public class CompareContents {
	/**
	 * 
	 * String sourceFile,
	 * String destinationFile,
	 * String pay_sheetName,
	 * String account_sheetName,
	 * String pay_must_info,
	 * String account_must_info,
	 * String getPayColumnName,
	 * String getAccountColumnName
	 * 
	 *  D:\\马蜂窝对账项目\\送机对账\\测试数据
	 * D:\\马蜂窝对账项目\\送机对账\\result
	 */
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 

				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","pay","positive_account", "供应商","供应商","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","pay","positive_account", "订单金额","支付金额","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","pay","positive_account", "支付时间","支付时间","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","refund","negative_account", "供应商","供应商","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","refund","negative_account", "退款金额","支付金额","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","refund","negative_account", "退款时间","支付时间","业务单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","orders","double_account", "补贴金额","补贴","订单号","订单号"},
				{ "D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx","D:\\马蜂窝对账项目\\送机对账\\result\\contents.xls","orders","double_account", "支付金额","支付金额","支付ID","订单号"},
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getAccountColumnName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContentsTest(sourceFile,destinationFile,pay_sheetName,account_sheetName,pay_must_info,account_must_info,getPayColumnName,getAccountColumnName);

		return tests;
	}

}
