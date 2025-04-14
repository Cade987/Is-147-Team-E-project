package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Setup scanner
        Scanner scanner  = new Scanner(System.in);

        // Create objects
        UserAccount jimmyAccount = new UserAccount();

        // Setup default user - Jimmy
        jimmyAccount.setDefaultAccount();

        Menu.displayMenu(scanner, jimmyAccount);

    }
}
