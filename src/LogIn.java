package src;

import java.util.Scanner;

public class LogIn {

    // Validates the user's login credentials
    public static boolean isLoginCorrect(Scanner scanner, UserAccount userAccount) {
        System.out.print("Username: ");
        String userName = scanner.nextLine().trim();

        System.out.print("Password: ");
        String userPassword = scanner.nextLine().trim();

        boolean isValid = userName.equals(userAccount.getUserName()) &&
                userPassword.equals(userAccount.getPassword());

        if (isValid) {
            System.out.println("Hello, " + userAccount.getName() + "! Logging in...");
        } else {
            System.out.println("Incorrect username or password.");
        }

        return isValid;
    }
}
