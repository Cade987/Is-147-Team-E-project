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
            System.out.println("5. Change Product Prices");
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
                case 5:
                    changeProductPrices(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1-5.");
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

    private static void changeProductPrices(Scanner scanner) {
        Product[] inventory = POS.getInventory();
        System.out.println("\nProduct List:");
        for (int i = 0; i < inventory.length; i++) {
            Product p = inventory[i];
            System.out.printf("%d. %s (%s): $%.2f\n", i + 1, p.getName(), p.getCode(), p.getPrice());
        }

        System.out.print("Enter product number to change price: ");
        int index = readInt(scanner) - 1;

        if (index >= 0 && index < inventory.length) {
            System.out.print("Enter new price for " + inventory[index].getName() + ": $");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a valid price: ");
                scanner.nextLine();
            }
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); // clear newline
            inventory[index].setPrice(newPrice);
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear newline
        return value;
    }
}
