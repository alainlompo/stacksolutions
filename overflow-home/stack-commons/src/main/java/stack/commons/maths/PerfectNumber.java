package stack.commons.maths;

public class PerfectNumber {

public static void main(String[] args) {
  double sum = 0;
  double newsum = 0;
  for (int i = 2; i < 1000000; i++) {
     for (int j = 2; i<Math.sqrt(i); j++){
        if (i%j==0){
           sum = j + (i/j);

        }
        if ( Math.sqrt(i) == (int)Math.sqrt(i) ){ 
        	newsum = sum - Math.sqrt(i);
        }   
        if (sum == 0) {
        	System.out.println(sum + "is a prime number");
        }

}
}
}
}