package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
	
	public Date stringToDate(String strDate) {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
		Date date=null;
		try {
			date=(Date)format1.parse(strDate);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String dateToString(Date dateDate) {
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   String dateString = formatter.format(dateDate);
		   return dateString;
		}
	
	/*public static void main(String[] arg) {
		String string="2017-5-8";
		TimeFormat timeFormat=new TimeFormat();
		Date date=timeFormat.getDateByString(string);
		String string2=timeFormat.dateToStr(date);
		System.out.println(string2);
	}*/

}
