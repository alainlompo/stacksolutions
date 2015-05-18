package stack.commons.collections;

import java.util.Scanner;

class  WordReverser {

	public static String reverse(String strToReverse) {
		
		 	String original = strToReverse, reverse = "";
		    
		    boolean blankString = false;
		    
		    if (original.equals(""))
		    {
		            blankString = true ;
		     }
		     else {
		        int length = original.length();
		
		        for ( int i = length - 1 ; i >= 0 ; i-- )
		             reverse = reverse + original.charAt(i);
		     }
		    
		    return reverse;
	
	}
	
	public static void main(String[] args ) {

	    //Declare variables area
	    String original, reverse = "";
	    Scanner in = new Scanner(System.in);
	    boolean blankString = false;
	    //public StringBuilder reverse();
	
	    // beginning message to user to explain the program
	    System.out.println("Welcome to my reverse word program!");
	    System.out.println("Please enter in a word or a phrase and see it reversed: ");
	
	    //main code and calculations to do
	    while (!blankString){
	        System.out.println("Enter a string to reverse");//Collect inputs from user.
	        original = in.nextLine();
	        if (original.equals(""))
	        {
	            blankString = true ;
	        }
	        else {
	        	
	        	String[] words = original.split(" ");
	        	String[] reversedWords = new String[words.length];
	        	StringBuilder reverseBuilder = new StringBuilder();
	        	for (int index = 0; index < words.length; index++) {
	        		reversedWords[index] = reverse(words[index]);
	        		reverseBuilder.append(reversedWords[index] +  " ");
	        	}
	        	
	       
	            System.out.println("Reverse of entered string is: "+reverseBuilder.toString());//Output results here
	        }
	    }
	
	    //End program message
	    System.out.println();
	    System.out.println("Hope you enjoyed using this program!");
	}// end main method


 }// end clas
