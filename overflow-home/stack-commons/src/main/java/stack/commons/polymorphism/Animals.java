package stack.commons.polymorphism;

import java.util.Random;

public class Animals {

    public static void main(String[] args) throws InterruptedException { 
        
        Fish F = new Fish ();
        Frog Fr = new Frog ();
        Bird B = new Bird ();
      
        
       Animal[] A = new Animal [3];
        A[0]= F;
        A[1]=Fr;
        A[2]=B;
        
//        for (int i=0 ; i <3; i++){
//           A[i].toString();
//        }
        
        Random maestro = new Random();
        while (true) {
        	
        	int elementToPick = maestro.nextInt(3);
        	System.out.println(A[elementToPick]);
			Thread.sleep(500);
        	
        }
    }
    
}
