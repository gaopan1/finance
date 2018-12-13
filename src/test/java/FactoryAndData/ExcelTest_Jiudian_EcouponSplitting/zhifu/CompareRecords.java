package FactoryAndData.ExcelTest_Jiudian_EcouponSplitting.zhifu;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_EcouponSplitting.Zhifu.CompareRecordsTest;







public class CompareRecords {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
		
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_zhifu_"+testMonth+"_"+testDay+".xls",
				"zhengxiang",
				"positive_youhuiquan",
				"MFW订单ID",
				"positive_zhifu",
				"MFW订单ID",
				"positive_youhuiquan_zhifu" 
			},
			{ 
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和支付\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\records_zhifu_"+testMonth+"_"+testDay+".xls",
				"nixiang",
				"negative_youhuiquan",
				"MFW订单ID",
				"negative_zhifu",
				"MFW订单ID",
				"negative_youhuiquan_zhifu"
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

		tests[0] = new CompareRecordsTest(sourceTable,destinationTable,caseName,pay_sheetName,getPayColumnName,account_sheetName,getAccountColumnName,result_sheetName);

		return tests;
	}

}

