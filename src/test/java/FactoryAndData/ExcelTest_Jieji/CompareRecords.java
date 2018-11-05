package FactoryAndData.ExcelTest_Jieji;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Jieji.CompareRecordsTest;



public class CompareRecords {

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
			{ 
				"C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\接机账单\\result\\records.xls",
				"zhengxiang----zhifu records test",
				"pay",
				"支付ID",
				"positive_account",
				"订单号",
				"zhengxiang----zhifu" 
			},
			{
				"C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\接机账单\\result\\records.xls",
				"nixiang-----tuikuan records test",
				"refund",
				"支付ID",
				"negative_account",
				"订单号",
				"nixiang-----tuikuan"
			},
			{ 
				"C:\\Users\\gaopan\\Desktop\\接机账单\\测试数据\\接机对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\接机账单\\result\\records.xls",
				"orders---- double records test",
				"orders",
				"订单号",
				"double_account",
				"订单号",
				"orders----double" 
			},
			
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceTable,String destinationTable,String caseName,String pay_sheetName,String getPayColumnName,String account_sheetName,String getAccountColumnName,String result_sheetName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecordsTest(sourceTable,destinationTable,caseName,pay_sheetName,getPayColumnName,account_sheetName,getAccountColumnName,result_sheetName);

		return tests;
	}

}

