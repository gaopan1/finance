package TestScript.SaxExcel;

public class ExcelTest {
	
	
	 /**
     * 测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	
        IExcelRowReader rowReader = new ExcelRowReader();
        
        ExcelReaderUtil.readExcel(rowReader, "C:\\Users\\gaopan\\Desktop\\excel\\test.xlsx");
    }
	
}
