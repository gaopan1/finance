package FactoryAndData.ExcelTest_Jiudian;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareRecordsTest;





public class CompareRecords {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//数据准备\七月1_3	
			{ 	
				"C:\\Users\\gaopan\\Desktop\\酒店账单\\数据准备\\"+testMonth+"_"+testDay+"\\酒店流水对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\酒店账单\\result\\records"+testMonth+"_"+testDay+".xls",
				"zhengxiang----zhifu records test",
				"pay",
				"支付ID",
				"业务单号",
				"positive_hotel",
				"订单ID",
				"支付订单ID",
				"pay<>positive_hotel" 
			},
			{ 
				"C:\\Users\\gaopan\\Desktop\\酒店账单\\数据准备\\"+testMonth+"_"+testDay+"\\酒店流水对账全表.xlsx",
				"C:\\Users\\gaopan\\Desktop\\酒店账单\\result\\records"+testMonth+"_"+testDay+".xls",
				"nixiang-----tuikuan records test",
				"refund",
				"支付ID",
				"业务单号",
				"negative_hotel",
				"订单ID",
				"支付订单ID",
				"refund<>negative_hotel"
			},

		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceTable,
								String destinationTable,
								String caseName,
								String pay_sheetName,
								String getPayColumnName,
								String getPayBusinessColumnName,
								String account_sheetName,
								String getAccountColumnName,
								String getZhifuDingDanID,
								String result_sheetName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecordsTest(sourceTable,destinationTable,caseName,pay_sheetName,getPayColumnName,getPayBusinessColumnName,account_sheetName,getAccountColumnName,getZhifuDingDanID,result_sheetName);

		return tests;
	}

}

