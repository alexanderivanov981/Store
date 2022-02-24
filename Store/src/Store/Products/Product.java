package Store.Products;

public abstract class Product {

    protected String name;
    protected String brand;
    protected double price;
    protected double quantity;
    protected double discount;
    protected boolean hasDiscount;

    //General getters for all child classes of Product
    public String getName() {
        return this.name;
    }
    public String getBrand() {
        return this.brand;
    }
    public double getPrice() {
        return this.price;
    }
    public double getDiscount() {
        return this.discount;
    }
    public double getQuantity() {
        return this.quantity;
    }
    public boolean getHasDiscount() {
        return this.hasDiscount;
    }
}