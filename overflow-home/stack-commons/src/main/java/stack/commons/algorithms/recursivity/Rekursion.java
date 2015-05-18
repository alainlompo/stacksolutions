package stack.commons.algorithms.recursivity;


public class Rekursion {

    public static void main(String[] args) {
        int number = 22000;
        System.out.println("Result with a loop: " + add(number));
        System.out.println("Result with recursion: " + recursion(number));
    }

    public static int recursion(int x) {
        if (x==1){
            return 1;
        }
        else{
            return recursion(x-1)+x;
        }
    }
    public static int add(int x) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }
        return sum;

    }   

}