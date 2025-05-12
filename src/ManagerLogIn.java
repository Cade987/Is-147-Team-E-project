/**
 * This is the Manager Log In class.
 * Takes the inputted username and password and searches for a matching ID currently signed in to the system
 */

package src;

import java.util.Scanner;

public class ManagerLogIn {

    public static boolean isManagerLoginCorrect(Scanner scanner, ManagerAccount managerAccount) {
        System.out.print("Manager Username: ");
        String enteredUsername = scanner.nextLine().trim();

        System.out.print("Manager Password: ");
        String enteredPassword = scanner.nextLine().trim();

        boolean isValid = enteredUsername.equals(managerAccount.getUserName()) &&
                enteredPassword.equals(managerAccount.getPassword());

        if (isValid) {
            System.out.println("Manager login successful. Welcome, Administrator!");
        } else {
            System.out.println("Incorrect manager username or password.");
        }

        return isValid;
    }
}
