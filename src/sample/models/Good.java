package sample.models;

public class Good {
    private long id;
    private String name;
    private double price;
    private boolean active;
    private Category category;

    public Good() {
    }

    public Good(String name, double price, boolean active, Category category) {
        this.name = name;
        this.price = price;
        this.active = active;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
