package FactoryAndData.ExcelTest_Jieji;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji.CompareContentsTest;

public class CompareContents {
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 

				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","pay","positive_account", "供应商","供应商","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","pay","positive_account", "订单金额","支付金额","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","pay","positive_account", "支付时间","支付时间","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","refund","negative_account", "供应商","供应商","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","refund","negative_account", "退款金额","支付金额","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","refund","negative_account", "退款时间","支付时间","业务单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","orders","double_account", "补贴金额","补贴","订单号","订单号"},
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据11.1_11.11\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\contents.xls","orders","double_account", "支付金额","支付金额","订单号","订单号"},
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getAccountColumnName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContentsTest(sourceFile,destinationFile,pay_sheetName,account_sheetName,pay_must_info,account_must_info,getPayColumnName,getAccountColumnName);

		return tests;
	}

}
