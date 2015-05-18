package stack.commons.maths;

public class PrintDigits{

	  public static void main (String [] args)
	     {System.out.println(reversDigits(9876548));}

	        public static int reversDigits(int number) {
	           int result;

	           if (number < 10) {
	           System.out.println(number);
	           result = number;
	           }

	           else{
	           System.out.println(number % 10);
	           reversDigits(number/10);
	           result = number;
	           }
	           return result;
	        }


	        }   