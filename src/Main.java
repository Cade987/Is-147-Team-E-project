package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu.displayMenu(scanner); // ✅ FIXED: Only pass Scanner now
        scanner.close();
    }
}
