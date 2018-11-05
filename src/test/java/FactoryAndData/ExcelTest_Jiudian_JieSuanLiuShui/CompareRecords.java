package FactoryAndData.ExcelTest_Jiudian_JieSuanLiuShui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_JieSuanLiuShui.CompareRecords_Liushui_JieSuanLiuShui;

public class CompareRecords {

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
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\jalan\\Records_"+jalan_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },
			
			
			
					/*// ctrip_in
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_in\\"+ctrip_in_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_in\\Records_"+ctrip_in_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
			
				/*	// webbeds
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\webbeds\\"+webbeds_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\webbeds\\Records_"+webbeds_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
			
					/*// ctrip_out
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ctrip_out\\"+ctrip_out_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ctrip_out\\Records_"+ctrip_out_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
			
			
					/*// gta
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\gta\\"+gta_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\gta\\Records_"+gta_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
	
			
					/*//cnb
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\cnb\\"+cnb_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\cnb\\Records_"+cnb_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
			
			
					/*//top
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\top\\"+top_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\top\\Records_"+top_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
					
					/*//zyx
					{
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\zyx\\"+zyx_testDate+"\\结算流水对账全表.xlsx",
						  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\zyx\\Records_"+zyx_testDate+".xls",
						  "jiesuan_bill",
						  "bill",
						  "流水ID",
						  //--------------
						  "流水ID"
					  },*/
					
			
				/* // elong
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\elong\\"+elong_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\elong\\Records_"+elong_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "流水ID",
					  //--------------
					  "流水ID"
				  },*/
				
				
				/* // ean
				  {
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\ean\\"+ean_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\ean\\Records_"+ean_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "流水ID",
					  //--------------
					  "流水ID"
				  },*/
				
				/*//tcc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\tcc\\"+tcc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\tcc\\Records_"+tcc_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "流水ID",
					  //--------------
					  "流水ID"
				  },*/
				
				
				/*// trc
				{
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\数据准备\\trc\\"+trc_testDate+"\\结算流水对账全表.xlsx",
					  "C:\\Users\\gaopan\\Desktop\\已结算流水\\results\\trc\\Records_"+trc_testDate+".xls",
					  "jiesuan_bill",
					  "bill",
					  "流水ID",
					  //--------------
					  "流水ID"
				  },*/
				  
				 
				  
				
				
		};
	}

	@Factory(dataProvider = "results")
	public Object[] createTest(String sourceFile,
								String destinationFile,
								String sheetName_Jiesuan,
								String sheetName_Liushui,
								String liushui_id_Jiesuan,
								String liushui_id_Liushui) {

		Object[] tests = new Object[1];

		tests[0] = new CompareRecords_Liushui_JieSuanLiuShui(sourceFile,
															  destinationFile,
															  sheetName_Jiesuan,
															  sheetName_Liushui,
															  liushui_id_Jiesuan,
															  liushui_id_Liushui);

		return tests;
	}
	
}
