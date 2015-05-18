package stack.commons.maths;

public interface MathOperator {
	
	public MathOperator apply(MathOperable operation);
	public int getOperande1();
	public int getOperande2();
	public int getResult();
	
	
}
