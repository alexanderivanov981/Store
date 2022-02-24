package Store.Products;
import java.time.LocalDate;
import java.util.Objects;

public class PerishableProduct extends Product {

    private LocalDate expirationDate;

    public PerishableProduct(String name, String brand, double price, double quantity, String expDate) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setExpirationDate(expDate);
        this.setDiscount();
        this.setQuantity(quantity);
    }

    //getters and setters
    public LocalDate getExpirationDate() {
        return this.expirationDate;
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
    private void setExpirationDate(String expDate) {
        //If expirationDate is after today's date or is equal to today's date, then expirationDate is valid
        try {
            LocalDate expirationDate = LocalDate.parse(expDate);
            if (expirationDate.isAfter(LocalDate.now()) || expirationDate.equals(LocalDate.now())) {
                this.expirationDate = expirationDate;
            }
        } catch (NullPointerException e) {
            System.out.println("You have entered and invalid expiration date for " + this.name);
        }
    }
    private void setDiscount() {
        try {
            //Check if the expirationDate is equal to today's date
            if (Objects.equals(getExpirationDate(), LocalDate.now())) {
                this.discount = 0.7;
                this.hasDiscount = true;
            /*Check if expDate's year == today's year; expDate's month == today's month;
            and if expDate's date has <= 5 days before expiration, according to today's date */
            } else if (getExpirationDate().getYear() == LocalDate.now().getYear()) {
                if (getExpirationDate().getMonth() == LocalDate.now().getMonth()) {
                    if (LocalDate.now().getDayOfMonth() - getExpirationDate().getDayOfMonth() > 1 &&
                            LocalDate.now().getDayOfMonth() - getExpirationDate().getDayOfMonth() <= 5) {
                        this.discount = 0.3;
                        this.hasDiscount = true;
                    }
                }
            }
        } catch (NullPointerException e){
            throw new NullPointerException("You have entered an invalid expiration date for " + this.name);
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
            return this.name + " " + this.brand + "\n"
                + this.quantity + " x $" + this.price + " = $" +
                (String.format("%.2f",(this.price * this.quantity)) + "\n"
                + "#discount " + (this.discount * 100)  + "% - $" +
                (String.format("%.2f", (this.price * this.quantity) * this.discount) + "\n"));
        } else {
            return this.name + " " + this.brand + "\n"
                    + this.quantity + " x $" + this.price + " = $" +
                    (String.format("%.2f",(this.price * this.quantity)) + "\n");
        }
    }
}