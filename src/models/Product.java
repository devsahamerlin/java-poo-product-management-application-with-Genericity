package models;

import java.io.Serializable;

public class Product<T> implements Serializable {
    private T id;
    private T name;
    private T brand;
    private T price;
    private T description;
    private T quantity;

    public Product() {
    }

    public Product(T id, T name, T brand, T price, T description, T quantity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getBrand() {
        return brand;
    }

    public void setBrand(T brand) {
        this.brand = brand;
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }

    public T getDescription() {
        return description;
    }

    public void setDescription(T description) {
        this.description = description;
    }

    public T getQuantity() {
        return quantity;
    }

    public void setQuantity(T quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "[" + "id=" + id + ", name='" + name + ", brand='" + brand + ", price=" + price + ", description='" + description + ", quantity=" + quantity + ']';
    }
}
