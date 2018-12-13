package FactoryAndData.ExcelTest_Songji;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.ExcelTest_Songji.CompareRecordsTest;





public class CompareRecords {
	
	
	/**
	 * 
	 * String sourceTable
	 * String destinationTable,
	 * String caseName,
	 * String pay_sheetName,
	 * String getPayColumnName,
	 * String account_sheetName,
	 * String getAccountColumnName,
	 * String result_sheetName
	 * 
	 * D:\\马蜂窝对账项目\\送机对账\\测试数据
	 * D:\\马蜂窝对账项目\\送机对账\\result
	 */

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
			{ 
				"D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx",
				"D:\\马蜂窝对账项目\\送机对账\\result\\records.xls",
				"zhengxiang----zhifu records test",
				"pay",
				"业务单号",
				"positive_account",
				"订单号",
				"zhengxiang----zhifu" 
			},
			{
				"D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx",
				"D:\\马蜂窝对账项目\\送机对账\\result\\records.xls",
				"nixiang-----tuikuan records test",
				"refund",
				"业务单号",
				"negative_account",
				"订单号",
				"nixiang-----tuikuan"
			},
			{ 
				"D:\\马蜂窝对账项目\\送机对账\\测试数据11.1_11.13\\送机对账全表.xlsx",
				"D:\\马蜂窝对账项目\\送机对账\\result\\records.xls",
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
	public Object[] createTest(String sourceTable,
								String destinationTable,
								String caseName,
								String pay_sheetName,
								String getPayColumnName,
								String account_sheetName,
								String getAccountColumnName,
								String result_sheetName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecordsTest(sourceTable,
											destinationTable,
											caseName,
											pay_sheetName,
											getPayColumnName,
											account_sheetName,
											getAccountColumnName,
											result_sheetName);

		return tests;
	}

}

