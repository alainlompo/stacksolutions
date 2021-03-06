package stack.commons.polymorphism;

import java.util.Random;

public class Fish extends Animal {
	
	public final static int FISH_MOVE_LENGTH = 3;
	
    public Fish (){
        super("Fish");
    }
    @Override
    public int move () {
    	Random r = new Random();
    	double xValue = r.nextInt(FISH_MOVE_LENGTH/2)+ 0.0D;
    	double yValue = Math.sqrt(FISH_MOVE_LENGTH*FISH_MOVE_LENGTH - xValue*xValue);
    	setX(xValue);
    	setY(yValue);
   
    	return (int)Math.sqrt(xValue*xValue + yValue*yValue);
    	
}
    @Override
    public String toString (){
       return String.format("Fish swim "+move()+"  feet and its current position is " + position());
   }}