package stack.commons.exceptions;

public class NewTester {
	
	public static void methodA() throws Exception1 {
	
		throw new Exception1();
	}
	
	public static void methodB() throws Exception2 {
		
		throw new Exception2();
	}
	
	public static void main(String[] args) {
		//methodA();
		//methodB();
	}
}
