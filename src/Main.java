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
        Scanner scanner = new Scanner(System.in);
        UserAccount userAccount = new UserAccount(); // Creates an empty employee account
        Menu.displayMenu(scanner, userAccount);      // Starts the program at the menu
        scanner.close();                             // Close scanner at the end
    }
}
