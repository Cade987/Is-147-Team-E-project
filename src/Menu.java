package src;

import java.util.Scanner;

public class Menu {

    // Displays the main menu and handles login/signup logic
    public static void displayMenu(Scanner scanner, UserAccount userAccount) {
        boolean isLoggedIn = false;

        System.out.println("Welcome to the new POS (Point of Sale) System!");

        while (!isLoggedIn) {
            System.out.println("\n1. Log in");
            System.out.println("2. Sign up");
            System.out.print("Choose an option: ");

            // Make sure the user enters a valid integer
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Log in
                    isLoggedIn = LogIn.isLoginCorrect(scanner, userAccount);
                    break;

                case 2: // Sign up
                    SignUp.createNewAccount(scanner, userAccount);
                    System.out.println("Account created. Please log in.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }

        System.out.println("Login successful. Proceeding to system...");
    }
}
