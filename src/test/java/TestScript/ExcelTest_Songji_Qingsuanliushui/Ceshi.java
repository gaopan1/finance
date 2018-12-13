package TestScript.ExcelTest_Songji_Qingsuanliushui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ceshi {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String time = "2018-11-29";
		
		String result = getDateString(time,3);
		
		System.out.println(result);
		
		

	}
	
	
	public static String getDateString(String time,long day) throws ParseException {
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = sdf.parse(time);
		
			
			long timeMillis = date.getTime();
			day = day * 24 * 60 * 60 * 1000;
			timeMillis += day;
			Date d = new Date(timeMillis);
			
			return sdf.format(d);
	
		}
		
}
