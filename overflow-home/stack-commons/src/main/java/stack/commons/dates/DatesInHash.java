package stack.commons.dates;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DatesInHash {
	
	 private  Date exDate;
	 private Date frontDate;
	 private  Map<String, Object> selectDates;
	     {
	    	 exDate = new Date();
	         selectDates = new LinkedHashMap<String, Object>();
	         selectDates.put("First Date", exDate); //label, value
	         selectDates.put("Second Date", frontDate);
	     }

	     
	 public void initMap() {
		 
		 selectDates = new LinkedHashMap<String, Object>();
         selectDates.put("First Date", exDate); //label, value
         selectDates.put("Second Date", frontDate);
         
		 
	 }
	 public Map<String, Object> getSelectDates() {
	     return selectDates;
	 }
	 
	 public void doDemo() {
		 exDate = new Date();
		 frontDate = new Date();
		 Map<String, Object> datesMap = getSelectDates();
		 
		 System.out.println(((Date)datesMap.get("First Date")).toString());
		 
		 
	 }
	 
	 public static void main(String[] args) {
		 DatesInHash dIH = new DatesInHash();
		 dIH.doDemo();
		 
	 }
	 
}
