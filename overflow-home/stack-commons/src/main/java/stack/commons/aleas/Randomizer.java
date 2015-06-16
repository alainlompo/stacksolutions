package stack.commons.aleas;
import java.util.Random;

public  class Randomizer {

	private static Random randomHelper = new Random();
	
	public static Random getHelper() {
		return randomHelper;
	}
	
	private Randomizer() {
		
	}
	
	/**
	* This method will randomly pick up one object among all provided objects
	*
	*/
	public static Object oneOf(Object...objects) {
		
		if (null == objects) {			
			return null;			
		} else {
			return (objects[randomHelper.nextInt(objects.length)]);
		}
			
	}
	
	/**
	* Will randomly provide a positive integer lesser that maxValue
	*
	*/
	public static int integerBetweenZeroAnd(int maxValue) {
		return randomHelper.nextInt(maxValue);
	}
	
	/**
	* Will randomly provide a positive double lesser that maxValue
	*
	*/
	public static double positiveDoubleLesserThan(double maxValue) {
		return randomHelper.nextDouble() * maxValue;
	}
	
	
}
