package Store.People;
import java.time.LocalDateTime;

public class Cashier {

    public void printReceipt(Customer c) {
        double total = 0;
        double discount = 0;
        System.out.println("Date: " + LocalDateTime.now() + "\n--Products--\n");

        //Iterate through each element of the ArrayList cart
        for (int i = 0; i < c.cart.size(); i++) {
            System.out.println(c.cart.get(i));

            //Calculate the total sum and discount of all elements' prices in the cart
            double price = c.cart.get(i).getPrice();
            total += price * c.cart.get(i).getQuantity();
            discount += (c.cart.get(i).getPrice() * c.cart.get(i).getQuantity()) * c.cart.get(i).getDiscount();
        }

        System.out.println("-----------------------------------");
        System.out.println("SUBTOTAL: $" + (String.format("%.2f", total)));
        System.out.println("DISCOUNT: -$" + (String.format("%.2f", discount) + "\n"));
        System.out.println("TOTAL: $" + (String.format("%.2f", (total - discount))));
    }

}