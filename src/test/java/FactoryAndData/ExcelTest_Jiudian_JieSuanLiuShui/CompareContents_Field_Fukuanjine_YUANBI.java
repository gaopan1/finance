package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI;

public class CompareContents_Field_Fukuanjine_YUANBI {

public static String tcc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "tcc_date");
public static String elong_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "elong_date");
public static String zyx_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "zyx_date");
public static String top_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "top_date");
public static String cnb_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "cnb_date");
public static String trc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "trc_date");
public static String gta_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "gta_date");
public static String ctrip_out_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_out_date");
public static String webbeds_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "webbeds_date");
public static String ctrip_in_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_in_date");
public static String jalan_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "jalan_date");



	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {

		return new Object[][] { 
			
			// jalan
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\jalan\\"+jalan_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Contents_"+jalan_testDate+".xls",
				  "jiesuan_bill",
				  // ota 简写
				  "jalan",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "订单日汇率",
				  "应结算金额",
				  "对账差异",
				  "结算收入",
				  "付款金额-原币"
			  },
			
			/*// ctrip_in
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_in\\"+ctrip_in_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_in\\Contents_"+ctrip_in_testDate+".xls",
				  "jiesuan_bill",
				  // ota 简写
				  "ctrip_in",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "订单日汇率",
				  "应结算金额",
				  "对账差异",
				  "结算收入",
				  "付款金额-原币"
			  },*/
			
			/*// webbeds
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\webbeds\\"+webbeds_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\webbeds\\Contents_"+webbeds_testDate+".xls",
				  "jiesuan_bill",
				  // ota 简写
				  "webbeds",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "订单日汇率",
				  "应结算金额",
				  "对账差异",
				  "结算收入",
				  "付款金额-原币"
			  },*/
			
			
			/*// ctrip_out
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_out\\"+ctrip_out_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_out\\Contents_"+ctrip_out_testDate+".xls",
				  "jiesuan_bill",
				  // ota 简写
				  "ctrip_out",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "订单日汇率",
				  "应结算金额",
				  "对账差异",
				  "结算收入",
				  "付款金额-原币"
			  },*/
				
				
			/*// gta
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\gta\\"+gta_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\gta\\Contents_"+gta_testDate+".xls",
				  "jiesuan_bill",
				  // ota 简写
				  "gta",
				  "流水ID",
				  "订单ID",
				  "OTA订单ID",
				  "业务模式",
				  "订单日汇率",
				  "应结算金额",
				  "对账差异",
				  "结算收入",
				  "付款金额-原币"
			  },*/
			
				/*// trc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Contents_"+trc_testDate+".xls",
					  "jiesuan_bill",
					  // ota 简写
					  "trc",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "订单日汇率",
					  "应结算金额",
					  "对账差异",
					  "结算收入",
					  "付款金额-原币"
				  },*/
			
				/*// cnb
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\cnb\\"+cnb_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\cnb\\Contents_"+cnb_testDate+".xls",
					  "jiesuan_bill",
					  // ota 简写
					  "cnb",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "订单日汇率",
					  "应结算金额",
					  "对账差异",
					  "结算收入",
					  "付款金额-原币"
				  },*/
			
			
				/*// zyx
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\zyx\\"+zyx_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\zyx\\Contents_"+zyx_testDate+".xls",
					  "jiesuan_bill",
					  // ota 简写
					  "zyx",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "订单日汇率",
					  "应结算金额",
					  "对账差异",
					  "结算收入",
					  "付款金额-原币"
				  },*/
			
				/*// elong
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\elong\\"+elong_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\elong\\Contents_"+elong_testDate+".xls",
					  "jiesuan_bill",
					  // ota 简写
					  "elong",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "订单日汇率",
					  "应结算金额",
					  "对账差异",
					  "结算收入",
					  "付款金额-原币"
				  },*/
				
				/*// tcc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\tcc\\"+tcc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\tcc\\Contents_"+tcc_testDate+".xls",
					  "jiesuan_bill",
					  // ota 简写
					  "tcc",
					  "流水ID",
					  "订单ID",
					  "OTA订单ID",
					  "业务模式",
					  "订单日汇率",
					  "应结算金额",
					  "对账差异",
					  "结算收入",
					  "付款金额-原币"
				  },*/
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String jiesuan_sheet,
								String otaName,
								String liushuiID,
								String dingdanID,
								String ota_dingdanID,
								String yewumoshi,
								String dingdanrihuilv,
								String yingjiesuanjine,
								String duizhangchayi,
								String jiesuanshouru,
								String fukuanjine_YUANBI) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Fukuanjine_YUANBI(sourceFile,
															  destinationFile,
															  jiesuan_sheet,
															  otaName,
															  liushuiID,
															  dingdanID,
															  ota_dingdanID,
															  yewumoshi,
															  dingdanrihuilv,
															  yingjiesuanjine,
															  duizhangchayi,
															  jiesuanshouru,
															  fukuanjine_YUANBI);

		return tests;
	}
	
}
