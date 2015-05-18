package stack.commons.polymorphism;

import java.util.Random;

public class Bird extends Animal {
	
	public final static int BIRD_MOVE_LENGTH = 10;

	public Bird() {
		super("Bird");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move() {
		
		Random r = new Random();
    	double xValue = r.nextInt(BIRD_MOVE_LENGTH/2)+ 0.0D;
    	double yValue = Math.sqrt(BIRD_MOVE_LENGTH*BIRD_MOVE_LENGTH - xValue*xValue);
    	setX(xValue);
    	setY(yValue);
   
    	return (int)Math.sqrt(xValue*xValue + yValue*yValue);
	}
	
	 @Override
	 public String toString (){
	    return String.format("Bird flies "+ move() +"  feet and its current position is " + position());
	 }

}
