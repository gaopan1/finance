package TestScript.ExcelTest_Songji_Qingsuanliushui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareRecords_GetRepeat {
	
	String tag = "AAA";
	
	String sourceFile;
	String destinationFile;
	String qingsuanliushui_sheet;
	String jiejiliushui_sheet;
	String result_SheetName;
	

	String dingdanhao_qingsuan;
	String yewudingdanhao_qingsuan;
	String shangpingmingcheng_qingsuan;
	String mudidi_qingsuan;
	String hezuomoshi_qingsuan;
	String pinlei_qingsuan;
	String qudaolaiyuan_qingsuan;
	String goumairen_qingsuan;
	String gongyingshang_qingsuan;
	String gongyingshangjiancheng_qingsuan;
	String dianpuming_qingsuan;
	String dianpuID_qingsuan;
	String xiaoshoujine_qingsuan;
	String zhifujine_qingsuan;
	String butie_qingsuan;
	String gongyingshangbutie_qingsuan;
	String yingjiesuanjine_qingsuan;
	String jiesuanjine_qingsuan;
	String jiesuanjine_RMB_qingsuan;
	String shouru_qingsuan;
	String bizhong_qingsuan;
	String huilv_qingsuan;
	String zhangdanming_qingsuan;
	String zhifushijian_qingsuan;
	String chuxingriqi_qingsuan;
	String jiesuanriqi_qingsuan;
	String jiaoyiriqi_qingsuan;
	String qingsuanriqi_qingsuan;
	
	
	int dingdanhao_qingsuan_index;
	int yewudingdanhao_qingsuan_index;
	int shangpingmingcheng_qingsuan_index;
	int mudidi_qingsuan_index;
	int hezuomoshi_qingsuan_index;
	int pinlei_qingsuan_index;
	int qudaolaiyuan_qingsuan_index;
	int goumairen_qingsuan_index;
	int gongyingshang_qingsuan_index;
	int gongyingshangjiancheng_qingsuan_index;
	int dianpuming_qingsuan_index;
	int dianpuID_qingsuan_index;
	int xiaoshoujine_qingsuan_index;
	int zhifujine_qingsuan_index;
	int butie_qingsuan_index;
	int gongyingshangbutie_qingsuan_index;
	int yingjiesuanjine_qingsuan_index;
	int jiesuanjine_qingsuan_index;
	int jiesuanjine_RMB_qingsuan_index;
	int shouru_qingsuan_index;
	int bizhong_qingsuan_index;
	int huilv_qingsuan_index;
	int zhangdanming_qingsuan_index;
	int zhifushijian_qingsuan_index;
	int chuxingriqi_qingsuan_index;
	int jiesuanriqi_qingsuan_index;
	int jiaoyiriqi_qingsuan_index;
	int qingsuanriqi_qingsuan_index;

	
	
	
	String dingdanhao_jiejiliushui;
	String yewudingdanhao_jiejiliushui;
	String shangpingmingcheng_jiejiliushui;
	String mudidi_jiejiliushui;
	String hezuomoshi_jiejiliushui;
	String pinlei_jiejiliushui;
	String qudaolaiyuan_jiejiliushui;
	String goumairen_jiejiliushui;
	String gongyingshang_jiejiliushui;
	String gongyingshangjiancheng_jiejiliushui;
	String dianpuming_jiejiliushui;
	String dianpuID_jiejiliushui;
	String xiaoshoujine_jiejiliushui;
	String zhifujine_jiejiliushui;
	String butie_jiejiliushui;
	String gongyingshangbutie_jiejiliushui;
	String yingjiesuanjine_jiejiliushui;
	String jiesuanjine_jiejiliushui;
	String jiesuanjine_RMB_jiejiliushui;
	String shouru_jiejiliushui;
	String bizhong_jiejiliushui;
	String huilv_jiejiliushui;
	String zhangdanming_jiejiliushui;
	String zhifushijian_jiejiliushui;
	String chuxingriqi_jiejiliushui;
	String jiesuanriqi_jiejiliushui;
	String jiaoyiriqi_jiejiliushui;
	String qingsuanriqi_jiejiliushui;
	
	int dingdanhao_jiejiliushui_index;
	int yewudingdanhao_jiejiliushui_index;
	int shangpingmingcheng_jiejiliushui_index;
	int mudidi_jiejiliushui_index;
	int hezuomoshi_jiejiliushui_index;
	int pinlei_jiejiliushui_index;
	int qudaolaiyuan_jiejiliushui_index;
	int goumairen_jiejiliushui_index;
	int gongyingshang_jiejiliushui_index;
	int gongyingshangjiancheng_jiejiliushui_index;
	int dianpuming_jiejiliushui_index;
	int dianpuID_jiejiliushui_index;
	int xiaoshoujine_jiejiliushui_index;
	int zhifujine_jiejiliushui_index;
	int butie_jiejiliushui_index;
	int gongyingshangbutie_jiejiliushui_index;
	int yingjiesuanjine_jiejiliushui_index;
	int jiesuanjine_jiejiliushui_index;
	int jiesuanjine_RMB_jiejiliushui_index;
	int shouru_jiejiliushui_index;
	int bizhong_jiejiliushui_index;
	int huilv_jiejiliushui_index;
	int zhangdanming_jiejiliushui_index;
	int zhifushijian_jiejiliushui_index;
	int chuxingriqi_jiejiliushui_index;
	int jiesuanriqi_jiejiliushui_index;
	int jiaoyiriqi_jiejiliushui_index;
	int qingsuanriqi_jiejiliushui_index;
	
	
	
	ArrayList<String> list_Qingsuan =  new ArrayList<String>();
	ArrayList<String> list_Jiejiliushui = new ArrayList<String>();
	
	Map<String,Integer> result_map = new HashMap<String,Integer>();
	
	Map<String,Integer> result_map1 = new HashMap<String,Integer>();
	
	
	
	
	
	public CompareRecords_GetRepeat(String sourceFile,
							String destinationFile,
							String qingsuanliushui_sheet,
							String jiejiliushui_sheet,
							String result_SheetName,
							String dingdanhao_qingsuan,
							String yewudingdanhao_qingsuan,
							String shangpingmingcheng_qingsuan,
							String mudidi_qingsuan,
							String hezuomoshi_qingsuan,
							String pinlei_qingsuan,
							String qudaolaiyuan_qingsuan,
							String goumairen_qingsuan,
							String gongyingshang_qingsuan,
							String gongyingshangjiancheng_qingsuan,
							String dianpuming_qingsuan,
							String dianpuID_qingsuan,
							String xiaoshoujine_qingsuan,
							String zhifujine_qingsuan,
							String butie_qingsuan,
							String gongyingshangbutie_qingsuan,
							String yingjiesuanjine_qingsuan,
							String jiesuanjine_qingsuan,
							String jiesuanjine_RMB_qingsuan,
							String shouru_qingsuan,
							String bizhong_qingsuan,
							String huilv_qingsuan,
							String zhangdanming_qingsuan,
							String zhifushijian_qingsuan,
							String chuxingriqi_qingsuan,
							String jiesuanriqi_qingsuan,
							String jiaoyiriqi_qingsuan,
							String qingsuanriqi_qingsuan,
							String dingdanhao_jiejiliushui,
							String yewudingdanhao_jiejiliushui,
							String shangpingmingcheng_jiejiliushui,
							String mudidi_jiejiliushui,
							String hezuomoshi_jiejiliushui,
							String pinlei_jiejiliushui,
							String qudaolaiyuan_jiejiliushui,
							String goumairen_jiejiliushui,
							String gongyingshang_jiejiliushui,
							String gongyingshangjiancheng_jiejiliushui,
							String dianpuming_jiejiliushui,
							String dianpuID_jiejiliushui,
							String xiaoshoujine_jiejiliushui,
							String zhifujine_jiejiliushui,
							String butie_jiejiliushui,
							String gongyingshangbutie_jiejiliushui,
							String yingjiesuanjine_jiejiliushui,
							String jiesuanjine_jiejiliushui,
							String jiesuanjine_RMB_jiejiliushui,
							String shouru_jiejiliushui,
							String bizhong_jiejiliushui,
							String huilv_jiejiliushui,
							String zhangdanming_jiejiliushui,
							String zhifushijian_jiejiliushui,
							String chuxingriqi_jiejiliushui,
							String jiesuanriqi_jiejiliushui,
							String jiaoyiriqi_jiejiliushui,
							String qingsuanriqi_jiejiliushui){
		
				this.sourceFile = sourceFile;
				this.destinationFile = destinationFile;
				this.qingsuanliushui_sheet = qingsuanliushui_sheet;
				this.jiejiliushui_sheet = jiejiliushui_sheet;
				this.result_SheetName = result_SheetName;
				
				
				this.dingdanhao_qingsuan = dingdanhao_qingsuan;
				this.yewudingdanhao_qingsuan = yewudingdanhao_qingsuan;
				this.shangpingmingcheng_qingsuan = shangpingmingcheng_qingsuan;
				this.mudidi_qingsuan = mudidi_qingsuan;
				this.hezuomoshi_qingsuan = hezuomoshi_qingsuan;
				this.pinlei_qingsuan = pinlei_qingsuan;
				this.qudaolaiyuan_qingsuan = qudaolaiyuan_qingsuan;
				this.goumairen_qingsuan = goumairen_qingsuan;
				this.gongyingshang_qingsuan = gongyingshang_qingsuan;
				this.gongyingshangjiancheng_qingsuan = gongyingshangjiancheng_qingsuan;
				this.dianpuming_qingsuan = dianpuming_qingsuan;
				this.dianpuID_qingsuan = dianpuID_qingsuan;
				this.xiaoshoujine_qingsuan = xiaoshoujine_qingsuan;
				this.zhifujine_qingsuan = zhifujine_qingsuan;
				this.butie_qingsuan = butie_qingsuan;
				this.gongyingshangbutie_qingsuan = gongyingshangbutie_qingsuan;
				this.yingjiesuanjine_qingsuan = yingjiesuanjine_qingsuan;
				this.jiesuanjine_qingsuan = jiesuanjine_qingsuan;
				this.jiesuanjine_RMB_qingsuan = jiesuanjine_RMB_qingsuan;
				this.shouru_qingsuan = shouru_qingsuan;
				this.bizhong_qingsuan = bizhong_qingsuan;
				this.huilv_qingsuan = huilv_qingsuan;
				this.zhangdanming_qingsuan = zhangdanming_qingsuan;
				this.zhifushijian_qingsuan = zhifushijian_qingsuan;
				this.chuxingriqi_qingsuan = chuxingriqi_qingsuan;
				this.jiesuanriqi_qingsuan = jiesuanriqi_qingsuan;
				this.jiaoyiriqi_qingsuan = jiaoyiriqi_qingsuan;
				this.qingsuanriqi_qingsuan = qingsuanriqi_qingsuan;
				
				this.dingdanhao_jiejiliushui = dingdanhao_jiejiliushui;
				this.yewudingdanhao_jiejiliushui = yewudingdanhao_jiejiliushui;
				this.shangpingmingcheng_jiejiliushui = shangpingmingcheng_jiejiliushui;
				this.mudidi_jiejiliushui = mudidi_jiejiliushui;
				this.hezuomoshi_jiejiliushui = hezuomoshi_jiejiliushui;
				this.pinlei_jiejiliushui = pinlei_jiejiliushui;
				this.qudaolaiyuan_jiejiliushui = qudaolaiyuan_jiejiliushui;
				this.goumairen_jiejiliushui = goumairen_jiejiliushui;
				this.gongyingshang_jiejiliushui = gongyingshang_jiejiliushui;
				this.gongyingshangjiancheng_jiejiliushui = gongyingshangjiancheng_jiejiliushui;
				this.dianpuming_jiejiliushui = dianpuming_jiejiliushui;
				this.dianpuID_jiejiliushui = dianpuID_jiejiliushui;
				this.xiaoshoujine_jiejiliushui = xiaoshoujine_jiejiliushui;
				this.zhifujine_jiejiliushui = zhifujine_jiejiliushui;
				this.butie_jiejiliushui = butie_jiejiliushui;
				this.gongyingshangbutie_jiejiliushui = gongyingshangbutie_jiejiliushui;
				this.yingjiesuanjine_jiejiliushui = yingjiesuanjine_jiejiliushui;
				this.jiesuanjine_jiejiliushui = jiesuanjine_jiejiliushui;
				this.jiesuanjine_RMB_jiejiliushui = jiesuanjine_RMB_jiejiliushui;
				this.shouru_jiejiliushui = shouru_jiejiliushui;
				this.bizhong_jiejiliushui = bizhong_jiejiliushui;
				this.huilv_jiejiliushui = huilv_jiejiliushui;
				this.zhangdanming_jiejiliushui = zhangdanming_jiejiliushui;
				this.zhifushijian_jiejiliushui = zhifushijian_jiejiliushui;
				this.chuxingriqi_jiejiliushui = chuxingriqi_jiejiliushui;
				this.jiesuanriqi_jiejiliushui = jiesuanriqi_jiejiliushui;
				this.jiaoyiriqi_jiejiliushui = jiaoyiriqi_jiejiliushui;
				this.qingsuanriqi_jiejiliushui = qingsuanriqi_jiejiliushui;
	}
	
	
	
	@Test
	public void test() throws Exception{
		
		
		File file = new File(sourceFile);
		
		if(file.exists()){
			System.out.println("exists");
		}
		
	
        //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_sheet_qingsuan = xssfWorkbook.getSheetIndex(qingsuanliushui_sheet);
        Dailylog.logInfo("index qingsuan is :" + index_sheet_qingsuan);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_sheet_qingsuan);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        dingdanhao_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, dingdanhao_qingsuan);
        yewudingdanhao_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, yewudingdanhao_qingsuan);
        shangpingmingcheng_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, shangpingmingcheng_qingsuan);
        mudidi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, mudidi_qingsuan);
        hezuomoshi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, hezuomoshi_qingsuan);
        pinlei_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, pinlei_qingsuan);
        qudaolaiyuan_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, qudaolaiyuan_qingsuan);
        goumairen_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, goumairen_qingsuan);
		 gongyingshang_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, gongyingshang_qingsuan);
		 gongyingshangjiancheng_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, gongyingshangjiancheng_qingsuan);
		 dianpuming_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, dianpuming_qingsuan);
		 dianpuID_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, dianpuID_qingsuan);
		 xiaoshoujine_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, xiaoshoujine_qingsuan);
		 zhifujine_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhifujine_qingsuan);
		 butie_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, butie_qingsuan);
		 gongyingshangbutie_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, gongyingshangbutie_qingsuan);
		 yingjiesuanjine_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine_qingsuan);
		 jiesuanjine_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine_qingsuan);
		 jiesuanjine_RMB_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanjine_RMB_qingsuan);
		 shouru_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, shouru_qingsuan);
		 bizhong_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, bizhong_qingsuan);
		 huilv_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, huilv_qingsuan);
		 zhangdanming_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhangdanming_qingsuan);
		 zhifushijian_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhifushijian_qingsuan);
		 chuxingriqi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, chuxingriqi_qingsuan);
		 jiesuanriqi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, jiesuanriqi_qingsuan);
		 jiaoyiriqi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, jiaoyiriqi_qingsuan);
		 qingsuanriqi_qingsuan_index = WriterExcelUtil.getIndexOfFields(xssfRow, qingsuanriqi_qingsuan);
        
        
		
		 
		 // 将订单号+tag+补贴作为一个为唯一的值 放入到list中 
		 
		 
		 XSSFRow row = null;
		 
		 
		 for(int x = 1; x <= rowLength-1; x++){
			 
			 
			 row = sheet.getRow(x);
			 
			 XSSFCell cell = null;
			 
			 
			 String dingdanhao_qingsuan_Str = "";
			
			 
			 for(int y =0; y<colLength; y++){
				 
				 cell = row.getCell(y);
				 
				 if(y == dingdanhao_qingsuan_index){
					 dingdanhao_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }				 
			 }
		
			 list_Qingsuan.add(dingdanhao_qingsuan_Str);
			 
		 }
		 
		 
		 //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_jiejiliushui_sheet = xssfWorkbook1.getSheetIndex(jiejiliushui_sheet);
        Dailylog.logInfo("index jieji liushi is :" + index_jiejiliushui_sheet);
        XSSFSheet sheet1 = xssfWorkbook1.getSheetAt(index_jiejiliushui_sheet);
        //总行数
        int rowLength1 = sheet1.getLastRowNum()+1;
        System.out.println("row length1 is :" + rowLength1);
        //4.得到Excel工作表的行
        XSSFRow xssfRow1 = sheet1.getRow(0);
        //总列数
        int colLength1 = xssfRow1.getLastCellNum();
        System.out.println("colLength1 is :" + colLength1);
        
        
        
	   	 dingdanhao_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, dingdanhao_jiejiliushui);
	   	 yewudingdanhao_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, yewudingdanhao_jiejiliushui);
	   	 shangpingmingcheng_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, shangpingmingcheng_jiejiliushui);
	   	 mudidi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, mudidi_jiejiliushui);
	   	 hezuomoshi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, hezuomoshi_jiejiliushui);
	   	 pinlei_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, pinlei_jiejiliushui);
	   	 qudaolaiyuan_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, qudaolaiyuan_jiejiliushui);
	   	 goumairen_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, goumairen_jiejiliushui);
	   	 gongyingshang_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, gongyingshang_jiejiliushui);
	   	 gongyingshangjiancheng_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, gongyingshangjiancheng_jiejiliushui);
	   	 dianpuming_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, dianpuming_jiejiliushui);
	   	 dianpuID_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, dianpuID_jiejiliushui);
	   	 xiaoshoujine_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, xiaoshoujine_jiejiliushui);
	   	 zhifujine_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, zhifujine_jiejiliushui);
	   	 butie_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, butie_jiejiliushui);
	   	 gongyingshangbutie_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, gongyingshangbutie_jiejiliushui);
	   	 yingjiesuanjine_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, yingjiesuanjine_jiejiliushui);
	   	 jiesuanjine_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, jiesuanjine_jiejiliushui);
	   	 jiesuanjine_RMB_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, jiesuanjine_RMB_jiejiliushui);
	   	 shouru_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, shouru_jiejiliushui);
	   	 bizhong_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, bizhong_jiejiliushui);
	   	 huilv_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, huilv_jiejiliushui);
	   	 zhangdanming_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, zhangdanming_jiejiliushui);
	   	 zhifushijian_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, zhifushijian_jiejiliushui);
	   	 chuxingriqi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, chuxingriqi_jiejiliushui);
	   	 jiesuanriqi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, jiesuanriqi_jiejiliushui);
	   	 jiaoyiriqi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, jiaoyiriqi_jiejiliushui);
	   	 qingsuanriqi_jiejiliushui_index = WriterExcelUtil.getIndexOfFields(xssfRow1, qingsuanriqi_jiejiliushui);
        
		 
		 XSSFRow row_jiejiliushui = null;
		 
		 for(int x = 1; x <= rowLength1-1; x++){
			 
			 row_jiejiliushui = sheet1.getRow(x);
			 
			 XSSFCell cell_jijiliushui = null;
			 
			 String dingdanhao_jiejiliushui_Str = "";
			
			 
			 for(int y =0; y<rowLength1;y++){
				 
				 cell_jijiliushui = row_jiejiliushui.getCell(y);
				 
				 
				 
				 if(y == dingdanhao_jiejiliushui_index){
					 dingdanhao_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
				 }
				 
				
				
				 
			 }
		
			 list_Jiejiliushui.add(dingdanhao_jiejiliushui_Str);
		 }
		 
		 
		 
		 
		 
		 if(list_Qingsuan.size() >= list_Jiejiliushui.size()){
			 
			 String qingsuan_str = "";
			 
			 for(int x = 0; x <list_Qingsuan.size(); x++){
				 
				 qingsuan_str = list_Qingsuan.get(x);
				 
				 if(result_map.containsKey(qingsuan_str)){
					 
					 int temp = result_map.get(qingsuan_str);
					 temp = temp +1;
					 
					 result_map.put(qingsuan_str, temp);
					 
				 }else{
					 result_map.put(qingsuan_str, 1);
				 }
		 
			 }	 
		 }else{
			 
			 String jiejiliushui_str = "";
	
			 for(int x = 0; x<list_Jiejiliushui.size(); x++){
				 
				 jiejiliushui_str = list_Jiejiliushui.get(x);
				 
				 
				 if(result_map.containsKey(jiejiliushui_str)){
					 
					 int temp = result_map.get(jiejiliushui_str);
					 temp = temp +1;
					 
					 result_map.put(jiejiliushui_str, temp);
					 
				 }else{
					 result_map.put(jiejiliushui_str, 1);
				 }
		 
			 }					 
		}
		 
		 Set<String> set = result_map.keySet();
		 
		 Iterator<String> it = set.iterator();
		 
		 while(it.hasNext()){
			 
			 String temp = it.next();
			 
			 int value = result_map.get(temp);
			 
			 if(value>=2){
				 
				 result_map1.put(temp, value);
				 
			 }
		 }
		 
		 
		 Dailylog.logInfo("result map1 size is :" + result_map1.size());
		 
		 
		String sheetName1 = "";
		 
		 
		 if(list_Qingsuan.size() >= list_Jiejiliushui.size()){
			 sheetName1 = "清算流水表中重复的订单号";
		 }else{
			 sheetName1 = "接机流水新中重复的订单号";
		 }
		 
		 
		 
		 writeContent2Excels_Records(destinationFile,sheetName1+result_SheetName,result_map1);
		 
		 
		 
		 
		 
	}
	
		
		
	
		 
		
	
		
//		writeContent2Excels_Records(destinationFile,list_Qingsuan_left,list_Jiejiliushui_left,result_SheetName,"清算表的记录数：" + list_Qingsuan.size(),"接机流水的记录数：" + list_Jiejiliushui.size());
		
	
	


	
	public void writeContent2Excels_Records(String destinationTable,String sheetName,Map<String,Integer> resultMap) throws Exception{
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
//		String destination = "C:\\Users\\gaopan\\Desktop\\测试excel\\"+tableName+".xls";
		
		HSSFWorkbook book = null;
		
		
//		createNewExcels(destinationTable);
		
		//自己手动创建没有问题  但是程序创建就会有问题
		
		try{
			//1，创建操作xlsx的对象
			
			File file = new File(destinationTable);
			
			FileInputStream fis = new FileInputStream(file);
			
			book = new HSSFWorkbook(fis);
			
			int sheetNums = book.getNumberOfSheets();
			
			for(int m =0 ; m< sheetNums;m++){
				String temp_sheetName = book.getSheetName(m);
				if(temp_sheetName.equals(sheetName)){
					book.removeSheetAt(m);
					break;
				}
			}
			
			//2，创建sheet
			 			 
			 HSSFSheet sheet = book.createSheet(sheetName);
			 
			 
			 
			//3,操作sheet
			HSSFRow row1 = sheet.createRow(0);
			
			HSSFCell cell = row1.createCell(0);
			
			cell.setCellValue("订单号");
	
			HSSFCell cell2 = row1.createCell(1);
			cell2.setCellValue("相同的订单个数");

			
			Set<String> set = resultMap.keySet();
			
			Iterator<String> it = set.iterator();
			
			HSSFRow row = null;
			HSSFCell cell1 = null;
			
			int rowNum = 1;
			
			while(it.hasNext()){
				
				String str = it.next();
				int value = resultMap.get(str);
				
				row = sheet.createRow(rowNum);
				
				cell1 = row.createCell(0);
				cell1.setCellValue(str);
				cell1 = row.createCell(1);
				cell1.setCellValue(value+"");
				
				rowNum++;
			}
			
			FileOutputStream fout = new FileOutputStream(destinationTable);    

			book.write(fout);   
           
			
			
			fout.close();    
		
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				book.close();
			}catch(Exception e){
				
			}
		}
	
	}
	
	
	
	
	
}
