package Store.People;
import Store.Products.Product;
import java.util.ArrayList;

public class Customer {

    public ArrayList<Product> cart;

    public Customer() {
        cart = new ArrayList<>();
    }

    public void purchase() {
        Cashier cashier = new Cashier();
        cashier.printReceipt(this);
    }

    public void addToCart(Product p) {
        cart.add(p);
    }

}