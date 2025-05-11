package src;

import java.util.List;
import java.util.Scanner;

public class SignUp {

    // Create a new user and add to the list of users
    public static void createNewAccount(Scanner scanner, List<UserAccount> userAccounts) {
        System.out.print("What is your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("What are your weekly work hours: ");
        int workerHours = readInt(scanner);

        UserAccount newUser = new UserAccount();
        newUser.setNewAccount(name, workerHours);

        userAccounts.add(newUser); // Add to the list

        System.out.println("\nRegistration Summary:");
        System.out.println("----------------------");
        System.out.println("Employee Name      : " + newUser.getName());
        System.out.println("Employee ID        : " + newUser.getId());
        System.out.println("Worker Type        : " + (newUser.getWorkerType() == 'F' ? "Full-time" : "Part-time"));
        System.out.println("Calculated Salary  : $" + newUser.getSalary());
        System.out.println("Please use your Employee ID to log in.");
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
