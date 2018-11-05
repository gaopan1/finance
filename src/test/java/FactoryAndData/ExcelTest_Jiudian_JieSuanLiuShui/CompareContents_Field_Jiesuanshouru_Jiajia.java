package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Jiajia;

public class CompareContents_Field_Jiesuanshouru_Jiajia {

public static String trc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "trc_date");
public static String zyx_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "zyx_date");
public static String top_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "top_date");
public static String cnb_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "cnb_date");
public static String gta_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "gta_date");
public static String webbeds_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "webbeds_date");



	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {

		return new Object[][] { 
			
			/*	// webbeds
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\webbeds\\"+webbeds_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\webbeds\\Contents_"+webbeds_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },
				*/
			
				/*// gta
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\gta\\"+gta_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\gta\\Contents_"+gta_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },*/
			
				/*// cnb
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\cnb\\"+cnb_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\cnb\\Contents_"+cnb_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },*/
			
			
				/*// top
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\top\\"+top_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\top\\Contents_"+top_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },*/
			
				/*// zyx
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\zyx\\"+zyx_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\zyx\\Contents_"+zyx_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },
			*/
			
				
				/*// trc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Contents_"+trc_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },*/
				
				/*	// tcc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Contents_"+trc_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "实际销售价",
					  "OTA订单ID",
					  "成本价",
					  "结算收入"
				  },*/
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String jiesuan_sheet,
								String liushuiID,
								String dingdanID,
								String shijixiaoshoujia,
								String ota_dingdanID,
								String chengbenjia,
								String jiesuanshouru) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Jiesuanshouru_Jiajia(sourceFile,
															  destinationFile,
															  jiesuan_sheet,
															  liushuiID,
															  dingdanID,
															  shijixiaoshoujia,
															  ota_dingdanID,
															  chengbenjia,
															  jiesuanshouru);

		return tests;
	}
	
}
