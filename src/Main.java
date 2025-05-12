/**
 * This the main class.
 * @author Cade Wright (cadew1@), Jonathan Dacruz Evora (jdacruz1@umbc.edu), Leeroy Mbugua (leeroym1@umbc.edu), Joshua Mccourt (jmccour1@umbc.edu)
 * @version 1.0
 * @see src.Main
 */

package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu.displayMenu(scanner);
        scanner.close();
    }
}
