package src;

import java.util.Scanner;

public class SignUp {

    // Ask user to create new account by inputting all necessary properties
    public static void createNewAccount(Scanner scanner, UserAccount userAccount){
        System.out.print("What is your name (Replace spaces with underscores): ");
        String name = scanner.next();
        userAccount.setName(name);

        System.out.print("How old are you: ");
        int age = scanner.nextInt();
        userAccount.setAge(age);

        System.out.print("What is your gender (M/F): ");
        String gender = scanner.next();
        userAccount.setGender(gender.charAt(0));

        System.out.print("Create username: ");
        userAccount.setUserName(scanner.next());

        System.out.print("Create password: ");
        userAccount.setPassword(scanner.next());

        System.out.print("What are you weekly work hours: ");
        userAccount.setWorkerHours(scanner.nextInt());

        System.out.print("\nYour Employee ID is : " + GenerateUserProperties.generateID());
        System.out.print("\nYou are a " + GenerateUserProperties.generateWorkerType(userAccount) + " Employee");
        System.out.print("\nYour salary is : $" + GenerateUserProperties.generateSalary(userAccount));
    }
}
