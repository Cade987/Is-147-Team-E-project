/**
 * This is the Product class.
 * Stores the basic values shared by all products: Code, name, and price
 */

package src;

public class Product {
    private String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String price) {this.name = name;}

    public void setPrice(double price) {
        this.price = price;
    }
}
