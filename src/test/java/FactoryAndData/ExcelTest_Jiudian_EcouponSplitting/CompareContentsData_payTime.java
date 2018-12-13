package FactoryAndData.ExcelTest_Jiudian_EcouponSplitting;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_EcouponSplitting.CompareContentsTest_payTime;







public class CompareContentsData_payTime {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和流水\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\contents"+testMonth+"_"+testDay+".xls",
				"zhengxiang_支付时间",
				"positive_youhuiquan",
				"MFW订单ID",
				"positive_liushui",
				"订单ID",
				"positive_youhuiquan_liushui",
				"支付时间",
				"支付/退款时间"
			},
			{ 
				"D:\\马蜂窝对账项目\\优惠券拆分\\数据准备\\拆分和流水\\"+testMonth+"_"+testDay+"\\补贴拆分对账全表.xlsx",
				"D:\\马蜂窝对账项目\\优惠券拆分\\result\\contents"+testMonth+"_"+testDay+".xls",
				"nixiang_支付时间",
				"negative_youhuiquan",
				"MFW订单ID",
				"negative_liushui",
				"订单ID",
				"negative_youhuiquan_liushui",
				"支付时间",				"支付/退款时间"
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
								String result_sheetName,
								String getPayJine,
								String getAccount_youhuiquan) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContentsTest_payTime(sourceTable,destinationTable,caseName,pay_sheetName,getPayColumnName,account_sheetName,getAccountColumnName,result_sheetName,getPayJine,getAccount_youhuiquan);

		return tests;
	}

}

