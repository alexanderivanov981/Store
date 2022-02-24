package Store;
import Store.People.Customer;
import Store.Products.Appliances;
import Store.Products.Clothes;
import Store.Products.ClothesSize;
import Store.Products.PerishableProduct;

public class Demo {
    public static void main(String[] args) {

        Customer c = new Customer();

        c.addToCart(new PerishableProduct("apples", "brandA", 1.50, 2.45, "2022-02-24"));
        c.addToCart(new PerishableProduct("milk", "brandM", 0.99, 1, "2023-02-22"));
        c.addToCart(new Clothes("T-shirt", "brandT", 15.99, ClothesSize.M, 2, "violet"));
        c.addToCart(new Appliances("laptop", "brandL", 2345, 1, "2021-03-03",
                "modelL", 1.125));

        c.purchase();
    }
}

/* I throw an exception everytime the expirationDate and quantity are invalid, because I can't overcome the invalid
values. My calculations will be wrong all the time. On the other hand, I could set default values, but they wouldn't
work for some products. E.g., apples and bananas are measured in KG, not in quantity.
 */