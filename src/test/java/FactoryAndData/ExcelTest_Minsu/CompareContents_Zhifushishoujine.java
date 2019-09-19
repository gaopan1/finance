package FactoryAndData.ExcelTest_Minsu;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Zhifushishoujine_Test;





public class CompareContents_Zhifushishoujine {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
			//七月1_3	
			{ 
				"D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\民宿流水对账全表.xlsx",
				  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\results\\results_Contents.xls",
				  "refund",
				  "negative_hotel",
				  "退款金额",
				  "支付(实收)金额",
				  "支付ID",
				  "业务单号",
				  "订单ID",
				  "支付订单ID"
			  },
			{ 
				  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\民宿流水对账全表.xlsx",
				  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\results\\results_Contents.xls",
				  "pay",
				  "positive_hotel",
				  "订单金额",
				  "支付(实收)金额",
				  "支付ID",
				  "业务单号",
				  "订单ID",
				  "支付订单ID"
			},
	
		
		
		
		
		
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String pay_must_info,String account_must_info,String getPayColumnName,String getPayBusinessColumnName,String getAccountColumnName,String getZhifuDingdanIDColumnName) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Zhifushishoujine_Test(sourceFile,destinationFile,pay_sheetName,account_sheetName,pay_must_info,account_must_info,getPayColumnName,getPayBusinessColumnName,getAccountColumnName,getZhifuDingdanIDColumnName);

		return tests;
	}

}

