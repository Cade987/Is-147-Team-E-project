package src;

/**
 * This the main class
 * @author Cade Wright, Jonathan Dacruz Evora, Leeroy Mbugua, Joshua Mccourt
 * @version 1.0
 * @see src.Main
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu.displayMenu(scanner);
        scanner.close();
    }
}
