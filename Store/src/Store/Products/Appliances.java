package Store.Products;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Appliances extends Product {

    private String model;
    private LocalDate productionDate;
    private double weightKG;

    public Appliances(String name, String brand, double price, double quantity,
                      String productionDate, String model, double weightKG) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
        this.setProductionDate(productionDate);
        this.setModel(model);
        this.setWeightKG(weightKG);
        this.setDiscount();
        this.setQuantity(quantity);
    }

    //getters and setters
    public LocalDate getProductionDate() {
        return this.productionDate;
    }
    public String getModel() {
        return this.model;
    }
    public double getWeightKG() {
        return this.weightKG;
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
    private void setProductionDate(String prodDate) {
        /* If productionDate == today's date or productionDate is before today's date,
        then productionDate is valid. We can't have products made in the future */
        try {
            LocalDate productionDate = LocalDate.parse(prodDate);
            if (productionDate.isBefore(LocalDate.now()) || productionDate.equals(LocalDate.now())) {
                this.productionDate = productionDate;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("You have set an invalid production date for " + this.getName());
        }
    }
    private void setModel(String model) {
        if (model != null) {
            this.model = model;
        } else {
            this.model = "unknown";
        }
    }
    private void setWeightKG(double weightKG) {
        if (weightKG > 0) {
            this.weightKG = weightKG;
        } else {
            this.weightKG = 1;
        }
    }
    private void setDiscount() {
        /* Check if today's date is a weekday and if the
        price of the product is > 999, then this value is valid */
        LocalDate today = LocalDate.now();
        if ((today.getDayOfWeek() == DayOfWeek.SATURDAY || today.getDayOfWeek() == DayOfWeek.SUNDAY) && this.price > 999) {
            this.discount = 0.07;
            this.hasDiscount = true;
        }
    }
    private void setQuantity(double quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    //Print details about the product
    @Override
    public String toString() {
        if (this.hasDiscount) {
            return this.name + " " + this.brand + " " + this.model + "\n"
                + this.quantity + " x $" + this.price + " = $" +
                (String.format("%.2f",(this.price * this.quantity)) + "\n"
                + "#discount " + (String.format("%.1f", this.discount * 100))  + "% - $"
                + (String.format("%.2f", (this.price * this.quantity) * this.discount) + "\n"));
        } else {
            return this.name + " " + this.brand + " " + this.model + "\n"
                + this.quantity + " x $" + this.price + " = $" +
                (String.format("%.2f",(this.price * this.quantity)));
        }
    }
}