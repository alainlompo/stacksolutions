package stack.commons.polymorphism;

public class InstanceOfOp {
	
	public static void doStuff(Bar b) {
		if (b instanceof Zap) {
			System.out.println("In....");
		}
	}
	
	public static void main(String[] args) {
		Foo foo = new Foo();
		doStuff(foo);
		
	}

}

interface Zap {
	
}
class Bar {
	
}
class Foo extends Bar implements Zap {
	
}
