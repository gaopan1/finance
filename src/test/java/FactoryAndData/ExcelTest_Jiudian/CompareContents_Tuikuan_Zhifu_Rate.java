package FactoryAndData.ExcelTest_Jiudian;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian.CompareContents_Tuikuan_Zhifu_Rate_Test;





public class CompareContents_Tuikuan_Zhifu_Rate {
	
	
	public static String testMonth = WriterExcelUtil.getValueFromConf("Conf.properties", "TestMonth");
	public static String testDay = WriterExcelUtil.getValueFromConf("Conf.properties", "TestDay");
	
	
	

	@DataProvider(name = "results")
	public static Object[][] Data16389() {
		return new Object[][] { 
				
				
			//七月1_3	
			{ 
				  "C:\\Users\\gaopan\\Desktop\\酒店账单\\数据准备\\"+testMonth+"_"+testDay+"\\酒店流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\酒店账单\\result\\contents"+testMonth+"_"+testDay+".xls",
				  "positive_hotel",
				  "negative_hotel",
				  "流水类型",
				  "订单ID",
				  "订单ID",
				  "成本价-RMB",
				  "销售价",
				  "实际销售价",
				  "支付(实收)金额",
				  "预估佣金",
				  "补贴：折扣",
				  "补贴：蜂蜜",
				  "补贴：优惠券",
				  "补贴",
				  "报表收入",
				  "费用",
				  "返现"  
			},
	
		
		
		
		
		
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,String destinationFile,String pay_sheetName,String account_sheetName,String liuShuiLeixing,String getPayColumnName,String getAccountColumnName,String chengBenJia_RMB,String salesPrice,String actual_SalesPrice,String zhifu_Shishou_Jine,String yuguyongjin,String butie_zhekou,String butie_fengmi,String butie_youhuiquan,String butie,String baobiaoshouru,String feiyong,String fanxian) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_Tuikuan_Zhifu_Rate_Test(sourceFile,destinationFile,pay_sheetName,account_sheetName,liuShuiLeixing,getPayColumnName,getAccountColumnName,chengBenJia_RMB,salesPrice,actual_SalesPrice,zhifu_Shishou_Jine,yuguyongjin,butie_zhekou,butie_fengmi,butie_youhuiquan,butie,baobiaoshouru,feiyong,fanxian);

		return tests;
	}

}

