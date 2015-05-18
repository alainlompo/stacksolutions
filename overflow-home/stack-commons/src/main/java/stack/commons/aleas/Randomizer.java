package stack.commons.aleas;
import java.util.Random;

public  class Randomizer {

	private static Random randomHelper = new Random();
	
	public static Random getHelper() {
		return randomHelper;
	}
	
	private Randomizer() {
		
	}
	
	public static Object oneOf(Object...objects) {
		
		if (null == objects) {			
			return null;			
		} else {
			return (objects[randomHelper.nextInt(objects.length)]);
		}
			
	}
}
