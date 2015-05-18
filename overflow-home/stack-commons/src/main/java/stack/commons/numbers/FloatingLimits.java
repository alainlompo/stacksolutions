package stack.commons.numbers;

public class FloatingLimits {
	
	public static void doSimpleFloatingLimitDemo() {
		float firstValue = 1.56F;
		float newValue = 1.0F / ((float)Math.pow(2.0D, 150));
		
		double doubleFirst = 2.56;
		double doubleNew = 1.0F /Math.pow(2.0D, 150);
		double doubleThird = 1.0F/Math.pow(2.0D, 589);
		double doubleFourth = 1.0F/Math.pow(2.0, 1589);
		
		System.out.println("float first value =" + firstValue);
		System.out.println("float new value =" + newValue);
		
		System.out.println("double first value =" + doubleFirst);
		System.out.println("double new value =" + doubleNew);
		System.out.println("double third value =" + doubleThird);
		System.out.println("double fourth value =" + doubleFourth);
		
		
	}

	
	public static void main(String[] args) {
		doSimpleFloatingLimitDemo();
		
	}
}
