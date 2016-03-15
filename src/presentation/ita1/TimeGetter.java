package presentation.ita1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeGetter {
  public static String getToday(){
	    Date date=new Date();
	    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	   
	  
	  return df.format(date);
  }
	
public static String getDayBefore(int n){
	Calendar c=Calendar.getInstance();
	
	  c.add(Calendar.DATE, -n);
	  Date date=c.getTime();
	  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	  
	  return df.format(date);
  }
	
}
