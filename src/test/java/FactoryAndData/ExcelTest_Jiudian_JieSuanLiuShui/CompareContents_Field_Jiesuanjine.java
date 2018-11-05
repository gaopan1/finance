package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareContents_JieSuanLiuShui_Field_Jiesuanjine;

public class CompareContents_Field_Jiesuanjine {

public static String trc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "trc_date");
public static String tcc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "tcc_date");
public static String elong_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "elong_date");
public static String zyx_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "zyx_date");
public static String top_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "top_date");
public static String cnb_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "cnb_date");
public static String gta_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "gta_date");
public static String ctrip_out_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_out_date");
public static String webbeds_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "webbeds_date");
public static String ctrip_in_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ctrip_in_date");
public static String jalan_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "jalan_date");


	
	@DataProvider(name = "results")
	public static Object[][] Data16389() {

		return new Object[][] { 
			
			
			//jalan
			
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\jalan\\"+jalan_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Contents_"+jalan_testDate+".xls",
				  "jiesuan_bill",
				  "流水ID",
				  "订单ID",
				  "应结算金额",
				  "OTA订单ID",
				  "对账差异",
				  "ota变价",
				  "线上赔付",
				  "线下赔付",
				  "其它",
				  "结算金额"
			  },
			
			/*//ctrip_in
			
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_in\\"+ctrip_in_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_in\\Contents_"+ctrip_in_testDate+".xls",
				  "jiesuan_bill",
				  "流水ID",
				  "订单ID",
				  "应结算金额",
				  "OTA订单ID",
				  "对账差异",
				  "ota变价",
				  "线上赔付",
				  "线下赔付",
				  "其它",
				  "结算金额"
			  },*/
			
			
			/*//webbeds
			
			{
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\webbeds\\"+webbeds_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\webbeds\\Contents_"+webbeds_testDate+".xls",
				  "jiesuan_bill",
				  "流水ID",
				  "订单ID",
				  "应结算金额",
				  "OTA订单ID",
				  "对账差异",
				  "ota变价",
				  "线上赔付",
				  "线下赔付",
				  "其它",
				  "结算金额"
			  },*/
			
			
			
				/*//ctrip_out
				
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_out\\"+ctrip_out_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_out\\Contents_"+ctrip_out_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },*/
			
			
			
				/*// cnb
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\cnb\\"+cnb_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\cnb\\Contents_"+cnb_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },
				*/
			
				/*// zyx
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\zyx\\"+zyx_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\zyx\\Contents_"+zyx_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },*/
			
			
				/*// elong
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\elong\\"+elong_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\elong\\Contents_"+elong_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },*/
				
				/*// tcc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\tcc\\"+tcc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\tcc\\Contents_"+tcc_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },*/
				
				/*//trc
				
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Contents_"+trc_testDate+".xls",
					  "jiesuan_bill",
					  "流水ID",
					  "订单ID",
					  "应结算金额",
					  "OTA订单ID",
					  "对账差异",
					  "ota变价",
					  "线上赔付",
					  "线下赔付",
					  "其它",
					  "结算金额"
				  },*/
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String jiesuan_sheet,
								String liushuiID,
								String dingdanID,
								String yingjiesuanjine,
								String ota_dingdanID,
								String duizhangchayi,
								String ota_bianjia,
								String xianshangpeifu,
								String xianxiapeifu,
								String qita,
								String jiesuanjine) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Jiesuanjine(sourceFile,
															  destinationFile,
															  jiesuan_sheet,
															  liushuiID,
															  dingdanID,
															  yingjiesuanjine,
															  ota_dingdanID,
															  duizhangchayi,
															  ota_bianjia,
															  xianshangpeifu,
															  xianxiapeifu,
															  qita,
															  jiesuanjine);

		return tests;
	}
	
}