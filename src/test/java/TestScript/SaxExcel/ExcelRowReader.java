package TestScript.SaxExcel;

import java.util.List;

public class ExcelRowReader implements IExcelRowReader {

	
	 @Override
	    public void getRows(int sheetIndex, int curRow, List<String> rowlist) {
	        System.out.println(curRow+" ");  
	        for (int i = 0; i < rowlist.size(); i++) {  
	        	System.out.println("-------------------");
	            System.out.print(rowlist.get(i)==""?"*":rowlist.get(i) + " ");  
	        }  
	    }
}
