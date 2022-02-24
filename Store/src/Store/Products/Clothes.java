package Store.Products;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Clothes extends Product {

    private ClothesSize size;
    private String color;

    public Clothes(String name, String brand, double price, ClothesSize size, double quantity, String color) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setSize(size);
        this.setColor(color);
        this.setDiscount();
        this.setQuantity(quantity);
    }

    //getters and setters
    public ClothesSize getSize() {
        return this.size;
    }
    public String color() {
        return this.color;
    }
    private void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "unknown";
        }
    }
    private void setBrand(String brand) {
        if (brand != null) {
            this.brand = brand;
        } else {
            this.brand = "unknown";
        }
    }
    private void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }
    private void setSize(ClothesSize size) {
        if (size != null) {
            this.size = size;
        }
    }
    private void setColor(String color) {
        if (color != null) {
            this.color = color;
        } else {
            this.color = "unknown";
        }
    }
    private void setDiscount() {
        //Check if today's date is SUNDAY/MONDAY, then there's no discount; otherwise, discount is 10%
        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek() == DayOfWeek.SUNDAY || today.getDayOfWeek() == DayOfWeek.MONDAY) {
            this.discount = 0.0;
        } else {
            this.discount = 0.1;
            this.hasDiscount = true;
        }
    }
    private void setQuantity(double quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new RuntimeException("You have entered invalid quantity for " + this.name);
        }
    }

    //Print details about the product
    @Override
    public String toString() {
        if (this.hasDiscount) {
            return this.name + " " + this.brand + " " + this.size + " " + this.color + "\n"
                + this.quantity + " x $" + this.price + " = $" +
                (String.format("%.2f",(this.price * this.quantity)) + "\n"
                + "#discount " + (this.discount * 100)  + "% - $" +
                (String.format("%.2f", (this.price * this.quantity) * this.discount) + "\n"));
        } else {
            return this.name + " " + this.brand + " " + this.size + " " + this.color + "\n"
                + this.quantity + " x $" + this.price + " = $" +
                (String.format("%.2f",(this.price * this.quantity)) + "\n");
        }
    }
}