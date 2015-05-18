package stack.commons.maths;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PICalculator {
	
	private static final int BIG_NUMBER_OF_ITERATIONS = 500000;
	
	public static void calculatePi(int decimals) {
	    BigDecimal pi = new BigDecimal(0.0);
	    pi.setScale(decimals, RoundingMode.HALF_UP); // Set how many decimal points to use.
	    boolean plus = true; // Add on the next iteration?
	    int denominator = 1;
	    BigDecimal nextVal = new BigDecimal((4.0/denominator));

	    for(int i=0; i<BIG_NUMBER_OF_ITERATIONS; i++)
	    {
	        if(plus == true) {
	            pi = (pi.add(nextVal)).setScale(decimals, RoundingMode.HALF_UP);
	        } else {
	            pi = (pi.subtract(nextVal)).setScale(decimals, RoundingMode.HALF_UP);
	        }
	        denominator += 2;
	        nextVal = new BigDecimal(4.0/denominator);
	        plus = !plus; // Flip value of plus each iteration
	        //System.out.print(plus  + "...");
	    }
	    System.out.println(pi.toPlainString());
	}
	
	public static void main(String[] args) {
		String userInput = "";
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.println("Enter number of decimals for PI:");
			userInput = scanner.next();
			if (!"EXIT".equalsIgnoreCase(userInput.trim())) {
				calculatePi(Integer.parseInt(userInput));
			}
			
		} while (!"EXIT".equalsIgnoreCase(userInput.trim()));
		
		scanner.close();
		
	}

}
