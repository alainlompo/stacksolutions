package stack.commons.numbers;

import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
    	
	    	String phrase = "Madrid''; Real VS. Barcelona FC 14/May/2015";
	    	String[] dateSplit = phrase.split(";",-1);
	    	System.out.println("dateSplit[0]:" + dateSplit[0]);
	    	System.out.println("dateSplit[1]:" + dateSplit[1]);
	    	
	    	

            Scanner myScanner;
            myScanner = new Scanner( System.in );
            
            int mOne =0;
            int nOne = 0;
            int mTwo = 0;
            int nTwo = 0; 

            do {
                System.out.println("Enter the number of rows in Matrix #1: ");
                System.out.println("Enter the number of columns in Matrix #1: ");
                System.out.println("Enter the number of rows in Matrix #2: ");
                System.out.println("Enter the number of columns in Matrix  #2: ");

                 mOne = myScanner.nextInt();
                 nOne = myScanner.nextInt();
                 mTwo = myScanner.nextInt();
                 nTwo = myScanner.nextInt();

                if(mOne<=0 || mTwo<=0 || nOne<=0 || nTwo<=0){
                    System.out.println("Sorry, these are not valid     dimensional inpupts");
                    System.exit(0);
                }

                if (nOne != mTwo) {
                      System.out.println("Sorry these matrices cannot be     multiplied, please enter new dimensions");
                }

               } while (nOne!=mTwo);
            
            System.out.println("Here we can begin...");



            }
}
