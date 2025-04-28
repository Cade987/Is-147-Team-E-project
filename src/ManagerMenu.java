package src;

import java.util.Scanner;

public class ManagerMenu {

    public static void displayManagerMenu(Scanner scanner, UserAccount userAccount) {
        boolean running = true;

        while (running) {
            System.out.println("\nManager Menu:");
            System.out.println("1. View Employee Details");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Remove Employee");
            System.out.println("4. Log Out");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewEmployeeDetails(userAccount);
                    break;
                case 2:
                    updateEmployeeSalary(scanner, userAccount);
                    break;
                case 3:
                    removeEmployee(userAccount);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1-4.");
            }
        }
    }

    private static void viewEmployeeDetails(UserAccount userAccount) {
        System.out.println("\nEmployee Details:");
        System.out.println("----------------------");
        System.out.println("Name         : " + userAccount.getName());
        System.out.println("Username     : " + userAccount.getUserName());
        System.out.println("Gender       : " + userAccount.getGender());
        System.out.println("Worker Hours : " + userAccount.getWorkerHours());
        System.out.println("Worker Type  : " + (userAccount.getWorkerType() == 'F' ? "Full-time" : "Part-time"));
        System.out.println("Salary       : $" + userAccount.getSalary());
        System.out.println("Employee ID  : " + userAccount.getId());
    }

    private static void updateEmployeeSalary(Scanner scanner, UserAccount userAccount) {
        System.out.print("\nEnter new weekly work hours for employee: ");
        int newHours = readInt(scanner);
        userAccount.setWorkerHours(newHours);

        // Update worker type and salary based on new hours
        userAccount.setWorkerType(GenerateUserProperties.generateWorkerType(newHours));
        userAccount.setSalary(GenerateUserProperties.generateSalary(newHours));

        System.out.println("Employee work hours, worker type, and salary updated successfully.");
    }

    private static void removeEmployee(UserAccount userAccount) {
        userAccount.setName(null);
        userAccount.setUserName(null);
        userAccount.setPassword(null);
        userAccount.setGender('U');
        userAccount.setWorkerHours(0);
        userAccount.setId(0);
        userAccount.setWorkerType('P');
        userAccount.setSalary(0);

        System.out.println("Employee account removed (reset).");
    }

    // Helper to safely read integers
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
