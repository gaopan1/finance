package TestScript.ExcelTest_Jiudian_JieSuanLiuShui;

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

public class CompareContents_Liushui_JieSuanLiuShui {

	
	
	String sourceFile;
	String destinationFile;
	String sheetName_Jiesuan;
	String sheetName_Liushui;
	
	//字段的顺序按照已结算流水表中的字段顺序进行排序
	
	// 已结算流水中的字段
	
	String OTA_Jiesuan;
	String liushui_id_Jiesuan;
	String dingdan_id_Jiesuan;
	String OTA_dingdan_id_Jiesuan;
	String liushuileixing_Jiesuan;
	String yewumoshi_Jiesuan;
	String dingdanzhuangtai_Jiesuan;
	String ruzhushijian_Jiesuan;
	String lidianshijian_Jiesuan;
	String chengbenjia_Jiesuan;
	String xiaoshoujia_Jiesuan;
	String shijixiaoshoujia_Jiesuan;
	String zhifushishoujine_Jiesuan;
	String yongjinbili_Jiesuan;
	String baobiaoshouru_Jiesuan;
	String butie_Jiesuan;
	String butie_youhuiquan_Jiesuan;
	String butie_fengmi_Jiesuan;
	String butie_zhekou_Jiesuan;
	String baobiaofeiyong_Jiesuan;
	String dingdanrihuilv_Jiesuan;
	String yingjiesuanjine_Jiesuan;
	
	int OTA_Jiesuan_Index;
	int liushui_id_Jiesuan_Index;
	int dingdan_id_Jiesuan_Index;
	int OTA_dingdan_id_Jiesuan_Index;
	int liushuileixing_Jiesuan_Index;
	int yewumoshi_Jiesuan_Index;
	int dingdanzhuangtai_Jiesuan_Index;
	int ruzhushijian_Jiesuan_Index;
	int lidianshijian_Jiesuan_Index;
	int chengbenjia_Jiesuan_Index;
	int xiaoshoujia_Jiesuan_Index;
	int shijixiaoshoujia_Jiesuan_Index;
	int zhifushishoujine_Jiesuan_Index;
	int yongjinbili_Jiesuan_Index;
	int baobiaoshouru_Jiesuan_Index;
	int butie_Jiesuan_Index;
	int butie_youhuiquan_Jiesuan_Index;
	int butie_fengmi_Jiesuan_Index;
	int butie_zhekou_Jiesuan_Index;
	int baobiaofeiyong_Jiesuan_Index;
	int dingdanrihuilv_Jiesuan_Index;
	int yingjiesuanjine_Jiesuan_Index;
	
	
	//---------------------------------
	//流水中的字段
	
	String OTA_Liushui;
	String liushui_id_Liushui;
	String dingdan_id_Liushui;
	String OTA_dingdan_id_Liushui;
	String liushuileixing_Liushui;
	String yewumoshi_Liushui;
	String dingdanzhuangtai_Liushui;
	String ruzhushijian_Liushui;
	String lidianshijian_Liushui;
	String chengbenjia_RMB_Liushui;
	String xiaoshoujia_Liushui;
	String shijixiaoshoujia_Liushui;
	String zhifushishoujine_Liushui;
	String yongjinbili_Liushui;
	String baobiaoshouru_Liushui;
	String butie_Liushui;
	String butie_youhuiquan_Liushui;
	String butie_fengmi_Liushui;
	String butie_zhekou_Liushui;
	String feiyong_Liushui;
	String dingdanrihuilv_Liushui;
	String yingjiesuanjine_Liushui;
	
	int OTA_Liushui_Index;
	int liushui_id_Liushui_Index;
	int dingdan_id_Liushui_Index;
	int OTA_dingdan_id_Liushui_Index;
	int liushuileixing_Liushui_Index;
	int yewumoshi_Liushui_Index;
	int dingdanzhuangtai_Liushui_Index;
	int ruzhushijian_Liushui_Index;
	int lidianshijian_Liushui_Index;
	int chengbenjia_RMB_Liushui_Index;
	int xiaoshoujia_Liushui_Index;
	int shijixiaoshoujia_Liushui_Index;
	int zhifushishoujine_Liushui_Index;
	int yongjinbili_Liushui_Index;
	int baobiaoshouru_Liushui_Index;
	int butie_Liushui_Index;
	int butie_youhuiquan_Liushui_Index;
	int butie_fengmi_Liushui_Index;
	int butie_zhekou_Liushui_Index;
	int feiyong_Liushui_Index;
	int dingdanrihuilv_Liushui_Index;
	int yingjiesuanjine_Liushui_Index;
	
	
	Map<String,ArrayList<String>> map_Jiesuan = new HashMap<String,ArrayList<String>>();
	Map<String,ArrayList<String>> map_Liushui = new HashMap<String,ArrayList<String>>();
	
	List<String> liuShui_ID_jiesuan = new ArrayList<String>();
	List<String> liuShui_ID_liushui = new ArrayList<String>();
	
	Map<String,List<List<String>>> map_result = new HashMap<String,List<List<String>>>();
	
	
	
	
	
	
	  public CompareContents_Liushui_JieSuanLiuShui(String sourceFile,
	  												String destinationFile,
	  												String sheetName_Jiesuan,
	  												String sheetName_Liushui,
			  										String OTA_Jiesuan,
													String liushui_id_Jiesuan,
													String dingdan_id_Jiesuan,
													String OTA_dingdan_id_Jiesuan,
													String liushuileixing_Jiesuan,
													String yewumoshi_Jiesuan,
													String dingdanzhuangtai_Jiesuan,
													String ruzhushijian_Jiesuan,
													String lidianshijian_Jiesuan,
													String chengbenjia_Jiesuan,
													String xiaoshoujia_Jiesuan,
													String shijixiaoshoujia_Jiesuan,
													String zhifushishoujine_Jiesuan,
													String yongjinbili_Jiesuan,
													String baobiaoshouru_Jiesuan,
													String butie_Jiesuan,
													String butie_youhuiquan_Jiesuan,
													String butie_fengmi_Jiesuan,
													String butie_zhekou_Jiesuan,
													String baobiaofeiyong_Jiesuan,
													String dingdanrihuilv_Jiesuan,
													String yingjiesuanjine_Jiesuan, 
													String OTA_Liushui,
													String liushui_id_Liushui,
													String dingdan_id_Liushui,
													String OTA_dingdan_id_Liushui,
													String liushuileixing_Liushui,
													String yewumoshi_Liushui,
													String dingdanzhuangtai_Liushui,
													String ruzhushijian_Liushui,
													String lidianshijian_Liushui,
													String chengbenjia_RMB_Liushui,
													String xiaoshoujia_Liushui,
													String shijixiaoshoujia_Liushui,
													String zhifushishoujine_Liushui,
													String yongjinbili_Liushui,
													String baobiaoshouru_Liushui,
													String butie_Liushui,
													String butie_youhuiquan_Liushui,
													String butie_fengmi_Liushui,
													String butie_zhekou_Liushui,
													String feiyong_Liushui,
													String dingdanrihuilv_Liushui,
													String yingjiesuanjine_Liushui){
		
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.sheetName_Jiesuan = sheetName_Jiesuan;
		this.sheetName_Liushui = sheetName_Liushui;
		
		this.OTA_Jiesuan = OTA_Jiesuan;
		this.liushui_id_Jiesuan = liushui_id_Jiesuan;
		this.dingdan_id_Jiesuan = dingdan_id_Jiesuan;
		this.OTA_dingdan_id_Jiesuan = OTA_dingdan_id_Jiesuan;
		this.liushuileixing_Jiesuan = liushuileixing_Jiesuan;
		this.yewumoshi_Jiesuan = yewumoshi_Jiesuan;
		this.dingdanzhuangtai_Jiesuan = dingdanzhuangtai_Jiesuan;
		this.ruzhushijian_Jiesuan = ruzhushijian_Jiesuan;
		this.lidianshijian_Jiesuan =lidianshijian_Jiesuan;
		this.chengbenjia_Jiesuan = chengbenjia_Jiesuan;
		this.xiaoshoujia_Jiesuan = xiaoshoujia_Jiesuan;
		this.shijixiaoshoujia_Jiesuan = shijixiaoshoujia_Jiesuan;
		this.zhifushishoujine_Jiesuan = zhifushishoujine_Jiesuan;
		this.yongjinbili_Jiesuan = yongjinbili_Jiesuan;
		this.baobiaoshouru_Jiesuan = baobiaoshouru_Jiesuan;
		this.butie_Jiesuan = butie_Jiesuan;
		this.butie_youhuiquan_Jiesuan = butie_youhuiquan_Jiesuan;
		this.butie_fengmi_Jiesuan = butie_fengmi_Jiesuan;
		this.butie_zhekou_Jiesuan = butie_zhekou_Jiesuan;
		this.baobiaofeiyong_Jiesuan = baobiaofeiyong_Jiesuan;
		this.dingdanrihuilv_Jiesuan = dingdanrihuilv_Jiesuan;
		this.yingjiesuanjine_Jiesuan = yingjiesuanjine_Jiesuan;
		
		this.OTA_Liushui = OTA_Liushui;
		this.liushui_id_Liushui = liushui_id_Liushui;
		this.dingdan_id_Liushui = dingdan_id_Liushui;
		this.OTA_dingdan_id_Liushui = OTA_dingdan_id_Liushui;
		this.liushuileixing_Liushui = liushuileixing_Liushui;
		this.yewumoshi_Liushui = yewumoshi_Liushui;
		this.dingdanzhuangtai_Liushui = dingdanzhuangtai_Liushui;
		this.ruzhushijian_Liushui = ruzhushijian_Liushui;
		this.lidianshijian_Liushui = lidianshijian_Liushui;
		this.chengbenjia_RMB_Liushui = chengbenjia_RMB_Liushui;
		this.xiaoshoujia_Liushui = xiaoshoujia_Liushui;
		this.shijixiaoshoujia_Liushui = shijixiaoshoujia_Liushui;
		this.zhifushishoujine_Liushui = zhifushishoujine_Liushui;
		this.yongjinbili_Liushui = yongjinbili_Liushui;
		this.baobiaoshouru_Liushui = baobiaoshouru_Liushui;
		this.butie_Liushui = butie_Liushui;
		this.butie_youhuiquan_Liushui = butie_youhuiquan_Liushui;
		this.butie_fengmi_Liushui = butie_fengmi_Liushui;
		this.butie_zhekou_Liushui = butie_zhekou_Liushui;
		this.feiyong_Liushui = feiyong_Liushui;
		this.dingdanrihuilv_Liushui = dingdanrihuilv_Liushui;
		this.yingjiesuanjine_Liushui = yingjiesuanjine_Liushui;
	
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
        int index_Jiesuansheet = xssfWorkbook.getSheetIndex(sheetName_Jiesuan);
        Dailylog.logInfo("index Jiesuansheet is :" + index_Jiesuansheet);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_Jiesuansheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        // 得到结算流水表中相应字段的index
        
         OTA_Jiesuan_Index = WriterExcelUtil.getIndexOfFields(xssfRow, OTA_Jiesuan);
    	 liushui_id_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, liushui_id_Jiesuan);
    	 dingdan_id_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, dingdan_id_Jiesuan);
    	 OTA_dingdan_id_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, OTA_dingdan_id_Jiesuan);
    	 liushuileixing_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, liushuileixing_Jiesuan);
    	 yewumoshi_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, yewumoshi_Jiesuan);
    	 dingdanzhuangtai_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, dingdanzhuangtai_Jiesuan);
    	 ruzhushijian_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  ruzhushijian_Jiesuan);
    	 lidianshijian_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, lidianshijian_Jiesuan);
    	 chengbenjia_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  chengbenjia_Jiesuan);
    	 xiaoshoujia_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  xiaoshoujia_Jiesuan);
    	 shijixiaoshoujia_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, shijixiaoshoujia_Jiesuan);
    	 zhifushishoujine_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, zhifushishoujine_Jiesuan);
    	 yongjinbili_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  yongjinbili_Jiesuan);
    	 baobiaoshouru_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  baobiaoshouru_Jiesuan);
    	 butie_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, butie_Jiesuan);
    	 butie_youhuiquan_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, butie_youhuiquan_Jiesuan);
    	 butie_fengmi_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, butie_fengmi_Jiesuan);
    	 butie_zhekou_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, butie_zhekou_Jiesuan);
    	 baobiaofeiyong_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, baobiaofeiyong_Jiesuan);
    	 dingdanrihuilv_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow,  dingdanrihuilv_Jiesuan);
    	 yingjiesuanjine_Jiesuan_Index= WriterExcelUtil.getIndexOfFields(xssfRow, yingjiesuanjine_Jiesuan);
        
    	 
    	 
    	 
    	 
    	 XSSFRow row = null;
    	 
    	 ArrayList<String> list_Jiesuan = null;
        
    	 for(int x = 1; x < rowLength; x++){
    		 
    		 row = sheet.getRow(x);
//    		 Dailylog.logInfo("row is null ?" + (row==null));
    		 
    		
    		 
    		 
			String OTA_Jiesuan_Str = "";
    		String liushui_id_Jiesuan_Str= "";
    		String dingdan_id_Jiesuan_Str= "";
    		String OTA_dingdan_id_Jiesuan_Str= "";
    		String liushuileixing_Jiesuan_Str= "";
    		String yewumoshi_Jiesuan_Str= "";
    		String dingdanzhuangtai_Jiesuan_Str= "";
    		String ruzhushijian_Jiesuan_Str= "";
    		String lidianshijian_Jiesuan_Str= "";
    		String chengbenjia_Jiesuan_Str= "";
    		String xiaoshoujia_Jiesuan_Str= "";
    		String shijixiaoshoujia_Jiesuan_Str= "";
    		String zhifushishoujine_Jiesuan_Str= "";
    		String yongjinbili_Jiesuan_Str= "";
    		String baobiaoshouru_Jiesuan_Str= "";
    		String butie_Jiesuan_Str= "";
    		String butie_youhuiquan_Jiesuan_Str= "";
    		String butie_fengmi_Jiesuan_Str= "";
    		String butie_zhekou_Jiesuan_Str= "";
    		String baobiaofeiyong_Jiesuan_Str= "";
    		String dingdanrihuilv_Jiesuan_Str= "";
    		String yingjiesuanjine_Jiesuan_Str= "";
    		
    		 for(int y = 0; y<colLength; y++){
    			 
//    			 Dailylog.logInfo("x is :" + x+"    y is ---------：" + y);
    			 XSSFCell xssfCell = row.getCell(y);
    			 
    			 if(y == OTA_Jiesuan_Index){
    				 OTA_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    				 
    			 }else if(y == liushui_id_Jiesuan_Index){
    				 liushui_id_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    				
    			 }else if(y == dingdan_id_Jiesuan_Index){
    				 dingdan_id_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    				 
    			 }else if(y == OTA_dingdan_id_Jiesuan_Index){
    				 OTA_dingdan_id_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == liushuileixing_Jiesuan_Index){
    				 liushuileixing_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yewumoshi_Jiesuan_Index){
    				 yewumoshi_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == dingdanzhuangtai_Jiesuan_Index){
    				 dingdanzhuangtai_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == ruzhushijian_Jiesuan_Index){
    				 ruzhushijian_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == lidianshijian_Jiesuan_Index){
    				 lidianshijian_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == chengbenjia_Jiesuan_Index){
    				 chengbenjia_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == xiaoshoujia_Jiesuan_Index){
    				 xiaoshoujia_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == shijixiaoshoujia_Jiesuan_Index){
    				 shijixiaoshoujia_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == zhifushishoujine_Jiesuan_Index){
    				 zhifushishoujine_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yongjinbili_Jiesuan_Index){
    				 yongjinbili_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == baobiaoshouru_Jiesuan_Index){
    				 baobiaoshouru_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_Jiesuan_Index){
    				 butie_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_youhuiquan_Jiesuan_Index){
    				 butie_youhuiquan_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_fengmi_Jiesuan_Index){
    				 butie_fengmi_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_zhekou_Jiesuan_Index){
    				 butie_zhekou_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == baobiaofeiyong_Jiesuan_Index){
    				 baobiaofeiyong_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == dingdanrihuilv_Jiesuan_Index){
    				 dingdanrihuilv_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yingjiesuanjine_Jiesuan_Index){
    				 yingjiesuanjine_Jiesuan_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }	 
    		 }
    		 
    		 Dailylog.logInfo("OTA_Jiesuan_Str is :" + OTA_Jiesuan_Str);
    		 Dailylog.logInfo("liushui_id_Jiesuan_Str is :" + liushui_id_Jiesuan_Str);
    		 Dailylog.logInfo("dingdan_id_Jiesuan_Str is :" + dingdan_id_Jiesuan_Str);
    		 
    		 
    		 
    		 liuShui_ID_jiesuan.add(liushui_id_Jiesuan_Str);
    		 
    		 list_Jiesuan = new ArrayList<String>();
    		 
    		 
    		 list_Jiesuan.add(OTA_Jiesuan_Str);
    		 list_Jiesuan.add(dingdan_id_Jiesuan_Str);
    		 list_Jiesuan.add(OTA_dingdan_id_Jiesuan_Str);
    		 list_Jiesuan.add(liushuileixing_Jiesuan_Str);
    		 list_Jiesuan.add(yewumoshi_Jiesuan_Str);
    		 list_Jiesuan.add(dingdanzhuangtai_Jiesuan_Str);
    		 list_Jiesuan.add(ruzhushijian_Jiesuan_Str);
    		 list_Jiesuan.add(lidianshijian_Jiesuan_Str);
    		 list_Jiesuan.add(chengbenjia_Jiesuan_Str);
    		 list_Jiesuan.add(xiaoshoujia_Jiesuan_Str);
    		 list_Jiesuan.add(shijixiaoshoujia_Jiesuan_Str);
    		 list_Jiesuan.add(zhifushishoujine_Jiesuan_Str);
    		 list_Jiesuan.add(yongjinbili_Jiesuan_Str);
    		 list_Jiesuan.add(baobiaoshouru_Jiesuan_Str);
    		 list_Jiesuan.add(butie_Jiesuan_Str);
    		 list_Jiesuan.add(butie_youhuiquan_Jiesuan_Str);
    		 list_Jiesuan.add(butie_fengmi_Jiesuan_Str);
    		 list_Jiesuan.add(butie_zhekou_Jiesuan_Str);
    		 list_Jiesuan.add(baobiaofeiyong_Jiesuan_Str);
    		 list_Jiesuan.add(dingdanrihuilv_Jiesuan_Str);
    		 list_Jiesuan.add(yingjiesuanjine_Jiesuan_Str);
    		 
    		 
    		 map_Jiesuan.put(liushui_id_Jiesuan_Str, list_Jiesuan);
    		 
    	 }
    	 
    	  //3.Excel工作表对象
         int index_Liushuisheet = xssfWorkbook.getSheetIndex(sheetName_Liushui);
         Dailylog.logInfo("index Liushuisheet is :" + index_Liushuisheet);
         XSSFSheet sheet1 = xssfWorkbook.getSheetAt(index_Liushuisheet);
         //总行数
         int rowLength1 = sheet1.getLastRowNum()+1;
         System.out.println("row length is :" + rowLength1);
         //4.得到Excel工作表的行
         XSSFRow xssfRow1 = sheet1.getRow(0);
         //总列数
         int colLength1 = xssfRow1.getLastCellNum();
         System.out.println("colLength1 is :" + colLength1);
         
    	 
         // 得到流水表中相应字段的indexdingdan_id_Liushui_Index
         
     	OTA_Liushui_Index = WriterExcelUtil.getIndexOfFields(xssfRow1, OTA_Liushui);
     	
     	liushui_id_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, liushui_id_Liushui);
     	
     	dingdan_id_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, dingdan_id_Liushui);
     	
     	OTA_dingdan_id_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, OTA_dingdan_id_Liushui);
     	liushuileixing_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, liushuileixing_Liushui);
     	yewumoshi_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, yewumoshi_Liushui);
     	dingdanzhuangtai_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, dingdanzhuangtai_Liushui);
     	ruzhushijian_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  ruzhushijian_Liushui);
     	lidianshijian_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, lidianshijian_Liushui);
     	chengbenjia_RMB_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  chengbenjia_RMB_Liushui);
     	xiaoshoujia_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  xiaoshoujia_Liushui);
     	shijixiaoshoujia_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, shijixiaoshoujia_Liushui);
     	zhifushishoujine_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, zhifushishoujine_Liushui);
     	yongjinbili_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  yongjinbili_Liushui);
     	baobiaoshouru_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  baobiaoshouru_Liushui);
     	butie_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, butie_Liushui);
     	butie_youhuiquan_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, butie_youhuiquan_Liushui);
     	butie_fengmi_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, butie_fengmi_Liushui);
     	butie_zhekou_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, butie_zhekou_Liushui);
     	feiyong_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, feiyong_Liushui);
     	dingdanrihuilv_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1,  dingdanrihuilv_Liushui);
     	yingjiesuanjine_Liushui_Index= WriterExcelUtil.getIndexOfFields(xssfRow1, yingjiesuanjine_Liushui);
         
         
     	
//     	Dailylog.logInfo("OTA_Liushui_Index is :" + OTA_Liushui_Index + "OTA_Liushui is :" + OTA_Liushui);
//     	Dailylog.logInfo("liushui_id_Liushui_Index is :" + liushui_id_Liushui_Index + "liushui_id_Liushui is :" + liushui_id_Liushui);
//     	Dailylog.logInfo("dingdan_id_Liushui_Index is :" + dingdan_id_Liushui_Index + "dingdan_id_Liushui is :" + dingdan_id_Liushui);
     	
     	
     	
     	
     	XSSFRow row_liushui = null;
     	
     	ArrayList<String> list_Liushui = null;
    	 
    	 for(int x = 1; x< rowLength1;x++){
    		 
    		 row_liushui = sheet1.getRow(x);
//    		 Dailylog.logInfo("x is null ?:" + (row1==null));
    	
    		 
    		String OTA_Liushui_Str="";
			String liushui_id_Liushui_Str="";
			String dingdan_id_Liushui_Str="";
			String OTA_dingdan_id_Liushui_Str="";
			String liushuileixing_Liushui_Str="";
			String yewumoshi_Liushui_Str="";
			String dingdanzhuangtai_Liushui_Str="";
			String ruzhushijian_Liushui_Str="";
			String lidianshijian_Liushui_Str="";
			String chengbenjia_RMB_Liushui_Str="";
			String xiaoshoujia_Liushui_Str="";
			String shijixiaoshoujia_Liushui_Str="";
			String zhifushishoujine_Liushui_Str="";
			String yongjinbili_Liushui_Str="";
			String baobiaoshouru_Liushui_Str="";
			String butie_Liushui_Str="";
			String butie_youhuiquan_Liushui_Str="";
			String butie_fengmi_Liushui_Str="";
			String butie_zhekou_Liushui_Str="";
			String feiyong_Liushui_Str="";
			String dingdanrihuilv_Liushui_Str="";
			String yingjiesuanjine_Liushui_Str="";
    		 
    		 
    		 
    		 for(int y = 0; y<colLength1; y++){
    			 
//    			 Dailylog.logInfo("x is :：：：" + x +"   y is ：：：：：：" +y);
    			 
    			 XSSFCell xssfCell = row_liushui.getCell(y);
    			 
    			 if(y ==  OTA_Liushui_Index){
    				 OTA_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y ==  liushui_id_Liushui_Index){
    				 liushui_id_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == dingdan_id_Liushui_Index){
    				 dingdan_id_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == OTA_dingdan_id_Liushui_Index){
    				 OTA_dingdan_id_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == liushuileixing_Liushui_Index){
    				 liushuileixing_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yewumoshi_Liushui_Index){
    				 yewumoshi_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == dingdanzhuangtai_Liushui_Index){
    				 dingdanzhuangtai_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == ruzhushijian_Liushui_Index){
    				 ruzhushijian_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == lidianshijian_Liushui_Index){
    				 lidianshijian_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == chengbenjia_RMB_Liushui_Index){
    				 chengbenjia_RMB_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == xiaoshoujia_Liushui_Index){
    				 xiaoshoujia_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == shijixiaoshoujia_Liushui_Index){
    				 shijixiaoshoujia_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == zhifushishoujine_Liushui_Index){
    				 zhifushishoujine_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yongjinbili_Liushui_Index){
    				 yongjinbili_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == baobiaoshouru_Liushui_Index){
    				 baobiaoshouru_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_Liushui_Index){
    				 butie_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_youhuiquan_Liushui_Index){
    				 butie_youhuiquan_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_fengmi_Liushui_Index){
    				 butie_fengmi_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == butie_zhekou_Liushui_Index){
    				 butie_zhekou_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == feiyong_Liushui_Index){
    				 feiyong_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == dingdanrihuilv_Liushui_Index){
    				 dingdanrihuilv_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }else if(y == yingjiesuanjine_Liushui_Index){
    				 yingjiesuanjine_Liushui_Str = WriterExcelUtil.getCellValue(xssfCell);
    			 }	 
 	 
    		 }
    		 
//    		 Dailylog.logInfo("liuShui_ID_jiesuan size is :" + liuShui_ID_jiesuan.size());
//    		 Dailylog.logInfo("liuShui_ID_jiesuan is :" + liuShui_ID_jiesuan.toString());
//    		 Dailylog.logInfo("liushui_id_Liushui_Str is ：" + liushui_id_Liushui_Str);
//    		 Dailylog.logInfo("liushuileixing_Liushui_Str is ：" + liushuileixing_Liushui_Str);
    		 
//    		 Dailylog.logInfo("x is ::::::::: out   " + x );
    		 if(liuShui_ID_jiesuan.contains(liushui_id_Liushui_Str)){
    			 
    			 liuShui_ID_liushui.add(liushui_id_Liushui_Str);
    			 
//    			 Dailylog.logInfo("x is ::::::::: in    " + x );
    			 
    			 list_Liushui = new ArrayList<String>();
    			 
    			
    			 list_Liushui.add(OTA_Liushui_Str);
    			 list_Liushui.add(dingdan_id_Liushui_Str);
    			 list_Liushui.add(OTA_dingdan_id_Liushui_Str);
    			 list_Liushui.add(liushuileixing_Liushui_Str);
    			 list_Liushui.add(yewumoshi_Liushui_Str);
    			 list_Liushui.add(dingdanzhuangtai_Liushui_Str);
    			 list_Liushui.add(ruzhushijian_Liushui_Str);
    			 list_Liushui.add(lidianshijian_Liushui_Str);
    			 list_Liushui.add(chengbenjia_RMB_Liushui_Str);
    			 list_Liushui.add(xiaoshoujia_Liushui_Str);
    			 list_Liushui.add(shijixiaoshoujia_Liushui_Str);
    			 list_Liushui.add(zhifushishoujine_Liushui_Str);
    			 list_Liushui.add(yongjinbili_Liushui_Str);
    			 list_Liushui.add(baobiaoshouru_Liushui_Str);
    			 list_Liushui.add(butie_Liushui_Str);
    			 list_Liushui.add(butie_youhuiquan_Liushui_Str);
    			 list_Liushui.add(butie_fengmi_Liushui_Str);
    			 list_Liushui.add(butie_zhekou_Liushui_Str);
    			 list_Liushui.add(feiyong_Liushui_Str);
    			 list_Liushui.add(dingdanrihuilv_Liushui_Str);
    			 list_Liushui.add(yingjiesuanjine_Liushui_Str);
    			 
    			 Dailylog.logInfo("dingdan_id_Liushui_Str is :" + dingdan_id_Liushui_Str);
    			 
    			 
    			 map_Liushui.put(liushui_id_Liushui_Str, list_Liushui);
    		 } 
    	 }
    	 
    	 Dailylog.logInfo("map of jiesuan size is :" + map_Jiesuan.size());
    	 Dailylog.logInfo("map of liushui size is :" + map_Liushui.size());
    	 
    	 
        
        
    	 List<String> temp_Jiesuan = null;
    	 List<String> temp_Liushui = null;
    	 
    	 List<String> errorList = null;
    	 
    	 List<List<String>> list_result = null;
		
    	 for(int x = 0; x<liuShui_ID_liushui.size(); x++){
    		 
    		 String temp_liushuiID = liuShui_ID_liushui.get(x);
    		 
    		 temp_Jiesuan = map_Jiesuan.get(temp_liushuiID);
    		 temp_Liushui = map_Liushui.get(temp_liushuiID);
    		 
    		 Dailylog.logInfo("temp_liushuiID is :" + temp_liushuiID);
    		 Dailylog.logInfo("temp_Jiesuan  is null? :" + (temp_Jiesuan == null) + temp_Jiesuan.toString());
    		 Dailylog.logInfo("temp_Liushui  is null? :" + (temp_Liushui == null) + temp_Liushui.toString());
    		 
    		 errorList = new ArrayList<String>();
    		 Dailylog.logInfo("x is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:" + x);
    		 for(int y =0; y< temp_Jiesuan.size(); y++){
    			 
    			 String jiesuan_element = temp_Jiesuan.get(y);
    			 Dailylog.logInfo("temp_Liushui is null ?" + (temp_Liushui == null));
    			 String liushui_element = temp_Liushui.get(y);
    			
    			 Dailylog.logInfo("temp_liushuiID is :" + temp_liushuiID + "jiesuan_element is :" + jiesuan_element + "liushui_element is :" + liushui_element);
    			 
    			 if(!jiesuan_element.equals(liushui_element)){
    				 errorList.add(y+"");
    			 }
    		 }
    		 Dailylog.logInfo("---------------------------------");
    		 
    		if(errorList.size() != 0){
    			list_result = new ArrayList();
    			
    			list_result.add(temp_Jiesuan);
    			list_result.add(temp_Liushui);
    			list_result.add(errorList);
    			
    			map_result.put(temp_liushuiID, list_result);
    		}
	 
    	 }
    	 
    	 List<String> firstRowList = new ArrayList<String>();

    	 firstRowList.add("流水ID");
    	 firstRowList.add("OTA");
    	 firstRowList.add("订单ID");
    	 firstRowList.add("OTA订单ID");
    	 firstRowList.add("流水类型");
    	 firstRowList.add("业务模式");
    	 firstRowList.add("订单状态");
    	 firstRowList.add("入住时间");
    	 firstRowList.add("离店时间");
    	 firstRowList.add("成本价");
    	 firstRowList.add("销售价");
    	 firstRowList.add("实际销售价");
    	 firstRowList.add("支付(实收)金额");
    	 firstRowList.add("佣金比例");
    	 firstRowList.add("报表收入");
    	 firstRowList.add("补贴");
    	 firstRowList.add("补贴：优惠券");
    	 firstRowList.add("补贴：蜂蜜");
    	 firstRowList.add("补贴：折扣");
    	 firstRowList.add("报表费用");
    	 firstRowList.add("订单日汇率");
    	 firstRowList.add("应结算金额");
    	 
    	 
    	 
    	 
    	 writeContent2Excels_Contents(destinationFile,"CompareContents",sheetName_Jiesuan,sheetName_Liushui,firstRowList,map_result);
    	 
    	 
	}
	
	
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,String sheetName_Jiesuan,String sheetName_Liushui,List<String> list,Map<String,List<List<String>>> map){
		
		WriterExcelUtil.createNewExcelFile(destinationTable);
	
	
		HSSFWorkbook book = null;
		
		try{
			
			File file = new File(destinationTable);
			
			FileInputStream fis = new FileInputStream(file);
			
			book = new HSSFWorkbook(fis);
			
			int sheetNums = book.getNumberOfSheets();
			
			Dailylog.logInfo("sheet nums is " + sheetNums);
			
			for(int m =0 ; m< sheetNums;m++){
				String temp_sheetName = book.getSheetName(m);
				Dailylog.logInfo("m is :" + m + "temp_sheetName is :" + temp_sheetName+ "temp_sheetName length is :" + temp_sheetName.length());
				Dailylog.logInfo("m is :" + m + "sheet name is :" + sheetName);
				if(temp_sheetName.equals(sheetName)){
					Dailylog.logInfo("+++++++++++++++++++++++++++++++++++++++++++++");
					book.removeSheetAt(m);
					break;
				}
			}
			//创建sheet
			HSSFSheet sheet = book.createSheet(sheetName);
			
			HSSFRow firstRow = sheet.createRow(0);
			
			HSSFCell cell = null;
			for(int x = 0; x < list.size(); x++){
				
				cell = firstRow.createCell(x);
				
				cell.setCellValue(list.get(x));	
			}
			
			
			if(map.size() != 0){
				
				
				Set<String> set = map.keySet();
				
				Iterator<String> it = set.iterator();
				
				HSSFRow row = null;
				int rowNum = 1;
				
				CellStyle style = WriterExcelUtil.getCellStyle(book, "red");
				
				while(it.hasNext()){
					
					String liushuiID = it.next();
					
					List<List<String>> allList = map.get(liushuiID);
					
					for(int x = 0; x<allList.size()-1; x++){
						
						List<String> temp_list = allList.get(x);
						List<String> errorList = allList.get(allList.size()-1);
						
						row = sheet.createRow(rowNum);
						for(int y =1; y<=temp_list.size(); y++){
							
							HSSFCell cell_1 = row.createCell(0);
							cell_1.setCellValue(liushuiID);
							
							
							HSSFCell cell_temp = row.createCell(y);
							cell_temp.setCellValue(temp_list.get(y-1));
							
							if(errorList.contains((y-1)+"")){
//								WriterExcelUtil.setCellColor(book, cell_temp, "red");
								WriterExcelUtil.setCellColor(style, cell_temp);
							}
							
						}
						
						rowNum++;
						
					}	
				}	
			}
	
			FileOutputStream fos = new FileOutputStream(file);
			
			book.write(fos);
			
			fos.close();
			book.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
