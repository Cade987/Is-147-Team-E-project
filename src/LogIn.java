package src;

/**
 * This is the Log In class
 * Takes the inputted ID and searches for a matching ID currently signed in to the system
 */

import java.util.List;
import java.util.Scanner;

public class LogIn {

    public static UserAccount getLoggedInUser(Scanner scanner, List<UserAccount> userAccounts) {
        System.out.print("Enter your 6-digit Employee ID: ");
        int enteredId = readInt(scanner);

        for (UserAccount user : userAccounts) {
            if (user.getId() == enteredId) {
                System.out.println("Hello, " + user.getName() + "! Logging in...");
                return user;
            }
        }

        System.out.println("Invalid employee ID.");
        return null;
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid 6-digit ID: ");
            scanner.nextLine();
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}
