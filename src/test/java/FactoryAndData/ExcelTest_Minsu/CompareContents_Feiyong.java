package FactoryAndData.ExcelTest_Minsu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Feiyong_Test;

public class CompareContents_Feiyong {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
				// 补贴
				{
					  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\民宿流水对账全表.xlsx",
					  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\results\\results_Contents.xls",
					  "double_hotel",
					  "订单ID",
					  "支付订单ID",
					  "业务模式",
					  "补贴：蜂蜜",
					  "补贴：优惠券",
					  "补贴",
					  "费用"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdanID,String co_model,String fengmi,String youhuiquan,String butie,String feiyong) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Feiyong_Test(sourceFile,destinationFile,account_sheetName,payid,zhifudingdanID,co_model,fengmi,youhuiquan,butie,feiyong);

		return tests;
	}

	
	
	
	
	

}
