package src;

import java.util.Scanner;

public class SignUp {

    // Ask user to create a new account by inputting all necessary properties
    public static void createNewAccount(Scanner scanner, UserAccount userAccount) {
        System.out.print("What is your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("How old are you: ");
        int age = readInt(scanner);

        System.out.print("What is your gender (M/F): ");
        String tempGender = scanner.nextLine().trim();
        char gender = tempGender.isEmpty() ? 'U' : tempGender.charAt(0);

        System.out.print("Create username: ");
        String userName = scanner.nextLine().trim();

        System.out.print("Create password: ");
        String password = scanner.nextLine().trim();

        System.out.print("What are your weekly work hours: ");
        int workerHours = readInt(scanner);

        int generatedId = GenerateUserProperties.generateID();
        char workerType = GenerateUserProperties.generateWorkerType(workerHours);
        int salary = GenerateUserProperties.generateSalary(workerHours);

        System.out.println("\nRegistration Summary:");
        System.out.println("----------------------");
        System.out.println("Employee ID       : " + generatedId);
        System.out.println("Worker Type       : " + (workerType == 'F' ? "Full-time" : "Part-time"));
        System.out.println("Calculated Salary : $" + salary);

        // Create new account using the provided details
        userAccount.setNewAccount(name, userName, age, password, gender, workerHours);
    }

    // Utility to read integer input safely
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine(); // Clear invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear trailing newline
        return value;
    }
}
