package model;

public class Product {

    private Integer id;
    private String name;
    private String picture;
    private double price;
    private String description;
    private boolean availability;
    private int stockQuantity;
    private Category category;

    // Constructors, getters, setters
    public Product(){
        this.setName("");
        this.setPicture("");
        this.setPrice(0.0);
        this.setDescription("");
        this.setAvailability(false);
        this.setStockQuantity(0);
        this.setCategory();
    }

    public Product(Integer id,String name, String picture, double price, String description, boolean availability, int stockQuantity, Category category ){
        this.setId(id);
        this.setName(name);
        this.setPicture(picture);
        this.setPrice(price);
        this.setDescription(description);
        this.setAvailability(availability);
        this.setStockQuantity(stockQuantity);
        this.setCategory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory() {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

