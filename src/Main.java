package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Setup scanner
        Scanner scanner  = new Scanner(System.in);

        // Create objects
        UserAccount userAccount = new UserAccount();

        // Setup default user - Jimmy
        userAccount.setNewAccount();

        Menu.displayMenu(scanner, userAccount);

        System.out.println("\n" + userAccount.getName() + " " + userAccount.getUserName() + " " + userAccount.getAge()
                + " " + userAccount.getPassword() + " " + userAccount.getGender() + " " +
                userAccount.getWorkerHours() + " " + userAccount.getId() + " " + userAccount.getWorkerType() + " " +
                userAccount.getSalary());
    }
}
