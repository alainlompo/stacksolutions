package stack.commons.polymorphism;

import java.util.Random;

public class Frog extends Animal {
	
	public final static int FROG_MOVE_LENGTH = 5;

	public Frog() {
		super("Frog");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int move() {
		Random r = new Random();
    	double xValue = r.nextInt(FROG_MOVE_LENGTH/2)+ 0.0D;
    	double yValue = Math.sqrt(FROG_MOVE_LENGTH*FROG_MOVE_LENGTH - xValue*xValue);
    	setX(xValue);
    	setY(yValue);
   
    	return (int)Math.sqrt(xValue*xValue + yValue*yValue);
	}
	
	 @Override
	 public String toString (){
	    return String.format("Frog jumps "+ move() +"  feet and its current position is " + position());
	    
	 }

}
