package FactoryAndData.ExcelTest_Jieji;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji.CompareContents_Supplier_Test;

public class CompareContents_Supplier {
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 

				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\supplier.xls","pay","positive_account", "供应商","供应商","支付时间","支付时间","支付ID","订单号"},
			
				{ "C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx","C:\\Users\\gaopan\\Desktop\\接机账单\\result\\supplier.xls","refund","negative_account", "供应商","供应商","退款时间","支付时间","支付ID","订单号"},

				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String pay_time_zhifu,String pay_time_duizhang,String getPayColumnName,String getAccountColumnName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Supplier_Test(sourceFile,destinationFile,pay_sheetName,account_sheetName,pay_must_info,account_must_info,pay_time_zhifu,pay_time_duizhang,getPayColumnName,getAccountColumnName);

		return tests;
	}

}
