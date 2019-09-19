package FactoryAndData.ExcelTest_Minsu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Shouru_Test;

public class CompareContents_Shouru {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
				// 收入
				{
					"D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\民宿流水对账全表.xlsx",
					  "D:\\马蜂窝对账项目\\小猪民宿\\数据准备\\支付和流水\\results\\results_Contents.xls",
					  "double_hotel",
					  "订单ID",
					  "支付订单ID",
					  "业务模式",
					  "实际销售价",
					  "销售价",
					  "成本价-RMB",
					  "佣金比例",
					  "报表收入"
				  },
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdanID,String co_model,String actual_SalesPrice,String salesPrice,String chengbenPrice,String yongjin_rate,String shouru) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Shouru_Test(sourceFile,destinationFile,account_sheetName,payid,zhifudingdanID,co_model,actual_SalesPrice,salesPrice,chengbenPrice,yongjin_rate,shouru);
		return tests;
	}

	
	
	
	
	

}
