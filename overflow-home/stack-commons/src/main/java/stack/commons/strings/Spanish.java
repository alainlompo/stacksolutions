package stack.commons.strings;

import java.util.Scanner;

public class Spanish {
	
	static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
      System.out.print("En este programa calcularemos el area de una figura.\n" + 
              "Ingresa a continuacion que figura calcularemos.");
      String triangulo = "triangulo";
      String figura = scan.next();
      if (figura.equals(triangulo)){
      System.out.print("Ingrese base y altura del triangulo.\n");
      double base = scan.nextDouble();
      double altura = scan.nextDouble();
      System.out.print("La altura es " + (base*altura)/2);
      } 

}
    
    
}
