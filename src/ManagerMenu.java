package src;

import java.util.List;
import java.util.Scanner;

public class ManagerMenu {

    public static void displayManagerMenu(Scanner scanner, List<UserAccount> userAccounts) {
        boolean running = true;

        while (running) {
            System.out.println("\nManager Menu:");
            System.out.println("1. View All Employee Details");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Remove Employee");
            System.out.println("4. Log Out");
            System.out.println("5. Change Product Prices");
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
                    viewAllEmployees(userAccounts);
                    break;
                case 2:
                    updateEmployeeSalary(scanner, userAccounts);
                    break;
                case 3:
                    removeEmployee(scanner, userAccounts);
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

    private static void viewAllEmployees(List<UserAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\nAll Employees:");
        System.out.println("--------------");
        for (UserAccount user : accounts) {
            System.out.println("Name         : " + user.getName());
            System.out.println("Employee ID  : " + user.getId());
            System.out.println("Worker Hours : " + user.getWorkerHours());
            System.out.println("Worker Type  : " + (user.getWorkerType() == 'F' ? "Full-time" : "Part-time"));
            System.out.println("Salary       : $" + user.getSalary());
            System.out.println("-----------------------------");
        }
    }

    private static void updateEmployeeSalary(Scanner scanner, List<UserAccount> accounts) {
        UserAccount user = findEmployeeById(scanner, accounts);
        if (user == null) return;

        System.out.print("Enter new weekly work hours: ");
        int newHours = readInt(scanner);
        user.setWorkerHours(newHours);
        user.setWorkerType(GenerateUserProperties.generateWorkerType(newHours));
        user.setSalary(GenerateUserProperties.generateSalary(newHours));
        System.out.println("Updated work hours and salary.");
    }

    private static void removeEmployee(Scanner scanner, List<UserAccount> accounts) {
        UserAccount user = findEmployeeById(scanner, accounts);
        if (user == null) return;

        accounts.remove(user);
        System.out.println("Employee removed from system.");
    }

    private static UserAccount findEmployeeById(Scanner scanner, List<UserAccount> accounts) {
        System.out.print("Enter Employee ID: ");
        int id = readInt(scanner);

        for (UserAccount user : accounts) {
            if (user.getId() == id) {
                return user;
            }
        }
        System.out.println("Employee not found.");
        return null;
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
            scanner.nextLine();
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
        scanner.nextLine();
        return value;
    }
}
