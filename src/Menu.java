package src;

import java.util.Scanner;

public class Menu {

    public static void displayMenu(Scanner scanner, UserAccount userAccount) {
        ManagerAccount managerAccount = new ManagerAccount(); // Create manager account object

        while (true) { // <-- Keep the menu running forever until you manually exit (you can add Exit later if you want)
            boolean isLoggedIn = false;
            boolean isManager = false;

            System.out.println("Welcome to the new POS (Point of Sale) System!");

            while (!isLoggedIn && !isManager) {
                System.out.println("\n1. Employee Log in");
                System.out.println("2. Employee Sign up");
                System.out.println("3. Manager Log in");
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1: // Employee Log in
                        isLoggedIn = LogIn.isLoginCorrect(scanner, userAccount);
                        break;

                    case 2: // Employee Sign up
                        SignUp.createNewAccount(scanner, userAccount);
                        System.out.println("Account created. Please log in.");
                        break;

                    case 3: // Manager Log in
                        isManager = ManagerLogIn.isManagerLoginCorrect(scanner, managerAccount);
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            }

            if (isLoggedIn) {
                System.out.println("Employee login successful. Proceeding to system...");
                // Future: Employee features here
            } else if (isManager) {
                System.out.println("Manager login successful. Accessing admin tools...");
                ManagerMenu.displayManagerMenu(scanner, userAccount); // Display manager menu

                // When ManagerMenu exits (after log out), automatically re-show Main Menu!
            }
        }
    }
}
