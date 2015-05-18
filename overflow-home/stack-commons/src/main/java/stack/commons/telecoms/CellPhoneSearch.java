package stack.commons.telecoms;

import java.util.Scanner;

public class CellPhoneSearch {

	public static void main(String[] args) {
	    // TODO Auto-generated method stub
		Cellphone[] cellphoneArr = new Cellphone[10];
	        cellphoneArr [0] = new Cellphone ("Samsung", 123456789, 500.5);
	        cellphoneArr [1] = new Cellphone ("HTC", 123459876, 850.3);
	        cellphoneArr [2] = new Cellphone ("Sony", 543216789, 1230.4);
	        cellphoneArr [3] = new Cellphone ("Acer", 987654321, 600);
	        cellphoneArr [4] = new Cellphone ("Razr", 543298761, 700);
	        cellphoneArr [5] = new Cellphone (cellphoneArr [1]);
	        cellphoneArr [6] = new Cellphone (cellphoneArr [2]);
	        cellphoneArr [7] = new Cellphone (cellphoneArr [3]);
	        cellphoneArr [8] = new Cellphone (cellphoneArr [4]);
	        cellphoneArr [9] = new Cellphone (cellphoneArr [5]);
	
	
	     System.out.println("Please enter the brand");
	     Scanner userPreference = new Scanner(System.in);
	     String userBrand = userPreference.nextLine();
	
	     System.out.println("Please enter the serial number");
	     Scanner userSN = new Scanner(System.in);
	     long userSerialNumber = userSN.nextLong();
	
	     System.out.println("Please enter the Price");
	     Scanner userPr = new Scanner(System.in);
	     Double userPrice = userPr.nextDouble();
	
	
	     Cellphone cell_1 = new Cellphone( userBrand, userSerialNumber, userPrice  );
	
	     Scanner input = new Scanner(System.in);
	     System.out.println("Please enter true or false if you'd like to conduct a search to see whether or not two or more cellphones are similar");
	     boolean enteredValue = input.nextBoolean();
	
	     if (enteredValue == true)
	     { 
	    	 for(int i=0; i<=cellphoneArr.length-1; i++)
	    	 { 
	    		 System.out.println("hello");
	    		 if (cell_1.equals(cellphoneArr[i]))
	    			 System.out.println(cellphoneArr[i].toString());
	    	 }
	
	
	     }
	     else

	    	 for(int i=0; i>=cellphoneArr.length; i++)
	    	 {
	    		 if (cell_1.equals2(cellphoneArr[i]))
	    		 System.out.println(cellphoneArr[i]);
	
	         }
	}
	
}