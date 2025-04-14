package src;

import java.util.Scanner;

public class Menu {

    // Displays different menu screens depending on if the user is signed in
    public static void displayMenu(Scanner scanner, UserAccount userAccount){
        // If the user is not logged in, make them log or sign up
        if (true /* Replace with an isLoggedIn variable */) {
            System.out.println("Welcome to the new POS (Point of Sale) System!");

            System.out.println("\n1. Log in");
            System.out.println("2. Sign up");
        }

        int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Log in
                    // Log user in
                    LogIn.isLoginCorrect(scanner, userAccount);
                    break;

                case 2: // Sign up
                    // Placeholder
                    SignUp.createNewAccount(scanner, userAccount);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
    }
}
