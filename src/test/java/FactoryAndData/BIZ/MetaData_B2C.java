package FactoryAndData.BIZ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import TestScript.BIZ.MetaDataTest_B2C;

public class MetaData_B2C {
	public static String filePath = "\\\\10.62.6.95\\MetaDataTest\\MetaDataTest.xlsx";
	//public static String filePath = "C:\\Users\\gaopan2\\Desktop\\REPORT\\MetaData\\MetaDataTest.xlsx";
	

	@DataProvider(name = "MetaData")
	public static Object[][] DataMetaData() {
		return readInputData();
	}

	@Factory(dataProvider = "MetaData")
	public Object[] createTest(String rowIndex, String homePage_url, String gaming_Url,String SMB_Url,String outlet_Url,String AddressLine1,String City,String state,String zipCode,String phoneNumber) {

		Object[] tests = new Object[1];

		tests[0] = new MetaDataTest_B2C(rowIndex, homePage_url,gaming_Url,gaming_Url, outlet_Url,AddressLine1,City,state,zipCode,phoneNumber);

		return tests;
	}
	
	public static void deleteExcelContent(){
		try{
			FileInputStream excelFileInPutStream = new FileInputStream(filePath);
			
			Workbook workbook = WorkbookFactory.create(excelFileInPutStream);
			Sheet sheet = workbook.getSheetAt(0);
			
			int index = 1;
			int rowNum = 0;
			while(true){
				index++;
				Row row = sheet.getRow(index-1);
				
				try{
					Cell cell = row.getCell(0);
					String str = cell.getStringCellValue();
					System.out.println("str is :" + str);
				}catch(Exception e){
					break;
				}
				rowNum = index;
				
				System.out.println("rowNum is :" + rowNum);
			}
			
			
			int lastColumnNum = sheet.getRow(0).getLastCellNum();
			System.out.println("lastColumnNum is :" + lastColumnNum);
			
			CellStyle blankStyle = workbook.createCellStyle();
			blankStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			blankStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			
			
			for(int a = 1; a<rowNum;a++){
				for(int b = 9; b<lastColumnNum;b++){
					Cell cell = sheet.getRow(a).getCell(b);
					if(cell != null){
						cell.setCellValue("");
						cell.setCellStyle(blankStyle);
					}
				}
			}
		
			FileOutputStream excelFileOutPutStream = new FileOutputStream(filePath);
			workbook.write(excelFileOutPutStream);
			excelFileOutPutStream.flush();
			excelFileOutPutStream.close();
			workbook.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String[][] readInputData() {
		deleteExcelContent();
		try {
			String fileName = "\\\\10.62.6.95\\MetaDataTest\\B2CAutoTestInProgress.txt";
			//String fileName = "C:\\Users\\gaopan2\\Desktop\\REPORT\\MetaData\\AutoTestInProgress.txt";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			fileName = "\\\\10.62.6.95\\MetaDataTest\\B2CAutoTestDone.txt";
			file = new File(fileName);
			if (file.exists()) {
				file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			FileInputStream excelFileInPutStream = new FileInputStream(filePath);
		
			Workbook workbook = WorkbookFactory.create(excelFileInPutStream);
			Sheet sheet = workbook.getSheetAt(0);
			int rowIndex = 1;

			ArrayList<String[]> inputData = new ArrayList<String[]>();
			while (sheet.getRow(rowIndex) != null && readCellValue(sheet.getRow(rowIndex), 0) != "BlankCell") {
				String[] tempRow = { Integer.toString(rowIndex), readCellValue(sheet.getRow(rowIndex), 0), readCellValue(sheet.getRow(rowIndex),1),readCellValue(sheet.getRow(rowIndex),2),readCellValue(sheet.getRow(rowIndex),3),readCellValue(sheet.getRow(rowIndex),4),readCellValue(sheet.getRow(rowIndex),5),readCellValue(sheet.getRow(rowIndex),6),readCellValue(sheet.getRow(rowIndex),7),readCellValue(sheet.getRow(rowIndex),8)
						 };
				inputData.add(tempRow);
				rowIndex++;
			}
			excelFileInPutStream.close();
			String[][] test = (String[][]) inputData.toArray(new String[0][0]);
			return test;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	private static String readCellValue(Row row, int columnIndex) {
		Cell cell = row.getCell(columnIndex);
		if (cell == null) {
			return "BlankCell";
		}
		DecimalFormat df = new DecimalFormat("#");
		int type = cell.getCellType();
		if (type == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (type == Cell.CELL_TYPE_NUMERIC) {
			return df.format(cell.getNumericCellValue());
		} else if (type == Cell.CELL_TYPE_BLANK) {
			return "BlankCell";
		} else {
			return "Error!";
		}
	}
}
