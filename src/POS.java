/**
 * This is the POS system
 * Allows user to complete a transaction. There are items already in the inventory, but the user can manually input the
 * price of an item not hardcoded into the inventory at the end of checkout.
 */

package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POS {
    private static Product[] inventory = {
            new Product("001", "Milk", 3.49),
            new Product("002", "Bread", 2.29),
            new Product("003", "Eggs", 4.99),
            new Product("004", "Bananas", 1.19),
            new Product("005", "Chicken Breast", 8.99),
            new Product("006", "Bacon", 2.49)
    };

    public static void startPOS(Scanner scanner) {
        List<Product> cart = new ArrayList<>();
        boolean running = true;

        System.out.println("\nEntering POS System...");
        while (running) {
            System.out.println("\nAvailable Products:");
            for (Product p : inventory) {
                System.out.println(p.getCode() + " - " + p.getName() + ": $" + p.getPrice());
            }

            System.out.print("\nEnter product code to add to cart, or 'done' to finalize: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                completeTransaction(cart);
                running = false;
            } else {
                Product selected = findProductByCode(input);
                if (selected != null) {
                    cart.add(selected);
                    System.out.println(selected.getName() + " added to cart.");
                } else {
                    System.out.println("Invalid product code.");
                }
            }
        }
    }

    // Allows Employee to input an item not in the inventory
    private static double inputNewProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product price: ");
        return scanner.nextDouble();
    }

    private static Product findProductByCode(String code) {
        for (Product p : inventory) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

    private static void completeTransaction(List<Product> cart) {
        System.out.println("\nFinalizing transaction...");
        double total = 0;
        for (Product p : cart) {
            System.out.println(p.getName() + ": $" + p.getPrice());
            total += p.getPrice();
        }

        boolean running = true;
        while (running) {
            System.out.print("Add additional product to cart? (y/n) ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("y")) {
                total += inputNewProduct();
            } else if (input.equalsIgnoreCase("n")) {
                running = false;
            } else {
                System.out.println("Invalid input.");
            }
        }

        System.out.printf("Total: $%.2f\n", total);
        System.out.println("Transaction complete. Thank you!");
    }

    public static Product[] getInventory() {
        return inventory;
    }
}
