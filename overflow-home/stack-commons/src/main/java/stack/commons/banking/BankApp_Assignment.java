package stack.commons.banking;

import java.util.Scanner;

public class BankApp_Assignment {

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[10];

        Scanner sc = new Scanner(System.in);

        int userChoose;
        String name = null;
        int accNum = 0;
        double initiateAmount = 0;
        double newAmm = 0;

        double depOrWith = 0;
        System.out.println("WELCOME TO OUR BANK!\n\n"
                + "...................\n"
                + "...................\n\n"
                + "Choose your optiin:\n"
                + "1. Create new account\n"
                + "2. View all the accounts property\n"
                + "3. Quit\n\n");

        System.out.println("*************\n"
                + "************");
        while (true) {
            userChoose = sc.nextInt();
            sc.nextLine();
            if (userChoose == 1) {
                /*the user must be able to create multiple accounts, let's say 10 accounts for instance
                 To open another new account the user should choose the menu option "1" again and continue...
                 */
                System.out.println("Enter your full name:");
                name = sc.nextLine();

                System.out.println("Choose an account number:");

                accNum = sc.nextInt();

                System.out.println("Enter an initiating amount:");

                initiateAmount = sc.nextDouble();
                System.out.println("\n-----------\n"
                        + "------------");
            } else if (userChoose == 2) {//view all the accounts property (including account number and initial balance)

            } else if (userChoose == 3) {
                System.exit(0);

            }
        }

    }

}

class BankAccount {
	
}