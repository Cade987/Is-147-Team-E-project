package src;

import java.util.Scanner;

public class SignUp {

    // Ask user to create new account by inputting all necessary properties
    public static void createNewAccount(Scanner scanner, UserAccount userAccount) {
        System.out.print("What is your name (Replace spaces with underscores): ");
        String name = scanner.next();

        System.out.print("How old are you: ");
        int age = scanner.nextInt();

        System.out.print("What is your gender (M/F): ");
        String tempGender = scanner.next();
        tempGender.trim();
        char gender = tempGender.charAt(0);

        System.out.print("Create username: ");
        String userName = scanner.next();

        System.out.print("Create password: ");
        String password = scanner.next();

        System.out.print("What are you weekly work hours: ");
        int workerHours = scanner.nextInt();

        System.out.print("\nYour Employee ID is : " + GenerateUserProperties.generateID());
        if (GenerateUserProperties.generateWorkerType(workerHours) == 'F') {
            System.out.print("\nYou are a full-time employee");
        } else {
            System.out.print("\nYou are a part-time employee");
        }
        System.out.print("\nYour salary is : $" + GenerateUserProperties.generateSalary(workerHours));

        // Create new object with inputed values
        userAccount.setNewAccount(name, userName, age, password, gender, workerHours);
    }
}
