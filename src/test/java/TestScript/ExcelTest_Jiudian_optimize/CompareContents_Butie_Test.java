package TestScript.ExcelTest_Jiudian_optimize;

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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import CommonFunction.WriterExcelUtil;
import TestScript.ExcelTest_Jiudian_optimize.jiuDianModel.BuTie_Model;

public class CompareContents_Butie_Test {

//	public String tableName = "C:\\Users\\gaopan\\Desktop\\测试excel\\接机对账全表.xlsx";
	
	String tag = "AAA";
	
	
	String sourceFile;
	String destinationFile;
	String account_sheetName;
	String payid;
	String fengmi;
	String zhekou;
	String youhuiquan;
	String butie;
	String zhifudingdan_id;
	
	
	int payid_index;
	int fengmi_index;
	int zhekou_index;
	int youhuiquan_index;
	int butie_index;
	int zhifudingdan_id_index;
	
	
	
	
	public Map<String,String> map_pay = new HashMap();
	
	public List<String> list_pay = new ArrayList<String>();
	
	public Map<String,String> map_account = new HashMap();
	
	public List<String> list_account = new ArrayList<String>();
	
//	public Map<String,List<String>> result_map = new HashMap<String,List<String>>();
	
	public Map<String,BuTie_Model> result_map = new HashMap<String,BuTie_Model>();
	

	public CompareContents_Butie_Test(String sourceFile,String destinationFile,String account_sheetName,String payid,String zhifudingdan_id,String fengmi,String zhekou,String youhuiquan,String butie){
		this.sourceFile = sourceFile;
		this.destinationFile = destinationFile;
		this.account_sheetName = account_sheetName;
		this.payid = payid;
		this.fengmi = fengmi;
		this.zhekou = zhekou;
		this.youhuiquan = youhuiquan;
		this.butie = butie;
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
        int index_paysheet = xssfWorkbook.getSheetIndex(account_sheetName);

        XSSFSheet sheet = xssfWorkbook.getSheetAt(index_paysheet);
        //总行数
        int rowLength = sheet.getLastRowNum()+1;
        System.out.println("row length is :" + rowLength);
        //4.得到Excel工作表的行
        XSSFRow xssfRow = sheet.getRow(0);
        //总列数
        int colLength = xssfRow.getLastCellNum();
        System.out.println("colLength is :" + colLength);
        
        
        /*
         * 订单号
			蜂蜜
			折扣
			优惠券
			补贴
			
			int payid_index;
			int fengmi_index;
			int zhekou_index;
			int youhuiquan_index;
			int butie_index;
	
			
			
         * */
        
        // 获取支付id的index
        payid_index = WriterExcelUtil.getIndexOfFields(xssfRow, payid);


        //获取想要获得字段的index  
   
        fengmi_index =  WriterExcelUtil.getIndexOfFields(xssfRow, fengmi);
        zhekou_index =  WriterExcelUtil.getIndexOfFields(xssfRow, zhekou);
        youhuiquan_index =  WriterExcelUtil.getIndexOfFields(xssfRow, youhuiquan);
        butie_index =  WriterExcelUtil.getIndexOfFields(xssfRow, butie);
        zhifudingdan_id_index = WriterExcelUtil.getIndexOfFields(xssfRow, zhifudingdan_id);
        
        for(int x = 1; x <= rowLength-1;x++){
        	xssfRow = sheet.getRow(x);
        	
        	String payId_str = "";
        	String fengmi_str = "";
        	String zhekou_str = "";
        	String youhuiquan_str = "";
        	String butie_str= "";
        	String zhifudingdanId_str = "";
        	
        	// 得到表格中需要字段的值
        	
//        	List<String> list = null;
        
        	for(int y =0 ;y<colLength;y++){
        		
//        		list = new ArrayList<String>();
        		
        		XSSFCell xssfCell = xssfRow.getCell(y);
        		
        		if(y == payid_index){
        			payId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == fengmi_index){
        			fengmi_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == zhekou_index){
        			zhekou_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == youhuiquan_index){
        			youhuiquan_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == butie_index){
        			butie_str = WriterExcelUtil.getCellValue(xssfCell);
        		}else if(y == zhifudingdan_id_index){
        			zhifudingdanId_str = WriterExcelUtil.getCellValue(xssfCell);
        		}
        	}
        	
        	

        	
        	double f_fengmi = WriterExcelUtil.getFloatPrice(fengmi_str);

        	
        	double f_zhekou = WriterExcelUtil.getFloatPrice(zhekou_str);

        	
        	double f_youhuiquan = WriterExcelUtil.getFloatPrice(youhuiquan_str);


        	
        	double f_butie = WriterExcelUtil.getFloatPrice(butie_str);

        
        	
        	
        	BuTie_Model model = new BuTie_Model();
        	
        	model.setBuTie(f_butie);
        	model.setFengMi(f_fengmi);
        	model.setYouHuiQuan(f_youhuiquan);
        	model.setZheKou(f_zhekou);
        	
        	
        	if(!model.judgeEquals()){
        		
        		result_map.put(payId_str+tag+zhifudingdanId_str, model);
        	}

        }
        
        ArrayList<String> al_firstRowNames = new ArrayList<String>();
        al_firstRowNames.add("订单ID");
        al_firstRowNames.add("支付订单ID");
        al_firstRowNames.add("蜂蜜");
	    al_firstRowNames.add("折扣");
	    al_firstRowNames.add("优惠券");
	    al_firstRowNames.add("补贴（计算结果）");
	    al_firstRowNames.add("补贴");

	    
        
        
        
        writeContent2Excels_Contents(destinationFile,account_sheetName+"<>"+butie,al_firstRowNames,result_map);
        
    
	}
	
public void writeContent2Excels_Contents(String destinationTable,String sheetName,ArrayList<String> firstRowNames,Map<String,BuTie_Model> map){
		
		
		WriterExcelUtil.createNewExcelFile(destinationTable);

		HSSFWorkbook book = null;
		
		try{
			
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
			//创建sheet
			HSSFSheet sheet = book.createSheet(sheetName);
			
			
			//给标题行赋值
			HSSFRow firstRow = sheet.createRow(0);
		
			HSSFCell cell = null;
			for(int x = 0; x< firstRowNames.size(); x++){
				
				cell = firstRow.createCell(x);
				
				cell.setCellValue(firstRowNames.get(x));
				
			}
			
			
			// 开始往表里写入内容
			
			if(map.size() != 0){
				Set<String> set1 = map.keySet();
				
				Iterator<String> itt = set1.iterator();
				
				int num = 1;
				while(itt.hasNext()){
					
					String str = itt.next();
					BuTie_Model butie_Model = map.get(str);
					
					HSSFRow row = sheet.createRow(num);
					
					HSSFCell cell_2 = row.createCell(0);
					cell_2.setCellValue(str.split(tag)[0]);
					
					HSSFCell cell_3 = row.createCell(1);
					cell_3.setCellValue(str.split(tag)[1]);
					
					for(int t = 2;t<=(firstRowNames.size()-2)+1;t++){
						HSSFCell cell_1 = row.createCell(t);
						
						if("蜂蜜".equals(firstRowNames.get(t))){
							butie_Model.getFengMi();
						}else if("折扣".equals(firstRowNames.get(t))){
							butie_Model.getZheKou();
						}else if("优惠券".equals(firstRowNames.get(t))){
							butie_Model.getYouHuiQuan();
						}else if("补贴（计算结果）".equals(firstRowNames.get(t))){
							butie_Model.getCalculate_Butie();
						}else if("补贴".equals(firstRowNames.get(t))){
							butie_Model.getBuTie();
						}
					}
					
					num++;
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
