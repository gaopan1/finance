package TestScript.ExcelTest_Songji_Qingsuanliushui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import Logger.Dailylog;

public class CompareContetntsTest {
	
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
	
	ArrayList<String> common = new ArrayList<String>();
	
	
	Map<String,List<String>> map_qingsuan = new HashMap<String,List<String>>();
	Map<String,List<String>> map_jiejiliushui = new HashMap<String,List<String>>();
	
	Map<String,List<List<String>>> map_result = new HashMap<String,List<List<String>>>();
	
	
	public CompareContetntsTest(String sourceFile,
							String destinationFile,
							String qingsuanliushui_sheet,
							String jiejiliushui_sheet,
							String result_SheetName,
							//-----
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
		 
		 List<String> list_qingsuan_result = null;
		 
		 
		 for(int x = 1; x <= rowLength-1; x++){
			 
			 
			 row = sheet.getRow(x);
			 
			 XSSFCell cell = null;
			 
			String dingdanhao_qingsuan_Str = "";
			String yewudingdanhao_qingsuan_Str = "";
			String shangpingmingcheng_qingsuan_Str = "";
			String mudidi_qingsuan_Str = "";
			String hezuomoshi_qingsuan_Str = "";
			String pinlei_qingsuan_Str = "";
			String qudaolaiyuan_qingsuan_Str = "";
			String goumairen_qingsuan_Str = "";
			String gongyingshang_qingsuan_Str = "";
			String gongyingshangjiancheng_qingsuan_Str = "";
			String dianpuming_qingsuan_Str = "";
			String dianpuID_qingsuan_Str = "";
			String xiaoshoujine_qingsuan_Str = "";
			String zhifujine_qingsuan_Str = "";
			String butie_qingsuan_Str = "";
			String gongyingshangbutie_qingsuan_Str = "";
			String yingjiesuanjine_qingsuan_Str = "";
			String jiesuanjine_qingsuan_Str = "";
			String jiesuanjine_RMB_qingsuan_Str = "";
			String shouru_qingsuan_Str = "";
			String bizhong_qingsuan_Str = "";
			String huilv_qingsuan_Str = "";
			String zhangdanming_qingsuan_Str = "";
			String zhifushijian_qingsuan_Str = "";
			String chuxingriqi_qingsuan_Str = "";
			String jiesuanriqi_qingsuan_Str = "";
			String jiaoyiriqi_qingsuan_Str = "";
			String qingsuanriqi_qingsuan_Str = "";

			 String combine_qingsuan_Str = "";
			 
			 list_qingsuan_result = new ArrayList<String>();
			 
			 for(int y =0; y<colLength; y++){
				 
				 cell = row.getCell(y);
				 
				 if(y == dingdanhao_qingsuan_index){
					 dingdanhao_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == butie_qingsuan_index){
					 butie_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == yewudingdanhao_qingsuan_index){
					 yewudingdanhao_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == shangpingmingcheng_qingsuan_index){
					 shangpingmingcheng_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == mudidi_qingsuan_index){
					 mudidi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == hezuomoshi_qingsuan_index){
					 hezuomoshi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == pinlei_qingsuan_index){
					 pinlei_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == qudaolaiyuan_qingsuan_index){
					 qudaolaiyuan_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == goumairen_qingsuan_index){
					 goumairen_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == gongyingshang_qingsuan_index){
					 gongyingshang_qingsuan_Str = WriterExcelUtil.getCellValue(cell); 
				 }else if(y == gongyingshangjiancheng_qingsuan_index){
					 gongyingshangjiancheng_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == dianpuming_qingsuan_index){
					 dianpuming_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == dianpuID_qingsuan_index){
					 dianpuID_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == xiaoshoujine_qingsuan_index){
					 xiaoshoujine_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == zhifujine_qingsuan_index){
					 zhifujine_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == gongyingshangbutie_qingsuan_index){
					 gongyingshangbutie_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == yingjiesuanjine_qingsuan_index){
					 yingjiesuanjine_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == jiesuanjine_qingsuan_index){
					 jiesuanjine_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == jiesuanjine_RMB_qingsuan_index){
					 jiesuanjine_RMB_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == shouru_qingsuan_index){
					 shouru_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == bizhong_qingsuan_index){
					 bizhong_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == huilv_qingsuan_index){
					 huilv_qingsuan_Str= WriterExcelUtil.getCellValue(cell);
				 }else if(y == zhangdanming_qingsuan_index){
					 zhangdanming_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == zhifushijian_qingsuan_index){
					 zhifushijian_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == chuxingriqi_qingsuan_index){
					 chuxingriqi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == jiesuanriqi_qingsuan_index){
					 jiesuanriqi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == jiaoyiriqi_qingsuan_index){
					 jiaoyiriqi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }else if(y == qingsuanriqi_qingsuan_index){
					 qingsuanriqi_qingsuan_Str = WriterExcelUtil.getCellValue(cell);
				 }
			 }
			 
			
			list_Qingsuan.add(dingdanhao_qingsuan_Str);
			 
			list_qingsuan_result.add(yewudingdanhao_qingsuan_Str);
			list_qingsuan_result.add(shangpingmingcheng_qingsuan_Str);
			list_qingsuan_result.add(mudidi_qingsuan_Str);
			list_qingsuan_result.add(hezuomoshi_qingsuan_Str);
			list_qingsuan_result.add(pinlei_qingsuan_Str);
			list_qingsuan_result.add(qudaolaiyuan_qingsuan_Str);
			list_qingsuan_result.add(goumairen_qingsuan_Str);
			list_qingsuan_result.add(gongyingshang_qingsuan_Str);
			list_qingsuan_result.add(gongyingshangjiancheng_qingsuan_Str);
			list_qingsuan_result.add(dianpuming_qingsuan_Str);
			list_qingsuan_result.add(dianpuID_qingsuan_Str);
			list_qingsuan_result.add(xiaoshoujine_qingsuan_Str);
			list_qingsuan_result.add(zhifujine_qingsuan_Str);
			list_qingsuan_result.add(butie_qingsuan_Str);
			list_qingsuan_result.add(gongyingshangbutie_qingsuan_Str);
			list_qingsuan_result.add(yingjiesuanjine_qingsuan_Str);
			list_qingsuan_result.add(jiesuanjine_qingsuan_Str);
			list_qingsuan_result.add(jiesuanjine_RMB_qingsuan_Str);
			list_qingsuan_result.add(shouru_qingsuan_Str);
			list_qingsuan_result.add(bizhong_qingsuan_Str);
			list_qingsuan_result.add(huilv_qingsuan_Str);
			list_qingsuan_result.add(zhangdanming_qingsuan_Str);
			list_qingsuan_result.add(zhifushijian_qingsuan_Str);
			list_qingsuan_result.add(chuxingriqi_qingsuan_Str);
			list_qingsuan_result.add(jiesuanriqi_qingsuan_Str);
			list_qingsuan_result.add(jiaoyiriqi_qingsuan_Str);
			list_qingsuan_result.add(qingsuanriqi_qingsuan_Str);
		 
			map_qingsuan.put(dingdanhao_qingsuan_Str, list_qingsuan_result);
			 
		 }
		 
		 
		 //2.Excel工作薄对象
        XSSFWorkbook xssfWorkbook1 = new XSSFWorkbook(new FileInputStream(file));
        //3.Excel工作表对象
        int index_jiejiliushui_sheet = xssfWorkbook1.getSheetIndex(jiejiliushui_sheet);
        Dailylog.logInfo("index jieji liushi is :" + index_jiejiliushui_sheet);
        XSSFSheet sheet1 = xssfWorkbook.getSheetAt(index_jiejiliushui_sheet);
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
        
		 Dailylog.logInfo("mudidi_jiejiliushui_index is :" + mudidi_jiejiliushui_index);
	   	 
	   	 
	   	 
		 XSSFRow row_jiejiliushui = null;
		 List<String> list_jiejiliushui_result = null;
		 
		 for(int x = 1; x <= rowLength1-1; x++){
			 
			 row_jiejiliushui = sheet1.getRow(x);
			 
			 XSSFCell cell_jijiliushui = null;
			 
			
			 
			String dingdanhao_jiejiliushui_Str = "";
			String yewudingdanhao_jiejiliushui_Str = "";
			String shangpingmingcheng_jiejiliushui_Str = "";
			String mudidi_jiejiliushui_Str = "";
			String hezuomoshi_jiejiliushui_Str = "";
			String pinlei_jiejiliushui_Str = "";
			String qudaolaiyuan_jiejiliushui_Str = "";
			String goumairen_jiejiliushui_Str = "";
			String gongyingshang_jiejiliushui_Str = "";
			String gongyingshangjiancheng_jiejiliushui_Str = "";
			String dianpuming_jiejiliushui_Str = "";
			String dianpuID_jiejiliushui_Str = "";
			String xiaoshoujine_jiejiliushui_Str = "";
			String zhifujine_jiejiliushui_Str = "";
			String butie_jiejiliushui_Str = "";
			String gongyingshangbutie_jiejiliushui_Str = "";
			String yingjiesuanjine_jiejiliushui_Str = "";
			String jiesuanjine_jiejiliushui_Str = "";
			String jiesuanjine_RMB_jiejiliushui_Str = "";
			String shouru_jiejiliushui_Str = "";
			String bizhong_jiejiliushui_Str = "";
			String huilv_jiejiliushui_Str = "";
			String zhangdanming_jiejiliushui_Str = "";
			String zhifushijian_jiejiliushui_Str = "";
			String chuxingriqi_jiejiliushui_Str = "";
			String jiesuanriqi_jiejiliushui_Str = "";
			String jiaoyiriqi_jiejiliushui_Str = "";
			String qingsuanriqi_jiejiliushui_Str = "";
			
			String combine_jiejiliushui_Str = "";
			
			list_jiejiliushui_result = new ArrayList<String>();
			 
			 for(int y =0; y<colLength1;y++){
				 
				 cell_jijiliushui = row_jiejiliushui.getCell(y);
				 
				 Dailylog.logInfo("y is ::::" + y);
				 
					if(y == dingdanhao_jiejiliushui_index){
						 dingdanhao_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == butie_jiejiliushui_index){
						 butie_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == yewudingdanhao_jiejiliushui_index){
						 yewudingdanhao_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == shangpingmingcheng_jiejiliushui_index){
						 shangpingmingcheng_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == mudidi_jiejiliushui_index){
						 mudidi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == hezuomoshi_jiejiliushui_index){
						 hezuomoshi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == pinlei_jiejiliushui_index){
						 pinlei_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == qudaolaiyuan_jiejiliushui_index){
						 qudaolaiyuan_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == goumairen_jiejiliushui_index){
						 goumairen_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == gongyingshang_jiejiliushui_index){
						 gongyingshang_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui); 
					 }else if(y == gongyingshangjiancheng_jiejiliushui_index){
						 gongyingshangjiancheng_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == dianpuming_jiejiliushui_index){
						 dianpuming_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == dianpuID_jiejiliushui_index){
						 dianpuID_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == xiaoshoujine_jiejiliushui_index){
						 xiaoshoujine_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == zhifujine_jiejiliushui_index){
						 zhifujine_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == gongyingshangbutie_jiejiliushui_index){
						 gongyingshangbutie_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == yingjiesuanjine_jiejiliushui_index){
						 yingjiesuanjine_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == jiesuanjine_jiejiliushui_index){
						 jiesuanjine_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == jiesuanjine_RMB_jiejiliushui_index){
						 jiesuanjine_RMB_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == shouru_jiejiliushui_index){
						 shouru_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == bizhong_jiejiliushui_index){
						 bizhong_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == huilv_jiejiliushui_index){
						 huilv_jiejiliushui_Str= WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == zhangdanming_jiejiliushui_index){
						 zhangdanming_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == zhifushijian_jiejiliushui_index){
						 zhifushijian_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == chuxingriqi_jiejiliushui_index){
						 chuxingriqi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == jiesuanriqi_jiejiliushui_index){
						 jiesuanriqi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == jiaoyiriqi_jiejiliushui_index){
						 jiaoyiriqi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }else if(y == qingsuanriqi_jiejiliushui_index){
						 qingsuanriqi_jiejiliushui_Str = WriterExcelUtil.getCellValue(cell_jijiliushui);
					 }
			 }
			 
			 
//			Dailylog.logInfo("dingdanhao_jiejiliushui_Str is::::::::::::::::::::: :" + dingdanhao_jiejiliushui_Str);
//			Dailylog.logInfo("butie_jiejiliushui_Str is :::::::::::::::::::" + butie_jiejiliushui_Str);
//			Dailylog.logInfo("yewudingdanhao_jiejiliushui_Str is :::::::::::::::::" + yewudingdanhao_jiejiliushui_Str);
//			Dailylog.logInfo("shangpingmingcheng_jiejiliushui_Str is :::::::::::::::::" + shangpingmingcheng_jiejiliushui_Str);
//			Dailylog.logInfo("mudidi_jiejiliushui_Str is :::::::::::::::::" + mudidi_jiejiliushui_Str);
//			Dailylog.logInfo("hezuomoshi_jiejiliushui_Str is :::::::::::::::::" + hezuomoshi_jiejiliushui_Str);
//			Dailylog.logInfo("pinlei_jiejiliushui_Str is :::::::::::::::::::::::::::::::::" + pinlei_jiejiliushui_Str);
//			
			
		
			 list_Jiejiliushui.add(dingdanhao_jiejiliushui_Str);
			 
			 
			list_jiejiliushui_result.add(yewudingdanhao_jiejiliushui_Str);
			list_jiejiliushui_result.add(shangpingmingcheng_jiejiliushui_Str);
			list_jiejiliushui_result.add(mudidi_jiejiliushui_Str);
			list_jiejiliushui_result.add(hezuomoshi_jiejiliushui_Str);
			list_jiejiliushui_result.add(pinlei_jiejiliushui_Str);
			list_jiejiliushui_result.add(qudaolaiyuan_jiejiliushui_Str);
			list_jiejiliushui_result.add(goumairen_jiejiliushui_Str);
			list_jiejiliushui_result.add(gongyingshang_jiejiliushui_Str);
			list_jiejiliushui_result.add(gongyingshangjiancheng_jiejiliushui_Str);
			list_jiejiliushui_result.add(dianpuming_jiejiliushui_Str);
			list_jiejiliushui_result.add(dianpuID_jiejiliushui_Str);
			list_jiejiliushui_result.add(xiaoshoujine_jiejiliushui_Str);
			list_jiejiliushui_result.add(zhifujine_jiejiliushui_Str);
			list_jiejiliushui_result.add(butie_jiejiliushui_Str);
			list_jiejiliushui_result.add(gongyingshangbutie_jiejiliushui_Str);
			list_jiejiliushui_result.add(yingjiesuanjine_jiejiliushui_Str);
			list_jiejiliushui_result.add(jiesuanjine_jiejiliushui_Str);
			list_jiejiliushui_result.add(jiesuanjine_RMB_jiejiliushui_Str);
			list_jiejiliushui_result.add(shouru_jiejiliushui_Str);
			list_jiejiliushui_result.add(bizhong_jiejiliushui_Str);
			list_jiejiliushui_result.add(huilv_jiejiliushui_Str);
			list_jiejiliushui_result.add(zhangdanming_jiejiliushui_Str);
			list_jiejiliushui_result.add(zhifushijian_jiejiliushui_Str);
			list_jiejiliushui_result.add(chuxingriqi_jiejiliushui_Str);
			list_jiejiliushui_result.add(jiesuanriqi_jiejiliushui_Str);
			list_jiejiliushui_result.add(jiaoyiriqi_jiejiliushui_Str);
			list_jiejiliushui_result.add(qingsuanriqi_jiejiliushui_Str);
			
			
			map_jiejiliushui.put(dingdanhao_jiejiliushui_Str, list_jiejiliushui_result);
			

		 }
		 
		 
		 if(list_Qingsuan.size() >= list_Jiejiliushui.size()){
			 
			 String qingsuan_str = "";
			 
			 for(int x = 0; x <list_Qingsuan.size(); x++){
				 
				 qingsuan_str = list_Qingsuan.get(x);
				 
				 if(list_Jiejiliushui.contains(qingsuan_str)){
					 common.add(qingsuan_str);
				 } 
			 }	 
		 }else{
			 
			 String jiejiliushui_str = "";
			 
			 for(int x = 0; x<list_Jiejiliushui.size(); x++){
				 
				 jiejiliushui_str = list_Jiejiliushui.get(x);
				 
				 if(list_Qingsuan.contains(jiejiliushui_str)){
					 common.add(jiejiliushui_str);
				 }	 
			 }
		 }
		 
		 Dailylog.logInfo("list_Qingsuan size is :" + list_Qingsuan.size());
		 Dailylog.logInfo("list_Jiejiliushui size is :" + list_Jiejiliushui.size());
      
		 Dailylog.logInfo("common size is :" + common.size());
		 
		 String key = "";
		 
		 List<String> temp_qingsuan = null;
		 List<String> temp_jiejiliushui = null;
		 List<String> errorList = null;
		 List<List<String>> list_result = null;
		 
		 for(int x = 0; x<common.size(); x++){
			 
			 list_result = new ArrayList<List<String>>();
			 
			 errorList = new ArrayList<String>();
			 
			 key = common.get(x);
			 
			 temp_qingsuan = map_qingsuan.get(key);
			 temp_jiejiliushui = map_jiejiliushui.get(key);
			 
			 Dailylog.logInfo("------------------------------------------------------------------------------");
			 
			 for(int y=0; y<temp_qingsuan.size();y++){		 
				 String qingsuan_Str = temp_qingsuan.get(y);
				 String jiejiliushui_Str = temp_jiejiliushui.get(y);
				
				 
				 
				 if(!qingsuan_Str.equals(jiejiliushui_Str)){
					 Dailylog.logInfo("qingsuan_Str is :" + qingsuan_Str + "     jiejiliushui_Str is :" + jiejiliushui_Str + "y is :" + y);
					 
					 if(y != 0){
						 errorList.add(y+"");
					 }
					
				 }
			 }
			 
			 if(errorList.size() != 0){
				 list_result.add(temp_qingsuan);
				 list_result.add(temp_jiejiliushui);
				 list_result.add(errorList);
				 
				 Dailylog.logInfo("error list size is :" + errorList.size());
				 map_result.put(key, list_result);
			 }	 
		 }
		 
		 Dailylog.logInfo("map_result size is :" + map_result.size());
		
		 List<String> list_FirstRow = new ArrayList<String>();
		 
		 
		 list_FirstRow.add("订单号");
		 list_FirstRow.add("业务订单号");
		 list_FirstRow.add("商品名称");
		 list_FirstRow.add("目的地");
		 list_FirstRow.add("合作模式");
		 list_FirstRow.add("品类");
		 list_FirstRow.add("渠道来源");
		 list_FirstRow.add("购买人");
		 list_FirstRow.add("供应商");
		 list_FirstRow.add("供应商简称");
		 list_FirstRow.add("店铺名");
		 list_FirstRow.add("店铺ID");
		 list_FirstRow.add("销售金额");
		 list_FirstRow.add("支付金额");
		 list_FirstRow.add("补贴");
		 list_FirstRow.add("供应商补贴");
		 list_FirstRow.add("应结算金额");
		 list_FirstRow.add("结算金额");
		 list_FirstRow.add("结算金额（RMB)");
		 list_FirstRow.add("收入");
		 list_FirstRow.add("币种");
		 list_FirstRow.add("汇率");
		 list_FirstRow.add("账单名");
		 list_FirstRow.add("支付时间");
		 list_FirstRow.add("出行日期");
		 list_FirstRow.add("结算日期");
		 list_FirstRow.add("交易日期");
		 list_FirstRow.add("清算日期");
		 
		 
		 
		 writeContent2Excels_Records(destinationFile,result_SheetName,list_FirstRow,map_result);

	}

	
	public void writeContent2Excels_Records(String destinationTable,String sheetName,List<String> firstRowName,Map<String,List<List<String>>> resultMap) throws Exception{
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
		
		
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
			HSSFCell cell1 = null;
			
			for(int x =0; x<firstRowName.size(); x++){
				
				cell1 = row1.createCell(x);
				
				cell1.setCellValue(firstRowName.get(x));
			}
			
			
			
			Set<String> resultSet = resultMap.keySet();
			
			Iterator<String> it = resultSet.iterator();
			
			List<List<String>> list = null;
			
			List<String> temp_list = null;
			List<String> error_list = null;
			
			int num = 1;
			
			CellStyle style = WriterExcelUtil.getCellStyle(book, "red");
			
			while(it.hasNext()){
				
				String keyName = it.next();
				
				list = resultMap.get(keyName);
				
				HSSFRow row = null;
				for(int x =0; x <list.size()-1; x++){
					
					temp_list = list.get(x);
					error_list = list.get(list.size()-1);
					
					row = sheet.createRow(num);
					
					HSSFCell cell0 = row.createCell(0);
					cell0.setCellValue(keyName);
		
					HSSFCell cell = null;
					for(int y=1;y<temp_list.size()+1;y++){
						
						cell = row.createCell(y);
						cell.setCellValue(temp_list.get(y-1));	
						
						if(error_list.contains((y-1)+"")){
							if((y-1) != 0){
								WriterExcelUtil.setCellColor(style, cell);
							}		
						}
					}
					num++;
				}
	
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
