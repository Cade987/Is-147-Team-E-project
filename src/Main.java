/**
 * This is main class to test Person.Java
 *
 * @author Leeroy Mbugua
 * @version 1.0
 * @see Person
 */
package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create user account and set default user - Jimmy
            UserAccount userAccount = new UserAccount();
            userAccount.setNewAccount();

            // Display menu
            Menu.displayMenu(scanner, userAccount);

            // Display user info
            System.out.printf(
                    "\n%s %s %d %s %s %.2f %d %s %.2f\n",
                    userAccount.getName(),
                    userAccount.getUserName(),
                    userAccount.getAge(),
                    userAccount.getPassword(),
                    userAccount.getGender(),
                    userAccount.getWorkerHours(),
                    userAccount.getId(),
                    userAccount.getWorkerType(),
                    userAccount.getSalary()
            );
        }
    }
}