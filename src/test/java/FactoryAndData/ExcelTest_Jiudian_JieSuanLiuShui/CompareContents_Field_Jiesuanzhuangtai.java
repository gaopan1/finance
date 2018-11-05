package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareContents_JieSuanLiuShui_Field_Jiesuanzhuangtai;

public class CompareContents_Field_Jiesuanzhuangtai {

	public static String trc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "trc_date");
	public static String tcc_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "tcc_date");
	public static String ean_testDate = WriterExcelUtil.getValueFromConf("jiesuan_bill.properties", "ean_date");
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
			
			// jalan
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\jalan\\"+jalan_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Contents_"+jalan_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },
			
			/*// ctrip_in
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_in\\"+ctrip_in_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_in\\Contents_"+ctrip_in_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			/*// webbeds
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\webbeds\\"+webbeds_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\webbeds\\Contents_"+webbeds_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			
			
			/*// ctrip_out
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_out\\"+ctrip_out_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_out\\Contents_"+ctrip_out_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			
			
			/*// gta
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\gta\\"+gta_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\gta\\Contents_"+gta_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			 /* // trc
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Contents_"+trc_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			
			/*// cnb
			  {
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\cnb\\"+cnb_testDate+"\\结算流水对账全表.xlsx",
				  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\cnb\\Contents_"+cnb_testDate+".xls",
				  "jiesuan_bill",
				  "bill",
				  "结算中",
				  "流水ID",
				  //--------------
				  "流水ID",
				  "结算状态"
			  },*/
			
			
				/*// zyx
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\top\\"+top_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\top\\Contents_"+top_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "结算中",
					  "流水ID",
					  //--------------
					  "流水ID",
					  "结算状态"
				  },*/
			
				/*// zyx
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\zyx\\"+zyx_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\zyx\\Contents_"+zyx_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "结算中",
					  "流水ID",
					  //--------------
					  "流水ID",
					  "结算状态"
				  },*/
				
			
			
			
				/* // elong
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\elong\\"+elong_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\elong\\Contents_"+elong_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "结算中",
					  "流水ID",
					  //--------------
					  "流水ID",
					  "结算状态"
				  },*/
				  
				/*// tcc
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\tcc\\"+tcc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\tcc\\Contents_"+tcc_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "已结算",
					  "流水ID",
					  //--------------
					  "流水ID",
					  "结算状态"
				  },*/
				
				
				  
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String sheetName_Jiesuan,
								String sheetName_Liushui,
								String jiesuan_Status,
								String liushui_id_Jiesuan,
								String liushui_id_Liushui,
								String jiesuanzhuangtai_Liushui) {

		Object[] tests = new Object[1];

		tests[0] = new CompareContents_JieSuanLiuShui_Field_Jiesuanzhuangtai(sourceFile,
															  destinationFile,
															  sheetName_Jiesuan,
															  sheetName_Liushui,
															  jiesuan_Status,
															  liushui_id_Jiesuan,
															  liushui_id_Liushui,
															  jiesuanzhuangtai_Liushui);

		return tests;
	}
	
}
