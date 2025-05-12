/**
 * This is the menu class.
 * Lets user interact with a simple login or signup interface
 */

package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void displayMenu(Scanner scanner) {
        ManagerAccount managerAccount = new ManagerAccount();
        List<UserAccount> userAccounts = new ArrayList<>();

        boolean running = true;
        while (running) {
            UserAccount loggedInEmployee = null;
            boolean isManager = false;

            System.out.println("Welcome to the POS (Point of Sale) System!");

            while (loggedInEmployee == null && !isManager && running) {
                System.out.println("\n1. Employee Log in (by ID)");
                System.out.println("2. Employee Sign up");
                System.out.println("3. Manager Log in");
                System.out.println("4. Exit POS");
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine();
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        loggedInEmployee = LogIn.getLoggedInUser(scanner, userAccounts);
                        break;
                    case 2:
                        SignUp.createNewAccount(scanner, userAccounts);
                        break;
                    case 3:
                        isManager = ManagerLogIn.isManagerLoginCorrect(scanner, managerAccount);
                        break;
                    case 4:
                        running = false;
                        System.out.println("\nShutting off..."); // Shuts down program
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 4.");
                }
            }

            if (loggedInEmployee != null) {
                System.out.println("Employee login successful. Proceeding to POS system...");
                POS.startPOS(scanner);
            } else if (isManager) {
                System.out.println("Manager login successful. Accessing admin tools...");
                ManagerMenu.displayManagerMenu(scanner, userAccounts);
            }
        }
    }
}
