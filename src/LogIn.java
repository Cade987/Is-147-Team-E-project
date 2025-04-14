package src;

import java.util.Scanner;

public class LogIn {
    // Ask user to input username & password. If both are correct, log user in. Else reject login
    public static void isLoginCorrect(Scanner scanner, UserAccount userAccount) {

        System.out.print("Username: ");
        String userName = scanner.next();

        System.out.print("Password: ");
        String userPassword = scanner.next();

        if (userName.equals(userAccount.getUserName()) && userPassword.equals(userAccount.getPassword())) {
            System.out.println("Hello, " + userAccount.getName() + "! Logging in...");
        } else {
            System.out.println("Incorrect username or password");
        }
    }

}
